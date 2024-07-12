import java.util.*;

public class BubbleSort_Faulty {
	
	public static void main(String[] args) {
		
		int[] unsorted = { 10, 7, 8, -9, -8, 9, 1, 5, 4, 20};
		
		System.out.println("Unsorted array:");
		System.out.println(Arrays.toString(unsorted));
		
		bubbleSort(unsorted);
		
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(unsorted));	
		
	}
	
	
	/**
	 * Implements bubble sort algorithm.
	 * 
	 * Bubble sort: A simple sorting algorithm that repeatedly
	 * steps through the array, compares adjacent elements and swaps
	 * them if they are in the wrong order. 
	 * 
	 * The pass through the array is repeated until the list
	 * is sorted.
	 * 
	 * @param x the array to be sorted
	 */
	 public static void bubbleSort(int[] x) {
		
		//Initialize the number of rounds of sorting
		int round = 1;

		//Loop as many times as the length of the array
		while(round < x.length) {
			
			//Iterate over the array up to the length minus the number of completed rounds
			for(int i = 0; i < x.length - round; i++) {
				
				//Swap if the current element is greater than next element
				if(x[i] > x[i+1]) { 
					
					int temp;	
					temp = x[i];
					
					x[i] = x[i+1];
					x[i+1] = temp;
				}
		
			}
			
			//Increment the round counter
			round += 2; //Faulty
		}	
	}


}
