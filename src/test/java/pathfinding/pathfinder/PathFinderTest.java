package pathfinding.pathfinder;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import pathfinding.domain.Point;
import utils.PSUtil;

public class PathFinderTest {

    @Test
    public void PathFinderFindsRouteDjikstra() {
        PathFinder pathFinder = new PathFinder();
        try {
            pathFinder.openMapFile("src/test/java/pathfinding/file/test.map");
        } catch (Exception ex) {
            fail(ex.toString());
        }
        ArrayList<Point> path = PSUtil.convertSQToArrayList(pathFinder.searchDjikstra(0, 4, 9, 2).getPath());
        assertTrue(path.size() > 0);        
    }

    @Test
    public void PathFinderFindsRouteAStar() {
        PathFinder pathFinder = new PathFinder();
        try {
            pathFinder.openMapFile("src/test/java/pathfinding/file/test.map");
        } catch (Exception ex) {
            fail(ex.toString());
        }
        ArrayList<Point> path = PSUtil.convertSQToArrayList(pathFinder.searchAStar(0, 4, 9, 2).getPath());
        assertTrue(path.size() > 0);        
    }
    
    @Test
    public void PathFinderFindsRouteIDAStar() {
        PathFinder pathFinder = new PathFinder();
        try {
            pathFinder.openMapFile("src/test/java/pathfinding/file/test.map");
        } catch (Exception ex) {
            fail(ex.toString());
        }
        ArrayList<Point> path = PSUtil.convertSQToArrayList(pathFinder.searchIDAStar(0, 4, 9, 2).getPath());
        assertTrue(path.size() > 0);        
    }    
    
}
