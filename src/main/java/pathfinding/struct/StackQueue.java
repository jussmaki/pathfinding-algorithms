package pathfinding.struct;

public class StackQueue<T> {

    private static final int DEFAULT_SIZE = 8;
    private int arrSize;
    private Object[] arr;
    private int first;
    private int last;
    
    /**
     * Creates new StackQueue object with custom size
     * @param heapSize
     */
    public StackQueue(int heapSize) {
        arr = new Object[heapSize];
        arrSize = heapSize;
        first = 0;
        last = 0;
    }
    
    /**
     * Creates new StackQueue object with default size
     */
    public StackQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * Insert object in StackQueue
     */
    public void push(Object p) {       
        if (last >= arrSize) {
            expandArray();
        }
        arr[last] = p;
        last++; 
    }
    
    public T pop() {
        return pollLast();
    }
    
    /**
     * Remove last node from StackQueue
     * @return top node of StackQueue
     */    
    public T pollLast() {
        last--;        
        Object p = arr[last];
        return (T) p;
    }
    
    public T pollFirst() {
        Object p = arr[first];
        first++;
        return (T) p;
    }
    
    /**
     * Size of sStackQueue
     * @return number of points in StackQueue
     */
    public int size() {
        return last - first;
    }
    
    /**
     *  Founds out if StackQueue is empty or not
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
        T[] newArr = (T[]) new Object[arrSize];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = (T) arr[i];
        }
        arr = newArr;
    }
    
}
