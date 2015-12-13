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
	Nicholas Smith, Queen's University

*/

public class Assn2 {

	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	

	public static String[] elementsToAdd = new String[2000];
	static Assn2 theFunc = new Assn2(5000);
	static int comparisions = 0;
	
	public static void main(String[] args) throws IOException{
	
	    // create token1
	    String token1 = "";
	    Arrays.fill(theFunc.theArray, "null");
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


	    
	    
	    
	    
	    for (int j = 0; j < elementsToAdd.length; j++){
	    	quadProbingInsert(elementsToAdd[j]);
	    }
	    
	   
	    System.out.println("The number of comparisons are " + comparisions);
	    
	}
	
	
	
	public static int hash(String key){
		int total = 0;
		
		for (int i = 0; i < key.length(); i++){
			char c = key.charAt(i);
			total = total + (c)*2;
		}
		
		return total;
	}
	
	
	public static void quadProbingInsert(String k){
		
		int m = theFunc.theArray.length;
		int i = 0;
		int a = 0;
		int v  = hash(k);
		int c1 = 1;
		int c2 = 1;
		while ((i < theFunc.theArray.length) && (theFunc.theArray[a] != null)){
			i++;
			comparisions++;
			a = (v + c1*i + (c2*i)^2) % m;
			System.out.println(a);
		}
		if ((theFunc.theArray[a] == null)) {
				theFunc.theArray[a] = k;
				System.out.println("GOT HERE!");
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
	
	
	Assn2(int size){
		arraySize = size;
		theArray = new String[size];
	}
	
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