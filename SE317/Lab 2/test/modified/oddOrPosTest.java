package modified;

import static org.junit.Assert.*;

import org.junit.Test;

public class oddOrPosTest {

	@Test
	public void oddOrPos_Expected() {
	
		oddOrPos count = new oddOrPos();
		
		int[] x = {-3, -2, 0, 1, 4};
		assertEquals(3, count.oddOrPos(x));
	}

}
