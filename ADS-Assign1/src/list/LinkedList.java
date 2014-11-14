package list;
//try to find this somewhere else and cite where you got it from
/**
 * LinkedList is an implementation of List using a single pointer from each piece to another of the list
 *
 * @param <E> type for our list
 * @author 
 * @version 1.0.0
 */
public class LinkedList<E> implements List<E> {
    /* An empty list is an instantiated head node.  The "last" element is where the next piece of data should be added,
     * not the last element already in the list.
     */
    private Node<E> head;
    private Node<E> last;

    /**
     * Initializes our list
     */
    public LinkedList() {
        clear();
    }

    /**
     * Adds our item to the end of the list
     *
     * @param item to add
     * @return true if successfully added
     */
    @Override
    public boolean add(E item) {
        add(size(), item);
        return true;
    }

    /**
     * Adds item to specified index
     *
     * @param index to add to
     * @param item  to add
     * @throws IndexOutOfBoundsException on negative index, or non-existent index
     */
    @Override
    public void add(int index, E item) throws IndexOutOfBoundsException {
        Node<E> parentNode;

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head.setItem(item);
            head.setNext(new Node<E>());
        } else {
            // Set the previous Node's next to a new Node with data = item and next = previous node's old next
            parentNode = getNode(index - 1);
            parentNode.setNext(new Node(item, parentNode.getNext()));
        }
    }

    /**
     * Empties our list
     */
    @Override
    public void clear() {
        head = new Node<E>();
    }

    /**
     * Retrieve element at index
     *
     * @param index to search
     * @return element at index
     * @throws IndexOutOfBoundsException on negative index, or non-existent index
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return getNode(index).getItem();
    }

    /**
     * Determine if our list is empty
     *
     * @return true on 0-item list
     */
    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * Removes element at specified index
     *
     * @param index to search for
     * @return item removed at index
     * @throws IndexOutOfBoundsException on negative index, or non-existent index
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        Node<E> removedNodeParent;
        E dataOfRemovedNode;

        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            dataOfRemovedNode = head.getItem();
            head = head.getNext();
        } else {
            removedNodeParent = getNode(index - 1);
            dataOfRemovedNode = removedNodeParent.getNext().getItem();
            removedNodeParent.setNext(removedNodeParent.getNext().getNext());
        }

        return dataOfRemovedNode;

    }

    /**
     * Get the number of elements in our list
     *
     * @return number of elements
     */
    @Override
    public int size() {
        int counter;
        Node<E> pointer = head;

        for (counter = 0; pointer.getNext() != null; counter++) {
            pointer = pointer.getNext();
        }

        return counter;
    }

    /**
     * @param index
     * @return node at index
     */
    private Node<E> getNode(int index) {
        Node<E> pointer = head;
        for (int i = index; i > 0; i--) {
            pointer = pointer.getNext();
        }
        return pointer;
    }
}