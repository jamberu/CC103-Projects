package cc103.tuitionFee;

import cc103.Verification;
import java.util.Scanner;

class StudentTuition {
    private static float tuition;
    private static float computedTuition;
    private static final float cashDiscount = 0.10F, installmentInterest = 0.10F;
    private static final float fullScholarDiscount = 0.90F;
    private static final float halfScholarDiscount = 0.50F;

    public StudentTuition(int studentTuition) {
        tuition = studentTuition;
    }
    public void nonScholarFee(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("Cash")) {
            computedTuition = tuition - (tuition * cashDiscount);
        }

        else if (paymentMethod.equalsIgnoreCase("Installment")) {
            computedTuition = tuition + (tuition * installmentInterest);
        }

        System.out.println("==================================================");
        System.out.print("                                              \n");
        System.out.println("\t\t        TUITION FEE SUMMARY\t\t        ");
        System.out.print("                                              \n");
        System.out.printf("\t\t    Total Tuition Fee: %,.2f\t\t\n", tuition);
        System.out.println("\t\t    Payment Scheme: Non-Scholar\t\t\t");
        System.out.printf("\t\t    Payment Method: %s\t\t\t    \n", paymentMethod);
        System.out.print("                                              \n");
        System.out.printf("\t\t    Tuition Fee: %,.2f\t\t\t\t\n", computedTuition);
        System.out.print("                                              \n");
        System.out.println("==================================================");
    }
    public void scholarFee(String paymentMethod) {
        if (paymentMethod.equalsIgnoreCase("Full Scholar")) {
            computedTuition = tuition - (tuition * fullScholarDiscount);
        }
        else if (paymentMethod.equalsIgnoreCase("Half Scholar")) {
            computedTuition = tuition - (tuition * halfScholarDiscount);
        }
        System.out.println("==================================================");
        System.out.print("                                              \n");
        System.out.println("\t\t        TUITION FEE SUMMARY\t\t        ");
        System.out.print("                                              \n");
        System.out.printf("\t\t    Total Tuition Fee: %,.2f\t\t\n", tuition);
        System.out.println("\t\t    Payment Scheme: Scholar\t\t\t\t");
        System.out.printf("\t\t    Payment Method: %s\t\t\n", paymentMethod);
        System.out.print("                                              \n");
        System.out.printf("\t\t    Tuition Fee: %,.2f\t\t\t\t\n", computedTuition);
        System.out.print("                                              \n");
        System.out.println("==================================================");
    }
}

public class Main {
    public static void main(String[] args) {
        Verification verification = new Verification();

        Scanner entry = new Scanner(System.in);

        System.out.print("Enter your tuition fee: ");

        int tuition = entry.nextInt();
        StudentTuition studentTuition = new StudentTuition(tuition);

        System.out.println("==================================================");
        System.out.print("                                              \n");
        System.out.println("\t\t      TUITION FEE CALCULATOR\t\t    ");
        System.out.println("\t\t     [1] Non-Scholar Tuition\t\t    ");
        System.out.println("\t\t     [2] Scholar Tuition\t\t        ");
        System.out.print("                                              \n");
        System.out.println("==================================================");
        System.out.print("Enter your payment scheme (1/2): ");

        int scheme = entry.nextInt();

        if (scheme != 1 || scheme != 2) {
            System.out.print("Payment scheme must only be from 1 and 2. Exiting system...");
            System.exit(1);
        }
        entry.nextLine();

        if (scheme == 1) {
            System.out.println("==================================================");
            System.out.print("                                              \n");
            System.out.println("\t\t   NON-SCHOLAR PAYMENT METHOD\t\t    ");
            System.out.println("\t\t   Cash (has 10% discount)   \t\t    ");
            System.out.println("\t\t   Installment (has 10% interest)\t\t");
            System.out.print("                                              \n");
            System.out.println("==================================================");
            System.out.print("Enter your payment method (Cash/Installment): ");

            String nonScholarMethod = entry.nextLine();

            if (!nonScholarMethod.equalsIgnoreCase("Cash") || !nonScholarMethod.equalsIgnoreCase("Installment")) {
                System.out.print("Method of payment must only be Cash or Installment. Exiting system...");
                System.exit(1);
            }

            studentTuition.nonScholarFee(nonScholarMethod);
        }

        else if (scheme == 2) {
            System.out.println("==================================================");
            System.out.print("                                              \n");
            System.out.println("\t\t      SCHOLAR PAYMENT METHOD\t\t    ");
            System.out.println("\t     Full Scholar (has 90% discount) \t\t");
            System.out.println("\t     Half Scholar (has 50% discount)\t\t");
            System.out.print("                                              \n");
            System.out.println("==================================================");
            System.out.print("Enter your payment method (Full Scholar/Half Scholar): ");
            String scholarMethod = entry.nextLine();

            if (!scholarMethod.equalsIgnoreCase("Full Scholar") || !scholarMethod.equalsIgnoreCase("Half Scholar")) {
                System.out.print("Method of payment must only be Full Scholar or Half Scholar. Exiting system...");
                System.exit(1);
            }

            studentTuition.scholarFee(scholarMethod);
        }
    }
}
