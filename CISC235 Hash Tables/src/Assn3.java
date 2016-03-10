import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
 * I confirm that this
	submission is my own work and is consistent with the Queen's regulations on Academic
	Integrity.
 */

public class Assn2 {

	static String[] theArray = new String[2293];
	int arraySize;
	int itemsInArray = 0;
	static double comparisions = 0;
	public static String[] elementsToAdd = new String[2000];
	
	public static void main(String[] args) throws IOException{
	
	    // create token1
	    String token1 = "";
	    Arrays.fill(theArray, null);
	    // create Scanner inFile1
	    Scanner inFile1 = new Scanner(new FileReader("aliases2015.txt"));

	    // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
	    // List<String> temps = new LinkedList<String>();
	    
	    /*
	    List<String> temps = new ArrayList<String>();
	    
	    
	    
	    // while loop
	    while (inFile1.hasNext()) {
	      // find next line
	      token1 = inFile1.next();
	      temps.add(token1);
	    }
	    
	    inFile1.close();

	    String[] tempsArray = temps.toArray(new String[2000]);
	    int i = 0;
	    
	    for (String s : tempsArray) {
	    	elementsToAdd[i] = s;
	    	i++;
	    }
	    
	    
	    */
	    int i = 0;
	    while (inFile1.hasNextLine()){
	    	String name =  inFile1.nextLine(); 
	    	elementsToAdd[i] = name;
	    	i++;
	    }


	    
	    
	    
	    //Calling Quadratic Probe
	    for (int j = 0; j < elementsToAdd.length; j++){
	    	quadProbingInsert(elementsToAdd[j]);
	   }
	    
	    //Calling Double Hash (Uncomment to run)
	    //for (int j = 0; j < elementsToAdd.length; j++){
	    //	doubleHash(elementsToAdd[j]);
	  // }
	    
	    
	    System.out.println("Results for Quad Probing");
	    System.out.println("The total # of comparisons was " + comparisions);
	    System.out.println("The average # of comparisons was " + comparisions/2000);
	    System.out.println("The size of the hash table is " + theArray.length);
	    
	}
	
	
	
	public static int hash(String key){
		int total = 0;
		char c;
		
		for (int i = 0; i < key.length(); i++){
			 c = key.charAt(i);
			total = total*7 + Character.getNumericValue(c);
			
		}
		return total;
	}
	
	public static long hash2(String key){
		long hash = 5381;
		
		for (int i = 0; i < key.length(); i++){
			hash = ((hash << 5) + hash) + 33;
		}
		
		return hash;
	}
	
	public static int hash3(String key){
		double v = (Math.sqrt(5)-1)/2;


		int k = hash(key);
		
		double x = v*k;
		double frac = x-Math.floor(x);
		
		
		return (int) Math.floor(frac * theArray.length);
	}

	
	
	public static void quadProbingInsert(String k){
		
		int m = theArray.length;
		int i = 0;
		int a = 0;
		int v  = hash(k) % m;
		int c1 = 1;
		int c2 = 1;
		
		
		while ((i < theArray.length) && (theArray[a] != null)){
			i++;
			comparisions++;
			a = (v + c1*i + c2*i^2) % m;
		}
		
	
		if (theArray[a] == null) {
			theArray[a] = k;
				
		} 
		
		
		
	}
	
	public static void doubleHash(String k){
		int m = theArray.length;
		int i = 0;
		
		int v1  = hash(k) % m;
		long v2 = hash2(k) % m;
		int v3 = hash3(k) % m;
		int a = (int) ((v1 + i*v2));
		int c1 = 1;
		int c2 = 1;
		
		
		while ((i < theArray.length) && (theArray[a] != null)){
			i++;
			comparisions++;
			a = (int) ((v1 + i*v2) % m); //Using hash1 and hash2
		//	a = (int) ((v2 + i*v3) % m); //Using hash2 and Hash3
		//	a = (int) ((v1 + i*v3) % m); //Using hash1 and Hash3
		}
		
	
		if (theArray[a] == null) {
			theArray[a] = k;
				
		} 
	}
	
	/*
	public String findKey(String key){
		
		int arrayIndexHash = Integer.parseInt(key)%29;
		
		while(theArray[arrayIndexHash] != "-1") {
			if(theArray[arrayIndexHash] == key){
				System.out.println(key + " was fond in index " + arrayIndexHash);
				return theArray[arrayIndexHash];
			}
			
			arrayIndexHash++;
			
			arrayIndexHash %= arraySize;
			
		}
		
		return null;
	}
	*/
	
	public void displayTheStack() {

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

				if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}

	}

}