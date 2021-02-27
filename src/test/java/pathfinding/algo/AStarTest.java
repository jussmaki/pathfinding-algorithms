package pathfinding.algo;

import utils.PSUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pathfinding.domain.Point;

public class AStarTest {

    @Test
    public void findsNotRouteWhenThereIsNoRoute() {
        int[][] arr = {{1, 1, 1},
                       {0, 0, 0},
                       {1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertPSToArrayList(AStar.search(arr, 0, 0, 2, 2).getPath());
        assertEquals(0, path.size());
    }
    
    @Test
    public void findsRouteWhenThereIsOne1() {
        int[][] arr = {{1, 1, 1},
                       {1, 1, 1},
                       {1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertPSToArrayList(AStar.search(arr, 0, 0, 2, 2).getPath());
        assertTrue(path.size() > 0);
    }
    
    @Test
    public void findsRouteWhenThereIsOne2() {
        int[][] arr = {{1, 1, 0, 1, 1},
                       {1, 1, 1, 0, 1},
                       {1, 0, 1, 1, 1},
                       {1, 1, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertPSToArrayList(AStar.search(arr, 0, 1, 4, 3).getPath());
        assertTrue(path.size() > 0);
    }    

    @Test
    public void onlyPassablePointsOnRoute() {
        int[][] arr = {{1, 1, 0, 1, 1},
                       {1, 1, 1, 0, 1},
                       {1, 0, 1, 1, 1},
                       {1, 1, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertPSToArrayList(AStar.search(arr, 0, 1, 4, 3).getPath());
        assertFalse(path.contains(new Point(0, 2)));
        assertFalse(path.contains(new Point(1, 3)));
        assertFalse(path.contains(new Point(2, 1)));
        assertFalse(path.contains(new Point(3, 2)));
        assertFalse(path.contains(new Point(3, 3)));
    }    
    
}
