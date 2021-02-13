package pathfinding.domain;

import java.util.ArrayList;

public class Result {
    private long runTime;
    private int visitedNodes;
    private ArrayList<Point> path;

    public Result() {
        this.runTime = runTime;
        this.visitedNodes = visitedNodes;
        this.path = path;
    }

    public double getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public int getVisitedNodes() {
        return visitedNodes;
    }

    public void setVisitedNodes(int visitedNodes) {
        this.visitedNodes = visitedNodes;
    }

    public ArrayList<Point> getPath() {
        return path;
    }

    public void setPath(ArrayList<Point> path) {
        this.path = path;
    }
    
    public int getNoNodesInPath() {
        return this.path.size();
    }

    @Override
    public String toString() {
        return "runtime: " + (this.runTime/1e9) + " s, nodes in path: " + this.getNoNodesInPath() + " visited nodes: "+ this.getVisitedNodes();
    }
    
}
