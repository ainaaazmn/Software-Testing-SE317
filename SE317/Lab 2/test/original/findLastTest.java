package original;

import static org.junit.Assert.*;
import org.junit.Test;
import original.findLast;

public class findLastTest {
	
	@Test
	public void test_doesntExecuteFault() {

		findLast finder = new findLast();
		
		int[] x = null;
		int y = 1;
		assertThrows(NullPointerException.class, () -> finder.findLast(x, y));
	}
	
	@Test
	public void test_executeFaultNoError() {
		
		findLast finder = new findLast();
		
		int[] x = {1, 2, 3, 2, 4};
		
		int y = 2;
		
		assertEquals(3, finder.findLast(x, y));	
		
	}
	
	@Test
	public void test_errorNoFailure() {
		
		findLast finder = new findLast();
		
		int[] x = {4, 2, 3, 4, 4};
		int y = 4;
		
		assertEquals(4, finder.findLast(x, y));
		
		
	}

}
