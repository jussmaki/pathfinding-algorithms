package pathfinding.struct;

import java.util.ArrayDeque;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import pathfinding.domain.Point;

public class StackQueueTest {
    
    StackQueue ps;
    
    @Before
    public void setUp() {
        ps = new StackQueue<Point>();
    }
    
    @Test
    public void isEmptyReturnsEmptyWhenIsEmptyAtStart() {
        assertTrue(ps.isEmpty());
    }
    
    @Test
    public void isNotEmptyReturnsEmptyWhenIsNotEmpty() {
        ps.push(new Point(1, 1));
        assertFalse(ps.isEmpty());
    }    
  
    @Test
    public void sizeReturns0WhenIsEmptyAtStart() {
        assertEquals(0, ps.size());
    }
    
    @Test
    public void sizeReturns1WhenContainsOnePoint() {
        ps.push(new Point(1, 1));
        assertEquals(1, ps.size());
    }
    
    @Test
    public void popWorks() {
        Point p = new Point(1, 1);
        ps.push(p);
        assertEquals(p, ps.pop());
    }
    
    @Test
    public void orderOfPointsIsCorrectWhenPollingComparedToJavasArrayDeque() {
        Random r = new Random();
        ArrayDeque<Point> javaDeque = new ArrayDeque<>();
        for (int i = 100; i < 1000000; i++) {
            Point p = new Point(r.nextInt(1000), r.nextInt(1000));
            javaDeque.addLast(p);
            ps.push(p);
        }
        while (!javaDeque.isEmpty()) {
            assertEquals(javaDeque.removeLast(), ps.pop());
        }
        assertTrue(ps.isEmpty());
    }
    
    @Test
    public void orderOfPointsIsCorrectWhenPollingAndPoppingComparedToJavasArrayDeque() {
        Random r = new Random();
        ArrayDeque<Point> javaDeque = new ArrayDeque<>();
        for (int i = 100; i < 1000000; i++) {
            Point p = new Point(r.nextInt(1000), r.nextInt(1000));
            javaDeque.addLast(p);
            ps.push(p);
            if (r.nextInt() % 2 == 0) {
                assertEquals(javaDeque.removeLast(), ps.pop());
            }
        }
        while (!javaDeque.isEmpty()) {
            assertEquals(javaDeque.removeLast(), ps.pop());
        }
        assertTrue(ps.isEmpty());
    }
}
