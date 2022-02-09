package vcs.lt.exam.accounts;

import java.math.BigDecimal;

public class DebitAccount extends Account {


	public DebitAccount(Bank bank, String accNumber) {
		super(accNumber, bank);
	}

	@Override
	public void debit(BigDecimal debit) throws InvalidAccountOperationException {

		
		if(getBalance().compareTo(debit) >= 0) {
			
			super.setBalance(super.getBalance().subtract(debit));
			
		} else throw new InvalidAccountOperationException("Not enough money on debit account Nr." + super.getAccNumber());
		
	}

	@Override
	public void credit(BigDecimal credit) throws InvalidAccountOperationException {
		
		super.setBalance(super.getBalance().add(credit));
		
		
		
		
		
		}
}


