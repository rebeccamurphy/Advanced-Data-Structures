package list;

/**
 * 
 *
 * @param <E> type of our list
 * @author 
 * @version 1.0.0
 */
public class ArrayList<E> implements List<E> {
    

    private E[] array= null;
    

    public ArrayList() {
    	clear();
    }
    
    public ArrayList(int initialCapacity)
    {
     array = createArrayOfSize(initialCapacity);
     
    }
    
@Override
    public boolean add(E item)
    {
	if (array==null)
	{array = createArrayOfSize(1);
	array[0] = item;
	}
	else
		add(array.length, item);
	return true;
    }
@Override
public void add(int index, E item) throws IndexOutOfBoundsException
{
	if (index< 0 || index>array.length+1)
		throw new IndexOutOfBoundsException();
	/*if (array.length==1 && index==1 && array[0] ==null)
	{
		array[0] = item;
	}*/	
	if (index==0 && array.length==0)
	{	array = createArrayOfSize(1);
		array[index] = item;
	}
	else if(index==0) //adding an item to the beginning
	{
		E[] newArray = createArrayOfSize(array.length +1);
		newArray[index]= item;
	    for (int i = 0; i < array.length; i++) {
	        newArray[i+1] = array[i];
	    }
	    array = newArray;
	}
	else if (index == array.length) // adding an item to the end
	{
		E[] newArray = createArrayOfSize(array.length +1);
	    for (int i = 0; i < array.length; i++) {
	        newArray[i] = array[i];
	    }
	    newArray[index] = item;
	    array = newArray;
	}
	else //adding an item anywhere else
	{
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
@Override
public void clear()
{
array = null;	
}
@Override
public E get(int index) throws IndexOutOfBoundsException
{
	if (index< 0 || index>array.length+1)
		throw new IndexOutOfBoundsException();
	else
	{
		return array[index];
	}
}
@Override
public boolean isEmpty() 
{
return array.length ==0;	
}
@Override
public E remove(int index) throws IndexOutOfBoundsException
{
	if (index< 0 || index>array.length+1)
		throw new IndexOutOfBoundsException();
	else
	{
		E[] newArray = createArrayOfSize(array.length -1);
		E removedItem = array[index];
		if(index==0) //removing an item at the beginning
		{	
		    for (int i = 1; i < array.length; i++) {
		        newArray[i] = array[i];
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
public int size() {
	return array.length;
}

private E[] createArrayOfSize(int size) {
	//Generics are odd, I originally tried to initiate an array E[size], but that did not work. 
	//You have to do some type casting, which might not be the safest thing to do, but it is a common work around
	// I found the common work around here: http://stackoverflow.com/questions/2927391/whats-the-reason-i-cant-create-generic-array-types-in-java
	
	return (E[]) (new Object[size]);

}

}