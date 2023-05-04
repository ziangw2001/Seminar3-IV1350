package se.kth.iv1350.groceryStore.controller;
import se.kth.iv1350.groceryStore.integration.Printer;
import se.kth.iv1350.groceryStore.integration.SystemCreator;
import se.kth.iv1350.groceryStore.model.CashRegister;
import se.kth.iv1350.groceryStore.integration.ItemDTO;
import se.kth.iv1350.groceryStore.model.CurrentSale;
import se.kth.iv1350.groceryStore.model.Receipt;


/**
 *
 * This is the application's only controller class. All calls to the model pass through here.
 */

public class Controller {
    private CashRegister cashregister = new CashRegister();
    private CurrentSale currentSale;
    private SystemCreator creator;
    private Printer printer;
    private Receipt receipt;


    /**
     * Creates a new instance of the Controller class with the specified SystemCreator and Printer.
     * @param creator       Used to get all classes that handle database calls. (InventorySystem, AccountingSystem)
     * @param printer       Printer is used to print out the receipt.
     */

    public Controller(SystemCreator creator, Printer printer) {
        this.creator = creator;
        this.printer = printer;
    }

    /**
    * Starts a new sale.
    * Sets running total to 0;
    */

    public void startNewSale(){
        currentSale = new CurrentSale();
        currentSale.setRunningTotal(0);
    }
    
    /**
     * 
     * @return return the current sale.
     */
    
    

/**
* Adds an item to the current sale by finding the item with the specified item ID.
* @param itemID The item identifier for the scanned item.
*/

public String scanItem(int itemID){
    ItemDTO foundItem = creator.getExtinventorySystem().findItem(itemID); 
    if(foundItem == null)
        System.out.println("Item not found");
    if (foundItem != null){
        currentSale.addItem(foundItem);
        return foundItem.getItemDescription();
    }
    return null;
}
  

/**
* The method initializes the payment. It passes the payment amount to the currentSale instance and CashRegister, 
* updates the inventory and accounting systems with the currentSale object, and then creates a receipt using the 
* currentSale object. Finally, the receipt is printed using the {@link Printer} instance.
*
* @param amountPaid The amount paid by the customer.
*/

   
    public void inizializePayment(double amountPaid){
        currentSale.pay(amountPaid);
        creator.getExtinventorySystem().updateInventorySystem(currentSale);
        creator.getAccountingSystem().updateAccountingSystem(currentSale); 
        cashregister.addPayment(amountPaid,currentSale);
        receipt = new Receipt(currentSale);
        printer.printReceipt(receipt);
    }
}