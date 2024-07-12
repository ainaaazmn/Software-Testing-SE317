 package lab6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ATMandUtilityTestLogin {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setup() {
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void tearDown() {
		System.setOut(null);
		System.setIn(System.in);
	}
	
	@Test
	public void testBankAccountLoginSuccesful() {
		
		String username = "se317user";
		String password = "summer2024";
		
		String input = username + "\n" + password + "\n";
		
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		try {
			
			ATMandUtility.BankAccountLogin();
			String output = outContent.toString();
			
			assertTrue(output.contains("Succesfully login into your Bank Account!"));
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		
		}
	}
	
	@Test
	public void testBankAccountWrongCredentials() {
		
		String username = "se317student";
		String password = "summer2024";
		
		String input = username + "\n" + password + "\n";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		try {
			
			ATMandUtility.BankAccountLogin();
			
			fail("Expected an IllegalArgumentException to be thrown");
			
		}
		
		catch(IllegalArgumentException e) {
				
			assertEquals("Incorrect username or password.", e.getMessage());
		}
	}
	
	
	@Test
	public void testUtilityAccountLoginSuccesful() {
		
		String username = "SE317User";
		String password = "summer2024";
		
		String input = username + "\n" + password + "\n";
		
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		try {
			
			ATMandUtility.UtilityCompanyLogin();
			String output = outContent.toString();
			
			assertTrue(output.contains("Succesfully login into your Utility Account!"));
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUtilityAccountWrongCredentials() {
		
		String username = "se317student";
		String password = "summer2024";
		
		String input = username + "\n" + password + "\n";
		
		System.setIn(new ByteArrayInputStream(input.getBytes()));
		
		try {
			
			ATMandUtility.UtilityCompanyLogin();
			
			fail("Expected an IllegalArgumentException to be thrown");
			
		}
		
		catch(IllegalArgumentException e) {
				
			assertEquals("Incorrect username or password.", e.getMessage());
		}
	}

}

