package t16_generic_factory;

import java.util.HashMap;

public class GenericFactory<Product>{

    private interface Creator<Product>{
        Product create();
    }

    HashMap<String, Creator<Product>> map;

    public GenericFactory() {
        map = new HashMap<>();
    }

    public Product getNewProduct(String key){
        if(map.containsKey(key))
            return map.get(key).create();
        return null;
    }

    // now we can't fill the map in the constructor because we don't know which product we got.
    // we'll use this insertProduct method. ATTENTION: as the value of each entry of the map - we'll ask for the CLASS:
    // the *type* of Product we want to create.
    // Class<? extends Product> = anything that is a kind of Product
    public void insertProduct(String key, Class<? extends Product> c){
        // anonymous class: an unnamed class that implements Creator
        // we want to create the Creator by ourselves, but we need to know which kind of Creator (which type of Product it has to create)
        // that's why we need the Class argument
        map.put(key, new Creator<Product>() {
            @Override
            public Product create() {
                // c is any specific type of Product, and get a new instance of this specific type
                try {
                    return c.newInstance(); // create a new instance of the specific Product
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }
}
