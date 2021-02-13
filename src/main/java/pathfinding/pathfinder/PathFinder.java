package pathfinding.pathfinder;

import java.util.ArrayList;
import pathfinding.algo.AStar;
import pathfinding.algo.Djikstra;
import pathfinding.domain.Point;
import pathfinding.domain.Result;
import pathfinding.file.MapReader;

public class PathFinder {
    //class for interacting with gui
    private int[][] grid;

    private MapReader mapReader;
    private Djikstra djikstra;
    private AStar aStar;

    /**
     *
     */
    public PathFinder() {
        mapReader = new MapReader();
        djikstra = new Djikstra();
        aStar = new AStar();
    }
    
    /**
     *
     * @param fileName
     * @throws Exception
     */
    public void openMapFile(String fileName) throws Exception {
        this.grid = mapReader.readMap(fileName);
    }
    
    /**
     *
     * @return graph as array
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return result object
     */
    public Result searchDjikstra(int startX, int startY, int endX, int endY) {
        return djikstra.search(this.getGrid(), startX, startY, endX, endY);
    }
    
    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return result object
     */
    public Result searchAStar(int startX, int startY, int endX, int endY) {
        return aStar.search(this.getGrid(), startX, startY, endX, endY);
    }

}
