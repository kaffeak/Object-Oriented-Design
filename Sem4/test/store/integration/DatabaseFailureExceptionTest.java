package store.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseFailureExceptionTest {
    private ExternalInventorySystem ex;

    @BeforeEach
    void setUp() {
        ex = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        ex = null;
    }

    @Test
    public void testDatabaseFailure(){
        String actual = null;
        try{
            ex.getItem(1337);
        }catch (DatabaseFailureException ex) {
            actual = ex.getMessage();
        } catch (ItemNotFoundException ex) {
            ex.printStackTrace();
        }
        assertEquals("Database can not be reached", actual);
    }
}