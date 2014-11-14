package circularlist;

/**
 *item that points to another item
 *
 * @param <E> type of our item
 * @author Rebecca Murphy (Though this code was mostly taken from CS2)
 * @version 1.0.0
 */
public class Node<E> {

	private E item;
	private Node<E> next;
	/**
	 * Creates the first item, with no items after it.
	 * @param newItem
	 */
	public Node (E newItem)
	{
		item = newItem;
		next = null;
	}
	/**
	 * Creates as an item that can be added to
	 * @param newItem
	 * @param nextNode
	 */
	
	public Node (E newItem, Node<E> nextNode)
	{
		item = newItem;
		next = nextNode;
	}
	/**
	 * enables item to be set to a new item
	 * @param newItem
	 */
	public void setItem(E newItem)
	{
		item = newItem;
	}
	/**
	 * Returns item
	 * @return item
	 */
	public E getItem()
	{
		return item;
	}
	/**
	 * Sets the next node.
	 * @param nextNode
	 */
	public void setNext(Node<E> nextNode)
	{
		next = nextNode;
	}
	/**
	 * Gets the next node
	 * @return next
	 */
	public Node<E> getNext()
	{
		return next;
	}
}