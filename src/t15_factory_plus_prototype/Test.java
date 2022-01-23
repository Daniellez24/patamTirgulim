package t15_factory_plus_prototype;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = null; // user input
        Employee e = null;

        EmpFactory ef = new EmpFactory();

        while(!(input=in.readLine()).equals("done")){ // we'd like to create an Object that a client asks, as long as he doesn't write "done"

//            if(input.equals("dev"))
//                e=new Deceloper();
//            if(input.equals("man"))
//                e=new Manager();
            //... o(n) checks...

            e= ef.createEmp(input); // o(1)

            if(e != null)
                System.out.println(e.getClass() + " was created");
            else
                System.out.println("this type of Employee does not exist");

        }

    }

}
