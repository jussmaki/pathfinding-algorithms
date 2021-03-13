package pathfinding.algo;

import pathfinding.domain.Node;
import pathfinding.domain.Point;
import pathfinding.struct.MinHeap;
import pathfinding.struct.StackQueue;

class PathFind {
     /**
     * Finds out neighbour cells of coordinate
     * @param grid 2d array of map
     * @param x x-coordinate
     * @param y y-coordinate
     * @return neighbour coordinate points as PointStack-object
     */
    public static StackQueue<Point> getNeighbourCells(int[][] grid, int fromX, int fromY) {
        StackQueue<Point> neighbours = new StackQueue<>();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (canGoFromTo(grid, fromX, fromY, fromX + x, fromY + y)) {
                    neighbours.push(new Point(fromX + x, fromY + y));
                }
            }
        }
        return neighbours;
    }
    
    //muuta tää myöhemmin
    public static StackQueue<Point> sortPointsByGPlusH(double curDist, Point endPoint, StackQueue<Point> points) {
        MinHeap minHeap = new MinHeap();
        while(!points.isEmpty()) {
            Point p = points.pop();
            minHeap.add(new Node(p.getLocationX(), p.getLocationY(), curDist, endPoint));
        }
        StackQueue<Point> reverse = new StackQueue<>();
        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            reverse.push(new Point(node.getLocationX(), node.getLocationY()));
        }
        StackQueue<Point> ret = new StackQueue<>();
        while(!reverse.isEmpty()) {
            ret.push(reverse.pop());
        }
        return ret;
    }
    
     /**
     * Euclidean distance of two points
     * @param fromX from x-coordinate
     * @param fromY from y-coordinate
     * @param toX to x-coordinate
     * @param toY to y-coordinate
     * @return euclidean distance of two points
     */
    public static double getBirdsWayDistance(int fromX, int fromY, int toX, int toY) {
        return Math.sqrt((toY - fromY) * (toY - fromY) + (toX - fromX) * (toX - fromX));
    }
    
     /**
     * Forms path
     * @param previous array of previous points
     * @param startX start x-coordinate
     * @param startY start y-coordinate
     * @param endX end x-coordinate
     * @param endY end y-coordinate
     * @return path as points in PointStack-object
     */
    public static StackQueue<Point> path(Point[][] previous, int startX, int startY, int endX, int endY) {
        StackQueue<Point> path = new StackQueue<>(1024);
        if (previous[endX][endY] == null) {
            return path; //unreachable
        }
        Point p = new Point(endX, endY);
        path.push(p);
        while (true) {
            p = previous[p.getLocationX()][p.getLocationY()];
            //System.out.println(previous[p.getLocationX()][p.getLocationY()]);
            path.push(p);
            if (p.getLocationX() == startX && p.getLocationY() == startY) {
                break;
            }
        }
        return path;
    }
    
     /**
     * Insert Points in heap to PointStack 
     * @param heap MinHeap-object
     * @return points in heap as PointStack-object
     */
    public static StackQueue<Point> heapToPoints(MinHeap heap) {
        StackQueue<Point> ret = new StackQueue<>(1024);
        while (!heap.isEmpty()) {
            ret.push(heap.poll().getLocation());
        }
        return ret;
    }
    
    private static boolean canGoFromTo(int[][] grid, int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return false;
        }
        if (grid[x1][y1] != 1) {
            return false;
        }
        if (x2 < 0 || x2 >= grid.length || y2 < 0 || y2 >= grid[0].length) {
            return false;
        }
        if (grid[x2][y2] != 1) {
            return false;
        }
        return true;
    }
}
