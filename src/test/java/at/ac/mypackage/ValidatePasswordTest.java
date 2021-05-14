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
    public void testPasswordLengthMinimum1(){
        assertTrue(testPassword.checkPassword("hasvalidlength"));
    }
    @Test
    @DisplayName("Minimum length is too short")
    public void testPasswordLengthMinimum2(){
        assertFalse(testPassword.checkPassword("short"));
    }
    @Test
    @DisplayName("Maximum length is valid")
    public void testPasswordLengthMaximum1(){
        assertTrue(testPassword.checkPassword("thisisavalidlengthpassw"));
    }
    @Test
    @DisplayName("Maximum length is not valid")
    public void testPasswordLengthMaximum2(){
        assertFalse(testPassword.checkPassword("thisisnotavalidlengthpassw"));
    }
    @Test
    @DisplayName("This password has only lower case letters")
    public void testIfOnlyLowerCase(){
        assertFalse(testPassword.checkPassword("thisisabadpassword"));
    }





}
