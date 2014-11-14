package list;

import circularlist.CircularList;
import circularlist.CircularListReferenceBased;

/**
 * Class to test the circularlist package
 */
public class TestList {

    public static void main(String [] args)
    {
	// Create a CircularList of Strings
	ArrayList<String> cl = new ArrayList<String>(2);
	
	// Add elements
	cl.add("A");  
	//cl.add("B"); cl.add("C"); cl.add("D"); cl.add("E"); 
	//cl.remove(1);
	for (int i =0; i<cl.size(); i++)
	System.out.println(cl.get(i));
	// Use the foreach loop to print out elements from the iterator
    
    }
	
}