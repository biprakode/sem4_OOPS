// Name - Biprarshi Biswas
// Roll No - 002410501094
// BCSE-II A3

// Question:
// Each customer of a bank has customer id, name, current loan amount and phone number.
// One can change attributes like name and phone number. A customer may ask for loan of
// certain amount. It is granted provided the sum of current loan amount and asked amount
// does not exceed credit limit (fixed amount for all customers). A customer can be a
// privileged customer with higher credit limit. Once a loan is sanctioned necessary
// updates should be made. Any type of customer should be able to find his credit limit,
// current loan amount and amount of loan he can seek. No customer can change customer id
// once created. Print customer name when the object is printed by toString() method.
// Design and implement the classes. Show the working through a menu driven user interface.

package Assignment2.q5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        // two different credit caps based on customer type
        double regularCreditLimit = 50000;
        double privCreditLimit = 100000;

        Scanner sc = new Scanner(System.in);
        int choice;
        // keep running the menu until the user chooses 0
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
                    // add a regular customer
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
                    // add a privileged customer with the higher cap
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
                    // try to draft a loan for the chosen customer
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
                    // show the customer's credit situation
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
                    // update name
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.print("New name: ");
                    c.setName(sc.next());
                    System.out.println("Name updated.");
                    break;
                }
                case 6: {
                    // update phone
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.print("New phone: ");
                    c.setPhone(sc.next());
                    System.out.println("Phone updated.");
                    break;
                }
                case 7: {
                    // call toString - should print just the name
                    Customer c = findCustomer(sc);
                    if (c == null) break;
                    System.out.println(c);
                    break;
                }
            }
        } while (choice != 0);
    }

    // tiny helper to look up a customer by ID
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
