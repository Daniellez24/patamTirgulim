package t10_bridge;

public class Task1 implements Task{

    @Override
    public void doTask(Logger l) {
        //..
        // does the Task
        l.writeToLog("some log entry");
        //..
        // does the Task
        l.writeToLog("some other log entry");

    }

    // before the bridge:
    // because of being abstract, Task1 forces its heirs classes to implement writeToLog (so they can write to anywhere they decide)
    // we had: FileTask1 extends Task1, DBTask1 extends Task1, SocketTask1 extends Task1.... but what happens when we have more than just
    //one Task? we have to implement these 3 for every Task (double code!). solution: Bridge
    // we created Logger interface, and Task receives a Logger as a parameter
    //protected abstract void writeToLog(String text);
}
