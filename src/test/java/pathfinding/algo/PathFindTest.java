package pathfinding.algo;

import utils.PSUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pathfinding.domain.Point;

public class PathFindTest {
    
    @Test
    public void getNeighbourCellsWorks1() {
        int[][] arr = {{1, 1},
                       {1, 1}};
        
        ArrayList<Point> neighbours1 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 0, 0));
        assertEquals(3, neighbours1.size());
        assertTrue(neighbours1.contains(new Point(0, 1)));
        assertTrue(neighbours1.contains(new Point(1, 1)));
        assertTrue(neighbours1.contains(new Point(1, 0)));
        
        ArrayList<Point> neighbours2 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 0, 1));
        assertEquals(3, neighbours2.size());
        assertTrue(neighbours2.contains(new Point(0, 0)));
        assertTrue(neighbours2.contains(new Point(1, 1)));
        assertTrue(neighbours2.contains(new Point(1, 0))); 

        ArrayList<Point> neighbours3 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 1, 0));
        assertEquals(3, neighbours3.size());
        assertTrue(neighbours3.contains(new Point(0, 1)));
        assertTrue(neighbours3.contains(new Point(1, 1)));
        assertTrue(neighbours3.contains(new Point(0, 0))); 
        
        ArrayList<Point> neighbours4 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 1, 1));
        assertEquals(3, neighbours4.size());
        assertTrue(neighbours4.contains(new Point(0, 1)));
        assertTrue(neighbours4.contains(new Point(0, 0)));
        assertTrue(neighbours4.contains(new Point(1, 0))); 
    }
    
    @Test
    public void getNeighbourCellsworks2() {
        int[][] arr = {{0, 0},
                       {0, 0}};
        assertEquals(0, PathFind.getNeighbourCells(arr, 0, 0).size());
        assertEquals(0, PathFind.getNeighbourCells(arr, 0, 1).size());
        assertEquals(0, PathFind.getNeighbourCells(arr, 1, 1).size());
        assertEquals(0, PathFind.getNeighbourCells(arr, 1, 0).size());  
    }
    
    @Test
    public void getNeighbourCellsworks3() {
        int[][] arr = {{1, 1, 1},
                       {1, 0, 1},
                       {1, 1, 1}};
        ArrayList<Point> neighbours1 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 0, 0));
        assertEquals(2, neighbours1.size());
        assertTrue(neighbours1.contains(new Point(1, 0)));
        assertTrue(neighbours1.contains(new Point(0, 1)));
        ArrayList<Point> neighbours2 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 1, 0));
        assertEquals(2, neighbours2.size());
        assertTrue(neighbours2.contains(new Point(0, 0)));
        assertTrue(neighbours2.contains(new Point(2, 0)));
        ArrayList<Point> neighbours3 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 2, 0));
        assertEquals(2, neighbours3.size());
        assertTrue(neighbours3.contains(new Point(1, 0)));
        assertTrue(neighbours3.contains(new Point(2, 1)));
        ArrayList<Point> neighbours4 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 0, 1));
        assertEquals(2, neighbours4.size());
        assertTrue(neighbours4.contains(new Point(0, 0)));
        assertTrue(neighbours4.contains(new Point(0, 2)));
        ArrayList<Point> neighbours5 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 2, 1));
        assertEquals(2, neighbours5.size());
        assertTrue(neighbours5.contains(new Point(2, 0)));
        assertTrue(neighbours5.contains(new Point(2, 2)));
        ArrayList<Point> neighbours6 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 0, 2));
        assertEquals(2, neighbours6.size());
        assertTrue(neighbours6.contains(new Point(0, 1)));
        assertTrue(neighbours6.contains(new Point(1, 2)));        
        ArrayList<Point> neighbours7 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 1, 2));
        assertEquals(2, neighbours7.size());
        assertTrue(neighbours7.contains(new Point(0, 2)));
        assertTrue(neighbours7.contains(new Point(2, 2)));     
        ArrayList<Point> neighbours8 = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 2, 2));
        assertEquals(2, neighbours8.size());
        assertTrue(neighbours8.contains(new Point(1, 2)));
        assertTrue(neighbours8.contains(new Point(2, 1)));        
    }
    

    @Test
    public void getNeighbourCellsworks4() {
        int[][] arr = {{1, 1, 1},
                       {1, 1, 1},
                       {1, 1, 1}};
        ArrayList<Point> neighbours = PSUtil.convertSQToArrayList(PathFind.getNeighbourCells(arr, 1, 1));
        assertEquals(8, neighbours.size());
        assertTrue(neighbours.contains(new Point(0, 0)));
        assertTrue(neighbours.contains(new Point(0, 1)));
        assertTrue(neighbours.contains(new Point(0, 2)));
        assertTrue(neighbours.contains(new Point(1, 0)));
        assertTrue(neighbours.contains(new Point(1, 2)));
        assertTrue(neighbours.contains(new Point(2, 0)));
        assertTrue(neighbours.contains(new Point(2, 1)));
        assertTrue(neighbours.contains(new Point(2, 2)));
    }    
}
