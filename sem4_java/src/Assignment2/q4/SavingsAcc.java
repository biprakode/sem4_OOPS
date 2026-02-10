package Assignment2.q4;

public class SavingsAcc extends  BankAcc{
    private static double interestRate;

    SavingsAcc(String accNo , double intRate) {
        super(accNo);
        SavingsAcc.interestRate = intRate;
    }

    @Override
    public double calculateInterest(double money) {
        return (money * (1 + interestRate));
    }
}
