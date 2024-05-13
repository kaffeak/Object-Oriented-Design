package store.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemNotFoundExceptionTest {

    private ExternalInventorySystem ex;
    private static final int invalidItemID = 69;

    @BeforeEach
    void setUp() {
        ex = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        ex = null;
    }

    @Test
    public void testInvalidItemID(){
        String actual = null;
        try {
            ex.getItem(invalidItemID);
        } catch (ItemNotFoundException ex){
            actual = ex.getMessage();
        } catch (DatabaseFailureException e){
            e.printStackTrace();
        }
        assertEquals("Item could not be found, ID: " + invalidItemID, actual);
    }
}