/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package se.kth.iv1350.groceryStore.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.groceryStore.model.CurrentSale;

/**
 *
 * @author alexwang07
 */
public class ExtInventorySystemTest {
     private ExtInventorySystem inventorySystem;
    private ItemDTO oneItem;

  
    @BeforeEach
    public void setUp() {
        inventorySystem = new ExtInventorySystem();
        oneItem = new ItemDTO(20.0, 12345, "Milk", 200);
        
    }

    @Test
    public void testFindItem() {
     ItemDTO item = inventorySystem.findItem(oneItem.getItemIdentifier());
        assertNotNull(item);
        assertEquals(oneItem.getItemDescription(), item.getItemDescription());
        assertEquals(oneItem.getItemPrice(), item.getItemPrice());
    }
   @Test
    public void testUpdateInventorySystem() {
        CurrentSale currentSale = new CurrentSale();
        ItemDTO item = inventorySystem.findItem(12345);
        currentSale.addItem(item);
        inventorySystem.updateInventorySystem(currentSale);
        // Add assertions here to verify that the inventory system has been updated correctly.
    }
}
