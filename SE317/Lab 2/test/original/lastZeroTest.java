package original;

import static org.junit.Assert.*;

import org.junit.Test;

public class lastZeroTest {

	@Test
	public void lastZero_doesntExecuteFault() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = null;
		assertThrows(NullPointerException.class, ()-> findLastZero.lastZero(x));
	}
	
	@Test
	public void lastZero_executeFaultNoError() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = {1, 2, 4, 5, 0};
		assertEquals(4, findLastZero.lastZero(x));
		
	}
	
	@Test
	public void lastZero_errorNoFailure() {
		
		lastZero findLastZero = new lastZero();
		
		int[] x = {0, 2, 4, 5, 0};
		assertEquals(0, findLastZero.lastZero(x));
		
	}

}
