package t9_Adapter;

public class CodeExecuterTask implements Task {

    // with an Object Adapter we can't use methods that aren't public. so we'll use Class Adapter (we have to use inheritance)
    protected void preCompile() { /*..*/ }
    protected void compile() { /*..*/ }
    protected void execute() { /*..*/ }

    @Override
    public void doTask() {
        //...
        execute();

    }
}
