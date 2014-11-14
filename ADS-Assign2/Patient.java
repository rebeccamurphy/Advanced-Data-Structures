package vacsys;

import java.util.HashMap;

public class Patient implements Comparable<Patient> {
	/**
	 * Patient class
	 * @author Rebecca Murphy
	 * 
	 */
	public String name;
	public int age;
	public String zip;
	public int priority;
	/**
	 * Creates a default Patient with empty properties
	 */
	public Patient() {
	
		this.name ="";
		this.age= -1;
		this.zip = "";
		this.priority =-1;
	}
	/**
	 * Creates a Patient with name, age,zip, priority
	 * 
	 * @param name
	 * @param age
	 * @param zip
	 * @param priority
	 */
	
	public Patient(String name, int age,String zip,int priority) {
		this.name = name;
		this.age = age;
		this.zip = zip;
		this.priority = priority;
					
	}
	
	@Override
	/**
	 *  compareTo method for Patient
	 *  @param p2, patient to be compared to.
	 *  @return unless on of the patients is null, returns the difference in the two patients priority 
	 */
	public int compareTo(Patient p2) {
		if (p2 == null)
			return 1;
		else if (this == null)
			return -1;
		//basically checks if the this person's priority is greater than p2 
		return this.priority - p2.priority;
		
			
	}
	/**
	 * Function to set the priority of a patient
	 * @param pri
	 */
	public void setPriority(int pri)
	{
		this.priority = pri;
	}
	/**
	 * Function to calculate the priority of a patient, 
	 * using tpop and a Hashmap the number of patients in each zipcode
	 * @param tpop
	 * @param zipcodes
	 */
	public void calcPriority(int tpop, HashMap<String, Integer> zipcodes)
	{
	int zpop =-1;
	if (zipcodes.get(this.zip) !=null)
		zpop = zipcodes.get(this.zip);
	
	this.setPriority((Math.abs(35 - this.age) /5) +((zpop/ tpop) *10));
	
	}
	/**
	 * To string method for patient so it can be easily written to a file. 
	 */
	@Override
	public String toString ()
	{
		return this.name + "," +this.age + "," +this.zip;
	}
}
