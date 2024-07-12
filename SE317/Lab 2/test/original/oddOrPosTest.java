package original;

import static org.junit.Assert.*;

import org.junit.Test;

public class oddOrPosTest {

	@Test
	public void oddOrPos_doesntExecuteFault() {
		
		oddOrPos count = new oddOrPos();
		
		int[] x = null;
		assertThrows(NullPointerException.class, ()-> count.oddOrPos(x));
		
	}
	
	@Test
	public void oddOrPos_executeFaultNoError() {
		
		oddOrPos count = new oddOrPos();
		
		int[] x = {1, 2, 3, -2, 5};
		assertEquals(4, count.oddOrPos(x));
		
	}
	
	@Test
	public void oddOrPos_errorNoFailure() {
		
		oddOrPos count = new oddOrPos();
		
		int[] x =  {1, 2, 3, -3, 5, -7};
		assertEquals(4, count.oddOrPos(x));
	}

}
