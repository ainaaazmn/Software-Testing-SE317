import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class QuickSort_FaultyTest_NotReveal {

	@Test
	public void test1() {
		
		int[] x = {10, 7, 8, 9, 1, 120, 5};
		int[] expected = {1, 5, 7, 8, 9, 10, 120};
		
		System.out.println("Input array test1: ");
		System.out.println(Arrays.toString(x));
		
		QuickSort_Faulty.quickSort(x, 0, x.length - 1);
		
		System.out.println("Output array test1: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
	}
	
	@Test
	public void test2() {
		
		int[] x = {1, 3, 5, 7, 9, 11};
		int[] expected = {1, 3, 5, 7, 9, 11};
		
		System.out.println("Input array test2: ");
		System.out.println(Arrays.toString(x));
		
		QuickSort_Faulty.quickSort(x, 0, x.length - 1);
		
		System.out.println("Output array test2: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
		
	}

}
