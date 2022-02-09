package vcs.lt.exam.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import vcs.lt.exam.accounts.Account;
import vcs.lt.exam.accounts.Bank;
import vcs.lt.exam.accounts.CreditAccount;
import vcs.lt.exam.accounts.DataProvider;
import vcs.lt.exam.accounts.DebitAccount;
import vcs.lt.exam.accounts.InvalidAccountOperationException;
import vcs.lt.exam.accounts.SavingsAccount;
//import vcs.lt.exam.accounts.CreditAccount;
//import vcs.lt.exam.accounts.DataProvider;
//import vcs.lt.exam.accounts.DebitAccount;
//import vcs.lt.exam.accounts.InvalidAccountOperationException;
//import vcs.lt.exam.accounts.SavingsAccount;
//
class BankTest {
//
    Account acc;
    Bank bank = new Bank("LT", "CBVILT2XXXX70440", "SEB bankas", "Gedimino Ave. 12, LT-01103 Vilnius");
//
//
//    // Test the correct string of a bank. To extract country name from Locale,
//    // use method locale.getDisplayCountry().
    @Test
    void testToString() {

        String str = bank.toString();
        assertTrue("Bank#70440, Lithuania, SEB bankas, Gedimino Ave. 12, LT-01103 Vilnius" .equals(str));
    }
//
//    // Test DEBIT account - You can add money (credit) to this account with no
//    // limitations; You can spend money (debit) from this account only if there
//    // is enough money (more than zero)
//
    @Test
    void testDebitAccount() throws InvalidAccountOperationException {
        acc = new DebitAccount(bank, "LT704400010077211111");
        assertTrue(acc.getBalance().compareTo(BigDecimal.ZERO) == 0);
        acc.credit(BigDecimal.TEN);
        assertTrue(acc.getBalance().compareTo(BigDecimal.TEN) == 0);

        acc.debit(new BigDecimal(7.5));
        assertTrue(acc.getBalance().compareTo(new BigDecimal(2.50)) == 0);

        try {
            acc.debit(new BigDecimal(5.80));
            fail();
        } catch (InvalidAccountOperationException e) {
            assertEquals(
                    "Not enough money on debit account Nr.LT704400010077211111",
                    e.getMessage());
            assertTrue(acc.getBalance().compareTo(new BigDecimal(2.50)) == 0);
        }

    }
//
//    // Test CREDIT account - You can add money (credit) to this account, only
//    // when it is empty (the balance is zero or less); You can spend money
//    // (debit) from this account with no limitations
    @Test
    void testCreditAccount() throws InvalidAccountOperationException {
        acc = new CreditAccount(bank, "LT40100825251211567");
        assertTrue(acc.getBalance().compareTo(BigDecimal.ZERO) == 0);
        acc.debit(new BigDecimal(7.5));
        assertTrue(acc.getBalance().compareTo(new BigDecimal(-7.50)) == 0);
        acc.credit(BigDecimal.TEN);
        assertTrue(acc.getBalance().compareTo(new BigDecimal(2.50)) == 0);
        try {
            acc.credit(new BigDecimal(7.50));
            fail();
        } catch (InvalidAccountOperationException e) {
            assertEquals(
                    "Credit account Nr.LT40100825251211567 is not empty yet",
                    e.getMessage());
            assertTrue(acc.getBalance().compareTo(new BigDecimal(2.50)) == 0);
        }

    }
//
//    // Test SAVINGS account - You can add money (credit) to this account only
//    // once; You can not spend money (debit) from this account
    @Test
    void testSavingsAccount() throws InvalidAccountOperationException {
        acc = new SavingsAccount(bank, "LT72300452155259555");
        assertTrue(acc.getBalance().compareTo(BigDecimal.ZERO) == 0);
        acc.credit(BigDecimal.TEN);
        assertTrue(acc.getBalance().compareTo(BigDecimal.TEN) == 0);
        try {
            acc.credit(BigDecimal.ONE);
            fail();
        } catch (InvalidAccountOperationException ex) {
            assertEquals(
                    "Savings account Nr. LT72300452155259555 was already credited",
                    ex.getMessage());
            assertTrue(acc.getBalance().compareTo(BigDecimal.TEN) == 0);
        }

        try {
            acc.debit(BigDecimal.ONE);
            fail();
        } catch (InvalidAccountOperationException e) {
            assertEquals(
                    "This account Nr. LT72300452155259555 is for savings. It can not be debited",
                    e.getMessage());
            assertTrue(acc.getBalance().compareTo(BigDecimal.TEN) == 0);
        }

    }
//
//
//  //ADDITIONAL EXTRA TASK	
//  //Test reading from file (the one in vcs.exam.lt.files package)
//   
    @Test
    void testReadingFromFile() {
        DataProvider prvd = new DataProvider();
        HashMap<String, Bank> banks = prvd.getBanks();
        Bank last = banks.get("LT72300");
        assertTrue(banks.size() == 6);
        assertEquals(last.toString(),
                "Bank#72300, Lithuania, UAB Medicinos bankas, Pamenkalnio Str. 40, LT-01114 Vilnius");

    }
//
//
//
}
