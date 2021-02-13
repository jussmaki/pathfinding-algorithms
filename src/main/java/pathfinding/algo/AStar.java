package pathfinding.algo;

import java.util.PriorityQueue;
import pathfinding.domain.ANode;
import pathfinding.domain.Point;
import pathfinding.domain.Result;

public class AStar extends PathFind {

    public Result search(int[][] arr, int startX, int startY, int endX, int endY) {
        int visitedNodes = 0;
        long startTime = System.nanoTime();
        Point endPoint = new Point(endX, endY);
        Point[][] previous = new Point[arr.length][arr[0].length];
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] dist = new int[arr.length][arr[0].length];
        for (int x = 0; x < dist.length; x++) {
            for (int y = 0; y < dist[0].length; y++) {
                dist[x][y] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<ANode> heap = new PriorityQueue<>();
        
        heap.add(new ANode(startX, startY, Integer.MAX_VALUE, endPoint));
        
        while (!heap.isEmpty()) {
            ANode node = heap.poll();
            
            if (visited[node.getLocationX()][node.getLocationY()]) {
                continue;
            }
            //System.out.println(node);
            visited[node.getLocationX()][node.getLocationY()] = true;
            visitedNodes++;
            for (Point neighbour : getNeighbourCells(arr, node.getLocationX(), node.getLocationY())) {
                int curDist = dist[neighbour.getLocationX()][neighbour.getLocationY()];
                int newDist =  dist[node.getLocationX()][node.getLocationY()] + 1;
                if (newDist < curDist) {
                    dist[neighbour.getLocationX()][neighbour.getLocationY()] = newDist;
                    previous[neighbour.getLocationX()][neighbour.getLocationY()] = new Point(node.getLocationX(), node.getLocationY());
                    heap.add(new ANode(neighbour.getLocationX(), neighbour.getLocationY(), newDist, endPoint));
                }
            }
        }
        long endTime = System.nanoTime();
        Result res = new Result();
        res.setPath(path(previous, startX, startY, endX, endY));
        res.setRunTime(endTime-startTime);
        res.getVisitedNodes();
        return res;
    }
    
}
