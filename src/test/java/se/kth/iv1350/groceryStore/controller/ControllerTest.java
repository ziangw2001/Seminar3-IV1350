/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.controller;

import se.kth.iv1350.groceryStore.integration.Printer;
import se.kth.iv1350.groceryStore.integration.SystemCreator;
import se.kth.iv1350.groceryStore.integration.ItemDTO;
import se.kth.iv1350.groceryStore.model.CurrentSale;
import se.kth.iv1350.groceryStore.model.Receipt;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test; 
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*; 
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author alexwang07
 */
public class ControllerTest {
    private Controller controller;
    private SystemCreator creator;
    private Printer printer;
    private CurrentSale currentSale;

    @BeforeEach
    public void setUp() {
        creator = new SystemCreator();
        printer = new Printer();
        controller = new Controller(creator, printer);
        controller.startNewSale();
        currentSale = new CurrentSale();
        
    }
    
    @Test
    public void testStartNewSale() {
        controller.startNewSale();
        assertEquals(0,currentSale.getRunningTotal());
    }

    @Test
        public void testScanItem() {
        controller.startNewSale(); 
        int itemID = 12345; 
        ItemDTO item = creator.getExtinventorySystem().findItem(12345);
        assertEquals(itemID, item.getItemIdentifier());
    }
      

   @Test
    public void testInitializePayment() {
        controller.startNewSale();
        controller.scanItem(12345);
        double amountPaid = 100.0;
        controller.inizializePayment(amountPaid);
       // assertNotNull(controller.getReceipt());
    }
}

