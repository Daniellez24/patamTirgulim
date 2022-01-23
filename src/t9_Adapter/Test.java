package t9_Adapter;

public class Test {

    public static void main(String[] args) {
        Thread t = new Thread(new TaskRunnable(new CodeExecuterTask())); // new Thread expects to receive a Runnable, it got TaskRunnable,
        // and the TaskRunnable got the specific Task
        t.start(); // TaskRunnable calls run() that calls CodeExecuterTask.doTask()
    }
}
