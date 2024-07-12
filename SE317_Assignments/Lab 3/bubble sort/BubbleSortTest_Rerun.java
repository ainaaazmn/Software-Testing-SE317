import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class BubbleSortTest_Rerun {

	@Test
	public void test1() {
		
		int[] x = {8, 7, 6, 5, 4, 3, 2, 1};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println("Input array test1: ");
		System.out.println(Arrays.toString(x));
		
		BubbleSort.bubbleSort(x);

		System.out.println("Output array test1: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
		
	}
	
	@Test
	public void test2() {
		
		int[] x = {5, 1, 8, 3, 7, 2, 6, 4};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println("Input array test2: ");
		System.out.println(Arrays.toString(x));
		
		BubbleSort.bubbleSort(x);

		System.out.println("Output array test2: ");
		System.out.println(Arrays.toString(x));
		
		assertArrayEquals(expected, x);
		
	}

}
