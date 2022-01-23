package t15_factory_plus_prototype;

import java.util.HashMap;

public class EmpFactory {

    // prototype solution: map between String and Employee instead of Creator
    HashMap<String, Employee> map;

    //prototype solution:
    public EmpFactory() {
        map = new HashMap<>();
        // we'll get the same MOFA (item) everytime we get it out of the map. we DON'T want that.
        map.put("dev", new Developer());
        map.put("arc", new Architect());
        map.put("man", new Manager());
    }

    public Employee createEmp(String key){
        if(map.containsKey(key))
            // use cloneMe() in order to receive a new item everytime we use the map to get an Employee (product),
            // instead of receiving the same one
            return map.get(key).cloneMe();

        return null;
    }

    /** Lambda Expressions solution:
     *
     * HashMap<String, Creator> map; // the value is a *Creator* and NOT an Employee (product)
     *
    private interface Creator{ // functional interface!!
        Employee create(); // factoryMethod()
    }

    public EmpFactory() {
        map = new HashMap<>();
        // insert the creators to the map - o(n) memory, but happens only once - in this constructor
        map.put("dev", ()->new Developer());
        map.put("arc", ()-> new Architect());
        map.put("man", ()->new Manager());
    }

     public Employee createEmp(String key){
     if(map.containsKey(key))
     return map.get(key).create(); // we get the specific Creator from the map, and call its create() method to get the specific Employee

     return null; // if we didn't find the Creator, that means there isn't the type of Employee (product) that the client asked for. return null
     }
     **/


    // for every kind of product (Architect, Deceloper..), we created a specific productCreator (ArcCreator, DevCreator...)
    // use lambda expressions in the constructor instead (in green comment) OR prototype solution

//    private class ArcCreator implements Creator{
//        @Override
//        public Employee create() {
//            return new Architect();
//        }
//    }
//
//    private class DevCreator implements Creator{
//        @Override
//        public Employee create() {
//            return new Developer();
//        }
//    }
//
//    private class ManCreator implements Creator{
//        @Override
//        public Employee create() {
//            return new Manager();
//        }
//    }
}
