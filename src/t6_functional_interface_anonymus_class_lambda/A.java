package t6_functional_interface_anonymus_class_lambda;

public class A implements Task{

    @Override
    public void doTask(int x, int y) {
        System.out.println("A's a task "+x + " " + y);
    }
}
