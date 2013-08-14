/**
 * L3 U14
 * @author sthlm
 * 
 * @param theArray is main array aka. the hash table.
 * @param hashVal is hashing value
 * @param key the String to hash.
 * @param tableSize the size of the hash table. 
 * @return the hash value.
 * 
 *
 * implementing hashtable with some numbers
 * 
 */

import java.util.Arrays;

//-----main class
public class HashFunction{
	
	//-----creating variables and theArray hash table
	public static String[] theArray;
	int arraySize; 
	int itemsInArray = 0;
	
	
	//-----main method
	public static void main(String[] args){
		
		//execute and create 30 space array
		HashFunction func = new HashFunction(30);
		
		//create string array element to add to main array theArray
		String[] elementsToAdd = {"1", "5", "17", "21", "26"};
		
		//parse elements(datamängden) to add, parse along the function itself with the array
		func.hashFunction(elementsToAdd, func.theArray);
		
		func.displayActivities();
	}
	
	//-----the hash function
	/**
	 * @param stringsForArray innehåller nu 5 element elementsToAdd.
	 * for loopar < 5 gör newElementVal = 5
	 */
	public void hashFunction(String[] stringsForArray, String[] theArray){	//receive string string of numbers that is going to be stored in arrray
		
		for (int n = 0; n < stringsForArray.length; n++) {		//array that have a bunch of values that we want to insert in the regular array
			String newElementVal = stringsForArray[n];			//take the info that is stored inside of the array that is been passed over 
			
		
		//
		//create an index to store the value in by taking the modulus of the string value and parse to int arrayIndex.
		//21 mod 10 = 21/10=2 remainder 1 == 1
		//
		int arrayIndex = Integer.parseInt(newElementVal) % 10;
		
		//prints the arrayIndex and the elementValue
		System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);
		
		//looping through the array until we find empty space. while theArray index != -1 
		while (theArray[arrayIndex] != "0") {	
			arrayIndex++;
			
			System.out.println("Collision Try " + arrayIndex + " Instead");
			
			//go back to offset if reached end
			arrayIndex %= arraySize;
		}
			
		theArray[arrayIndex] = newElementVal;
		
		}
	}
	
	
	//-----constructor
	/**
	 *  
	 * @param size store arraySize, create array with that specific size, 
	 *  two hash functions and fill negative 1 in every single index in the array that starts out to display index info.  
	 *  
	 *  @param Arrays.fill Assigns the specified int value "0" to each element of the specified array of ints. 
	 *  If value in array = 0, display "|      "
	 * 
	 */
	HashFunction(int size){
		arraySize = size;
		theArray = new String[size];
		Arrays.fill(theArray, "0");

		
		
	}
	
	//-----display activities
	public static void displayActivities() {

		int increment = 0;

		for (int m = 0; m < 3; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (theArray[n].equals("0"))
					System.out.print("|      ");

				else
					System.out.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}

	}
}