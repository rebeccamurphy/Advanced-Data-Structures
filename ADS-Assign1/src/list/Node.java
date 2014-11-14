package list;
//find this some where are and cite where you got it 
/**
 * Piece of item that points to another piece of item
 *
 * @param <E> type of our item
 * @author Rebecca Murphy (Though this code was mostly taken from CS2, so technically Professor Haeys
 * @version 1.0.0
 */
public class Node<E> {

    E item;
    Node next;

    Node() {
        next = null;
        item = null;
    }

    Node(E newItem) {
        next = null;
        item = newItem;
    }

    Node(Node<E> newNext) {
        next = newNext;
        item = null;
    }

    Node(E newItem, Node<E> newNext) {
        next = newNext;
        item = newItem;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> nextNode) {
        this.next = nextNode;
    }
}