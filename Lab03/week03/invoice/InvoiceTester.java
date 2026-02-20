package week03.invoice;

import java.util.Scanner;

public class InvoiceTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many invoice items do you have? ");
        int numberOfItems = input.nextInt();
        input.nextLine(); 

        Invoice[] invoices = new Invoice[numberOfItems];

        for (int i = 0; i < invoices.length; i++) {
            System.out.println("\n--- Entering Details for Item " + (i + 1) + " ---");
            
            System.out.print("Enter Part Number: ");
            String partNum = input.nextLine();
            
            System.out.print("Enter Part Description: ");
            String desc = input.nextLine();
            
            System.out.print("Enter Quantity: ");
            int qty = input.nextInt();
            
            System.out.print("Enter Price per Item: ");
            double price = input.nextDouble();
            input.nextLine(); 

            invoices[i] = new Invoice(partNum, desc, qty, price);
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.printf("%-10s | %-20s | %-8s | %-10s%n", "PART #", "DESCRIPTION", "QTY", "AMOUNT");
        System.out.println("-".repeat(60));

        double totalGrandAmount = 0;

        for (Invoice inv : invoices) {
            double itemAmount = inv.getQuantity() * inv.getPricePerItem();
            totalGrandAmount += itemAmount;

            System.out.printf("%-10s | %-20s | %-8d | $%.2f%n", 
                inv.getPartNumber(), 
                inv.getPartDescription(), 
                inv.getQuantity(), 
                itemAmount);
        }

        System.out.println("=".repeat(60));
        System.out.printf("TOTAL INVOICE AMOUNT: $%.2f%n", totalGrandAmount);

        input.close();
    }
}
