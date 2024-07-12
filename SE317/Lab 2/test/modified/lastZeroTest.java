package modified;

import static org.junit.Assert.*;

import org.junit.Test;

public class lastZeroTest {

	@Test
	public void lastZero_Expected() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = {0, 1, 0};
		assertEquals(2, findLastZero.lastZero(x));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test
	public void test_singleElementZero() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = {0};
		assertEquals(0, findLastZero.lastZero(x));
	}
	
	@Test
	public void test_singleElementNonZero() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = {10};
		assertEquals(-1, findLastZero.lastZero(x));
	}
	
	
	@Test
	public void test_ZeroNotPresent() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = {10, 9, 7, 65, 3, 2};
		assertEquals(-1, findLastZero.lastZero(x));
		
	}
	
	@Test
	public void test_nullArray() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = null;
		assertThrows(NullPointerException.class,() -> findLastZero.lastZero(x));
	}*/

}
