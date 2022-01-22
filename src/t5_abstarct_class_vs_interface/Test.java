package t5_abstarct_class_vs_interface;

public class Test {

    // interface mentions only the functionality of something, and has no data members
//    interface A{
//        int x=0; // compiler: public static final int x=0; don't do it!! no data members in interfaces
//        // compiler sees: public abstract void m();
//        void m(); // no need to mention if its private/public... everybody who implemets A has to write it
//        void f();
//    }

    interface Task{
        void start();
        void stop();
        void pause();
    }

    class TaskManager{
        //....
        void add(Task t){ // Strategy design pattern
            //..
            t.start();
            //..
            t.stop();
        }
    }

    interface Swimmable{
        void swim();
    }

    interface Walkable{
        void walk();
    }

    interface Flyable{
        void fly();
    }

    interface Duck extends Swimmable, Walkable, Flyable{ // whoever extands Duck has to write all his methods and the //
        // methods he got from the other interfaces
        void quack();
    }

//    interface TaggedDuck extends Duck{
//        String getID(); // not enough. we want every duck to have an ID, and to initiate it in the constructor. use ABSTRACT CLASS!
//    }

    abstract class TaggedDuck implements Duck{ // we want the duck to have an ID, but we don't care about the implementations of the nethods.
        // thats why we use abstarct class
        String ID;

        // abstarct class can force his Yorshim to initiate ID in the constructor
        public TaggedDuck(String ID){
            this.ID = ID;
        }

        String getID(){
            return ID;
        }

    }

    interface Drawable{
        void Draw();
    }

    interface Danceable{
        void Dance();
    }

    class DonaldDuck extends TaggedDuck implements Drawable, Danceable{

        public DonaldDuck(String ID) { // we have to initiate ID because the abstarct class forced us
            super(ID);
        }

        public DonaldDuck() { // constructor doesn't have to receive parameters, can be default (without parameters)
            super("0");
        }

        // every constructor has to use super


        @Override
        public void swim() {

        }

        @Override
        public void walk() {

        }

        @Override
        public void fly() {

        }

        @Override
        public void quack() {

        }

        @Override
        public void Draw() {

        }

        @Override
        public void Dance() {

        }
    }

    interface Iterator<T>{
        boolean hasNext();
        // which type do we return?
        //Object next(); // but we have to down casting... better solution:
        T next(); // T can be any type. טיפוס פרמטרי

    }

    interface Consumer<T>{
        void accept(T t);
    }

    interface Iterable<T>{
        Iterator<T> iterator(); // if our Data Structure is Iterable, it'll call this method and will get a referance to an iterator object

        default void forEach(Consumer<T> c){ // with a Consumer, forEach methods iterates the data Structure members and run the consumer method on each of them
            Iterator<T> it = iterator();
            while(it.hasNext()){
                T t = it.next();
                c.accept(t);
                // or just: c.accept(it.next());
            }

            m();
        }

        private void m(){ // can call a private method in an interface within another method in the interface
            //..
        }
    }

    interface Collection<E> extends Iterable<E>{
        void add(E e);
        //...
    }
}
