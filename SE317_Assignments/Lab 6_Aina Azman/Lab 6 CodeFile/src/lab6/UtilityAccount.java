package lab6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UtilityAccount {	
	
	protected static String bill = "Bill.txt";
	
	public static void billPaymentHistory() {
		
		try {
			
			Scanner fileBill = new Scanner(new File(bill));
			
			while(fileBill.hasNext()) {
				
				String lineIn = fileBill.nextLine();
				System.out.println(lineIn);			
					
				}	
			
			fileBill.close();
				
			} catch(IOException e) {
			System.out.println("File not found");	
		}
	}
}
