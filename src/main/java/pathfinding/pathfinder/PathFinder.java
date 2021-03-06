package pathfinding.pathfinder;

import pathfinding.algo.AStar;
import pathfinding.algo.Djikstra;
import pathfinding.algo.IDAStar;
import pathfinding.domain.Result;
import pathfinding.file.MapReader;

public class PathFinder {
    private int[][] grid;

    /**
     * Open .map-file
     * @param fileName
     * @throws Exception
     */
    public void openMapFile(String fileName) throws Exception {
        this.grid = MapReader.readMap(fileName);
    }
    
    /**
     *
     * @return graph as array
     */
    public int[][] getGrid() {
        return grid;
    }

    /**
     * Start search with Djikstra
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return result object
     */
    public Result searchDjikstra(int startX, int startY, int endX, int endY) {
        return Djikstra.search(this.getGrid(), startX, startY, endX, endY);
    }
    
    /**
     * Start search with AStar
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return result object
     */
    public Result searchAStar(int startX, int startY, int endX, int endY) {
        return AStar.search(this.getGrid(), startX, startY, endX, endY);
    }
    
    /**
     * Start search with IDAStar
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return result object
     */
    public Result searchIDAStar(int startX, int startY, int endX, int endY) {
        return IDAStar.search(this.getGrid(), startX, startY, endX, endY);
    }

}
