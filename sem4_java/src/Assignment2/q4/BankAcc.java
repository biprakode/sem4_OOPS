package Assignment2.q4;

public abstract class BankAcc {
    private String accNo;

    protected BankAcc(String accNo) {
        this.accNo = accNo;
    }

    abstract public double calculateInterest(double money);

    public String getAccNo() {
        return accNo;
    }
}
