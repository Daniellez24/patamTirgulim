package t6_functional_interface_anonymus_class_lambda;

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
            public void doTask() {
                // x=5; can't do this! this changes only the by value x, not the original
                System.out.println("Anonymous Task" + x); // x has to be initiated when declared,
                // beacuse this x is not the same as the first x. x was transferd by value to the anonymous class
                // thats why x has to be final

            }
        });


    }

}
