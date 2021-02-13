package pathfinding.algo;

import java.util.PriorityQueue;
import pathfinding.domain.DNode;
import pathfinding.domain.Point;
import pathfinding.domain.Result;
import pathfinding.struct.MinHeap;

public class Djikstra extends PathFind {

    /**
     *
     * @param arr 2d array of map
     * @param startX start point x-coordinate
     * @param startY start point y-coordinate
     * @param endX end point x-coordinate
     * @param endY end point x-coordinate
     * @return path as ArrayList
     */
    public Result search(int[][] arr, int startX, int startY, int endX, int endY) {
        int visitedNodes = 0;
        long startTime = System.nanoTime();
        Point[][] previous = new Point[arr.length][arr[0].length];
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] dist = new int[arr.length][arr[0].length];
        for (int x = 0; x < dist.length; x++) {
            for (int y = 0; y < dist[0].length; y++) {
                dist[x][y] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<DNode> heap = new PriorityQueue<>();
        //MinHeap heap = new MinHeap();
        
        
        heap.add(new DNode(startX, startY, Integer.MAX_VALUE));
        
        while (!heap.isEmpty()) {
            DNode node = (DNode) heap.poll();
            
            if (visited[node.getLocationX()][node.getLocationY()]) {
                continue;
            }
            visited[node.getLocationX()][node.getLocationY()] = true;
            visitedNodes++;
            for (Point neighbour : getNeighbourCells(arr, node.getLocationX(), node.getLocationY())) {
                int curDist = dist[neighbour.getLocationX()][neighbour.getLocationY()];
                int newDist =  dist[node.getLocationX()][node.getLocationY()] + 1;
                if (newDist < curDist) {
                    dist[neighbour.getLocationX()][neighbour.getLocationY()] = newDist;
                    previous[neighbour.getLocationX()][neighbour.getLocationY()] = new Point(node.getLocationX(), node.getLocationY());
                    heap.add(new DNode(neighbour.getLocationX(), neighbour.getLocationY(), newDist));
                }
            }
        }
        
        long endTime = System.nanoTime();
        Result res = new Result();
        res.setPath(path(previous, startX, startY, endX, endY));
        res.setRunTime(endTime-startTime);
        res.setVisitedNodes(visitedNodes);
        return res;
    }

}
