package pathfinding.struct;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ArrayList<T> implements Iterable<T> {

    private int arrSize;
    private Object[] arr;
    private int cell;
    
    /**
     *
     */
    public ArrayList() {
        arr = new Object[8];
        arrSize = 8;
        cell = 0;
    }

    /**
     *
     * @param object
     */
    public void add(T object) {
        if (cell >= arrSize) {
            arrSize = arrSize * 2;
            Object[] newArr = new Object[arrSize];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[cell] = object;
        cell++;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param action
     */
    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public int size() {
        return cell;
    }
    
}
