package lab6;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMandUtilityTestUtilityAccount {

	    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
	    private final String testingBill = "testingBill.txt";
	    
	    @Before
	    public void setup() {
	    
	   
	    	initializeBill();
	        CheckingAccount.bill = testingBill;
	        UtilityAccount.bill = testingBill;
	        
	        System.setOut(new PrintStream(outContent));
	    }

	    private void initializeBill() {
	   	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(testingBill))) {
	            writer.write("September Bill, $36.00");
	            writer.newLine();
	            writer.write("Payment of $36.00");
	            writer.newLine();
	            
	            writer.write("October Bill, $37.00");
	            writer.newLine();
	            writer.write("Payment of $37.00");
	            writer.newLine();
	            
	            writer.write("November Bill, $38.00");
	            writer.newLine();
	            writer.write("Payment of $38.00");
	            writer.newLine();
	            
	            writer.write("December Bill, $40.00");
	            writer.newLine();
	          
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
	    
	    @After
	    public void tearDown() {
	        System.setOut(null);
	        System.setIn(System.in);
	    }

	    
	    @Test
	    public void testUtilityAccountPaymentHistory() {
	    	
	    	UtilityAccount.billPaymentHistory();
	    	
	    	String consoleOutput = outContent.toString();
	    	
	    	assertTrue(consoleOutput.contains("September Bill, $36.00"));
	     	assertTrue(consoleOutput.contains("Payment of $36.00"));

	    	assertTrue(consoleOutput.contains("October Bill, $37.00"));
	     	assertTrue(consoleOutput.contains("Payment of $37.00"));
	     	
	     	assertTrue(consoleOutput.contains("November Bill, $38.00"));
	     	assertTrue(consoleOutput.contains("Payment of $38.00"));
	     	
	    	assertTrue(consoleOutput.contains("December Bill, $40.00"));
	    }
	    
	   
}
