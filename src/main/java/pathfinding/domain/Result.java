package pathfinding.domain;

import pathfinding.struct.StackQueue;

public class Result {
    private long runTime;
    private int visitedNoNodes;
    private double distance;
    private StackQueue<Point> path;
    private StackQueue<Point> pointsInHeap;
    private boolean[][] visited;

    /**
     *
     * @return
     */
    public long getRunTime() {
        return runTime;
    }

    public StackQueue<Point> getPointsInHeap() {
        return pointsInHeap;
    }

    public void setPointsInHeap(StackQueue<Point> pointsInHeap) {
        this.pointsInHeap = pointsInHeap;
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
    public StackQueue<Point> getPath() {
        return path;
    }

    /**
     *
     * @param path
     */
    public void setPath(StackQueue<Point> path) {
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
     * Returns number of nodes in path
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
        //return "runtime: " + (this.runTime / 1e9) + " s, distance: " + this.getDistance()
        //        + " nodes in path: " + this.getNoNodesInPath() + " visited nodes: " + this.getVisitedNoNodes();
        return "distance: " + this.getDistance()
                + " nodes in path: " + this.getNoNodesInPath() + " visited nodes: " + this.getVisitedNoNodes();
    }
    
}
