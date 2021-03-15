package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScenarioReader {
   
    public static ArrayList<Scenario> readScenarios(String fileName) throws FileNotFoundException {
        ArrayList<Scenario> scenarios = new ArrayList<>();
        Scanner s = new Scanner(new File(fileName));
        if (!s.hasNextLine() || !s.nextLine().contains("version")) {
            throw new IllegalArgumentException();
        }
        while (s.hasNextLine()) {
            String nextLine = s.nextLine();
            //nextLine = nextLine.strip();
            String[] parts = nextLine.split("\\s+");

            /*for (String part : parts) {
                //if (part == " ") {
                //    
                //}
                //System.out.print(part);

                //scenarios.add(new Scenario(part))
            }*/
            int startX = Integer.valueOf(parts[4]);
            int startY = Integer.valueOf(parts[5]);
            int endX = Integer.valueOf(parts[6]);
            int endY = Integer.valueOf(parts[7]);
            double shortestPath = Double.valueOf(parts[8]);
            scenarios.add(new Scenario(startX, startY, endX, endY, shortestPath));
            //System.out.println("");
        }

        
        return scenarios;
    }

}
