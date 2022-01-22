package t6_functional_interface_anonymus_class_lambda;

import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks;

    public TaskManager(){
        tasks = new ArrayList<>();

    }

    public void add(Task t){
        tasks.add(t);
    }
}
