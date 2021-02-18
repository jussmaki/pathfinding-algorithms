package pathfinding.struct;

import pathfinding.domain.DNode;

public class MinHeap {

    int arrSize;
    DNode[] heap;
    int last;
    
    public MinHeap() {
        arrSize = 8;
        heap = new DNode[arrSize];
        //heap[0] = null;
        last = 0;
    }

    public void add(DNode node) {
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
    
    public DNode min() {
        return heap[1];
    }

    public DNode poll() {
        DNode node = heap[1];
        heap[1] = heap[last];
        last--;
        truncate(1);
        return node;
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

    public boolean isEmpty() {
        //System.out.println(this + " last: " + last);
        if (last > 0) {
            return false;
        }
        return true;
    }

    private void expandHeap() {
            arrSize = arrSize*2;
            DNode[] newArr = new DNode[arrSize];
            for(int i = 0; i < heap.length; i++) {
                newArr[i] = heap[i];
            }
            heap = newArr;
    }

    private void swap(int a, int b) {
        DNode h = heap[a];
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

    private String nodes() {
        String tulos = "";
        for (DNode n : heap) {
            if (n==null) {
                continue;
            }
            tulos = tulos + /*n.getLocation() +*/ " " + (int) n.getDistance() + " ";
        }
        return tulos;
    }
    
    @Override
    public String toString() {
        return "MinHeap{" + "heap=" + nodes() + '}';
    }
}
