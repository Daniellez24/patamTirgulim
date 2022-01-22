package t7_streaming_fileSearch_dataStructures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InMemFileSearcher implements FileSearcher {

    ArrayList<String> lines; // save all the lines of the file in the memory, each line is in a different index

    HashMap<String, Set<Integer>> map; // we use Set and not List because in Set every member appears only once,
    // and we want to save each line that contains a word only once. the set is a set of the lines' indexes
    int size;

    public InMemFileSearcher() {
        lines = new ArrayList<>();
        map = new HashMap<>();
        size = 0;
    }

    private void add(String word, int index) {
        if(!map.containsKey(word)){
            map.put(word, new HashSet<>());
            size+=word.length();
        }
        if(map.get(word).add(index)) // if add returned true (successful addition - the index wasn't there before)
            size+=4; // size of int (index)
    }

    @Override
    public void loadFile(String fileName) {
        try {
            Stream<String> s = Files.lines(Paths.get(fileName));
            int i[] = {0}; // we use an array because parameters are sent by value into a lambda expression
            s.forEach(line->{
                lines.add(line);
                size+=line.length();
                Stream.of(line.split("\\s+")).forEach(word->add(word, i[0])); // skips all white spaces. we want to go over every word in the line,
                // so we can add it to the map with this line containing it.
                i[0] = i[0]+1; // the line index
            });

            s.close();
        } catch(IOException e) {}
    }




    @Override
    public Set<String> search(String word) {
//        HashSet<String> result = new HashSet<>();
//        map.get(word).forEach(i->result.add(lines.get(i)));

        // we get a stream of indexes, and for each line i in lines, we put it in a Set of Strings (all the lines that contain the word)
        return map.get(word).stream().map(i->lines.get(i)).collect(Collectors.toSet());
    }

    @Override
    public int getMemSize() {
        return size;
    }
}
