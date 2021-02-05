package pathfinding.pathfinder;

import java.util.ArrayList;
import pathfinding.algo.Djikstra;
import pathfinding.domain.Maze;
import pathfinding.domain.Node;
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
    }
    
    /**
     *
     * @return graph as array
     */
    public int[][] getAsArray() {
        return graph.getMaze();
    }

    public ArrayList<Node> searchDjikstra(int startX, int startY, int endX, int endY) {
        ArrayList<Node>[] adjacencyList = graph.toAdjacencyList();
        int fromNode;
        int toNode;
        return null;
        //return djikstra.search(adjacencyList, fromNode, toNode);
    }
    
    /**
     *
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @return nodes as list of integers
     */
    /*public ArrayList<Integer> searchDjikstra(int startX, int startY, int endX, int endY) {
        return djikstra.search(this.graph.toAdjacencyList(), this.graph.toNodeNumberFromCoordinate(startX, startY), this.graph.toNodeNumberFromCoordinate(endX, endY));
        //return djikstra.search(this.graph.toAdjacencyList(), 1, 3);
    }*/
}
