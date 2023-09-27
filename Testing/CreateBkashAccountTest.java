package new_banking.Testing;

import new_banking.code.BkashUser;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileReader;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBkashAccountTest {
    static BkashUser bkashUser;

    @BeforeAll
    public static void setUp() {
        bkashUser = new BkashUser();
    }

    @Test
    @DisplayName("Create New User")
    void testToCreateNewUser(){
        //testcase: 2
        assertTrue(bkashUser.createBkashAccount("sakib","001122",1234));
    }

    @Test
    @DisplayName("User exist test")
    void testUserExistsCreateAccount(){
        //testcase: 1
        assertFalse(bkashUser.createBkashAccount("sakib","001122",1234));
    }


    @AfterAll
    static void deleteCreateUser(){
        String filePath = "code/accountDetails.txt";
        try {
            File inputFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            StringBuilder content = new StringBuilder();
            String line, tempLine=null;

            while ((line = reader.readLine()) != null) {
                //System.out.println(line+" "+tempLine);
               // if(line.length() > 0) {
                    if (tempLine != null) {
                        content.append(tempLine);
                        content.append("\n");
                    }
                //}
                tempLine = line;
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            writer.write(content.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
