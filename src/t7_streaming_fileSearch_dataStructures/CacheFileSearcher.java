package t7_streaming_fileSearch_dataStructures;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CacheFileSearcher implements FileSearcher {

    int size;
    IOFileSearcher ifs; // reuse code!
    int cacheSize; // limit the cache size, work with LRU - least recently used data will be deleted if we reach max cacheSize
    // we choose LinkedHashMap because it saves the order of added items. good for the LRU
    LinkedHashMap<String, Set<String>> cache;

    public CacheFileSearcher() {
        size = 0;
        ifs = new IOFileSearcher();
        cacheSize = 400;
        // implement an unnamed anonymous class that extends LinkedHashMap, so we can "run over" the "remove eldest entry" and re-implement it
        cache = new LinkedHashMap<String, Set<String>>() {
            protected boolean removeEldestEntry(Map.Entry<String, Set<String>> eldest){
                // when do we remove the eldest: LRU
                return size() > cacheSize; // size() = size of cache.
            }
        };
    }

    @Override
    public void loadFile(String fileName) {
        ifs.loadFile(fileName);
    }

    @Override
    public Set<String> search(String word) {
        if(cache.containsKey(word))
            return cache.get(word);

        // use IOFileSearcher to search, and save this query in the cache and increase size
        Set<String> result = ifs.search(word);
        cache.put(word, result);
        size+=word.length();
        result.forEach(line-> size+=line.length());

        return result;
    }

    @Override
    public int getMemSize() {
        return size;
    }
}
