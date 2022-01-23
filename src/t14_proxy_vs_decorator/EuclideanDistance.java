package t14_proxy_vs_decorator;

import java.awt.*;

public class EuclideanDistance implements DistanceCalculator{

    public static int calls = 0; // check: counts how many times we used the getDistance method

    @Override
    public double getDistance(Point p1, Point p2) {
        calls++;
        int X = p1.x-p2.x;
        int Y = p1.y-p2.y;
        return Math.sqrt(X*X + Y*Y);
    }
}
