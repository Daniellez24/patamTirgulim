package t7_streaming_fileSearch_dataStructures;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Set;

public class Test {

    public static void test(FileSearcher fs){
        String fileName = "resources/mobydick.txt";
        File f = new File(fileName); // pointer to a file
        long size = f.length();

        fs.loadFile(fileName);

        long t0=System.nanoTime();
        Set<String> result = fs.search("sail");
        result.addAll(fs.search("the"));
        result.addAll(fs.search("ship"));
        result.addAll(fs.search("ship"));
        result.addAll(fs.search("ship"));
        long t1=System.nanoTime();

        DecimalFormat df = new DecimalFormat("###,###.###"); // comma after every 3 digits, and 3 digits after the point
        long memSize = fs.getMemSize();
        System.out.println("mem size is "+ df.format(memSize + " bytes"));
        System.out.println("original file size is " + df.format(size) + " bytes");
        System.out.println("the ratio is " + df.format((double)memSize/size));
        System.out.println("search time: " + df.format(t1-t0) + " nanosecs");
    }

    public static void main(String[] args){
        test(new IOFileSearcher()); // doesn't use any memory, but the slowest search time
        test(new InMemFileSearcher()); // save all file in memory, but faster search time
        test(new CacheFileSearcher()); // Winner! save used data that was already calculated, search time and memory are worth the tradeoff

        System.out.println("done");
    }

}
