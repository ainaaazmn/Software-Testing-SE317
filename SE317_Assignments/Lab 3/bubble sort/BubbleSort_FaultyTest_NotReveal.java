
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class BubbleSort_FaultyTest_NotReveal {

	@Test
	public void test1() {
		
		int[] x = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println("Input array test1: ");
		System.out.println(Arrays.toString(x));
		
		BubbleSort_Faulty.bubbleSort(x);
		
		System.out.println("Output array test1: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
		
	}
	
	@Test
	public void test2() {
		
		int[] x = {2, 1, 4, 3, 5, 6, 7, 8};
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println("Input array test2: ");
		System.out.println(Arrays.toString(x));
		
		BubbleSort_Faulty.bubbleSort(x);
		
		System.out.println("Output array test2: ");
		System.out.println(Arrays.toString(x));
		assertArrayEquals(expected, x);
	
	}

}
