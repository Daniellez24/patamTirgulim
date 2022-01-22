package t7_streaming_fileSearch_dataStructures;

import java.util.Set;

public interface FileSearcher {
    void loadFile(String fileName);
    Set<String> search(String word); // returns Set of Strings  - a group of lines that contain the word
    int getMemSize();
}
