package pathfinding.struct;

import pathfinding.domain.Point;

public class PointStack {

    private static final int DEFAULT_SIZE = 8;
    private int arrSize;
    private Point[] arr;
    private int last;
    
    /**
     *
     * @param heapSize
     */
    public PointStack(int heapSize) {
        arr = new Point[heapSize];
        arrSize = heapSize;
        last = 0;
    }
    
    public PointStack() {
        this(DEFAULT_SIZE);
    }

    public void push(Point p) {       
        if (last >= arrSize) {
            expandArray();
        }
        arr[last] = p;
        last++; 
    }
    
    private void expandArray() {
        arrSize = arrSize * 2;      
        Point[] newArr = new Point[arrSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public boolean isEmpty() {
        if (last > 0) {
            return false;
        }
        return true;
    }
    
    public Point pop() {
        last--;        
        Point p = arr[last];
        return p;
    }
    /**
     *
     * @return
     */
    public int size() {
        return last;
    }
}
