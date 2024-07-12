package modified;

public class oddOrPos {
	
	
	/**
	 * Count odd or positive elements
	 * 
	 * @param x array to search
	 * @return count of odd/positive values in x
	 * @throws NullPointerException if x is null
	 */
	public static int oddOrPos(int[] x) {
		
		int count = 0;
		for(int i = 0; i < x.length; i++) {
			
			if(Math.abs(x[i]%2) == 1 || x[i] > 0) {
				count++;
			}
		}
		
		return count;
		
	}

}
