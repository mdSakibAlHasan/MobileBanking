package new_banking.Testing;

import new_banking.code.Bkash;
import new_banking.code.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PinUpdateTest {
    BkashUser bkashUser;
    Bkash bkash;

    @BeforeEach
    public void setUp() {
        bkashUser = new BkashUser();
        bkash = bkashUser.enterBkash("01707");
    }


    @Test
    @DisplayName("Pin not match")
    void oldPinNotMatchTestCase(){
        //testcase: 1
        assertEquals("Old pin does not match. Pin update failed",bkash.pin_update(1233,1243));
    }

    @Test
    @DisplayName("Old pin same as new pin")
    void pinNotUpdateAsoldPinSameAsSetNewPin(){
        //testcase: 2
        assertEquals("old pin can't be same as new pin",bkash.pin_update(1234,1234));
    }

    @Test
    @DisplayName("Old pin same as new pin")
    void pinUpdateSuccessfully(){
        //testcase: 3
        assertEquals("Pin updated successfully",bkash.pin_update(1234,1243));
    }

}
