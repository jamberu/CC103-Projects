package cc103.bankTransact;

import java.util.Scanner;
class Account {
    protected static int number;
    protected static int balance = 10000;
    protected static final int deduction = 18;

    Account(int accountNumber) {
        if (accountNumber >= 100 && accountNumber <= 110) {
            number = accountNumber;
        }

        else {
            System.out.print("The account number is invalid. Exiting system...");
            System.exit(1);
        }
    }

    public void getBalance() {
        System.out.println("==============================================");
        System.out.println("             Account Balance              ");
        System.out.print("                                          ");
        System.out.printf("\n Current balance for %d:    %,d\t\t", number, balance);
        System.out.println("\n==============================================");
    }

    public void withdrawCash(int amount) {
        if (balance < amount) {
            System.out.print("You don't have enough balance. Exiting system...");
            System.exit(1);
        }
        if (amount < 500) {
            System.out.print("The minimum withdrawal amount is 500.00. Exiting system...");
            System.exit(1);
        }
        else {
            balance -= amount;
            balance -= deduction;
        }
    }

    public void depositCash(int amount) {
        if (amount < 500) {
            System.out.print("The minimum withdrawal amount is 500.00. Exiting system...");
            System.exit(1);
        }
        else {
            balance += amount;
            balance -= deduction;
        }
    }
}

public class Main {
    private static void createTUI(int accountNumber) {
        System.out.println("==============================================");
        System.out.print("                                          ");
        System.out.printf("\n         Bank Transaction for %d         \n", accountNumber);
        System.out.print("                                          \n");
        System.out.println("         [1] Withdraw Cash                ");
        System.out.println("         [2] Deposit Cash                 ");
        System.out.println("         [3] Balance Inquiry              ");
        System.out.print("                                          \n");
        System.out.println("==============================================");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner entry = new Scanner(System.in);

        System.out.print("Enter your account number (100 - 110): ");
        int accountNumber = entry.nextInt();
        Account userAccount = new Account(accountNumber);

        do {
            createTUI(accountNumber);

            System.out.print("Enter your transaction: ");

            int transaction = entry.nextInt();

            switch (transaction) {
                case 1:
                    System.out.printf("Enter the amount to withdraw (There is a deduction fee of %d PHP): ", Account.deduction);
                    int withdrawAmount = entry.nextInt();
                    entry.nextLine();
                    userAccount.withdrawCash(withdrawAmount);

                    System.out.print("Would you like to check your balance? (Yes/No): ");
                    String withdrawOption = entry.nextLine();

                    if (withdrawOption.equalsIgnoreCase("Yes")) {
                        userAccount.getBalance();
                    }
                    break;

                case 2:
                    System.out.printf("Enter the amount to deposit (There is a deduction fee of %d PHP): ", Account.deduction);
                    int depositAmount = entry.nextInt();
                    entry.nextLine();
                    userAccount.depositCash(depositAmount);

                    System.out.print("Would you like to check your balance? (Yes/No): ");
                    String depositOption = entry.nextLine();

                    if (depositOption.equalsIgnoreCase("Yes")) {
                        userAccount.getBalance();
                    }
                    break;

                case 3:
                    userAccount.getBalance();
                    break;
            }

            System.out.print("Would you like another transaction? (Yes/No): ");
            String transactionOption = entry.nextLine();

            if (!transactionOption.equalsIgnoreCase("Yes")) {
                entry.close();
                System.out.print("Exiting system...");
                System.exit(0);
            }
        }
        while (true);


    }
}