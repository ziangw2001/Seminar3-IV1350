package se.kth.iv1350.groceryStore.integration;
import se.kth.iv1350.groceryStore.model.Receipt;

/**
 * The Printer class handles printing of receipts. When deployed, it would represent an actual printer.
 * 
 */

public class Printer {
    

    /**
     * Prints the provided receipt to the console.
     * 
     * @param receipt the <code>{@link se.kth.iv1350.groceryStore.model.Receipt Receipt}</code> to be printed
     */
    
    public void printReceipt(Receipt receipt){
        System.out.println (receipt.printReceipt());
    }
}