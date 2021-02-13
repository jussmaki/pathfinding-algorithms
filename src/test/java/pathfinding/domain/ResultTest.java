package pathfinding.domain;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ResultTest {
    
    @Test
    public void returnCorrectNoOfNodesInpath() {
        ArrayList<Point> path = new ArrayList<>();
        path.add(new Point(1,1));
        path.add(new Point(2,1));
        path.add(new Point(3,1));
        Result res = new Result();
        res.setPath(path);
        assertEquals(3, res.getNoNodesInPath());
    }
}
