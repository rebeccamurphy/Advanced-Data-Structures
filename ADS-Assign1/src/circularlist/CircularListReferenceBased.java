package circularlist;
import java.util.Iterator;
/**
 * 
 *
 * @param  <E> type of elements in list
 * @author Rebecca Murphy 
 * @version 1.0.0
 */
public class CircularListReferenceBased<E> implements CircularList<E> {

	
	private Node<E> head;
	private int numItems;
	/**
	* Initializes the LinkedList
	*/
	public CircularListReferenceBased() {
		head=null;
		numItems=0;
    }
	
	/**
	* Adds the item to the end of the list or if it is the first item added starts the list with that item.  
	*
	* @param item to add
	* @return true if successfully added
	*/
	@Override
public boolean add(E item)
{
		if (numItems ==0)
		{
			Node<E> newNode = new Node<E>(item, head);
			head = newNode;
		
		}
	else 
		{
			Node<E> prev = find(numItems );
			Node<E> newNode = new Node<E> (item, prev.getNext());
			prev.setNext(newNode);
			
		}
		numItems++;
		return true;
}

/**
* Adds item to specified index 
*
* @param index to add to
* @param Generic item  to add
* @throws IndexOutOfBoundsException on negative index, or non-existent index
*/
@Override	
public void add(int index, E item) throws IndexOutOfBoundsException
{	while (index >= numItems && numItems!=0)
		index-=numItems;
	if (index < 0 || index > numItems+1) {
        throw new IndexOutOfBoundsException();
	}
	
	if (index ==0)
		{
			Node<E> newNode = new Node<E>(item, head);
			head = newNode;
		}
	else 
		{
			Node<E> prev = find(index );
			Node<E> newNode = new Node<E> (item, prev.getNext());
			prev.setNext(newNode);
		}
	
	numItems++;
			
	}

/**
* Empties our list
*/
public void clear()
{
	head =null;
	numItems =0;	
}

/**
* gets items circularly at specified index
*
* @param index to search
* @return element at index
* @throws IndexOutOfBoundsException on negative index, or non-existent index
*/
@Override
public E get(int index) throws IndexOutOfBoundsException
{
	index+=1;
	if (index >= 1)
{	while (index> numItems)
		index-=numItems;
	Node<E> curr = find(index);
	E dataItem = curr.getItem();
	return dataItem;
}
else
{
	throw new IndexOutOfBoundsException();

}
	}
/**
* Checks if the list is empty
*
* @return true on 0-item list
*/
public boolean isEmpty()
{
return numItems ==0;	
}

/**
* Circularly Removes element at specified index
*
* @param index to search for
* @return item removed at index
* @throws IndexOutOfBoundsException on negative index, or non-existent index
*/
@Override
public E remove(int index) throws IndexOutOfBoundsException
{	
	E itemofremovedNode;
	while (index >=numItems)
		index-=numItems;
	if (index<0 || isEmpty())
		throw new IndexOutOfBoundsException();
	else
	{
		if (index ==0)
			{
			itemofremovedNode = head.getItem();
			head = head.getNext();
			numItems--;
			return itemofremovedNode;
			
			}
		else
		{
			Node<E> prev = find(index);
			Node<E> curr = prev.getNext();
			prev.setNext(curr.getNext());
			numItems--;
			return curr.getItem();
		}
		
	}
	 
			
}

/**
* Get the number of elements in the list
*
* @return number of elements
*/
public int size()
{
 return numItems;	
}
/**
 * Goes through the list and find the node at the specified index. Used by get, add and remove. 
 * @param index
 * @return node at that index. 
 */
private Node<E> find (int index)
{
	Node<E> curr = head;
	for (int i=1;i<index;i++)
		curr= curr.getNext();
	return curr;
}
/**
 * Defines an iterator for this class
 * @see circularlist.CircularList#iterator()
 */
	    @Override
    public Iterator<E> iterator() {
	        return new CircularListIterator(this);
	    }

}
