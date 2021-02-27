package pathfinding.struct;

import pathfinding.domain.Node;

public class MinHeap {

    private int arrSize;
    private Node[] heap;
    private int last;
    
    /**
     * Creates new MinHeap-object
     */
    public MinHeap() {
        arrSize = 1024;
        heap = new Node[arrSize];
        last = 0;
    }

    /**
     * Insert node in heap
     * @param node node to add in heap
     */
    public void add(Node node) {
        if (last >= arrSize - 1) {
            expandHeap();
        }
        last++;
        heap[last] = node;
        int curNode = last;
        while ((curNode > 1) && heap[curNode].compare(heap[parent(curNode)]) < 0) {
            swap(curNode, parent(curNode));
            curNode = parent(curNode);
        }
    }
    
    /**
     * Poll node from heap
     * @return smallest node in heap
     */
    public Node poll() {
        Node node = heap[1];
        heap[1] = heap[last];
        last--;
        truncate(1);
        return node;
    }
    
    /**
     *  Founds out if heap is empty or not
     * @return true/false
     */
    public boolean isEmpty() {
        //System.out.println(this + " last: " + last);
        if (last > 0) {
            return false;
        }
        return true;
    }
    
    private int left(int p) {
        if (2 * p > last) {
            return 0;
        }
        return 2 * p;
    }
    
    private int right(int p) {
        if (2 * p + 1 > last) {
            return 0;
        }
        return 2 * p + 1;
    }
    
    private int parent(int p) {
        return (int) p / 2;
    }

    private void expandHeap() {
        arrSize = arrSize * 2;
        //System.out.println("expanding heap, heap size: " + arrSize);            
        Node[] newArr = new Node[arrSize];
        for (int i = 0; i < heap.length; i++) {
            newArr[i] = heap[i];
        }
        heap = newArr;
    }

    private void swap(int a, int b) {
        Node h = heap[a];
        heap[a] = heap[b];
        heap[b] = h;
    }
    
    private void truncate(int p) {
        int littlestChild = -1;
        if (left(p) == 0) {
            return;
        }
        if (left(p) == last) {
            littlestChild = left(p);
        } else {
            if (heap[left(p)].compare(heap[right(p)]) < 0) {
                littlestChild = left(p);
            } else {
                littlestChild = right(p);
            }
        }
        if (heap[p].compare(heap[littlestChild]) > 0) {
            swap(p, littlestChild);
            truncate(littlestChild);
        }
    }

}
