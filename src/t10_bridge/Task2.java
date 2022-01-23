package t10_bridge;

public class Task2 implements Task{

    @Override
    public void doTask(Logger l) {
        //..
        // does the other Task
        l.writeToLog("some log entry");
        //..
        // does the other Task
        l.writeToLog("some other log entry");
    }

}
