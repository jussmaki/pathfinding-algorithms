package pathfinding.domain;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MazeTest {
    @Test
    public void arrayToAdjacencyListWorks1() {
        int[][] arr = {{1, 1},
                      {1, 1}};
        Maze m = new Maze(arr);
        ArrayList<Node>[] res = m.toAdjacencyList();
        assertEquals(3, res[1].size());
        assertTrue(res[1].contains(new Node(2)));
        assertTrue(res[1].contains(new Node(3)));
        assertTrue(res[1].contains(new Node(4)));      
        assertEquals(3, res[2].size());
        assertTrue(res[2].contains(new Node(3)));
        assertTrue(res[2].contains(new Node(1)));
        assertTrue(res[2].contains(new Node(4)));  

        assertEquals(3, res[3].size());
        assertTrue(res[3].contains(new Node(1)));
        assertTrue(res[3].contains(new Node(2)));
        assertTrue(res[3].contains(new Node(4)));
    }
    
    @Test
    public void arrayToAdjacencyListWorks2() {
        int[][] arr = {{0, 0},
                      {0, 0}};
        Maze m = new Maze(arr);
        ArrayList<Node>[] res = m.toAdjacencyList();
        assertEquals(0, res[1].size());
        assertEquals(0, res[2].size());
        assertEquals(0, res[3].size());        
    }    
}
