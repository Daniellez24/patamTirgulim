package t20_data_binding_with_observer;

import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

public class Property<T> extends Observable implements Observer {
    T val;
    private Consumer<T> c;

    @Override
    public void update(Observable o, Object arg) {
        Property<T> p = (Property<T>) o;
        set(p.get());

    }

    public void bindTo(Property<T> p) {
        p.addObserver(this);
    }

    public void bind(Property<T> p) {
        this.bindTo(p);
        p.bindTo(this);

    }

    public void onChange(Consumer <T> c) {
        this.c = c;

    }

    public void set(T v) {
        if(val != v){
            val = v;
            if(c!= null){
                c.accept(val);
            }
            setChanged();
            notifyObservers();
        }
    }

    public T get() {
        return val;
    }
}
