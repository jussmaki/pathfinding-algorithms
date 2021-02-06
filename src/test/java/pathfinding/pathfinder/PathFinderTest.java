package pathfinding.pathfinder;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import pathfinding.domain.Point;

public class PathFinderTest {

    @Test
    public void PathFinderFindsRoute() {
        PathFinder pathFinder = new PathFinder();
        try {
            pathFinder.openMapFile("src/test/java/pathfinding/file/test.map");
        } catch (Exception ex) {
            fail(ex.toString());
        }
        ArrayList<Point> route = pathFinder.searchDjikstra(0, 4, 9, 2);
        assertTrue(route.size() > 0);        
    }

    
    
}
