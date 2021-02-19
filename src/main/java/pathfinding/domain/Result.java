package pathfinding.domain;

//import pathfinding.struct.ArrayList;
import java.util.ArrayList;

public class Result {
    private long runTime;
    private int visitedNoNodes;
    private double distance;
    private ArrayList<Point> path;
    private boolean[][] visited;

    /**
     *
     */
    public Result() {
        this.runTime = runTime;
        this.visitedNoNodes = visitedNoNodes;
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
