package t22_observable_prioirity_queue;

import java.util.*;

public class MyPriorityQueue<T> implements Observer {
    PriorityQueue<T> q;

    public MyPriorityQueue(Comparator<T> c) {
        q = new PriorityQueue<>(c);
    }

    @Override
    public void update(Observable o, Object arg) {
        q.remove(o);
        q.add((T) o);
    }

    public void add(T t) {
        if(t instanceof Observable){
            Observable o = (Observable)t;
            o.addObserver(this);
        }
        q.add(t);
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public T poll() {
        return q.poll();
    }


}
