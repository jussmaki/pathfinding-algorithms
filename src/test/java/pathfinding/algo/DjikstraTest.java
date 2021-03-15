package pathfinding.algo;

import java.io.FileNotFoundException;
import utils.PSUtil;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import pathfinding.domain.Point;
import pathfinding.domain.Result;
import pathfinding.file.MapReader;
import utils.Scenario;
import utils.ScenarioReader;

public class DjikstraTest {
    
    @Test
    public void findsNotRouteWhenThereIsNoRoute() {
        int[][] arr = {{1, 1, 1},
                       {0, 0, 0},
                       {1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(Djikstra.search(arr, 0, 0, 2, 2).getPath());
        assertEquals(0, path.size());
    }
    
    @Test
    public void findsRouteWhenThereIsOne1() {
        int[][] arr = {{1, 1, 1},
                       {1, 1, 1},
                       {1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(Djikstra.search(arr, 0, 0, 2, 2).getPath());
        assertTrue(path.size() > 0);
    }
    
    @Test
    public void findsRouteWhenThereIsOne2() {
        int[][] arr = {{1, 1, 0, 1, 1},
                       {1, 1, 1, 0, 1},
                       {1, 0, 1, 1, 1},
                       {1, 1, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(Djikstra.search(arr, 0, 1, 4, 3).getPath());
        assertTrue(path.size() > 0);
    }    

    @Test
    public void onlyPassablePointsOnRoute() {
        int[][] arr = {{1, 1, 0, 1, 1},
                       {1, 1, 1, 0, 1},
                       {1, 0, 1, 1, 1},
                       {1, 1, 0, 0, 1},
                       {1, 1, 1, 1, 1}};
        ArrayList<Point> path = PSUtil.convertSQToArrayList(Djikstra.search(arr, 0, 1, 4, 3).getPath());
        assertFalse(path.contains(new Point(0, 2)));
        assertFalse(path.contains(new Point(1, 3)));
        assertFalse(path.contains(new Point(2, 1)));
        assertFalse(path.contains(new Point(3, 2)));
        assertFalse(path.contains(new Point(3, 3)));
    }
    
    @Test
    public void findsShortestsPathOnAllHTStoreMap() {
        ArrayList<Scenario> scenarios;
        int[][] arr;
        try {
            scenarios = ScenarioReader.readScenarios("resources/ht_store.map.scen");
            arr = MapReader.readMap("resources/ht_store.map");
            if (scenarios == null || scenarios.isEmpty()) {
                fail("loading scenarios failed");
            }
            for (Scenario s : scenarios) {
                Result r = Djikstra.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                float resultDistance = (float) r.getDistance();
                float scenarioDistance = (float) s.getShortestPath();
                assertTrue(scenarioDistance == resultDistance);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.toString());
        }
    }
    
    @Test
    public void findsShortesstPathOnParisMap() {
        ArrayList<Scenario> scenarios;
        int[][] arr;
        try {
            scenarios = ScenarioReader.readScenarios("resources/Paris_0_1024.map.scen");
            arr = MapReader.readMap("resources/Paris_0_1024.map");
            if (scenarios == null || scenarios.isEmpty()) {
                fail("loading scenarios failed");
            }
            
            Collections.shuffle(scenarios);
            
            for (int i = 0; i < 50; i++) {
                Scenario s = scenarios.get(0);
                Result r = Djikstra.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                float resultDistance = (float) r.getDistance();
                float scenarioDistance = (float) s.getShortestPath();
                assertTrue(scenarioDistance == resultDistance);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.toString());
        }
    }
    
    @Test
    public void findsShortestPathsOnMoscowMap() {
        ArrayList<Scenario> scenarios;
        int[][] arr;
        try {
            scenarios = ScenarioReader.readScenarios("resources/Moscow_2_1024.map.scen");
            arr = MapReader.readMap("resources/Moscow_2_1024.map");
            if (scenarios == null || scenarios.isEmpty()) {
                fail("loading scenarios failed");
            }
            
            Collections.shuffle(scenarios);
            
            for (int i = 0; i < 50; i++) {
                Scenario s = scenarios.get(0);
                Result r = Djikstra.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                float resultDistance = (float) r.getDistance();
                float scenarioDistance = (float) s.getShortestPath();
                assertTrue(scenarioDistance == resultDistance);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.toString());
        }
    }
    
    @Test
    public void findsShortestPathsInAllScenariousOnLTHouseMap() {
        ArrayList<Scenario> scenarios;
        int[][] arr;
        try {
            scenarios = ScenarioReader.readScenarios("resources/lt_house.map.scen");
            arr = MapReader.readMap("resources/lt_house.map");
            if (scenarios == null || scenarios.isEmpty()) {
                fail("loading scenarios failed");
            }
            
            for (Scenario s : scenarios) {
                Result r = Djikstra.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                float resultDistance = (float) r.getDistance();
                float scenarioDistance = (float) s.getShortestPath();
                assertTrue(scenarioDistance == resultDistance);
            }
        } catch (FileNotFoundException ex) {
            fail(ex.toString());
        }
    }
    
}
