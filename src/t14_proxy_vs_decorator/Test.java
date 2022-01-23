package t14_proxy_vs_decorator;

import java.awt.Point;

public class Test {

    public static void main(String[] args) {
        Point p1 = new Point(10,20);
        Point p2 = new Point(30,-150);

//        DistanceCalculator dc = new EuclideanDistance();
        DistanceCalculator dc = new DistanceCacher(new EuclideanDistance()); // use the DistanceCalculator's proxy. Decorator: wrap a specifice DistanceCalculator
        // with the DistanceCalculator

        System.out.println(dc.getDistance(p1,p2));
        System.out.println(dc.getDistance(p1,p2));
        System.out.println(dc.getDistance(p2,p1));

        System.out.println("num of calls to EucDist: " + EuclideanDistance.calls);

    }
}
