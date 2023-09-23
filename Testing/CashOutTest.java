package new_banking.Testing;

import new_banking.Bkash;
import new_banking.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashOutTest {
    BkashUser bkashUser;
    Bkash bkash;

    @BeforeEach
    public void setUp() {
        bkashUser = new BkashUser();
        bkash = bkashUser.enterBkash("01707");
    }


    @Test
    @DisplayName("Pin not match")
    void pinNotMatchTestCase(){
        //testcase: 1
        assertEquals("Pin doesn't match",bkash.cash_out(1000,1233));
    }

    @Test
    @DisplayName("Cashout limit exceed")
    void testCashOutLimitExceed(){
        //testcase: 2
        assertEquals("Cash out failed due to limit exceed",bkash.cash_out(35000,1234));
    }

    @Test
    @DisplayName("Not sufficient balance")
    void testCashOutNotSuccessfulDueToBalanceShortage(){
        //testcase: 3
        assertEquals("Cash out failed for balance limit",bkash.cash_out(6500,1234));
    }

    @Test
    @DisplayName("Successfully cashout")
    void testCashOutSuccessful(){
        //testcase: 2
        assertEquals("Cash out successfully",bkash.cash_out(4100,1234));
    }
}
