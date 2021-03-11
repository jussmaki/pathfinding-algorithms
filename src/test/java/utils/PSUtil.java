package utils;

import java.util.ArrayList;
import pathfinding.domain.Point;
import pathfinding.struct.StackQueue;

public class PSUtil {
    public static ArrayList<Point> convertSQToArrayList(StackQueue<Point> ps) {
        ArrayList<Point> ret = new ArrayList<>();
        while (!ps.isEmpty()) {
            ret.add(ps.pop());
        }
        return ret;
    }
}
