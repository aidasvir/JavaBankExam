package vcs.lt.exam.accounts;

import java.math.BigDecimal;

public class SavingsAccount extends Account {

	public SavingsAccount(Bank bank, String accNumber) {
		super(accNumber, bank);
		
	}

	@Override
	public void debit(BigDecimal debit) throws InvalidAccountOperationException {
		
		throw new InvalidAccountOperationException("This account Nr. " + super.getAccNumber() +" is for savings. It can not be debited");
	}

	@Override
	public void credit(BigDecimal credit) throws InvalidAccountOperationException {
		
		
		
		
		if (super.getBalance().compareTo(BigDecimal.ZERO) == 0 ) {
			
			super.setBalance(super.getBalance().add(credit));
			
		} else throw new InvalidAccountOperationException("Savings account Nr. " + super.getAccNumber() + " was already credited");
		
		
	}

}
