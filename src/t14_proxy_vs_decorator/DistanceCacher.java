package t14_proxy_vs_decorator;

import java.awt.Point;
import java.util.HashMap;

public class DistanceCacher implements DistanceCalculator{ // the proxy of the DistanceCalculator

    HashMap<String, Double> map;
    DistanceCalculator dc; // create a field of the class that this class is its proxy

    public DistanceCacher(DistanceCalculator dc) {
        this.dc = dc;
        map = new HashMap<>();
    }

    @Override
    public double getDistance(Point p1, Point p2) {
        // checks if we already calculated these distance with the EucDist, and returns it if we did
        String k1 = p1.toString() + "," + p2.toString();
        if(map.containsKey(k1))
            return map.get(k1);

        String k2 = p2.toString() + "," + p1.toString();
        if(map.containsKey(k2))
            return map.get(k2);

        // if we didn't calculated this distance before, we'll call EucDist.getDistance, and put it in the map
        double dist = dc.getDistance(p1, p2);
        map.put(k1, dist);
        map.put(k2, dist);

        return dist;

    }
}
