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
            long totalTime = 0;
            for (Scenario s : scenarios) {
                Result r = null;
                if (algo.equals("djikstra")) {
                    r = Djikstra.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                }
                if (algo.equals("astar")) {
                    r = AStar.search(arr,  s.getStartX(), s.getStartY(), s.getEndX(), s.getEndY());
                }
                if (algo.equals("ida")) {
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
                System.out.println(r);
                totalTime += r.getRunTime();
                String result = algo + " " + r.getRunTime() +  " " + mapName + " " + r;
                writeToFile(outputFile, result);
            }
            writeToFile(outputFile, algo + " total time: " + totalTime +
                    " ns (" + totalTime / 1e9 + " s.) on map: " + mapName);
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
