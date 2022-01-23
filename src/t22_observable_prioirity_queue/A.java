package t22_observable_prioirity_queue;

import java.util.Observable;

/**Data structure that will notify us when some things changed*/
public class A extends Observable{
    int x;

    public A(int x) {
        this.x = x;
    }

    public int get() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        setChanged();
        notifyObservers();

    }
}
