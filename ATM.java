import java.util.InputMismatchException;

import java.util.Scanner;



public class ATM {

    private static double atmBalance = 1000000; // Initial ATM balance

    private static double userBalance = 100000; // Initial user account balance



    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            int choice;

            

            do {

                System.out.println("ATM Menu:");

                System.out.println("1. Withdraw Money");

                System.out.println("2. Deposit Money");

                System.out.println("3. Exit");

                System.out.print("Enter your choice: ");

                try {

                    choice = scanner.nextInt();

                } catch (InputMismatchException e) {

                    System.out.println("Invalid input. Please enter a number.");

                    scanner.next(); // Clear the invalid input

                    continue;

                }

                

                switch (choice) {

                    case 1 -> withdrawMoney(scanner);

                    case 2 -> depositMoney(scanner);

                    case 3 -> System.out.println("Exiting...");

                    default -> System.out.println("Invalid choice. Please try again.");

                }

            } while (true);

        }

    }



    private static void withdrawMoney(Scanner scanner) {

        while (true) {

            try {

                System.out.print("Enter amount to withdraw: ");

                double amount = scanner.nextDouble();



                if (amount <= 0) {

                    System.out.println("Please enter a valid amount greater than zero.");

                } else if (amount > atmBalance) {

                    System.out.println("ATM does not have enough balance.");

                } else if (amount > userBalance) {

                    System.out.println("Insufficient account balance.");

                } else {

                    // If all checks pass

                    userBalance -= amount;

                    atmBalance -= amount;

                    System.out.println("Withdrawal successful! New user balance: " + userBalance);

                    System.out.println("New ATM balance: " + atmBalance);

                    break;

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a number.");

                scanner.next(); // Clear the invalid input

            }

        }

    }



    private static void depositMoney(Scanner scanner) {

        while (true) {

            try {

                System.out.print("Enter amount to deposit: ");

                double amount = scanner.nextDouble();



                if (amount <= 0) {

                    System.out.println("Please enter a valid amount greater than zero.");

                } else if (amount > 500000) {

                    System.out.println("Maximum deposit amount is 500000.");

                } else {

                    // If all checks pass

                    userBalance += amount;

                    atmBalance += amount;

                    System.out.println("Deposit successful! New user balance: " + userBalance);

                    System.out.println("New ATM balance: " + atmBalance);

                    break;

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Please enter a number.");

                scanner.next(); // Clear the invalid input

            }

        }

    }

                  }
