package pathfinding.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScenarioReader {

    /**
     * Read .scen-file
     * @param fileName
     * @return Scenarios as ArrayList
     * @throws FileNotFoundException
     */    
    public static ArrayList<Scenario> readScenarios(String fileName) throws FileNotFoundException {
        ArrayList<Scenario> scenarios = new ArrayList<>();
        Scanner s = new Scanner(new File(fileName));
        if (!s.hasNextLine() || !s.nextLine().contains("version")) {
            throw new IllegalArgumentException();
        }
        while (s.hasNextLine()) {
            String nextLine = s.nextLine();
            String[] parts = nextLine.split("\\s+");
            int startX = Integer.valueOf(parts[4]);
            int startY = Integer.valueOf(parts[5]);
            int endX = Integer.valueOf(parts[6]);
            int endY = Integer.valueOf(parts[7]);
            double shortestPath = Double.valueOf(parts[8]);
            scenarios.add(new Scenario(startX, startY, endX, endY, shortestPath));
        }
        return scenarios;
    }

}
