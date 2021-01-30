package pathfinding.algo;

import pathfinding.domain.Node;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Djikstra {

    /**
     *
     * @param adjacencyList
     * @param fromNode
     * @param toNode
     * @return shortest path from fromNode to toNode as ArrayList
     */
    public ArrayList<Integer> search(ArrayList<Integer>[] adjacencyList, int fromNode, int toNode) {
        int n = adjacencyList.length; //n+1
        ArrayList<Integer> route = new ArrayList<>();
        //int[] previous = new int[n];
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.add(new Node(fromNode, 0));
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (visited[node.getNumber()]) {
                continue;
            }
            visited[node.getNumber()] = true;
            route.add(node.getNumber());
            for (Integer neighbour : adjacencyList[node.getNumber()]) {
                int curDist = dist[neighbour];
                int newDist = dist[node.getNumber()]+1;
                if (newDist < curDist) {
                    dist[neighbour] = newDist;
                    heap.add(new Node(neighbour, newDist));
                }
            }
        }
        //System.out.println(route);
        return route;
    }

    
}
