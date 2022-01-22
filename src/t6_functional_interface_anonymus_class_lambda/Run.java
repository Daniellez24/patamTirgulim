package t6_functional_interface_anonymus_class_lambda;

import java.util.function.Predicate;

public class Run {

    public static void main(String[] args) {

        TaskManager tm = new TaskManager();
        tm.add(new A()); // strategy design pattern. create a concrete class of Task and receive it

         int x=0; // actually: final int x=0;

        //anonymous class: unnamed class who implements Task
        tm.add(new Task() {
            // int x;
            // Task(int x) {this.x = x}   - thats what really happened. x was transferred by value

            @Override
            public void doTask(int x, int y) {
                // x=5; can't do this! this changes only the by value x, not the original
                //System.out.println("Anonymous Task" + x); // x has to be initiated when declared,
                // beacuse this x is not the same as the first x. x was transferd by value to the anonymous class
                // thats why x has to be final

                System.out.println("Anonymous Task");

            }
        });

        // Lambda expression
        tm.add((a,y)-> System.out.println("Lambda Expression "+a + " " + y));

        //Predicate.java.util :
        Predicate<String> pr = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                // have to implement only the test method if the Predicate interface
                return false;
            }
        };

        // our Predicate interface:
        t6_functional_interface_anonymus_class_lambda.Predicate<Integer> p = i-> i>5;
        t6_functional_interface_anonymus_class_lambda.Predicate<Integer> p2 = i-> i%2==0;

        System.out.println(p.test(3)); // false
        System.out.println(p.test(6)); // will receive true 6>5

        System.out.println();

        System.out.println(p.negate().test(3)); //true
        System.out.println(p.negate().test(6)); //false

        System.out.println();

        System.out.println(p.and(p2).test(10)); // is 10 bigger than 5 *and* is an even number?
        System.out.println(p.and(p2).test(2));
        System.out.println();
        //p.negate() = is b <= 5?
        //.and(p2) = and b is even
        //.or(b->b>10) = p.negate().and(p2) or b > 10
        //total: (b <=5 and is even) or (b>10)
        t6_functional_interface_anonymus_class_lambda.Predicate<Integer> p3 = p.negate().and(p2).or(b->b>10);

        System.out.println(p3.test(2)); // true: 2<=5 and is even, or 2>10
        System.out.println(p3.test(5)); // false: 5<=5 and is even = false, or 5>10 is also false
        System.out.println(p3.test(6)); // (6<=5 and is even) or (6>10) = false
        System.out.println(p3.test(7)); // (7<=5 and is even) or (7>10) = false
        System.out.println(p3.test(11)); // (11<=5 and is even) or (11>10) = true


    }

}
