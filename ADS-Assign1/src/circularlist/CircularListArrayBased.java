package circularlist;
import java.util.Iterator;

/**
 * CircularListArrayBased adds, removes, and gets items circularly. 
 *
 * @param <E>(Generic) type of elements in list
 * @author Rebecca Murphy  
 * @version 1.0.0
 */

public class CircularListArrayBased<E>  implements CircularList<E>{
	  private E[] array= null;
	    
	  /**
	   * creates an empty CircularListArrayBased
	   */

	    public CircularListArrayBased() {
	    	clear();
	    }
	    /**
	    * creates an ArrayBasedList with an initalCapacity. Though,  it is not used in the test code, and currently there is no way to replace
	    * the nulls that it initializes with. I wasn't sure how necessary it was. If I have time I will make sure it works.
	    * @param int initial Capacity 
	    */
	    public CircularListArrayBased(int initialCapacity)
	    {
	     array = createArrayOfSize(initialCapacity);
	     
	    }
	    /**
	     * If it is the first item added to the list, it will initialize the array and add the item. Else it will just add the item to the end
	     * of the array.
	     * @param item to be added
	     * @return true if item was added.
	     * @see circularlist.CircularList#add(java.lang.Object)
	     */
	@Override
	    public boolean add(E item)
	    {
		if (array==null)
		{array = createArrayOfSize(1);
		array[0] = item;
		}
		else
			
		{	E[] newArray = createArrayOfSize(array.length +1);
			for (int i = 0; i < array.length; i++) {
	        if (array[i] !=null)
	        	newArray[i] = array[i];
	    }
	    newArray[array.length] = item;
	    array = newArray;
		}
	    return true;
	    }
	/**
	 * Circular adding implemented here. if the index is greater than the length of the array, the index is reduced until the correct place to be
	 * inserted in the list is found. otherwise it is inserted normally. Assumes that the user will want the first item to go at index 0. 
	 * @param index where to add item
	 * @param item
	 * @throws IndexOutOfBoundsException
	 * @see circularlist.CircularList#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, E item) throws IndexOutOfBoundsException
	{	
		if (index< 0 )
			throw new IndexOutOfBoundsException();
		
		if (index==0 && array==null)
		{	array = createArrayOfSize(1);
			array[index] = item;
		}
		else if(index==0&& array!=null) //adding an item to the beginning
		{
			E[] newArray = createArrayOfSize(array.length +1);
			newArray[index]= item;
		    for (int i = 0; i < array.length; i++) {
		        newArray[i+1] = array[i];
		    }
		    array = newArray;
		}
		
		else //adding an item anywhere else
		{	while (index >=array.length)
				index-=array.length;
			E[] newArray = createArrayOfSize(array.length +1);
		    for (int i = 0; i < index; i++) {
		        newArray[i] = array[i];
		    }
		    newArray[index] = item;
		    for (int i = index; i < array.length; i++) {
		        newArray[i+1] = array[i];
		    }
		    array = newArray;
			
		}
	}
	/**
	 * removes all the elements from the array. 
	 * @see circularlist.CircularList#clear()
	 */
	@Override
	public void clear()
	{
	array = null;	
	}
	/**
	 *Circularly gets an item at the given index.  
	 *@param index 
	 *@throws IndexOutOfBoundsException
	 * @see circularlist.CircularList#get(int)
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException
	{
		if (index< 0)
			throw new IndexOutOfBoundsException();
		else
		{
			while (index >= array.length)
				index-=array.length;
			return array[index];
		}
	}
	/**
	 * Checks if the list is empty, returns true is array length is 0.
	 * @see circularlist.CircularList#isEmpty()
	 */
	@Override
	public boolean isEmpty() 
	{
	return array.length ==0;	
	}
	@Override
	/**
	 * Removes items circularly, given a certain index. 
	 * @param index
	 * @ throws IndexOutOfBoundsException
	 * @see circularlist.CircularList#remove(int)
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{	while (index >= array.length)
			index-=array.length;
		if (index< 0 || array == null)
			throw new IndexOutOfBoundsException();
		else
		{
			E[] newArray = createArrayOfSize(array.length -1);
			E removedItem = array[index];
			if(index==0) //removing an item at the beginning
			{	
			    for (int i = 1; i < array.length; i++) {
			        newArray[i-1] = array[i];
			    }
			    
			    array = newArray;
		}
			
			else if (index == array.length) // removing the last item
			{
				
			    for (int i = 0; i < array.length-1; i++) {
			        newArray[i] = array[i];
			    }
			    array = newArray;
			}
			else //removing an item anywhere else
			{
			    for (int i = 0; i < index; i++) {
			        newArray[i] = array[i];
			    }
			    
			    for (int i = index; i < array.length-1; i++) {
			        newArray[i] = array[i+1];
			    }
			    array = newArray;
				
			}
			return removedItem;
		}
	}
	@Override
	/**
	 * Returns the size of the list.
	 * @return array length / size of array
	 * @see circularlist.CircularList#size()
	 */
	public int size() {
		return array.length;
	}

	/**
	 * This is not in the circularList interface. 
	 * @param size of Array to Create
	 * @return a Generic Array of that size 
	 */
	private E[] createArrayOfSize(int size) {
		//Generic types are odd, I originally tried to initiate an array E[size], but that did not work. 
		//You have to do some type casting, which might not be the safest thing to do, but it is a common work around
		// This was the only common work around I found, which is not highly recommended to use but it works. 
		
		return (E[]) (new Object[size]);

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