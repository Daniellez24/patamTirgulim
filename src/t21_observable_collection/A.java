package t21_observable_collection;

import java.util.Observable;

/**Data stractur that will notify us when some things changed*/
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
