package t21_observable_collection;

import java.util.Collection;
import java.util.LinkedList;
/**I wrote the code, but it was not total understandable to me
 * So there are no comments on it*/
public class main {
    public static void main(String[] args) {
        ObservableCollection<A> c = new ObservableCollection<A>(new LinkedList<A>());
        c.add(new A(0));
        c.add(new A(1));
        c.add(new A(2));


        A a = new A(3);

        c.onChange((Collection<A> collection) -> {
            System.out.println("List changed");
            collection.forEach(e -> System.out.println(e.get()));
            System.out.println();
        });


        c.add(a);
        a.setX(5);
        c.remove(a);
    }
}
