package pathfinding.algo;

import pathfinding.domain.Node;
import java.util.ArrayList;
import java.util.PriorityQueue;
import pathfinding.domain.Point;

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
    public ArrayList<Point> search(int[][] arr, int startX, int startY, int endX, int endY) {
        Point[][] previous = new Point[arr.length][arr[0].length];
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] dist = new int[arr.length][arr[0].length];
        for (int x = 0; x < dist.length; x++) {
            for (int y = 0; y < dist[0].length; y++) {
                dist[x][y] = Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<Node> heap = new PriorityQueue<>();
        
        heap.add(new Node(startX, startY));
        
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            
            if (visited[node.getLocationX()][node.getLocationY()]) {
                continue;
            }
            visited[node.getLocationX()][node.getLocationY()] = true;

            for (Point neighbour : getNeighbourCells(arr, node.getLocationX(), node.getLocationY())) {
                int curDist = dist[neighbour.getLocationX()][neighbour.getLocationY()];
                int newDist =  dist[node.getLocationX()][node.getLocationY()] + 1;
                if (newDist < curDist) {
                    dist[neighbour.getLocationX()][neighbour.getLocationY()] = newDist;
                    previous[neighbour.getLocationX()][neighbour.getLocationY()] = new Point(node.getLocationX(), node.getLocationY());
                    heap.add(new Node(neighbour.getLocationX(), neighbour.getLocationY(), newDist));
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
        return route;
    }

}
