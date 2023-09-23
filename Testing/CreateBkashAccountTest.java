package new_banking.Testing;

import new_banking.BkashUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBkashAccountTest {
    BkashUser bkashUser;

    @BeforeEach
    public void setUp() {
        bkashUser = new BkashUser();
    }


    @Test
    @DisplayName("User exist test")
    void testUserExistsCreateAccount(){
        //testcase: 1
        assertFalse(bkashUser.createBkashAccount("sakib","012345",1234));
    }

    @Test
    @DisplayName("Create New User")
    void testToCreateNewUser(){
        //testcase: 2
        assertTrue(bkashUser.createBkashAccount("sakib","01707",1234));
    }
}
