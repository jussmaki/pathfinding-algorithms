package pathfinding.struct;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import pathfinding.domain.Node;
import pathfinding.domain.Point;

public class MinHeapTest {
    
    @Test
    public void emptyHeapIsEmptyAtStart() {
        MinHeap heap = new MinHeap();
        assertTrue(heap.isEmpty());
    }
    
    @Test
    public void heapWorksDistance1() {
        MinHeap ownHeap = new MinHeap();
        PriorityQueue<Node> javaHeap = new PriorityQueue<>(Node::compare);
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            Node n = new Node(r.nextInt(1024 + 1), r.nextInt(1024 + 1), r.nextDouble() + r.nextInt(Integer.MAX_VALUE));
            ownHeap.add(n);
            javaHeap.add(n);
        }
        while (!javaHeap.isEmpty()) {
            assertEquals(javaHeap.poll(), ownHeap.poll());
        }
    }
    
    @Test
    public void heapWorksDistance2() {
        MinHeap ownHeap = new MinHeap();
        PriorityQueue<Node> javaHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                double diff = n1.getDistance() - n2.getDistance();
                if (diff > 0) {
                    return 1;
                }
                if (diff < 0) {
                    return -1;
                }
                return 0;
            }
        });
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            Node n = new Node(r.nextInt(1024 + 1), r.nextInt(1024 + 1), r.nextDouble() + r.nextInt(Integer.MAX_VALUE));
            ownHeap.add(n);
            javaHeap.add(n);
        }
        while (!javaHeap.isEmpty()) {
            assertTrue(javaHeap.poll().getDistance() == ownHeap.poll().getDistance());
        }
    }
    
    @Test
    public void heapWorksDistance3() {
        MinHeap ownHeap = new MinHeap();
        PriorityQueue<Node> javaHeap = new PriorityQueue<>(Node::compare);
        Random r = new Random();
        for (int i = 0; i < 1000000; i++) {
            int locationX = r.nextInt(1024);
            int locationY = r.nextInt(1024);
            double distance = r.nextDouble() + r.nextInt(1000);
            ownHeap.add(new Node(locationX, locationY, distance));
            javaHeap.add(new Node(locationX, locationY, distance));
            if (r.nextInt() % 10 == 0) {
                assertEquals(javaHeap.poll(), ownHeap.poll());
            }
        }
        while (!javaHeap.isEmpty()) {
            assertEquals(javaHeap.poll(), ownHeap.poll());
        }
        assertTrue(ownHeap.isEmpty());
    }
    
    @Test
    public void heapWorksDistancePlusHeuristics1() {
        MinHeap ownHeap = new MinHeap();
        PriorityQueue<Node> javaHeap = new PriorityQueue<>(Node::compare);
        Random r = new Random();
        Point endPoint = new Point(r.nextInt(1024), r.nextInt(1024));
        for (int i = 0; i < 1000000; i++) {
            Node n = new Node(r.nextInt(1024 + 1), r.nextInt(1024 + 1),
                    r.nextDouble() + r.nextInt(Integer.MAX_VALUE), endPoint);
            ownHeap.add(n);
            javaHeap.add(n);
        }
        while (!javaHeap.isEmpty()) {
            assertEquals(javaHeap.poll(), ownHeap.poll());
        }
    }
    
    @Test
    public void heapWorksDistancePlusHeuristics2() {
        MinHeap ownHeap = new MinHeap();
        Random r = new Random();
        Point endPoint = new Point(r.nextInt(1024), r.nextInt(1024));
        PriorityQueue<Node> javaHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                double heur = heuristics(n1) - heuristics(n2);
                double diff = n1.getDistance() - n2.getDistance();
                if (heur + diff > 0) {
                    return 1;
                }
                if (heur + diff < 0) {
                    return -1;
                }
                return 0;
            }
            private double heuristics(Node n) {
                int startPointX = n.getLocationX();
                int startPointY = n.getLocationY();
                int endPointX = endPoint.getLocationX();
                int endPointY = endPoint.getLocationY();
                return Math.sqrt((endPointY - startPointY) * (endPointY - startPointY)
                        + (endPointX - startPointX) * (endPointX - startPointX));
            }
        });
        for (int i = 0; i < 1000000; i++) {
            Node n = new Node(r.nextInt(1024 + 1), r.nextInt(1024 + 1),
                    r.nextDouble() + r.nextInt(Integer.MAX_VALUE), endPoint);
            ownHeap.add(n);
            javaHeap.add(n);
        }
        while (!javaHeap.isEmpty()) {
            assertTrue(javaHeap.poll().getDistance() == ownHeap.poll().getDistance());
        }
    }
    
    @Test
    public void heapWorksDistancePlusHeuristics3() {
        MinHeap ownHeap = new MinHeap();
        PriorityQueue<Node> javaHeap = new PriorityQueue<>(Node::compare);
        Random r = new Random();
        Point endPoint = new Point(r.nextInt(1024), r.nextInt(1024));
        for (int i = 0; i < 1000000; i++) {
            int locationX = r.nextInt(1024);
            int locationY = r.nextInt(1024);
            double distance = r.nextDouble() + r.nextInt(1000);
            ownHeap.add(new Node(locationX, locationY, distance, endPoint));
            javaHeap.add(new Node(locationX, locationY, distance, endPoint));
            if (r.nextInt() % 10 == 0) {
                assertEquals(javaHeap.poll(), ownHeap.poll());
            }
        }
        while (!javaHeap.isEmpty()) {
            assertEquals(javaHeap.poll(), ownHeap.poll());
        }
        assertTrue(ownHeap.isEmpty());
    }

}
