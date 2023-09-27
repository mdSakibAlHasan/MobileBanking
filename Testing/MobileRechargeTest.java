package new_banking.Testing;

import new_banking.code.Bkash;
import new_banking.code.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MobileRechargeTest {
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
        assertEquals("pin not match",bkash.mobileRechrge("01707500000",1233,30));
    }

    @Test
    @DisplayName("number is invalid")
    void testNUmberIsInvalid(){
        //testcase: 2
        assertEquals("phn number not valid",bkash.mobileRechrge("01707500000000",1234,35));
    }

    @Test
    @DisplayName("Not sufficient balance")
    void testMobileRechargeNotSuccessfulDueToBalanceShortage(){
        //testcase: 3
        assertEquals("balance shortage or below amount",bkash.mobileRechrge("01234567890",1234,6000));
    }

    @Test
    @DisplayName("Successfully recharge")
    void testRechargeMoneySuccessful(){
        //testcase: 4
        assertEquals("recharge successfully done",bkash.mobileRechrge("12345678900",1234,50));
    }

    @Test
    @DisplayName("low balance select")
    void testMobileRechargeNotSuccessfulDueToLowBalanceSelect(){
        //testcase: 5
        assertEquals("balance shortage or below amount",bkash.mobileRechrge("01234567890",1234,10));
    }
}
