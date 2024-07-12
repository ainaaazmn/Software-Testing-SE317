package modified;

import static org.junit.Assert.*;

import org.junit.Test;

public class countPositiveTest {

	@Test
	public void countPositive_Expected() {
		
		countPositive countP = new countPositive();
		
		int[] x = {-4, 2, 0, 2};
		assertEquals(2, countP.countPositive(x));
	}


}
