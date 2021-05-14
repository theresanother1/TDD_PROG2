package at.ac.mypackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatePasswordTest {
      private ValidatePassword testPassword;
    private ValidatePassword testPassword2;


    @BeforeEach
    void setup(){
        testPassword = new ValidatePassword();
        testPassword2 = new ValidatePassword("xyz");
    }

    @Test
    public void testPasswordLengthMinimum(){
        testPassword.setMyPassword("WeAreTogether@inThis90");
        testPassword2.setMyPassword("short");
        int actual = testPassword2.checkPassword(testPassword2);
        int expected = testPassword.checkPassword(testPassword);
    }





}
