package pathfinding.algo;

import java.util.ArrayList;
import java.util.PriorityQueue;
import pathfinding.domain.ANode;
import pathfinding.domain.Point;

public class AStar extends PathFind {

    public ArrayList<Point> search(int[][] arr, int startX, int startY, int endX, int endY) {
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
            System.out.println(node);
            visited[node.getLocationX()][node.getLocationY()] = true;

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
        
        ArrayList<Point> route = new ArrayList<>();
        if (previous[endX][endY] == null) {
            return route; //unreachable
        }
        Point p = new Point(endX, endY);
        route.add(p);
        while (true) {
            p = previous[p.getLocationX()][p.getLocationY()];
            route.add(p);
            if (p.equals(new Point(startX, startY))) {
                break;
            }
        }
        return route; //return null;
    }
    
}
