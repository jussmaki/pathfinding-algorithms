package pathfinding.domain;

import java.util.ArrayList;
import pathfinding.struct.PointStack;

public class Result {
    private long runTime;
    private int visitedNoNodes;
    private double distance;
    private PointStack path;
    private boolean[][] visited;

    /**
     *
     * @return
     */
    public double getRunTime() {
        return runTime;
    }

    /**
     *
     * @param runTime
     */
    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    /**
     *
     * @return
     */
    public int getVisitedNoNodes() {
        return visitedNoNodes;
    }

    /**
     *
     * @param visitedNoNodes
     */
    public void setVisitedNoNodes(int visitedNoNodes) {
        this.visitedNoNodes = visitedNoNodes;
    }

    /**
     *
     * @return
     */
    public double getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public PointStack getPath() {
        return path;
    }

    /**
     *
     * @param path
     */
    public void setPath(PointStack path) {
        this.path = path;
    }

    /**
     *
     * @return
     */
    public boolean[][] getVisited() {
        return visited;
    }

    /**
     *
     * @param visited
     */
    public void setVisited(boolean[][] visited) {
        this.visited = visited;
    }
    
    /**
     *
     * @return number of nodes in path
     */
    public int getNoNodesInPath() {
        return this.path.size();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "runtime: " + (this.runTime / 1e9) + " s, distance: " + this.getDistance() + " nodes in path: " + this.getNoNodesInPath() + " visited nodes: " + this.getVisitedNoNodes();
    }
    
}
