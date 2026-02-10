package Assignment2.q4;

public class CurrentAcc extends BankAcc{
    private static double interestRate;
    private double overDraftLimit;

    protected CurrentAcc(String accNo, double overDraftLimit , double intRate) {
        super(accNo);
        this.overDraftLimit = overDraftLimit;
        CurrentAcc.interestRate = intRate;
    }

    public static void setInterestRate(double interestRate) {
        CurrentAcc.interestRate = interestRate;
    }

    public void displayOverdraftAmount(double debit) {
        if(debit > overDraftLimit) {
            throw new OverdraftLimitException("Overdraft limit breached");
        }
        this.overDraftLimit = this.overDraftLimit - debit;
        System.out.printf("Overdrafted limit left:- %s%n", overDraftLimit);
    }

    public double getOverDraftLimit() {
        return overDraftLimit;
    }

    public void setOverDraftLimit(double overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public double calculateInterest(double money) {
        return money * (1 + interestRate);
    }
}
