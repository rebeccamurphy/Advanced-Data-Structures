package vacsys;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;

public class VacSys {
	/**
	 * @author Rebecca Murphy
	 * class for making a VacSys. VacSys uses a heap of queues of patients with the same priority.
	 * When a patient is removed, it is popped from the top queue. Once the top queue is empty
	 * it is removed from the heap, and the last node of the heap is moved to the root of the heap.
	 * the new root is then trickled down until the heap is ordered properly.
	 * */
	 
	private int tpop =0;
	private HashMap<String, Integer> zipcodes = new HashMap<String, Integer>();
	private VacSysHeap patientHeap;
	private ArrayList<Patient> patients= new ArrayList<Patient>();
	//Constructors:
	
	/**
	 * Creates initializes patientHeap as a new VacSysHeap()
	 */
	public VacSys() {
		// Create a system with an empty priority queue
		patientHeap = new VacSysHeap();
		tpop =0;
		patients= new ArrayList<Patient>();
	}
	/**
	 * Creates a new VacSysHeap from the patients in the filename
	 * @param filename the file name of the requests to be added to the system
	 */
	public VacSys(String filename) {
		//Create a system loaded with requests from the batch ﬁle given by ﬁlename
		
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		patientHeap = new VacSysHeap();
		patients =new ArrayList<Patient>();
		tpop =0;
		try {
			 
			br = new BufferedReader(new FileReader(filename));
			
			while ((line = br.readLine()) != null) {
			        // use comma as separator
				String[] people = line.split(cvsSplitBy);
				Patient peep = new Patient (people[0], Integer.parseInt(people[1].replaceAll("\\s+","")), people[2].replaceAll("\\s+",""), 0);
				patients.add(peep);
				addZipcode(peep);
				tpop++;
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		updatePatients();
		 
	}
	/**
	 * 
	 * Method to insert a new patient into the heap
	 * @param name String Patient Name
	 * @param age int Patient age
	 * @param zip String Patient Zip
	 * @return true if the add was successful
	 */
	
	boolean insert(String name, int age, String zip){
		//Add a new request to the system
		Patient newb = new Patient(name, age, zip,-1);
		//System.out.println(zipcodes);
		//checks if the patient's zip exists, if not it addes the zipcode.
		
		addZipcode(newb);
		tpop++;

		newb.calcPriority(tpop, zipcodes);
		patientHeap.insertIntoHeap(newb);
		return true;
	}
	/***
	 * Removes the top Patient
	 * @return the removed Patient.toString()
	 */
	String remove(){
		//Remove the next request from the system
		tpop--;
		Patient removed = patientHeap.removeFromHeap();
		removeZipcode(removed);
		return removed.toString();
	}
	/***
	 * Removes the top num of patients and writes them to a csv	
	 * @param num Number of Patients to be removed
	 * @param filename File to be written to
	 * @return True if removal was successful
	 */
	boolean remove(int num, String filename){
		//Remove num requests and store them in CSV format in ﬁlename
		try{
		FileWriter writer = new FileWriter(filename);
		//writer.append("NAME, AGE, ZIPCODE\n");
		for (int i = 0; i< num; i++)
		{	
			Patient removed = patientHeap.removeFromHeap();
			removeZipcode(removed);
			writer.append(removed.toString() + "\n");
			tpop--;
		}
		writer.flush();
	    writer.close();
		}
		
		catch(IOException e)
		{
		     e.printStackTrace();
		}
		return true;
	}
	/***
	 * updates the Hashmaps of Zipcodes based on the  patient's zipcode, if the Zipcode is present in hashmap,
	 * it adds one to the Zipcodes's value, else it addes the Zipcode to the list 
	 * of Zipcodes
	 * @param peep 
	 */
	public void addZipcode(Patient peep)
	{
		if (zipcodes.containsKey(peep.zip))
			zipcodes.put(peep.zip, zipcodes.get(peep.zip)+ 1);
		else
			zipcodes.put(peep.zip, 1);
	}
	public void removeZipcode(Patient peep)
	{
		zipcodes.put(peep.zip, zipcodes.get(peep.zip)-1);
	}
	/***
	 * Updates all the patients in Arraylist patients after the file has been read and 
	 * Zipcodes hashmap has been completed as well as tpop, to have the correct
	 *  priority value, and inserts the patient into the heap.
	 */
	
	public void updatePatients()
	{
		for (int i=0; i<patients.size();i++)
		{
			patients.get(i).calcPriority(tpop, zipcodes);
			patientHeap.insertIntoHeap(patients.get(i));
		}
		
	}
}
