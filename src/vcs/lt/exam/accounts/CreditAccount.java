package vcs.lt.exam.accounts;

import java.math.BigDecimal;

public class CreditAccount extends Account {

	
	public CreditAccount(Bank bank, String accNumber) {
		super(accNumber, bank);
		
	}
	
	@Override
	public void debit(BigDecimal debit) throws InvalidAccountOperationException {
		
		super.setBalance(super.getBalance().subtract(debit));

	}

	@Override
	public void credit(BigDecimal credit) throws InvalidAccountOperationException {
	
		if(super.getBalance().compareTo(new BigDecimal(0.00)) <= 0) {
			
			super.setBalance(super.getBalance().add(credit));
			
		} else throw new InvalidAccountOperationException("Credit account Nr." + super.getAccNumber() + " is not empty yet");
		

	}

}
