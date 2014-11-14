package vacsys;

import java.util.LinkedList;

public class Queue {

	/**
	 *Custom Queue class made from a Linked List
	 * @author Rebecca Murphy
	 */
	  	public LinkedList<Patient> list; 
	  	/**
	  	 * Initiates a new empty Queue	
	  	 */
	    public Queue () { 
	        list = new LinkedList<Patient> (); 
	    } 
	    
	    /**
	     * Functionto check if the Queue is empty
	     * @return whether or not the queue is empty
	     */
	    public boolean isEmpty () { 
	        return list.isEmpty() ; 
	    } 
	    /**
	     * Function to add Patients to the end of the Queue
	     */
	    public void add (Patient p1) { 
	        list.addLast (p1); 
	    } 
	    /**
	     * Function to remove patient from the front of a queue
	     * @return the removed patient 
	     */
	    public Patient remove () { 
	    	Patient temp = new Patient();
	    	temp = list.getFirst();
	        list.removeFirst();
	        return temp;
	    }
	    /**
	     * Function for determining the overall priority of the Queue
	     * @return the priority of the queue
	     */
	    public int getPriority()
	    {
	    	return list.getFirst().priority;
	    }
	    /**
	     * Function for getting the first Patient in a Queue
	     * @return first patient in Queue
	     */
	    public Patient getFirst()
	    {
	    	return list.getFirst();
	    }
	    /**
	     * Function for determining the size of a Queue
	     * @return int size of Queue
	     */
	    public int size()
	    {
	    	return list.size();
	    } 
}
