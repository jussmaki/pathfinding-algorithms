package pathfinding.algo;

import pathfinding.domain.Point;
import pathfinding.domain.Result;
import pathfinding.struct.StackQueue;

public class IDAStar extends PathFind {
    
    private static boolean[][] visited;
    private static long visitedNodes;
    
    private static final double DEFAULT_DIST = Double.MAX_VALUE;
    
    private static StackQueue<Point> path;        
    private static double threshold;
    private static Point endPoint;
    private static boolean found;
    private static boolean [][]inPath;    
    
    /**
     * Search with IDAStar
     * @param arr 2d array of map
     * @param startX start point x-coordinate
     * @param startY start point y-coordinate
     * @param endX end point x-coordinate
     * @param endY end point x-coordinate
     * @return results as result object
     */
    public static Result search(int[][] arr, int startX, int startY, int endX, int endY) {
                
        visitedNodes = 0;
        visited = new boolean[arr.length][arr[0].length];
        long startTime = System.nanoTime();
                
        inPath = new boolean[arr.length][arr[0].length];
        
        endPoint = new Point(endX, endY);
        path = new StackQueue<>();
        path.push(new Point(startX, startY));
        inPath[startX][startY] = true;
        
        threshold = getBirdsWayDistance(startX, startY, endX, endY);
        found = false;
        
        double d;
        
        while (true) {
            d = ida(arr, 0, threshold);
            
            if (found || d == DEFAULT_DIST) {
                break;
            }
            
            threshold = d;
        }
        
        if (!found) {
            path = new StackQueue<Point>();
        }
        
        long endTime = System.nanoTime();
        
        Result res = new Result();
        res.setDistance(d);
        res.setPath(path);
        res.setRunTime(endTime - startTime);
        res.setVisited(visited);
        res.setPointsInHeap(new StackQueue<Point>());
        res.setVisitedNoNodes(visitedNodes);
        
        return res;
    }

    private static double ida(int[][] arr, double distance, double threshold) {
        Point current = path.peek();
        visited[current.getLocationX()][current.getLocationY()] = true;
        visitedNodes++;
        double estimate = distance + getBirdsWayDistance(
                current.getLocationX(), current.getLocationY(), endPoint.getLocationX(), endPoint.getLocationY());
        if (estimate > threshold) {
            return estimate;
        }
        if (current.getLocationX() == endPoint.getLocationX() && current.getLocationY() == endPoint.getLocationY()) {
            found = true;
            return estimate;
        }
            
        double min = DEFAULT_DIST;
           
        StackQueue<Point> ps = getNeighbourCells(arr, current.getLocationX(), current.getLocationY());
        while (!ps.isEmpty()) {
            Point next = ps.pop();
            if (!inPath[next.getLocationX()][next.getLocationY()]) {
                path.push(next);
                inPath[next.getLocationX()][next.getLocationY()] = true;
                double newDistance = distance + getBirdsWayDistance(
                        current.getLocationX(), current.getLocationY(), next.getLocationX(), next.getLocationY());
                double newEstimate = ida(arr, newDistance, threshold);
                if (found) {
                    return newEstimate;
                }
                if (newEstimate < min) {
                    min = newEstimate;
                }
                path.pop();
                inPath[next.getLocationX()][next.getLocationY()] = false;
            }
        }
        return min;
    }
}
