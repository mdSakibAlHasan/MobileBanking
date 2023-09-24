package new_banking.Testing;

import new_banking.Bkash;
import new_banking.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferToBankTest {
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
        assertEquals("pin not match",bkash.transfer(1000,1233,"12334"));
    }

    @Test
    @DisplayName("transfer Money limit exceed")
    void testTransferMoneyLimitExceed(){
        //testcase: 2
        assertEquals("balance shortage or quota exceed",bkash.transfer(35000,1234,"4545"));
    }

    @Test
    @DisplayName("Not sufficient balance")
    void testTransferMoneyNotSuccessfulDueToBalanceShortage(){
        //testcase: 2
        assertEquals("balance shortage or quota exceed",bkash.transfer(20000,1234,"4545"));
    }

    @Test
    @DisplayName("Successfully sent")
    void testTransferMoneySuccessful(){
        //testcase: 2
        assertEquals("balance transfer complete",bkash.transfer(200,1234,"4545"));
    }
}
