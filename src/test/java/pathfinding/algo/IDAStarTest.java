package pathfinding.algo;

import java.io.FileNotFoundException;
import utils.PSUtil;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import pathfinding.domain.Point;
import pathfinding.domain.Result;
import pathfinding.file.MapReader;
import pathfinding.file.Scenario;
import pathfinding.file.ScenarioReader;

public class IDAStarTest {

    @Test
    public void findsNotRouteWhenThereIsNoRoute() {
        int[][] arr = {{1, 1, 1},
                       {0, 0, 0},
                       {1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(IDAStar.search(arr, 0, 0, 2, 2).getPath());
        assertEquals(0, path.size());
    }
    
    @Test
    public void findsRouteWhenThereIsOne1() {
        int[][] arr = {{1, 1, 1},
                       {1, 1, 1},
                       {1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(IDAStar.search(arr, 0, 0, 2, 2).getPath());
        assertTrue(path.size() > 0);
    }
    
    @Test
    public void findsRouteWhenThereIsOne2() {
        int[][] arr = {{1, 1, 0, 1, 1},
                       {1, 1, 1, 0, 1},
                       {1, 0, 1, 1, 1},
                       {1, 1, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(IDAStar.search(arr, 0, 1, 4, 3).getPath());
        assertTrue(path.size() > 0);
    }    

    @Test
    public void onlyPassablePointsOnRoute() {
        int[][] arr = {{1, 1, 0, 1, 1},
                       {1, 1, 1, 0, 1},
                       {1, 0, 1, 1, 1},
                       {1, 1, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(IDAStar.search(arr, 0, 1, 4, 3).getPath());
        assertFalse(path.contains(new Point(0, 2)));
        assertFalse(path.contains(new Point(1, 3)));
        assertFalse(path.contains(new Point(2, 1)));
        assertFalse(path.contains(new Point(3, 2)));
        assertFalse(path.contains(new Point(3, 3)));
    }
    
    @Test
    public void findsShortestsPathInAllScenariousOnLTHouseMap() {
        ArrayList<Scenario> scenarios;
        int[][] arr;
        try {
            scenarios = ScenarioReader.readScenarios("resources/lt_house.map.scen");
            arr = MapReader.readMap("resources/lt_house.map");
            if (scenarios == null || scenarios.isEmpty()) {
                fail("loading scenarios failed");
            }
            
            for (Scenario s : scenarios) {
                Result r = AStar.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                float resultDistance = (float) r.getDistance();
                float scenarioDistance = (float) s.getShortestPath();
                assertTrue(Math.abs(scenarioDistance - resultDistance) <= 0.002);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.toString());
        }
    }
}
