// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Design a BankAcct class with account number, balance and interest rate as attribute.
// Interest rate is same for all account. Support must be there to initialize, change
// and display the interest rate. Also supports are to be there to return balance and
// calculate interest.

package Assignmen1.q7;

import javax.naming.directory.InvalidAttributesException;
import java.util.Date;

public class BankAcct {
    private String accnum;
    private Long balance;
    // single interest rate shared by every account - that's why it's static
    private static float interest;

    BankAcct(String acc, Long b) {
        this.accnum = acc;
        balance = b;
    }

    // grows the balance using months between the two dates times the interest rate
    public Long calculateInterest(Date date1, Date date2) throws InvalidAttributesException {
        if (!date1.before(date2)) {
            throw new InvalidAttributesException("Time error");
        }
        long month = date2.getMonth() - date1.getMonth();
        long year = date2.getYear() - date1.getYear();
        long time = 12 * year + month;
        balance = (long) (balance * time * interest + balance);
        return (balance);
    }

    @Override
    public String toString() {
        return "AccNum = " + accnum + "balance = " + balance + "interest/month = " + interest;
    }

    public static float getInterest() {
        return interest;
    }

    public static void setInterest(float interest) {
        BankAcct.interest = interest;
    }

    public String getAccnum() {
        return accnum;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
