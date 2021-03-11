package pathfinding.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pathfinding.struct.StackQueue;

public class ResultTest {
    
    @Test
    public void returnCorrectNoOfNodesInpath() {
        StackQueue<Point> path = new StackQueue<>();
        path.push(new Point(1, 1));
        path.push(new Point(2, 1));
        path.push(new Point(3, 1));
        Result res = new Result();
        res.setPath(path);
        assertEquals(3, res.getNoNodesInPath());
    }
}
