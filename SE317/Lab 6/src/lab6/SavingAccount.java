package lab6;

import java.io.IOException;
import java.io.PrintWriter;

public class SavingAccount extends BankAccount {
	
	protected final int MAX_TRANSFER = 100;
	protected static String file = "SavingAccount.txt";

	public SavingAccount(double initialBalance) {
		super(initialBalance);
	}

	@Override
	protected void deposit(double amountDeposit) {
		
		if(amountDeposit > MAX_DEPOSIT) {
			
			throw new IllegalArgumentException("Deposit limit is $" + MAX_DEPOSIT + "per day");
		}
		
		this.balance += amountDeposit;
		updateSavingAccountFile();
		
	}
	
	protected void transferToChecking(CheckingAccount checking, double amountTransfer) {
		
		if(amountTransfer > this.balance || amountTransfer > MAX_TRANSFER) {
			
			throw new IllegalArgumentException("Insuficient balance or excedeed $" + MAX_TRANSFER + " transfer limit");
		}
		
		this.balance -= amountTransfer;
		checking.deposit(amountTransfer);
		updateSavingAccountFile();
			
	}
	
	protected void updateSavingAccountFile() {
		
		try {
			
			PrintWriter savingUpdate = new PrintWriter(file);
			
			savingUpdate.println("Saving Balance = " + this.balance);
			
			savingUpdate.close();
		
		}
		
		catch(IOException e) {
			
			System.out.println("Unable to write");
			
		}
	}
	
	
}
