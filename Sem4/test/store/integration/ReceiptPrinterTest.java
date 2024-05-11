package store.integration;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import store.integration.ReceiptPrinter;
import store.controller.Controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

class ReceiptPrinterTest {
    private Controller controller;
    private DiscountDB discounts = new DiscountDB();
    private ExternalAccountingSystem accountingSystem = new ExternalAccountingSystem();
    private ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
    private ReceiptPrinter printer = new ReceiptPrinter();
    private PrintStream old;
    private ByteArrayOutputStream baos;
    private  PrintStream ps;
    private final int validItemID = 0;
    private final int amountPaid = 500;
    private final int uniqueQuantity = 32;
    private final double validItemPrice = 10.5;
    private final double validVATrate = 0.12;

    @BeforeEach
    void setUp() {
        controller = new Controller(accountingSystem, inventorySystem, printer, discounts);
        baos = new ByteArrayOutputStream();
        ps = new PrintStream(baos);
        old = System.out;
        System.setOut(ps);
    }

    @AfterEach
    void tearDown(){
        System.out.flush();
        System.setOut(old);
    }

    @Test
    void printReceipt() {
        controller.startSale();
        try {
            controller.addItem(validItemID, uniqueQuantity);
        }catch (ItemNotFoundException ex){
            ex.printStackTrace();
            fail("Item could not be added to sale");
        }

        String totalcost = Double.toString(controller.endSale());
        String change = Double.toString(controller.getChange(amountPaid));
        LocalDate date = LocalDate.now();
        String totalVat = Double.toString((validItemPrice * validVATrate * uniqueQuantity));
        String printedReceipt = baos.toString();

        boolean contains = printedReceipt.contains("Banana");
        assertTrue(contains, "Receipt does not contain purchased item");
        contains = printedReceipt.contains(Integer.toString(uniqueQuantity));
        assertTrue(contains, "Receipt does not contain the correct quantity of entered item");
        contains = printedReceipt.contains(Double.toString(validItemPrice + (validItemPrice * validVATrate)));
        assertTrue(contains, "Receipt does not contain the price of entered item");
        contains = printedReceipt.contains(totalcost);
        assertTrue(contains, "Receipt does not contain correct formatting of total cost");
        contains = printedReceipt.contains(Integer.toString(amountPaid));
        assertTrue(contains, "Receipt does not contain correct amount paid");
        contains = printedReceipt.contains(change);
        assertTrue(contains, "Receipt does not contain correct formatting of change");
        contains = printedReceipt.contains(totalVat);
        assertTrue(contains, "Receipt does not contain the correct amount of VAT");
        contains = printedReceipt.contains(date.toString());
        assertTrue(contains, "Receipt does not contain correct formatting of current date");
    }
}