package pathfinding.pathfinder;

import java.util.ArrayList;
import pathfinding.algo.Djikstra;
import pathfinding.domain.Maze;
import pathfinding.file.MapReader;


public class PathFinder {
    //class for interacting with gui
    private Maze graph;

    private MapReader mapReader;
    private Djikstra djikstra;

    public PathFinder() {
        mapReader = new MapReader();
        djikstra = new Djikstra();
    }
    
    /**
     *
     * @param fileName
     * @throws Exception
     */
    public void openMapFile(String fileName) throws Exception {
        this.graph = mapReader.readMap(fileName);
        /*for (int x=0; x<maze.getMaze().length; x++) {
            for (int y=0; y<maze.getMaze().length; y++) {
                System.out.print(maze.getMaze()[x][y]);
            }
            System.out.println("");
        }*/
        /*ArrayList<Integer>[] adjacencyList = this.graph.toAdjacencyList();
        
        for (int i=1; i<adjacencyList.length; i++) {
            System.out.print("node " + i + ": ");
            for (Integer node : adjacencyList[i]) {
                System.out.print(node + " " );
            }
            System.out.println("");
        }*/
    }
    
    /**
     *
     * @return graph as array
     */
    public int[][] getAsArray() {
        return graph.getMaze();
    }
    
    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return nodes as list of integers
     */
    public ArrayList<Integer> searchDjikstra(int startX, int startY, int endX, int endY) {
        return djikstra.search(this.graph.toAdjacencyList(), this.graph.toNodeNumberFromCoordinate(startX, startY), this.graph.toNodeNumberFromCoordinate(endX, endY));
        //return djikstra.search(this.graph.toAdjacencyList(), 1, 3);
    }
}
