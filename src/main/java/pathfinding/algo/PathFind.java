package pathfinding.algo;

//import pathfinding.struct.ArrayList;
import java.util.ArrayList;
import pathfinding.domain.Point;

class PathFind {
     /**
     *
     * @param grid 2d array of map
     * @param x x-coordinate
     * @param y y-coordinate
     * @return neighbour coordinate points as ArrayList
     */
    public ArrayList<Point> getNeighbourCells(int[][] grid, int x, int y) {
        ArrayList<Point> neighbours = new ArrayList<>();
        if (canGoFromTo(grid, x, y, x - 1, y)) {
            neighbours.add(new Point(x - 1, y));
        }
        if (canGoFromTo(grid, x, y, x - 1, y - 1)) {
            neighbours.add(new Point(x - 1, y - 1));
        }
        if (canGoFromTo(grid, x, y, x + 1, y)) {
            neighbours.add(new Point(x + 1, y));
        }
        if (canGoFromTo(grid, x, y, x, y + 1)) {
            neighbours.add(new Point(x, y + 1));
        }
        if (canGoFromTo(grid, x, y, x, y - 1)) {
            neighbours.add(new Point(x, y - 1));
        }
        if (canGoFromTo(grid, x, y, x - 1, y + 1)) {
            neighbours.add(new Point(x - 1, y + 1));
        }
        if (canGoFromTo(grid, x, y, x + 1, y - 1)) {
            neighbours.add(new Point(x + 1, y - 1));
        }
        if (canGoFromTo(grid, x, y, x + 1, y + 1)) {
            neighbours.add(new Point(x + 1, y + 1));
        }
        return neighbours;
    }
    

    private boolean canGoFromTo(int[][] grid, int x1, int y1, int x2, int y2) {
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
    
    public double getBirdsWayDistance(int fromX, int fromY, int toX, int toY) {
        return Math.sqrt((toY - fromY) * (toY - fromY) + (toX - fromX) * (toX - fromX));
    }
    
    public ArrayList<Point> path(Point[][] previous, int startX, int startY, int endX, int endY) {
        ArrayList<Point> path = new ArrayList<>();
        if (previous[endX][endY] == null) {
            return path; //unreachable
        }
        Point p = new Point(endX, endY);
        path.add(p);
        while (true) {
            p = previous[p.getLocationX()][p.getLocationY()];
            path.add(p);
            if (p.equals(new Point(startX, startY))) {
                break;
            }
        }
        return path; 
    }
}
