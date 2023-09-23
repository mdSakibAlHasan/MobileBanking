package new_banking.Testing;

import new_banking.Bkash;
import new_banking.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceCheckTest {
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
        assertEquals("Wrong pin",bkash.balance_check(1243));
    }

    @Test
    @DisplayName("balance check successfully")
    void balanceCheckSuccessfully(){
        //testcase: 2
        assertEquals("Your balance is: 5000.0",bkash.balance_check(1234));
    }

}
