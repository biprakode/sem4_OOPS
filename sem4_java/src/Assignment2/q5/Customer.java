package Assignment2.q5;

public abstract class Customer {
    private String customerID;
    private String name;
    private double currLoan;
    private String phone;
    static double creditLimit;


    public Customer(String customerID, String name, String phone , double creditLim) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.currLoan = 0;
        Customer.creditLimit = creditLim;
    }

    @Override
    public String toString() {
        return "Name:- %s".formatted(name);
    }

    public static double getCreditLimit() {
        return creditLimit;
    }

    public boolean draftLoan(double loanAmt) {
        if((currLoan + loanAmt) > creditLimit) {
            System.out.println("Loan not drafted, credit limit exhausted = " + creditLimit);
            return false;
        }
        return true;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public double getCurrLoan() {
        return currLoan;
    }

    public void setCurrLoan(double currLoan) {
        this.currLoan = currLoan;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSeekableLoan() {
        return creditLimit - currLoan;
    }
}
