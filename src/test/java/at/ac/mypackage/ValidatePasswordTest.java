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
    @DisplayName("Minimum length is valid")
    public void testPasswordLengthMinimum2(){
        assertTrue(testPassword.checkPassword("hasvalidlength"));
    }
    @Test
    @DisplayName("Minimum length is too short")
    public void testPasswordLengthMinimum(){
        assertTrue(testPassword.checkPassword("short"));
    }




}
