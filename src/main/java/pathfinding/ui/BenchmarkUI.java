package pathfinding.ui;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import pathfinding.algo.AStar;
import pathfinding.algo.Djikstra;
import pathfinding.algo.IDAStar;
import pathfinding.domain.Result;
import pathfinding.file.MapReader;
import pathfinding.file.Scenario;
import pathfinding.file.ScenarioReader;


public class BenchmarkUI {

    public static void start(String[] args) {
        if (args.length < 3) {
            System.out.println("too few arguments");
            return;
        }
        if (!args[0].toLowerCase().equals("djikstra") && !args[0].toLowerCase().equals("astar") &&
                !args[0].toLowerCase().equals("idastar")) {
            System.out.println("algorithm not known");
            return;
        }
        testScenarios(args[0].toLowerCase(), args[1], args[2]);
    }
    
    public static void testScenarios(String algo, String mapName, String outputFile) {
        ArrayList<Scenario> scenarios;
        int[][] arr;
        try {
            scenarios = ScenarioReader.readScenarios(mapName + ".map.scen");
            arr = MapReader.readMap(mapName + ".map");
            if (scenarios == null || scenarios.isEmpty()) {
                System.out.println("loading scenarios failed");
                return;
            }
            long totalScenarios = 0; 
            long totalTime = 0;
            double totalDistance = 0;
            long totalNodesInPath = 0;
            long totalVisitedNodes = 0;
            for (Scenario s : scenarios) {
                Result r = null;
                if (algo.equals("djikstra")) {
                    r = Djikstra.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                }
                if (algo.equals("astar")) {
                    r = AStar.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                }
                if (algo.equals("idastar")) {
                    r = IDAStar.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                }
                float resultDistance = (float) r.getDistance();
                float scenarioDistance = (float) s.getShortestPath();
                if (Math.abs(scenarioDistance - resultDistance) >= 0.002) {
                    System.out.println("distance mitshmatch");
                    System.out.println(r);
                    System.out.println(s);
                    return;
                }
                //System.out.println(r);
                totalScenarios += 1;
                totalTime += r.getRunTime();
                totalDistance += r.getDistance();
                totalNodesInPath += r.getNoNodesInPath();
                totalVisitedNodes += r.getVisitedNoNodes();

                
                String result = algo + " " + r.getRunTime() +  " ns. " + mapName +
                        " start: " + s.getStartX() + "," + s.getStartY() +
                        " end: " + s.getEndX() + "," + s.getEndY() + " " + r;
                writeToFile(outputFile, result);
                System.out.println(result);
            }
            String resultTotals = algo + " on map: " + mapName + ".map\n" +
                    "scenarios count: " + totalScenarios + "\n" +
                    "total time: " + totalTime + " ns\n" +
                    "total time: " + (totalTime / 1e9) + " s\n" +
                    "total distance: " + totalDistance + "\n" +
                    "total nodes in paths: " + totalNodesInPath + "\n" +
                    "total visited nodes: " + totalVisitedNodes;
            writeToFile(outputFile, resultTotals);
            System.out.println(resultTotals);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
    private static void writeToFile(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
            out.println(text);
            out.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
