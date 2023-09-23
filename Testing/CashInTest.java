package new_banking.Testing;

import new_banking.Bkash;
import new_banking.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CashInTest {
    BkashUser bkashUser;
    Bkash bkash;

    @BeforeEach
    public void setUp() {
        bkashUser = new BkashUser();
        bkash = bkashUser.enterBkash("01707");
    }


    @Test
    @DisplayName("Cashin successfull")
    void testCashinSuccessfully(){
        //testcase: 1
        assertEquals("Successful",bkash.cashIn(1500));
    }

    @Test
    @DisplayName("cashin quota exceed")
    void testCashinQuotaExceed(){
        //testcase: 2
        assertEquals("maximum quota exceed",bkash.cashIn(35000));
    }
}
