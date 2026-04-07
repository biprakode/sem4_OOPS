package Assignment2.q4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<BankAcc> accounts = new ArrayList<>();

    public static void main(String[] args) {
        double currentIntRate = 0.2;
        double savingsIntRate = 0.3;

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Savings Account");
            System.out.println("2. Add Current Account");
            System.out.println("3. Check if account exists");
            System.out.println("4. Display all accounts");
            System.out.println("5. Calculate Interest");
            System.out.println("6. Display Overdraft Amount");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Account No: ");
                    accounts.add(new SavingsAcc(sc.next() , savingsIntRate));
                    System.out.println("Savings account added.");
                    break;
                case 2:
                    System.out.print("Account No: ");
                    String accNo = sc.next();
                    System.out.print("Overdraft Limit: ");
                    double limit = sc.nextDouble();
                    accounts.add(new CurrentAcc(accNo, limit , currentIntRate));
                    System.out.println("Current account added.");
                    break;
                case 3:
                    System.out.print("Account No to search: ");
                    String search = sc.next();
                    boolean found = false;
                    for (BankAcc a : accounts) {
                        if (a.getAccNo().equals(search)) {
                            found = true;
                            break;
                        }
                    }
                    System.out.println(found ? "Account exists." : "Account not found.");
                    break;
                case 4:
                    for (BankAcc a : accounts) {
                        String type = (a instanceof CurrentAcc) ? "Current" : "Savings";
                        System.out.println(type + " - " + a.getAccNo());
                    }
                    break;
                case 5:
                    System.out.print("Account No: ");
                    String acc = sc.next();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    for (BankAcc a : accounts) {
                        if (a.getAccNo().equals(acc)) {
                            System.out.println("Interest: " + a.calculateInterest(amt));
                        }
                    }
                    break;
                case 6:
                    System.out.print("Current Account No: ");
                    String cacc = sc.next();
                    System.out.print("Debit Amount: ");
                    double debit = sc.nextDouble();
                    for (BankAcc a : accounts) {
                        if (a.getAccNo().equals(cacc) && a instanceof CurrentAcc) {
                            ((CurrentAcc) a).displayOverdraftAmount(debit);
                        }
                    }
                    break;
            }
        } while (choice != 0);
    }
}