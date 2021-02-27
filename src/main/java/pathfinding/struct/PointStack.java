package pathfinding.struct;

import pathfinding.domain.Point;

public class PointStack {

    private static final int DEFAULT_SIZE = 8;
    private int arrSize;
    private Point[] arr;
    private int last;
    
    /**
     * Creates new PointStac object with custom size
     * @param heapSize
     */
    public PointStack(int heapSize) {
        arr = new Point[heapSize];
        arrSize = heapSize;
        last = 0;
    }
    
    /**
     * Creates new PointStack object with default size
     */
    public PointStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * Insert node in stack
     */
    public void push(Point p) {       
        if (last >= arrSize) {
            expandArray();
        }
        arr[last] = p;
        last++; 
    }
    
    /**
     * Remove node from stack
     * @return top node of stack
     */    
    public Point pop() {
        last--;        
        Point p = arr[last];
        return p;
    }
    /**
     * Size of stack
     * @return number of points in stack
     */
    public int size() {
        return last;
    }
    
    /**
     *  Founds out if stack is empty or not
     * @return true/false
     */
    public boolean isEmpty() {
        if (last > 0) {
            return false;
        }
        return true;
    }
    
    private void expandArray() {
        arrSize = arrSize * 2;      
        Point[] newArr = new Point[arrSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
    
}
