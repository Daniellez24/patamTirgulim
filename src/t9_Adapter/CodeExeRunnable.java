package t9_Adapter;

public class CodeExeRunnable extends CodeExecuterTask implements Runnable{ // Class Adapter: use inheritance of the class we want to use its protected methods,
    // and implements the interface we want this class to be adapted to

    @Override
    public void run() {
        // using the CodeExecuterTask protected methods
        preCompile();
        compile();
        execute();
    }
}
