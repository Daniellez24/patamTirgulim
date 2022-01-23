package t10_bridge;

public class Test {

    public static void main(String[] args) {
        // Task t = new FileTask1()
        Task t = new Task1();
        t.doTask(new FileLogger());
    }
}
