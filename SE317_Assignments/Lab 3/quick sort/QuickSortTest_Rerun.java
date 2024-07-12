import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest_Rerun{

	@Test
	public void test1() {
		
		int[] x = {4, 2, 6, 1, 3, 7, 5};
		int[] expected = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println("Input array test1: ");
		System.out.println(Arrays.toString(x));
		
		QuickSort.quickSort(x, 0, x.length - 1);
		
		System.out.println("Output array test1: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void test2() {
		
		int[] x = {9, -2, -1, 10, 7, 1, 5, 9, 8};
		int[] expected = {-2, -1, 1, 5, 7, 8, 9, 9, 10};
		
		System.out.println("Input array test2: ");
		System.out.println(Arrays.toString(x));
		
		QuickSort.quickSort(x, 0, x.length - 1);
		
		System.out.println("Output array test2: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
		
	}
}
