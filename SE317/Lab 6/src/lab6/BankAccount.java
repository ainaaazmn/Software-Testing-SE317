package lab6;

public abstract class BankAccount {
	
	protected final int MAX_DEPOSIT = 5000;
	protected final int MIN_BALANCE = 0;

	protected double balance;
	
	public BankAccount(double initialBalance) {
		
		if(initialBalance < MIN_BALANCE) {
			
			throw new IllegalArgumentException("NO OVERDRAFT ALLOWED");
		}
		
		this.balance = initialBalance;
		
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public void checkBalance() {
		
		System.out.println("Balance: $" + balance);
	}
	
	
	protected abstract void deposit(double amountDeposit);

}
