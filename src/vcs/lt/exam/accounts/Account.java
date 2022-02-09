package vcs.lt.exam.accounts;

import java.math.BigDecimal;

public abstract class Account {
	private String accNumber;
	private Bank bank;
	private BigDecimal balance;
	
	public Account(String accNumber, Bank bank) {
		this.accNumber = accNumber;
		this.bank = bank;
		this.balance = BigDecimal.ZERO;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public Bank getBank() {
		return bank;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	public abstract void debit (BigDecimal debit) throws InvalidAccountOperationException;
	
	public abstract void credit (BigDecimal credit) throws InvalidAccountOperationException;
	
}
