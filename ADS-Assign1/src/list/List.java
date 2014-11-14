package list;

public interface List<E> {

    /**
     * Adds our item to the end of the list
     *
     * @param item to add
     * @return true if successfully added
     */
    public boolean add(E item);

    /**
     * Adds item to specified index
     *
     * @param index to add to
     * @param item  to add
     * @throws IndexOutOfBoundsException on negative index, or non-existent index
     */
    public void add(int index, E item) throws IndexOutOfBoundsException;

    /**
     * Empties our list
     */
    public void clear();

    /**
     * Retrieve element at index
     *
     * @param index to search
     * @return element at index
     * @throws IndexOutOfBoundsException on negative index, or non-existent index
     */
    public E get(int index) throws IndexOutOfBoundsException;

    /**
     * Determine if our list is empty
     *
     * @return true on 0-item list
     */
    public boolean isEmpty();

    /**
     * Removes element at specified index
     *
     * @param index to search for
     * @return item removed at index
     * @throws IndexOutOfBoundsException on negative index, or non-existent index
     */
    public E remove(int index) throws IndexOutOfBoundsException;

    /**
     * Get the number of elements in our list
     *
     * @return number of elements
     */
    public int size();
}