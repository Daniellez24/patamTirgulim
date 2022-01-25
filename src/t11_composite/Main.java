package t11_composite;

public class Main {
   /** This design pattern does not prevent circular inheritance
    If we want to we can manually check for it**/
    public static void main(String[] args) throws Exception{
        Employee e0 = new Engineer();
        Employee e1 = new Engineer();
        Employee e2 = new Engineer();

        Manager m1 = new Manager();
        m1.addEmployee(e1);
        m1.addEmployee(e2);

        //This is the big boss, his employee is also a manager
        Manager m0 = new Manager();
        m0.addEmployee(e0);
        m0.addEmployee(m1);

        /** "This employee already got a manager" exception will occur,
         *  we are creating circles:
         *  The circle is that you will be the worker of your worker
         *  **/
//        m1.addEmployee(e0);
        /** Another problem is that you can be the boss of your boss (the one who you are working for)*/
//        m1.addEmployee(m0);
        /**In here m1 is the employee of m1*/
        //m1.addEmployee(m1);
    }
}
