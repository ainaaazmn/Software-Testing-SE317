import java.util.Arrays;

public class MergeSort_Faulty{
	
	public static void main(String args[]) {
		
	 int[] arr = {10, 7, 8, 9, 1, 5};
		
		System.out.println("Unsorted: ");
		System.out.println(Arrays.toString(arr));
		
		mergeSort(arr, 0, arr.length - 1);
		
		System.out.println("Sorted: ");
		System.out.println(Arrays.toString(arr));
		
	}
	
	/**
	 * Sorts an array using the merge sort algorithm
	 * 
	 * @param arr the array to be sorted
	 * @param left the starting index of the sub-array to be sorted
	 * @param right the ending index of the sub-array to be sorted
	 */
	public static void mergeSort(int[] arr, int left, int right) {
		
		if(left < right) {
			
			int mid = (left + right)/2;
			
			mergeSort(arr, left, mid); //Sort first half
			mergeSort(arr, mid+1, right); //Sort second half
				
			//Merge the sorted halves
			merge(arr, left, mid + 1, right); //Faulty
			
		}
	}
	
	/**
	 * Merges two sub-arrays of arr[].
	 * 
	 * @param arr the array to be merged
	 * @param left the starting index of the first sub-array
	 * @param mid the ending of index of the first sub-array
	 * @param right the ending index of the second sub-array
	 */
	public static void merge(int[] arr, int left, int mid, int right) {
		
		//Find the sizes of the two sub-arrays to be merged
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		//Create temp arrays
		int[] left_arr = new int[n1];
		int[] right_arr = new int[n2];
		
		//Copy data to temp arrays
		for(int i = 0; i < n1; i++) {
			
			left_arr[i] = arr[left + i];
		}
		
		for(int j = 0; j < n2; j++) {
			
			right_arr[j] = arr[mid + j + 1];
			
		}
		
		//Merge the temp arrays
		int i = 0, j = 0; //Initial indexes of first and second sub-array
		
		int k = left;
		
		while(i < n1 && j < n2) {
			
			if(left_arr[i] <= right_arr[j]) {
				
				arr[k] = left_arr[i];
				i++;
			}
			
			else {
				
				arr[k] = right_arr[j];
				j++;
			}
			
			k++;
		}
		
		//Copy remaining of left_arr[] if any
		while(i < n1) {
			
			arr[k] = left_arr[i];
			i++;
			k++;
		}
		
		//Copy remaining of right_arr[] if any
		while(j < n2) {
			
			arr[k] = right_arr[j];
			j++;
			k++;
		}
	}
	

}
