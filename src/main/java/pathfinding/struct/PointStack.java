package pathfinding.struct;

import pathfinding.domain.Point;

public class PointStack {

    private int arrSize;
    private Point[] arr;
    private int last;
    
    /**
     *
     */
    public PointStack() {
        arr = new Point[8];
        arrSize = 8;
        last = -1;
    }

    public void push(Point p) {
        last++;        
        if (last >= arrSize) {
            expandArray();
        }      
        arr[last] = p;
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
        Point p = arr[last];
        last--;
        return p;
    }
    /**
     *
     * @return
     */
    public int size() {
        return last;
    }
    
    public Object[] toArray() {
        Point[] ret = new Point[last];
        for (int i=0; i < ret.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
    
}
