package t7_streaming_fileSearch_dataStructures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOFileSearcher implements FileSearcher {

    String fileName;

    @Override
    public void loadFile(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public Set<String> search(String word) {
        Set<String> set = null;
        Stream<String> s;

        try {
            s = Files.lines(Paths.get(fileName)); // returns Stream of Strings. puts into the Stream every line by line that it reads from the file
            //Files.readAllLines : saves all the lines of the file in the memory (good for small files)
            set = s.filter(line->line.contains(word)).collect(Collectors.toSet());
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return set;
    }

    @Override
    public int getMemSize() {
        return 0; // we didn't use any memory
    }
}
