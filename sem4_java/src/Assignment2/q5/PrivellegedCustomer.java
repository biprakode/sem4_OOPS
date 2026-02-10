package Assignment2.q5;

public class PrivellegedCustomer extends Customer{
    static double privCreditLimit;

    public PrivellegedCustomer(String customerID, String name, String phone, double creditLim) {
        super(customerID, name, phone, creditLim);
        PrivellegedCustomer.privCreditLimit = creditLim;
    }

    @Override
    public boolean draftLoan(double loanAmt) {
        if((getCurrLoan() + loanAmt) > privCreditLimit) {
            System.out.println("Loan not drafted, credit limit exhausted");
            return false;
        }
        return true;
    }

    public double getSeekableLoan() {
        return privCreditLimit - getCurrLoan();
    }
}
