package store.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import store.integration.DiscountDB;
import store.integration.ExternalAccountingSystem;
import store.integration.ExternalInventorySystem;
import store.integration.ReceiptPrinter;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;
    private DiscountDB discounts = new DiscountDB();
    private ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
    private ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
    private ReceiptPrinter printer = new ReceiptPrinter();

    private final int validItemID = 0;

    @BeforeEach
    void setUp() {
        controller = new Controller(accountingSystem, inventorySystem, printer, discounts);
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void startSale() {
        try {
            controller.startSale();
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Sale object could not be initialized");
        }
        controller.addItem(validItemID, 1);
        controller.endSale();
    }

    @Test
    void addItem() {
        controller.startSale();
        try {
            assertNotNull(controller.addItem(validItemID, 1));
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Item could not be added");
        }
    }

    @Test
    void endSale() {
        controller.startSale();
        controller.addItem(validItemID, 1);
        try{
            assertEquals((10.50 * 1.12), controller.endSale(), "Ending the sale does not retrieve the correct amount");
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Sale could not be ended");
        }
    }

    @Test
    @Disabled("Not implemented yet nor currently used")
    void retrieveDiscount() {
    }

    @Test
    void getChange() {
        int amountPaid = 500;
        double actualChange = 0;

        controller.startSale();
        controller.addItem(validItemID, 10);
        double expectedTotalCost = controller.endSale();
        try {
            actualChange = controller.getChange(amountPaid);
        } catch (Exception ex) {
            ex.printStackTrace();
            fail("Change could not be gathered through controller");
        }
        double expectedChange = amountPaid - expectedTotalCost;
        assertEquals(expectedChange, actualChange, "Expected change does not match the actual amount of change");
    }
}