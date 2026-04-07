package Assignment2.q5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        double regularCreditLimit = 50000;
        double privCreditLimit = 100000;

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add Regular Customer");
            System.out.println("2. Add Privileged Customer");
            System.out.println("3. Request Loan");
            System.out.println("4. View Customer Info");
            System.out.println("5. Change Name");
            System.out.println("6. Change Phone");
            System.out.println("7. Print Customer (toString)");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("ID: ");
                    String id = sc.next();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();
                    customers.add(new RegularCustomer(id, name, phone, regularCreditLimit));
                    System.out.println("Regular customer added.");
                    break;
                }
                case 2: {
                    System.out.print("ID: ");
                    String id = sc.next();
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Phone: ");
                    String phone = sc.next();
                    customers.add(new PrivellegedCustomer(id, name, phone, privCreditLimit));
                    System.out.println("Privileged customer added.");
                    break;
                }
                case 3: {
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.print("Loan amount: ");
                    double amt = sc.nextDouble();
                    if (c.draftLoan(amt)) {
                        c.setCurrLoan(c.getCurrLoan() + amt);
                        System.out.println("Loan sanctioned. Current loan: " + c.getCurrLoan());
                    }
                    break;
                }
                case 4: {
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    String type = (c instanceof PrivellegedCustomer) ? "Privileged" : "Regular";
                    System.out.println("Type: " + type);
                    System.out.println("Credit Limit: " + (c instanceof PrivellegedCustomer ? PrivellegedCustomer.privCreditLimit : Customer.creditLimit));
                    System.out.println("Current Loan: " + c.getCurrLoan());
                    System.out.println("Seekable Loan: " + c.getSeekableLoan());
                    break;
                }
                case 5: {
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.print("New name: ");
                    c.setName(sc.next());
                    System.out.println("Name updated.");
                    break;
                }
                case 6: {
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.print("New phone: ");
                    c.setPhone(sc.next());
                    System.out.println("Phone updated.");
                    break;
                }
                case 7: {
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.println(c);
                    break;
                }
            }
        } while (choice != 0);
    }

    static Customer findCustomer(Scanner sc) {
        System.out.print("Customer ID: ");
        String id = sc.next();
        for (Customer c : customers) {
            if (c.getCustomerID().equals(id)) return c;
        }
        System.out.println("Customer not found.");
        return null;
    }
}