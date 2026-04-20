// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q5 - privileged customer with a higher credit cap

package Assignment2.q5;

public class PrivellegedCustomer extends Customer {
    // separate higher credit limit for privileged customers
    static double privCreditLimit;

    public PrivellegedCustomer(String customerID, String name, String phone, double creditLim) {
        super(customerID, name, phone, creditLim);
        PrivellegedCustomer.privCreditLimit = creditLim;
    }

    @Override
    public boolean draftLoan(double loanAmt) {
        // check against the privileged cap, not the regular one
        if ((getCurrLoan() + loanAmt) > privCreditLimit) {
            System.out.println("Loan not drafted, credit limit exhausted");
            return false;
        }
        return true;
    }

    public double getSeekableLoan() {
        return privCreditLimit - getCurrLoan();
    }
}
