package vacsys;

import java.util.ArrayList;

public class VacSysHeap implements VacSysPriorityQueue {
	/***
	 * Implementation of VacSysPriorityQueue
	 * Create and use a heap implementation of priority queue interface
	 * @author Rebecca Murphy
	 */
	ArrayList<Integer> priorities = new ArrayList<Integer>();
	ArrayList<Queue> heap = new ArrayList<Queue>();
		
	/***
	 * Default Constructor for VacSysHeap()
	 */
	public VacSysHeap() {}
	
	/***
	 * Function for inserting a patient into the heap. First it checks whether the patient's priority
	 * is an existing queue, if it is,the patient is added to the end of the queue.
	 * Else the patient is added to a newly created queue of that priority, and that queue is added to
	 * the end of the patient Heap. The priority of that patient is also added to the list of priorities.
	 * @param Patient person
	 */
	@Override
	public void insertIntoHeap(Patient person) {
		if (!priorities.contains(person.priority))
		{
			//If the priority of person is not currently in the queue, this creates a new queue
			//for that priority and adds it to the heap. 
			
			priorities.add(person.priority);
			Queue priorityQueue = new Queue();
			priorityQueue.add(person);
			heap.add(priorityQueue);
			
			int current = heap.size() - 1; // last node in heap
			//sorts the heap,after one node is added. 
			while (current > 0 && person.compareTo((heap.get(parent(current))).getFirst()) >= 0)
			{
				current = swap(current, parent(current));
			}
		}
		else 
		{
			//traverse heap, find equal priority 
			for (int i=0; i<heap.size(); i+=1)
			{	// checks if the current person's priority should be inserted to the queue at heap.get(i)
				if (person.priority == heap.get(i).getPriority())
					heap.get(i).add(person);
			}
		}	
	}
	/***
	 * Function to remove a the firstPatient from the heap. First it gets the topQueue, then it 
	 * removes the first Patient from that Queue, if the queue is empty after removing the patient
	 * percolate is called to remove the top queue and reorder the heap.
	 * @return Removed Patient
	 */
	@Override
	public Patient removeFromHeap() {
		Queue topQueue = heap.get(0);
		Patient firstPatient = topQueue.remove();
		
		if (topQueue.isEmpty())
		{
			priorities.remove( firstPatient.priority); //removes the priority of topQueue from the list of priorities	
			percolate(); //to make sure the root node is the highest priority, and generally reorder heap
		}
		
		return firstPatient;
	}
	
	/***
	 * Function to get the left child of a node in the heap
	 * @param n: current node position
	 * @return int position of left child
	 */
	private int leftchild(int n)
	{
		return 2 * n + 1;
	}
	/***
	 * Function to get the right child of a node in the heap.
	 * @param n: current node position
	 * @return int position of the right child
	 */
	private int rightchild(int n)
	{
		return 2 * n + 2;
	}
	/***
	 * Function to get the position of the parent of the current node
	 * @param n current node
	 * @return int position of node
	 */
	private int parent(int n)
	{
		if (n == 0)
			return 0;
		return (n - 1) / 2;
	}
	/***
	 * Function used in reordering the heap. Swaps the current node position with the newIndex
	 * @param currentIndex
	 * @param newIndex
	 * @return the new index of the current node, the newindex
	 */
	private int swap(int currentIndex, int newIndex)
	{
		Queue tempPerson = heap.get(currentIndex);
		heap.set(currentIndex, heap.get(newIndex));
		heap.set(newIndex, tempPerson);
		return newIndex;
	}
	/***
	 * Function to get the size of the heap
	 * @return int heap size
	 */
	public int size()
	{
		return heap.size();
	}
	/***
	 * Trickle down function for making the root node have the greatest priority. 
	 * After removing the top priority patient from the heap, if that priority queue is empty,
	 * the queue is removed and this function is called to reorder the heap.
	 */
	public void percolate(){
		int current = 0; //starting node for going through the heap
		heap.set(current, heap.get(heap.size() - 1)); //moves the last queue to the top of the heap
		heap.remove(heap.size() - 1); //removes the queue that was just moved from the end
		while (heap.size() != 0) // shifts the heap until it is in the right order, after removing the root 
		{
			Patient left, right; //left and right childs of the current node 
			Patient person = heap.get(current).getFirst();// gets a patient of the current top queue for comparison
			
			if (leftchild(current) <heap.size())
				left = heap.get(leftchild(current)).getFirst();	
			else
				left = null;
			
			if (rightchild(current) < heap.size()) 
				right = heap.get(rightchild(current)).getFirst();
			else
				right = null;
			
			if (person.compareTo(left) > 0 && person.compareTo(right) > 0)
				break;// if the new root is currently higher that both children the loop breaks
			else if (left.compareTo(right) > 0)// checks if left child is greater than right, and swaps the left child and the current node's places in the heap
				current = swap(current, leftchild(current));
			else
				current = swap(current, rightchild(current));
		}
		
	}
	
}
