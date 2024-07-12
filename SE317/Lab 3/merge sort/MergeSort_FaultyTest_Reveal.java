import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class MergeSort_FaultyTest_Reveal {

	@Test
	public void test1() {
		
		int[] x = {10, 7, 8, 9, 1, 5, 2};

		int[] expected = {1, 2, 5, 7, 8, 9, 10};
		
		System.out.println("Input array test1: ");
		System.out.println(Arrays.toString(x));
			
		MergeSort_Faulty.mergeSort(x, 0, x.length - 1);
		
		System.out.println("Output array test1: ");
		System.out.println(Arrays.toString(x));
		
		assertArrayEquals(expected, x);
	}
	
	
	@Test
	public void test2() {
		
		int[] x = {12, 11, 13, 5, 6, 7, 1};

		int[] expected =  {1, 5, 6, 7, 11, 12, 13};
		
		System.out.println("Input array test2: ");
		System.out.println(Arrays.toString(x));
			
		MergeSort_Faulty.mergeSort(x, 0, x.length - 1);
		
		System.out.println("Output array test2: ");
		System.out.println(Arrays.toString(x));
		
		assertArrayEquals(expected, x);
	}


}