import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
/*
	Nicholas Smith, Queen's University

*/

public class BinandTrinSearch {
	public static int mid;
	public static int mid1;
	public static int oneThird;
	public static int twoThirds;
	public static int randomNum;
	public int count = 0;
	public static int n = 0;
	public static int kTurn = 0;
	public static void main(String[] args) {
		int k = 0;
		System.out.print("How many n values do you have?");
		Scanner input = new Scanner(System.in);
		int nNum = input.nextInt();
		int[] arrayForN = new int[nNum];
		
		for (int i = 0; i < nNum; i++){
			System.out.println("What are your values for n?");
			int n = input.nextInt();
			arrayForN[i] = n;
			
		}
		//The K values that are being used are k = n/2, k = n/5 and k = n/10
		
		
	//This nested for loop will go through ALL the n values with 
	//the same K value at least once. 
	for (int m = 0; m < nNum; m++){
		for (int j=0; j < 3; j++){
			
			if(j == 0){
				k = arrayForN[m]/2;
			} else if (j == 1){
				k = arrayForN[m]/5;
			} else if (j == 2){
				k = arrayForN[m]/10;
			}
		
			makeList(arrayForN[m] , k);
			
			
		}
		
	}
		
	}
	
	
	
	//Making a list of N values, and another list of every 2nd value.
	//Since the numbers are random, every 'kDivider' value will be randomly scattered once the array is sorted.
	public static void makeList(int n , int kNum){
		int[] list1 = new int[n];
		int[] kVals = new int[kNum];
		
		int k = 0;
		Random rn = new Random();
		for (int i = 0; i < n; i++){
			randomNum = rn.nextInt(500) + 1;
			list1[i] = randomNum;
			
			if (i%(n/kNum) == 0) {
				kVals[k] = randomNum;
				k++;
			}
			
		}
	
	
		
	System.out.println("");
	int[] sortedList = new int[n];
	
	sortedList = recursiveQuickSort(list1, 0, n-1);


	double startTime = System.nanoTime();
	for (int k1 : kVals){
		binarySearch(sortedList, 0, n-1, k1);
		}
	double endTime = System.nanoTime();
	double duration = (endTime - startTime)/1000000;
	System.out.println("The time it took to find " + kVals.length + " values out of a set with " + n  + " length took " + duration + " ms (Binary Search).");
	
	
	
	double startTimeTrin = System.nanoTime();
	for (int k1 : kVals){
		trinarySearch(sortedList, 0, n-1, k1);
		}
	double endTimeTrin = System.nanoTime();
	double durationTrin = (endTimeTrin - startTimeTrin)/1000000;
	System.out.print("The time it took to find " + kVals.length + " values out of a set with " + n + " length took " + durationTrin + " ms. (Trinary Search)");
	}
	
	
	public static int[] recursiveQuickSort(int[] array, int startIdx, int endIdx) {
	     
        int idx = partition(array, startIdx, endIdx);

        // Recursively call quicksort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
        
        return array;
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
	
	public static int binarySearch(int[] array, int first, int last, int target){
		//Returns index of target in A if present
		//Returns -1 if target is not present in A
		if (first > last){
			return -1;
		} else {
			mid = (first + last)/2;
			if (array[mid] == target){
				return mid;
			} else if (array[mid] > target){
				return binarySearch(array, first, mid-1, target);
			} else {
				return binarySearch(array, mid+1, last, target);
			}
		}
		
	
	}
	
	
	public static int trinarySearch(int[] array, int first, int last, int target){
		//Returns index of target in A if present
		//Returns -1 if target is not present in A
		
		/**System.out.println("first Number: " + first);
		System.out.println("last Number: " + last);
		System.out.println("target Number: " +target);
		**/
		
		if (first > last){
			return -1;
		} else {
			oneThird = first + (last-first)/3;
			twoThirds = first + 2*(last-first)/3;
			if (array[oneThird] == target){
				return oneThird;
			} else if (array[oneThird] > target){
				//Search the left-hand third
				return trinarySearch(array, first, oneThird-1, target);
			}else if (array[twoThirds] == target){
				return twoThirds;
			}else if (array[twoThirds] > target){
				//Search the middle third
				return trinarySearch(array, oneThird+1, twoThirds-1, target);
			} else {
				return trinarySearch(array, twoThirds+1, last, target);
			}
		}

	
	}

}
