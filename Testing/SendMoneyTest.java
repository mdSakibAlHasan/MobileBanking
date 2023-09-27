package new_banking.Testing;

import new_banking.code.Bkash;
import new_banking.code.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendMoneyTest {
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
        assertEquals("Pin doesn't match",bkash.send_money(1000,1233));
    }

    @Test
    @DisplayName("Send Money limit exceed")
    void testSendMoneyLimitExceed(){
        //testcase: 2
        assertEquals("Money send failed due to limit exceed",bkash.send_money(35000,1234));
    }

    @Test
    @DisplayName("Not sufficient balance")
    void testSendMoneyNotSuccessfulDueToBalanceShortage(){
        //testcase: 2
        assertEquals("Money doesn't sent due to shortage balance",bkash.send_money(6500,1234));
    }

    @Test
    @DisplayName("Successfully sent")
    void testSendMoneySuccessful(){
        //testcase: 2
        assertEquals("Money send successfully",bkash.send_money(4100,1234));
    }
}
