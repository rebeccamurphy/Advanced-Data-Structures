package circularlist;
/**
 * Class to test the circularlist package
 */
public class TestList {

    public static void main(String [] args)
    {
	// Create a CircularList of Strings
	CircularList<String> cl = new CircularListReferenceBased<String>();
	//CircularList<String> cl = new CircularListArrayBased<String>();
	// Add elements
	
	cl.add(0,"A"); 
	cl.add("B");
	cl.add("C"); cl.add("D"); cl.add("E"); 
	System.out.println(cl.size());
	for (int i =1; i<cl.size(); i++)
		System.out.println(cl.get(i));
	//cl.add(7, "Z");
	cl.remove(7);
	// Use the foreach loop to print out elements from the iterator
	System.out.println("butt"+ cl.get(7));
	System.out.print("{ ");
	int i = 1;
	for(String s : cl) {
	    System.out.print(s + " ");
	    if(i++ > 25)
		break;
	}
	System.out.println("}");	
    }
}
