package t20_data_binding_with_observer;

public class main {
    public static void main(String[] args) {
        /**Observable - can be watched on
         * Observers - the one who watch
         * */

        Property<Integer> p1 = new Property<>();
        Property<Integer> p2 = new Property<>();
        Property<Integer> p3 = new Property<>();
        Property<Integer> p4 = new Property<>();

        /**When p1 changes his value so does p2*/
        p2.bindTo(p1);
        p3.bindTo(p2);
        p1.bindTo(p3);

        /**When p1/p4 changes so does p4/p1*/
        p1.bind(p4);

        p4.onChange(x -> System.out.println("P4 value has changed to "  + x));

        p1.set(100);

        System.out.println("p3 value is " + p3.get());
    }
}
