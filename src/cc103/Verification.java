package cc103;

import java.util.Scanner;
public class Verification {
    protected final static int passcode = 1234;
    protected static int trial = 3;

    public Verification() {
        Scanner entry = new Scanner(System.in);

        do {
            System.out.print("Enter the passcode: ");
            int inputPasscode = entry.nextInt();

            if (inputPasscode == passcode) {
                break;
            }
            trial--;

            System.out.printf("You have entered a wrong password. (%dx)\n", trial);

            if (trial == 0) {
                entry.close();
                System.out.println("You have been blocked from the system!");
                System.exit(1);
            }
        }
        while (true);


    }
}
