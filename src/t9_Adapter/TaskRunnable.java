package t9_Adapter;

public class TaskRunnable implements Runnable{
    // we'd like to run a specific Task as a Runnable, so it could run in a Thread:
    // Adaptation from Task to Runnable: Object Adapter

    Task t;

    public TaskRunnable(Task t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.doTask();
    }
}
