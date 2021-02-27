package pathfinding.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapReader {
   
    /**
     * Read .map-file
     * @param fileName
     * @return graph as array object, 1=passable, 0=not passable
     * @throws FileNotFoundException
     */
    public static int[][] readMap(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File(fileName));
        if (!s.hasNextLine() || !s.nextLine().equals("type octile")) {
            throw new IllegalArgumentException();
        }

        int height = Integer.valueOf(s.nextLine().split(" ")[1]);
        int width = Integer.valueOf(s.nextLine().split(" ")[1]);
        if (!s.nextLine().equals("map")) {
            throw new IllegalArgumentException();
        }
        int[][] map = new int[height][width];
        int column = 0;
        while (s.hasNextLine()) {
            String row = s.nextLine();
            //System.out.println("row: " + row);
            for (int i = 0; i < row.length(); i++) {
                if ((row.substring(i, i + 1).equals(".")) || (row.substring(i, i + 1).equals("G"))) {
                    map[i][column] = 1; //ei estettä
                } else {
                    map[i][column] = 0; //este
                }
            }
            column++;
        }
        return map;
    }
}
