package original;

import static org.junit.Assert.*;

import org.junit.Test;

public class countPositiveTest {

	@Test
	public void countPositive_doesntExecuteFault() {
	
		countPositive countP = new countPositive();
		
		int[] x = null;
		assertThrows(NullPointerException.class, ()-> countP.countPositive(x));
	}
	
	@Test
	public void countPositive_executeFaultNoError() {
		
		countPositive countP = new countPositive();
		
		int[] x = {1, 2, 3, 9, -2, -3};
		assertEquals(4, countP.countPositive(x));
	}
	
	@Test
	public void countPositive_errorNoFailure() {
		
       countPositive countP = new countPositive();
		
		int[] x = {0, 2, 3, 9, -2, -3};
		assertEquals(4, countP.countPositive(x));
		
	}

}
