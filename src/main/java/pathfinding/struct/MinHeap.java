package pathfinding.struct;

import pathfinding.domain.Node;

public class MinHeap {

    int arrSize;
    Node[] arr;
    int cell;
    
    public MinHeap() {
        arr = new Node[8];
        arrSize = 8;
        cell = 0;
    }

    public void add(Node node) {
        if (cell >= arrSize) {
            arrSize = arrSize*2;
            Node[] newArr = new Node[arrSize];
            for(int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[cell] = node;
        cell++;
    }

    public boolean isEmpty() {
        if (cell > 0) {
            return false;
        }
        return true;
    }

    public Node poll() {
        return arr[cell];
    }
    
}
