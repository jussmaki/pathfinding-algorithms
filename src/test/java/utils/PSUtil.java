package utils;

import java.util.ArrayList;
import pathfinding.domain.Point;
import pathfinding.struct.PointStack;

public class PSUtil {
    public static ArrayList<Point> convertPSToArrayList(PointStack ps) {
        ArrayList<Point> ret = new ArrayList<>();
        while (!ps.isEmpty()) {
            ret.add(ps.pop());
        }
        return ret;
    }
}
