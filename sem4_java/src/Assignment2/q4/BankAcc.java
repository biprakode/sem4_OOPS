// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q4 - abstract bank account parent

package Assignment2.q4;

public abstract class BankAcc {
    // every account has an account number
    private String accNo;

    BankAcc(String accNo) {
        this.accNo = accNo;
    }

    // subclasses decide how interest is computed
    abstract public double calculateInterest(double money);

    public String getAccNo() {
        return accNo;
    }
}
