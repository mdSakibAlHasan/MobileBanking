package new_banking.Testing;

import new_banking.code.Bkash;
import new_banking.code.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnterBkashTestCase {
    BkashUser bkashUser;
    Bkash bkash;

    @BeforeEach
    public void setUp() {
        bkashUser = new BkashUser();
    }


    @Test
    @DisplayName("Not enter into bkash")
    void testToNoDataToEnterIntoBkash(){
        //testcase: 2
        assertNull(bkashUser.enterBkash("017"));
    }

    @Test
    @DisplayName("User successfully enter to bkash")
    void testSuccesssfullEnterToBkash(){
        //testcase: 1
        assertNotNull(bkashUser.enterBkash("01707"));
    }

    @Test
    @DisplayName("Not enter into bkash")
    void testToNotEnterIntoBkash(){
        //testcase: 2
        assertNull(bkashUser.enterBkash("017075"));
    }
}
