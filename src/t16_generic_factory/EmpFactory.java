package t16_generic_factory;

import java.util.HashMap;

public class EmpFactory {

//     Lambda Expressions solution:

     HashMap<String, Creator> map; // the value is a *Creator* and NOT an Employee (product)

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
            // we get the specific Creator from the map, and call its create() method to get the specific Employee
            return map.get(key).create();

         // if we didn't find the Creator, that means there isn't the type of Employee (product) that the client asked for. return null
         return null;
     }



}
