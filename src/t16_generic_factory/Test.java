package t16_generic_factory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    /** in generic factory we'd like to make a factory for any product, not only for Employee **/
    /** create a generic factory that is not depended on the type of Products it creates **/

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null; // user input
        Employee e = null;

//      EmpFactory ef = new EmpFactory();
        GenericFactory<Employee> gf = new GenericFactory<>();
        // fill the map using insertProduct, with any kind of Employee (the product)
        gf.insertProduct("dev", Developer.class);
        gf.insertProduct("arc", Architect.class);
        gf.insertProduct("man", Manager.class);


        while(!(input=in.readLine()).equals("done")){


            e= gf.getNewProduct(input);

            if(e != null)
                System.out.println(e.getClass() + " was created");
            else
                System.out.println("this type of Employee does not exist");

        }

    }

}
