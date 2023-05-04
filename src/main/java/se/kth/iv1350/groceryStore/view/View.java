
package se.kth.iv1350.groceryStore.view;

import se.kth.iv1350.groceryStore.controller.Controller;


/**
 * This program has no view, this class is a placeholder for the entire view. It interacts with the controller class to execute.
 */
public class View {
    private final Controller contr; 
    /**
     * 
     * @param contr The controller that is used for all operations.
     */
    
     
   
    public View (Controller contr) {
        this.contr = contr;
    
    }

    /**
    * Performs a sample execution of the program by calling methods from the Controller object to simulate 
    * a cashier scanning items and initializing a payment.
    */

    public void sampleExecution(){
        System.out.println("Cashier starts a new sale.");
        contr.startNewSale();
        String item = contr.scanItem(23456); 
        System.out.println("Cashier scans a " + item);


        item = contr.scanItem(12345); 
        System.out.println("Cashier scans a " + item);
        item = contr.scanItem(34567);
        System.out.println("Cashier scans a " + item);
        item = contr.scanItem(34567); 
        System.out.println("Cashier scans a " + item);
        item = contr.scanItem(23456);
        System.out.println("Cashier scans a " + item);

        contr.inizializePayment(500);

        System.out.println("Cashier starts a new sale.");
        contr.startNewSale();
        item = contr.scanItem(23456);
        System.out.println("Cashier scans a " + item);
        contr.inizializePayment(500);
        
    }
}

