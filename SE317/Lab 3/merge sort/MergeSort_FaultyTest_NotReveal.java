import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort_FaultyTest_NotReveal {

	@Test
	public void test1() {
		
		int[] x = {2, 4, 6, 8, 10, 12, 14, 16, 90};

		int[] expected = {2, 4, 6, 8, 10, 12, 14, 16, 90};
		
		System.out.println("Input array test1: ");
		System.out.println(Arrays.toString(x));
			
		MergeSort_Faulty.mergeSort(x, 0, x.length - 1);
		
		System.out.println("Output array test1: ");
		System.out.println(Arrays.toString(x));
		
		assertArrayEquals(expected, x);
	}
	
	
	@Test
	public void test2() {
		
		int[] x = {3, 4, 4, 1, 5, 9, 10};

		int[] expected = {1, 3, 4, 4, 5, 9, 10};
		
		System.out.println("Input array test2: ");
		System.out.println(Arrays.toString(x));
			
		MergeSort_Faulty.mergeSort(x, 0, x.length - 1);
		
		System.out.println("Output array test2: ");
		System.out.println(Arrays.toString(x));
		
		assertArrayEquals(expected, x);
	}


}
