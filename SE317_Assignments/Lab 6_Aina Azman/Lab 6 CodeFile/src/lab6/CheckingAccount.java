package lab6;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CheckingAccount extends BankAccount {
	
	protected final int MAX_WITHDRAW = 500;
	protected static String file = "CheckingAccount.txt";
	protected static String bill = "Bill.txt";
	
	//Constructor
	public CheckingAccount(double initialBalance) {
		super(initialBalance);
	}
	
	@Override
	protected void deposit(double amountDeposit) {
		
		if(amountDeposit > MAX_DEPOSIT) {
			
			throw new IllegalArgumentException("Deposit limit is $" + MAX_DEPOSIT + "per day");
		}
		
		this.balance += amountDeposit;
		updateCheckingAccountFile();
		
	}
	
	protected void withdraw(double amountWithdraw) {

		if(amountWithdraw > MAX_WITHDRAW || amountWithdraw > this.balance) {
			
			throw new IllegalArgumentException("Transfer limit exceeded or insufficient balance");
		}
	
		this.balance -= amountWithdraw;
		updateCheckingAccountFile();
	}

	protected void transferToSaving(SavingAccount saving, double amountTransfer) {
		
		if(amountTransfer > this.balance) {
			
			throw new IllegalArgumentException("Insuficient balance");
		}
		
		this.balance -= amountTransfer;
		saving.deposit(amountTransfer);
		updateCheckingAccountFile();
			
	}
	
	protected void payBills(double amountPay) {
		
		if(amountPay > this.balance) {
			
			throw new IllegalArgumentException("Insuficient balance");
		}
		
		this.balance -= amountPay;
		updateCheckingAccountFile();
		updateUtilityFile(amountPay);
		
	}
	
	
	private void updateUtilityFile(double amountPay) {
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(bill, true))){
			
			writer.write("Payment of $" + amountPay);
			writer.newLine();
			
		} catch (IOException e) {
			
			System.out.println("An error occurred while writing to the file.");
			e.printStackTrace();
		}
	}
		
	
	protected void updateCheckingAccountFile() {
		
		try {
			
			PrintWriter checkingUpdate = new PrintWriter(file);
			
			checkingUpdate.println("Checking Balance = " + this.balance);
			
			checkingUpdate.close();
		
		}
		
		catch(IOException e) {
			
			System.out.println("Unable to write");
			
		}
	}
	


}
