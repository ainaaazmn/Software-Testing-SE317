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
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ATMandUtilityTestCheckingAccount {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private final String bankAccountType = "1";
    private final String quit = "7";
    
    private final String testingCheckingFile = "testingCheckingAccount.txt";
    private final String testingSavingFile = "testingSavingAccount.txt";
    private final String testingBill = "testingBill.txt";
    
    @Before
    public void setup() {
    
    	initializeTestingFile();
    	initializeBill();
    	
        ATMandUtility.checkingFile = testingCheckingFile;
        ATMandUtility.savingFile = testingSavingFile;
        
        CheckingAccount.file = testingCheckingFile;
        SavingAccount.file = testingSavingFile;
        CheckingAccount.bill = testingBill;
        
        System.setOut(new PrintStream(outContent));
    }
    
    private void initializeTestingFile() {
    	try {	
			PrintWriter initializeChecking = new PrintWriter(testingCheckingFile);	
			initializeChecking.println("Checking Balance = 1000.0");
			initializeChecking.close();	
		    
		    PrintWriter initializeSaving = new PrintWriter(testingSavingFile);
		    initializeSaving.println("Saving Balance = 800.0");
		    initializeSaving.close();
		}
		
		catch(IOException e) {
			System.out.println("Unable to write");
		}
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
    public void testBankAccountCheckingDeposit() {
 
        String chooseActivity = "1";
        String amountToDeposit = "100";
        
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
        
        String checkingBalance = readFile(testingCheckingFile);
        assertEquals(checkingBalance, "Checking Balance = 1100.0");
  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountCheckingDepositExceedsMax() {
    	
    	 CheckingAccount account = new CheckingAccount(100);
         double amountToDeposit = 15000.0; // This exceeds the MAX_DEPOSIT

         account.deposit(amountToDeposit);
    	
    }
    
    @Test
    public void testBankAccountCheckingWithdraw() {
 
        String chooseActivity = "2";
        String amountToWithdraw = "100";
        
        // Simulating user input
        String input = bankAccountType + "\n" + chooseActivity + "\n" + 
        		amountToWithdraw + "\n" + quit + "\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Call the method under test
        ATMandUtility.BankAccountActivity();

        // Capture console output
        String consoleOutput = outContent.toString();
        
        // Assertions
        assertTrue(consoleOutput.contains("Amount to Withdraw:"));
        

        String checkingBalance = readFile(testingCheckingFile);
        assertEquals(checkingBalance, "Checking Balance = 900.0");
  
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountCheckingWithdrawExceedsMax() {
    	
    	 CheckingAccount account = new CheckingAccount(1000);
         double amountToWithdraw = 1000.0; 

         account.withdraw(amountToWithdraw);
    	
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountCheckingWithdrawInsufficientBalance() {
    	
    	 CheckingAccount account = new CheckingAccount(1000);
         double amountToWithdraw = 1500.0; 

         account.withdraw(amountToWithdraw);
    	
    }
    
    @Test
    public void testBankAccountCheckingTransfer() {
    	
    	 String chooseActivity = "3"; 
         String amountToTransfer = "200";
         
         // Simulating user input
         String inputChecking = bankAccountType + "\n" + chooseActivity + "\n" + 
        		 amountToTransfer + "\n" + quit + "\n";

         System.setIn(new ByteArrayInputStream(inputChecking.getBytes()));

         // Call the method under test
         ATMandUtility.BankAccountActivity();

         // Capture console output
         String consoleOutput = outContent.toString();
         
         // Assertions
         assertTrue(consoleOutput.contains("Amount to transfer to Saving Account: "));
         
         String checkingBalance = readFile(testingCheckingFile);
         assertEquals(checkingBalance, "Checking Balance = 800.0");
     
         
         String savingBalance = readFile(testingSavingFile);   
         assertEquals(savingBalance, "Saving Balance = 1000.0");
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountCheckingTransferInsufficientBalance() {
    	
    	 CheckingAccount checking = new CheckingAccount(1000);
    	 SavingAccount saving = new SavingAccount(1000);
    	 
         double amountToTransfer = 1500.0; 

         checking.transferToSaving(saving, amountToTransfer);
    	
    }
    
    @Test
    public void testBankAccountCheckingPayBills() {
    	
     	 String chooseActivity = "4"; 
         String amountToPay = "40";
         
         // Simulating user input
         String inputChecking = bankAccountType + "\n" + chooseActivity + "\n" + 
        		 amountToPay + "\n" + quit + "\n";

         System.setIn(new ByteArrayInputStream(inputChecking.getBytes()));

         // Call the method under test
         ATMandUtility.BankAccountActivity();

         // Capture console output
         String consoleOutput = outContent.toString();
         
         // Assertions
         assertTrue(consoleOutput.contains("Amount to Pay: "));
         
         String checkingBalance = readFile(testingCheckingFile);
         assertEquals(checkingBalance, "Checking Balance = 960.0");
     
         
         ArrayList<String> bill =  readBill();
         String lastBill = bill.get(bill.size() - 1);
         assertEquals(lastBill, "Payment of $40.0");
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountCheckingPayBillsInsufficientBalance() {
    	
    	 CheckingAccount account = new CheckingAccount(20);
         double amountToPay = 50.0; 

         account.payBills(amountToPay);
    	
    }
    
    @Test
    public void testBankAccountCheckingBalance() {
    	
    	 String chooseActivity = "5"; 
         
         // Simulating user input
         String inputChecking = bankAccountType + "\n" + chooseActivity + "\n" + quit + "\n";

         System.setIn(new ByteArrayInputStream(inputChecking.getBytes()));

         // Call the method under test
         ATMandUtility.BankAccountActivity();

         // Capture console output
         String consoleOutput = outContent.toString();
         
         // Assertions
         assertTrue(consoleOutput.contains("Balance: $1000"));
         
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testBankAccountCheckingOverdraft() {
    	
    	 CheckingAccount account = new CheckingAccount(-20);
    	
    }
    
    @Test
    public void testBankAccountExitProgram() {
    	
    	String chooseActivity = "7"; 
        
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
    
    private ArrayList<String> readBill() {
    	
    	ArrayList<String> statements = new ArrayList<String>();
    	
    	try {
    		
    		Scanner billIn = new Scanner(new File(testingBill));
    		
    		while(billIn.hasNext()) {
    			
    			statements.add(billIn.nextLine());
    		}
    		
    		billIn.close();
    	}catch(IOException e) {
    		
    		e.printStackTrace();
    	}
    	
    	return statements;
    	
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

