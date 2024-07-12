package original;

public class lastZero {
	
	/**
	 * Find last index of zero
	 * 
	 * @param x array to search
	 * @return last index of 0 in x; -1 if absent
	 * @throws NullPointerException if x is null
	 */
	public static int lastZero(int[] x) {
		
		for(int i = 0; i < x.length; i++) {
			
			if(x[i] == 0) {
				return i;
			}
		}
		return -1;
	}
}
