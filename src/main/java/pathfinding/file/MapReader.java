package pathfinding.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import pathfinding.domain.Maze;


public class MapReader {
   
    public MapReader() {

    }

    /**
     *
     * @param fileName
     * @return graph as Maze object
     * @throws FileNotFoundException
     */
    public Maze readMap (String fileName) throws FileNotFoundException {
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
        while(s.hasNextLine()) {
            String row = s.nextLine();
            //System.out.println("row: " + row);
            for (int i=0;i<row.length();i++) {
                if ((row.substring(i,i+1).equals(".")) || (row.substring(i,i+1).equals("G"))) {
                    map[column][i] = 1;
                } else {
                    map[column][i] = 0;
                }
                //System.out.println(row.substring(i,i));
                //if (((row[i].equals(".")) || (row[i].equals("G"))) {
            }
            column++;
        }
        return new Maze(map);
        //throw new FileFormatException(this.mapFile);
    }
}
