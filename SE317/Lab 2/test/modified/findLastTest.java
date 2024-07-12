package modified;

import static org.junit.Assert.*;
import org.junit.Test;
import modified.findLast;

public class findLastTest {

	@Test
	public void findLast_Expected() {
		
		findLast finder = new findLast();
		
		int[] x = {2, 3, 5};
		int y = 2;
		
		assertEquals(0, finder.findLast(x, y));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void test_notPresent() {
		
		findLast finder = new findLast();
		
		int[] x = {7, 2, 3, 4, 4};
		int y = 8;
		
		assertEquals(-1, finder.findLast(x, y));
	}
	
	@Test
	public void test_elementAtLastPosition() {
		
		findLast finder = new findLast();
		
		int[] x = {7, 2, 3, 4, 4};
		int y = 4;
		
		assertEquals(4, finder.findLast(x, y));
	}
	
	@Test
	public void test_singleElement() {
	
		findLast finder = new findLast();
		
		int[] x = {10};
		int y = 10;
		
		assertEquals(0, finder.findLast(x, y));
		
	}
	
	@Test
	public void test_nullArray(){
		
		findLast finder = new findLast();
		
		int[] x = null;
		int y = 10;
		
		assertThrows(NullPointerException.class,() -> finder.findLast(x, y));
	}*/

}
