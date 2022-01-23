package t22_observable_prioirity_queue;

import java.util.PriorityQueue;

public class main {
    public static void main(String[] args) {
         /** By default - sometimes we will need to remove and then add items
             because the Q does not know when a state change (in q object) occurs*/
        MyPriorityQueue<A> q = new MyPriorityQueue<>(((a1, a2) -> a1.get() - a2.get()));
        q.add(new A(5));

        A a = new A(10);
        q.add(a);

        a.setX(2);

        q.add(new A(20));

        while (!q.isEmpty()){
            System.out.println(q.poll().get());
        }


    }
}
