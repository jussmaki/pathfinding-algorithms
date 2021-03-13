package pathfinding.algo;

import pathfinding.domain.Node;
import pathfinding.domain.Point;
import pathfinding.domain.Result;
import pathfinding.struct.StackQueue;

public class IDAStar extends PathFind {
    
    private static final double DEFAULT_DIST = Double.MAX_VALUE;
    
    private static StackQueue<Point> path;
        
    private static double threshold;
    
    private static Point endPoint;
    
    private static boolean found;
    
    private static boolean[][] visited;
    
    private static int visitedNodes;
    
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
        
        //Point endPoint = new Point(endX, endY);
        
        visitedNodes = 0;
        
        long startTime = System.nanoTime();
        
        //Point[][] previous = new Point[arr.length][arr[0].length];
        
        endPoint = new Point(endX, endY);
        
        path = new StackQueue<>();
        
        path.push(new Point(startX, startY));
        
        threshold = getBirdsWayDistance(startX, startY, endX, endY);
        
        found = false;
        
        visited = new boolean[arr.length][arr[0].length];
        
        double distance;
        
        
        //StackQueue<Point> path = new StackQueue<>();
        
        while (true) {
            //double d = abc(arr, path, 0, threshold);
            double d = abc(arr, path, 0, threshold);
          
            if (found || d == DEFAULT_DIST) {
                distance = d;
                break;
            }
            
            if (/*visitedNodes > 100000000*/ visitedNodes == Integer.MAX_VALUE/100) {
                distance = d;
                break;
            }
            
            threshold = d;
            
        }
        
       /* stack.push(new Node(startX, startY, 0, endPoint));
      
        
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            visitedNodes++;
            if (!visited[node.getLocationX()][node.getLocationY()]) {
                visited[node.getLocationX()][node.getLocationY()] = true;
                //path.push(node.getLocation());
                            //stop if we have found the goal node
                if (node.getLocationX() == endX && node.getLocationY() == endY) {
                    break;
                }            
                StackQueue<Point> ps = getNeighbourCells(arr, node.getLocationX(), node.getLocationY());
                while (!ps.isEmpty()) {
                    Point next = ps.pop();
                    //if (previous[next.getLocationX()][next.getLocationY()] == null) {
                    //    previous[next.getLocationX()][next.getLocationY()] = node.getLocation();
                    //}
                    //System.out.println(node.getLocation());
                    stack.push(new Node(next.getLocationX(), next.getLocationY(), 0, endPoint));
                }
            }
        }
        
        //path = IDAStar(new Point(startX, startY));*/
        
        
        long endTime = System.nanoTime();
        
        Result res = new Result();
        //res.setDistance(dist[endX][endY]);
        //res.setDistance(0);
        res.setDistance(distance);
        //res.setPath(path(previous, startX, startY, endX, endY));
        res.setPath(path);
        //res.setPath(new StackQueue<Point>());
        res.setRunTime(endTime - startTime);
        //res.setVisited(visited);
        res.setVisited(visited);
        //res.setPointsInHeap(heapToPoints(heap));
        res.setPointsInHeap(new StackQueue<Point>());
        
        res.setVisitedNoNodes(visitedNodes);
        
        return res;
    }

    private static StackQueue copyStack(StackQueue sq) {
        StackQueue<Point> ret = new StackQueue<>();
        while (!sq.isEmpty()) {
            ret.push(sq.pollFirst());
        }
        return ret;
    }
    
    private static double abc(int[][] arr, StackQueue<Point> path, double distance, double threshold) {
        Point current = path.peek();
        //System.out.println(current);
        double estimate = distance + getBirdsWayDistance(current.getLocationX(), current.getLocationY(), endPoint.getLocationX(), endPoint.getLocationY());
        if (estimate > threshold) {
            //threshold = estimate;
            return estimate;
            //return estimate;
        }
        if (current.getLocationX() == endPoint.getLocationX() && current.getLocationY() == endPoint.getLocationY()) {
            found = true;
            return estimate;
        }
            
        double min = DEFAULT_DIST;
           
        StackQueue<Point> ps = sortPointsByGPlusH(estimate, endPoint, getNeighbourCells(arr, current.getLocationX(), current.getLocationY()));
        while (!ps.isEmpty()) {
            Point next = ps.pop();
            //if (!inPath[next.getLocationX()][next.getLocationY()]) {
                //inPath[next.getLocationX()][next.getLocationY()] = true;
            if (/*!visited[next.getLocationX()][next.getLocationY()] && */ !path.inStack(next)) {
                visited[next.getLocationX()][next.getLocationY()] = true;
                visitedNodes++;
                if (visitedNodes % 1000 == 0) {
                //    System.out.println("visited nodes: " + visitedNodes);
                }
                path.push(next);
                double newDistance = distance + getBirdsWayDistance(current.getLocationX(), current.getLocationY(), next.getLocationX() ,next.getLocationY());
                double newEstimate = abc(arr, path, newDistance, threshold);
                //double newEstimate = abc(arr, path, newDistance, newEstimate);
                if (found) {
                    return newEstimate;
                }
                if (newEstimate < min) {
                    min = newEstimate;
                }
                path.pop();
                //double heuristics = getBirdsWayDistance(nex);
                //path.push(new Node(next.getLocationX(), next.getLocationY(), 0, endPoint));
            }
        }
        return min;
    }
}
