package at.ac.mypackage;

import org.junit.jupiter.api.BeforeEach;


public class ValidatePasswordTest {
      private ValidatePassword testPassword;
    private ValidatePassword testPassword2;


    @BeforeEach
    void setup(){
        testPassword = new ValidatePassword();
        testPassword2 = new ValidatePassword("xyz");
    }





}
