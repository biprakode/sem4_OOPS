// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q4 - savings account flavor

package Assignment2.q4;

public class SavingsAcc extends BankAcc {
    // shared rate for all savings accounts
    private static double interestRate;

    SavingsAcc(String accNo, double intRate) {
        super(accNo);
        SavingsAcc.interestRate = intRate;
    }

    @Override
    public double calculateInterest(double money) {
        // simple interest = principal * (1 + rate)
        return (money * (1 + interestRate));
    }
}
