package cc103.computerRentals;

import cc103.Verification;
import java.util.Scanner;


public class Main {
    public static final int set1Price = 20;
    public static final int set2Price = 25;
    public static final int nonColoredPrintPrice = 2;
    public static final int coloredPrintPrice = 10;
    public static void loadIntroTUI() {
        System.out.println("==================================================");
        System.out.println("                                              ");
        System.out.println("\t\t\t\t  RENT-A-COMPUTER\t\t\t\t");
        System.out.println("                                              ");
        System.out.println("\t\t\t  [1] Computer Rental\t\t\t\t");
        System.out.println("\t\t\t  [2] Printing       \t\t\t\t");
        System.out.println("                                              ");
        System.out.println("==================================================");
    }
    public static void loadServiceTUI(int service) {
        if (service == 1) {
            System.out.println("==================================================");
            System.out.println("                                              ");
            System.out.println("\t\t\t\t  COMPUTER RENTAL\t\t\t\t");
            System.out.println("                                              ");
            System.out.println("\t\t\t  [1] PC 1-5 (20 PHP/hr)  \t\t\t");
            System.out.println("\t\t\t  [2] PC 6-10 (25 PHP/hr) \t\t\t");
            System.out.println("                                              ");
            System.out.println("==================================================");
        }

        else if (service == 2) {
            System.out.println("==================================================");
            System.out.println("                                              ");
            System.out.println("\t\t\t\t  PRINTING RENTAL\t\t\t\t");
            System.out.println("                                              ");
            System.out.println("\t\t\t[1] Black & White (2 PHP/page)\t\t");
            System.out.println("\t\t\t[2] Colored (10 PHP/page) \t\t\t");
            System.out.println("                                              ");
            System.out.println("==================================================");
        }
    }

    public static void computeRentPCPrice(int set, int hours) {
        int price = 0;
        if (set == 1) {
            price =  set1Price * 5 * hours;
        }
        else if (set == 2) {
            price =  set2Price * 5 * hours;
        }

        System.out.println("==================================================");
        System.out.println("                                              ");
        System.out.println("\t\t\t\t  RENT PC SUMMARY\t\t\t\t");
        System.out.println("                                              ");
        System.out.printf("\t\t\t  PC Set Rented: Set %d\t\t\t\t\n", set);
        System.out.printf("\t\t\t  Hours to be Rented: %d hours\t\t\n", hours);
        System.out.println("                                              ");
        System.out.printf("\t\t\t  Total Amount: %,d PHP\t\t\t\n", price);
        System.out.println("                                              ");
        System.out.println("==================================================");
    }

    public static void computeRentPrintPrice(int colored, int pages) {
        String isColored = null;
        int price = 0;

        if (colored == 1) {
            isColored = "No";
            price = nonColoredPrintPrice * pages;
        }

        else if (colored == 2) {
            isColored = "Yes";
            price = coloredPrintPrice * pages;
        }

        System.out.println("==================================================");
        System.out.println("                                              ");
        System.out.println("\t\t\t\tRENT PRINT SUMMARY\t\t\t\t");
        System.out.println("                                              ");
        System.out.printf("\t\t\tColored Print: %s\t\t\t\t\t\n", isColored);
        System.out.printf("\t\t\tPages to Print: %d\t\t\t\t\t\n", pages);
        System.out.println("                                              ");
        System.out.printf("\t\t\tTotal Amount: %,d PHP\t\t\t\t\n", price);
        System.out.println("                                              ");
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        Verification verification = new Verification();
        Scanner entry = new Scanner(System.in);

        loadIntroTUI();
        System.out.print("Enter the service to rent (1/2): ");
        int service = entry.nextInt();

        loadServiceTUI(service);

        if (service  == 1) {
            System.out.print("Enter the PC set to rent (1/2): ");
            int set = entry.nextInt();

            if (set != 1 || set != 2) {
                System.out.print("PC Set must only be from 1 or 2. Exiting system...");
                System.exit(1);
            }
            System.out.print("How many hours will they be rented? (1-24): ");
            int hours = entry.nextInt();

            if (hours < 1 && hours > 24) {
                System.out.print("Hours to rent is at minimum 1 and maximum 24. Exiting system...");
                System.exit(1);
            }

            computeRentPCPrice(set, hours);
        }

        else if (service == 2) {
            System.out.print("Enter the color type (1/2): ");
            int colored = entry.nextInt();

            if (colored != 1 || colored != 2) {
                System.out.print("Color type must only be from 1 and 2. Exiting system...");
                System.exit(1);
            }
            System.out.print("How many pages will be printed?: ");
            int pages = entry.nextInt();

            computeRentPrintPrice(colored, pages);
        }




    }

}
