package pathfinding.pathfinder;

import pathfinding.algo.AStar;
import pathfinding.algo.Djikstra;
import pathfinding.algo.JPS;
import pathfinding.domain.Result;
import pathfinding.file.MapReader;

public class PathFinder {
    //class for interacting with gui
    private int[][] grid;

    /**
     *
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
     *
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
     *
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
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return result object
     */
    public Result searchJPS(int startX, int startY, int endX, int endY) {
        return JPS.search(this.getGrid(), startX, startY, endX, endY);
    }    

}
