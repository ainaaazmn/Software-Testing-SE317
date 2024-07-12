package lab6;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMandUtilityTestSavingAccount {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
    private final String bankAccountType = "2";
    private final String quit = "4";
    
    private final String testingCheckingFile = "testingCheckingAccount.txt";
    private final String testingSavingFile = "testingSavingAccount.txt";

    @Before
    public void setup() {
    
    	initializeTestingFile();
    	
        ATMandUtility.checkingFile = testingCheckingFile;
        ATMandUtility.savingFile = testingSavingFile;
        
        CheckingAccount.file = testingCheckingFile;
        SavingAccount.file = testingSavingFile;
        
        System.setOut(new PrintStream(outContent));
    }
    

	private void initializeTestingFile() {
    	try {	
			PrintWriter initializeChecking = new PrintWriter(testingCheckingFile);	
			initializeChecking.println("Checking Balance = 2000.0");
			initializeChecking.close();	
		    
		    PrintWriter initializeSaving = new PrintWriter(testingSavingFile);
		    initializeSaving.println("Saving Balance = 1000.0");
		    initializeSaving.close();
		}
		
		catch(IOException e) {
			System.out.println("Unable to write");
		}
    }
    

    @After
    public void tearDown() {
        System.setOut(null);
        System.setIn(System.in);
    }
    
    @Test
    public void testBankAccountSavingDeposit() {
 
        String chooseActivity = "1";
        String amountToDeposit = "300";
        
        // Simulating user input
        String input = bankAccountType + "\n" + chooseActivity + "\n" + 
                       amountToDeposit + "\n" + quit + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the method under test
        ATMandUtility.BankAccountActivity();

        // Capture console output
        String consoleOutput = outContent.toString();

        // Assertions
        assertTrue(consoleOutput.contains("Amount to Deposit:"));
        
        String savingBalance = readFile(testingSavingFile);
        assertEquals(savingBalance, "Saving Balance = 1300.0");
  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountSavingDepositExceedsMax() {
    	
    	 SavingAccount account = new SavingAccount(100);
         double amountToDeposit = 15000.0; // This exceeds the MAX_DEPOSIT

         account.deposit(amountToDeposit);
    	
    }
    
    @Test
    public void testBankAccountSavingTransfer() {
    	
    	 String chooseActivity = "2"; 
         String amountToTransfer = "50";
         
         // Simulating user input
         String input = bankAccountType + "\n" + chooseActivity + "\n" + 
        		 amountToTransfer + "\n" + quit + "\n";

         System.setIn(new ByteArrayInputStream(input.getBytes()));

         // Call the method under test
         ATMandUtility.BankAccountActivity();

         // Capture console output
         String consoleOutput = outContent.toString();
         
         // Assertions
         assertTrue(consoleOutput.contains("Amount to transfer to Checking Account: "));     
         
         String savingBalance = readFile(testingSavingFile);   
         assertEquals(savingBalance, "Saving Balance = 950.0");
         
         String checkingBalance = readFile(testingCheckingFile);
         assertEquals(checkingBalance, "Checking Balance = 2050.0");
        
    }
    
    @Test
    public void testBankAccountSavingBalance() {
    	
    	 String chooseActivity = "3"; 
         
         // Simulating user input
         String input = bankAccountType + "\n" + chooseActivity + "\n" + quit + "\n";

         System.setIn(new ByteArrayInputStream(input.getBytes()));

         // Call the method under test
         ATMandUtility.BankAccountActivity();

         // Capture console output
         String consoleOutput = outContent.toString();
         
         // Assertions
         assertTrue(consoleOutput.contains("Balance: $1000"));
         
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountSavingTransferExceedsMax() {
    	
    	 SavingAccount saving = new SavingAccount(1000);
    	 CheckingAccount checking = new CheckingAccount(100);
    	 
         double amountToTransfer = 150.0; 

    	 saving.transferToChecking(checking, amountToTransfer);
    	
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountSavingTransferInsufficientBalance() {
    	
    	 SavingAccount saving = new SavingAccount(20);
    	 CheckingAccount checking = new CheckingAccount(100);
    	 
         double amountToTransfer = 80.0;

    	 saving.transferToChecking(checking, amountToTransfer);
    	
    }
    
    @Test
    public void testBankAccountExitProgram() {
    	
    	String chooseActivity = "4"; 
        
        // Simulating user input
        String inputChecking = bankAccountType + "\n" + chooseActivity + "\n";

        System.setIn(new ByteArrayInputStream(inputChecking.getBytes()));

        // Call the method under test
        ATMandUtility.BankAccountActivity();

        // Capture console output
        String consoleOutput = outContent.toString();
        
        // Assertions
        assertTrue(consoleOutput.contains("Exitting the program. Thank you for using our service!"));
    	
    }
    
    
    private String readFile(String file) {
    	
    	String statement = null;
    	
    	try {
    		
    		Scanner fileIn = new Scanner(new File(file));
    		
    		while(fileIn.hasNext()) {
    			
    			statement = fileIn.nextLine();
    		}
    		
    		fileIn.close();
    	} catch(IOException e) {
			System.out.println("File not found");	
		}
		
    	return statement;
	}
    
}
