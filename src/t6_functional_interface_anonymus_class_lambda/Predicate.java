package t6_functional_interface_anonymus_class_lambda;

public interface Predicate<T> {

    boolean test(T t);

    default public Predicate<T> and(Predicate<T> other){

       return t->test(t) && other.test(t);

    }

    default Predicate<T> negate(){ // returns new function! הרכבה של פומקציה
        Predicate<T> first = this;
        Predicate<T> p = new Predicate<T>() {
            @Override
            public boolean test(T t) {
                return !first.test(t); // the test method of the object who ran the negate method
            }
        };

        //return p;

        //Lambda:
        return t->!test(t); // only this line is necessary for negate method!
    }

    default Predicate<T> or(Predicate<T> other){

        return t-> test(t) || other.test(t);

    }

}
