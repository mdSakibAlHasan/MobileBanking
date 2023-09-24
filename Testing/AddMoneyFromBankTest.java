package new_banking.Testing;

import new_banking.Bkash;
import new_banking.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMoneyFromBankTest {
    BkashUser bkashUser;
    Bkash bkash;

    @BeforeEach
    public void setUp() {
        bkashUser = new BkashUser();
        bkash = bkashUser.enterBkash("01707");
    }


    @Test
    @DisplayName("account not valid")
    void accountNumberNotValidTestCase(){
        //testcase: 1
        assertEquals("wrong account number",bkash.addMoneyFromBank(5000,"1234"));
    }

    @Test
    @DisplayName("balance add complete")
    void testSuccessfullyAddBalanceFromBank(){
        //testcase: 2
        assertEquals("balance add complete",bkash.addMoneyFromBank(500,"123456"));
    }


}
