package pathfinding.algo;

import pathfinding.domain.Point;
import pathfinding.struct.MinHeap;
import pathfinding.struct.PointStack;

class PathFind {
     /**
     *
     * @param grid 2d array of map
     * @param x x-coordinate
     * @param y y-coordinate
     * @return neighbour coordinate points as ArrayList
     */
    public static PointStack getNeighbourCells(int[][] grid, int x, int y) {
        PointStack neighbours = new PointStack();
        if (canGoFromTo(grid, x, y, x - 1, y)) {
            neighbours.push(new Point(x - 1, y));
        }
        if (canGoFromTo(grid, x, y, x - 1, y - 1)) {
            neighbours.push(new Point(x - 1, y - 1));
        }
        if (canGoFromTo(grid, x, y, x + 1, y)) {
            neighbours.push(new Point(x + 1, y));
        }
        if (canGoFromTo(grid, x, y, x, y + 1)) {
            neighbours.push(new Point(x, y + 1));
        }
        if (canGoFromTo(grid, x, y, x, y - 1)) {
            neighbours.push(new Point(x, y - 1));
        }
        if (canGoFromTo(grid, x, y, x - 1, y + 1)) {
            neighbours.push(new Point(x - 1, y + 1));
        }
        if (canGoFromTo(grid, x, y, x + 1, y - 1)) {
            neighbours.push(new Point(x + 1, y - 1));
        }
        if (canGoFromTo(grid, x, y, x + 1, y + 1)) {
            neighbours.push(new Point(x + 1, y + 1));
        }
        return neighbours;
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
    
     /**
     *
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
     *
     * @param previous array of previous points
     * @param startX start x-coordinate
     * @param startY start y-coordinate
     * @param endX end x-coordinate
     * @param endY end y-coordinate
     * @return path as points in arraylist
     */
    public static PointStack path(Point[][] previous, int startX, int startY, int endX, int endY) {
        PointStack path = new PointStack(1024);
        if (previous[endX][endY] == null) {
            return path; //unreachable
        }
        Point p = new Point(endX, endY);
        path.push(p);
        while (true) {
            p = previous[p.getLocationX()][p.getLocationY()];
            path.push(p);
            if (p.getLocationX() == startX && p.getLocationY() == startY) {
                break;
            }
        }
        return path;
    }
    
    public static PointStack heapToPoints(MinHeap heap) {
        PointStack ret = new PointStack(1024);
        while (!heap.isEmpty()) {
            ret.push(heap.poll().getLocation());
        }
        return ret;
    }
}
