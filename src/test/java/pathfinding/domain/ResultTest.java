package pathfinding.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import pathfinding.struct.PointStack;

public class ResultTest {
    
    @Test
    public void returnCorrectNoOfNodesInpath() {
        PointStack path = new PointStack();
        path.push(new Point(1, 1));
        path.push(new Point(2, 1));
        path.push(new Point(3, 1));
        Result res = new Result();
        res.setPath(path);
        assertEquals(3, res.getNoNodesInPath());
    }
}
