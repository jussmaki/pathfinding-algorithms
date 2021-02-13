package pathfinding.domain;

//import pathfinding.struct.ArrayList;

import java.util.ArrayList;


public class Result {
    private long runTime;
    private int visitedNodes;
    private ArrayList<Point> path;

    /**
     *
     */
    public Result() {
        this.runTime = runTime;
        this.visitedNodes = visitedNodes;
        this.path = path;
    }

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
    public int getVisitedNodes() {
        return visitedNodes;
    }

    /**
     *
     * @param visitedNodes
     */
    public void setVisitedNodes(int visitedNodes) {
        this.visitedNodes = visitedNodes;
    }

    /**
     *
     * @return
     */
    public ArrayList<Point> getPath() {
        return path;
    }

    /**
     *
     * @param path
     */
    public void setPath(ArrayList<Point> path) {
        this.path = path;
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
        return "runtime: " + (this.runTime / 1e9) + " s, nodes in path: " + this.getNoNodesInPath() + " visited nodes: " + this.getVisitedNodes();
    }
    
}
