package vacsys;

public interface VacSysPriorityQueue {
	/***
	 * Interface for priority queue.
	 * @author Rebecca Murphy
	 */
	
	/***
	 * Function for inserting a new patient into the heap
	 * @param Person
	 */
	public void insertIntoHeap(Patient Person);
	/***
	 * Function for removing a patient from the heap
	 * @return removed patient
	 */
	public Patient removeFromHeap();
	
	}

