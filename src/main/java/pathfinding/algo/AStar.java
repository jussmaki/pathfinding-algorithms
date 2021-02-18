package pathfinding.algo;

import java.util.PriorityQueue;
import pathfinding.domain.ANode;
import pathfinding.domain.Point;
import pathfinding.domain.Result;

public class AStar extends PathFind {

    /**
     *
     * @param arr 2d array of map
     * @param startX start point x-coordinate
     * @param startY start point y-coordinate
     * @param endX end point x-coordinate
     * @param endY end point x-coordinate
     * @return results as result object
     */
    public Result search(int[][] arr, int startX, int startY, int endX, int endY) {

        final double DEFAULT_DIST = Double.MAX_VALUE;
        
        Point endPoint = new Point(endX, endY);
        
        int visitedNodes = 0;
        long startTime = System.nanoTime();
        Point[][] previous = new Point[arr.length][arr[0].length];
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        double[][] dist = new double[arr.length][arr[0].length];
        for (int x = 0; x < dist.length; x++) {
            for (int y = 0; y < dist[0].length; y++) {
                dist[x][y] = DEFAULT_DIST;
            }
        }
        dist[startX][startY] = 0;
        
        PriorityQueue<ANode> heap = new PriorityQueue<>();
        
        heap.add(new ANode(startX, startY, 0, endPoint));
        
        while (!heap.isEmpty()) {
            ANode node = heap.poll();
            
            if (visited[node.getLocationX()][node.getLocationY()]) {
                continue;
            }
            
            //stop if we have found the goal node
            if (node.getLocationX() == endX && node.getLocationY() == endY) {
                break;
            }            
            
            //System.out.println(node);
            visited[node.getLocationX()][node.getLocationY()] = true;
            visitedNodes++;
            for (Point neighbour : getNeighbourCells(arr, node.getLocationX(), node.getLocationY())) {
                double curDist = dist[neighbour.getLocationX()][neighbour.getLocationY()];
                double newDist =  dist[node.getLocationX()][node.getLocationY()] + getBirdsWayDistance(node.getLocationX(), node.getLocationY(), neighbour.getLocationX(), neighbour.getLocationY());
                if (newDist < curDist) {
                    //System.out.println(newDist);
                    dist[neighbour.getLocationX()][neighbour.getLocationY()] = newDist;
                    previous[neighbour.getLocationX()][neighbour.getLocationY()] = new Point(node.getLocationX(), node.getLocationY());
                    heap.add(new ANode(neighbour.getLocationX(), neighbour.getLocationY(), newDist, endPoint));
                }
            }            
        }
        long endTime = System.nanoTime();
        Result res = new Result();
        res.setDistance(dist[endX][endY]);
        res.setPath(path(previous, startX, startY, endX, endY));
        res.setRunTime(endTime - startTime);
        res.setVisited(visited);
        res.setVisitedNoNodes(visitedNodes);
        return res;
    }
    
}
