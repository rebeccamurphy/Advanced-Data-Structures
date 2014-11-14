package circularlist;

import java.util.Iterator;

/**
 * 
 *
 * @param <E> (Generic) type of our underlying list
 * @author  Rebecca Murphy
 * @version 1.0.0
 */
public class CircularListIterator<E> implements Iterator<E> {

    private CircularList<E> list;
    private int currentIndex;

    /**
     * Tests if the list is iterable by seeing if there's more than one element to iterate through
     *
     * @return true, false if the list is empty
     */
    @Override
    public boolean hasNext() {

        // The only case where it would not be possible to iterate would be when the list is empty
        if (list.size() == 0)
        	return false;
        else
        	return true;
    }

    /**
     * Returns the next element in a CircularList
     *
     * @return the next element
     */
    @Override
    public E next() {
        return list.get(currentIndex++);
    }

    /**
     * Didn't fill out the remove function, because it wasn't specified in the instructions. 
     * 
     */
    @Override
    public void remove() {
        // Intentionally left blank
    }

    /**
     * Instantiates an iterator
     *
     * @param circularList to iterate on
     */
    public CircularListIterator(CircularList<E> circularList) {
        list = circularList;
        currentIndex = 0;
    }
}