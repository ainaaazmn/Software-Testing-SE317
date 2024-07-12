import java.util.*;

public class QuickSort {
	
	public static void main(String[] args) {
		
		int[] arr = {10, 7, 8, 9, 1, 5};
		
		System.out.println("Unsorted: ");
		System.out.println(Arrays.toString(arr));
		
		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("Sorted: ");
		System.out.println(Arrays.toString(arr));
		 
		
	}
	
	/**
	 * Swap the element at index i and j
	 * 
	 * @param arr to be swapped from
	 * @param i 
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		
	}
	
	/**
	 * Last element of an array is chosen to be a pivot.
	 * This function place the pivot element at its correct position.
	 * 
	 * @param arr to be partitioned
	 * @param low the lowest index being compared
	 * @param high the highest index being compared
	 * @return
	 */
	public static int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high]; //Last element of the array as pivot
		
		int i = low - 1;
		
		for(int j = low; j <= high; j++) {
			
			//If current element is less than pivot
			if(arr[j] < pivot) {
				
				//Increment index of smaller element and swap
				i++;
				swap(arr, i, j);
			}
		}
		
		//Place the pivot at the correct position
		swap(arr, i+1, high);
		
		return i+1; //Return the pivot current index
		
		
	}
	
	/**
	 * Implements quick sort
	 * 
	 * @param arr array to be sorted
	 * @param low starting index
	 * @param high ending index
	 */ 
	public static void quickSort(int[] arr, int low, int high) {
		
		if(low < high) {
			
			int p_index = partition(arr, low, high); // Find the index of the current pivot
			
			quickSort(arr, low, p_index - 1); //Sort elements before the pivot
			quickSort(arr, p_index + 1, high); //Sort elements after the pivot
		}
		
		
	}

}
