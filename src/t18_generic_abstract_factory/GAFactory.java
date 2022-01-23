package t18_generic_abstract_factory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class GAFactory {

    Map<String,String> map;

    public GAFactory(String fileName) {
        map = new HashMap<>();
        try {
            Stream<String> s = Files.lines(Paths.get(fileName));
            // for each line in the txt file, split it by tabs.
            // the first argument(index 0) is the key (= the kind of armory),
            // the second argument (index 1) is the value (= the specific class)
            s.forEach(str->map.put(str.split("\t")[0], str.split("\t")[1]));
            // don't forget to close the stream!
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public <Product> Product get(String key){
        String className = map.get(key);
        if(className != null){
            try {
                //getSystemClassLoader loads a class in runtime
                Class<?> c = ClassLoader.getSystemClassLoader().loadClass(className);
                // casting to Product is needed becsue newInstance() returns an Object
                return (Product)c.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
