package t21_observable_collection;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.function.Consumer;

public class ObservableCollection<E> implements Observer {

    private  Collection<E> collection;
    private Consumer<Collection<E>> consumer;

    public ObservableCollection(Collection<E> collection) {
        this.collection = collection;
    }

    @Override
    public void update(Observable o, Object arg) {
        notifyChanges();
    }

    public void add(E e) {
        if(e instanceof Observable){
            Observable o = (Observable)e;
            o.addObserver(this);
        }
        collection.add(e);
        notifyChanges();
    }

    public void remove(E e) {
        collection.remove(e);
        notifyChanges();
    }

    private void notifyChanges(){
        if(consumer != null){
            consumer.accept(collection);
        }
    }

    public void onChange(Consumer<Collection<E>> consumer) {
        this.consumer = consumer;

    }
}
