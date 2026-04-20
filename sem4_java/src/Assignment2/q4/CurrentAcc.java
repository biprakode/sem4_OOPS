// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Supporting class for q4 - current account with overdraft

package Assignment2.q4;

public class CurrentAcc extends BankAcc {
    // shared rate across every current account
    private static double interestRate;
    private double overDraftLimit;

    CurrentAcc(String accNo, double overDraftLimit, double intRate) {
        super(accNo);
        this.overDraftLimit = overDraftLimit;
        CurrentAcc.interestRate = intRate;
    }

    public static void setInterestRate(double interestRate) {
        CurrentAcc.interestRate = interestRate;
    }

    // reduces the remaining overdraft - blows up if you cross the limit
    public void displayOverdraftAmount(double debit) {
        if (debit > overDraftLimit) {
            throw new OverdraftLimitException("Overdraft limit breached");
        }
        this.overDraftLimit = this.overDraftLimit - debit;
        System.out.printf("Overdrafted limit left:- %s%n", overDraftLimit);
    }

    public double getOverDraftLimit() { return overDraftLimit; }
    public void setOverDraftLimit(double overDraftLimit) { this.overDraftLimit = overDraftLimit; }

    @Override
    public double calculateInterest(double money) {
        // same formula, different rate
        return money * (1 + interestRate);
    }
}
