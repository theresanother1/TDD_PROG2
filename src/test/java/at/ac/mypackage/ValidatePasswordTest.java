package at.ac.mypackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatePasswordTest {
      private ValidatePassword testPassword;

    @BeforeEach
    void setup(){
        testPassword = new ValidatePassword();
    }


    //Password length
    @Test
    @DisplayName("Password is NULL.")
    public void testIfPasswordIsNULL(){ assertThrows(IllegalArgumentException.class, ()
            -> testPassword.checkValidLength(null)); }
    @Test
    @DisplayName("Minimum length is valid")
    public void testPasswordLengthMinimum1(){
        assertTrue(testPassword.checkValidLength("hasvalidlength"));
    }
    @Test
    @DisplayName("Minimum length is too short")
    public void testPasswordLengthMinimum2(){
        assertFalse(testPassword.checkValidLength("short"));
    }
    @Test
    @DisplayName("Maximum length is valid")
    public void testPasswordLengthMaximum1(){
        assertTrue(testPassword.checkValidLength("thisisavalidlengthpassw"));
    }
    @Test
    @DisplayName("Maximum length is not valid")
    public void testPasswordLengthMaximum2(){ assertFalse(testPassword.checkValidLength("thisisnotavalidlengthpassw")); }

    //check for letters inside word & upper-/lowercase Requirement
    @Test
    @DisplayName("Password has letter")
    public void testIfPasswordContainsLetters1(){
        assertTrue(testPassword.hasLetters("this9$hasLetters"));
    }
    @Test
    @DisplayName("Password has no letters")
    public void testIfPasswordContainsLetters2(){
        assertFalse(testPassword.hasLetters("1856393@#"));
    }
    @Test
    @DisplayName("This password has only lower case letters")
    public void testIfOnlyLowerCase(){
        assertFalse(testPassword.hasLetters("thisisabadpassword"));
    }
    @Test
    @DisplayName("This password has only upper case letters")
    public void testIfOnlyUpperCase() {
        assertFalse(testPassword.hasLetters("THISISABADPASSWORD"));
    }

    //Test for number requirement
    @Test
    @DisplayName("Password has numbers")
    public void testIfThereAreNumbers1(){
        assertTrue(testPassword.hasNumbers("has89numbers"));
    }
    @Test
    @DisplayName("Password has no numbers")
    public void testIfThereAreNumbers2(){
        assertFalse(testPassword.hasNumbers("hasnonumbers"));
    }

    //Test for number requirement extensions
    @Test
    @DisplayName("Password contains more than two ascending numbers")
    public void testForAscendingNumbers(){ assertFalse(testPassword.checkForAscendingNumbers("psd931#!oA456")); }
    @Test
    @DisplayName("Password contains more than two descending numbers")
    public void testForDescendingNumbers(){
        assertFalse(testPassword.checkForDescendingNumbers("psd931#!oA654"));
    }
    @Test
    @DisplayName("Password contains more than 3 numbers in a row.")
    public void testForSameNumbersInARow(){ assertFalse(testPassword.hasLessThanThreeSameNumbersInRow("psd931#!2222A"));}


    //Test for special characters
    @Test
    @DisplayName("Password checked for special characters")
    public void testForSpecialCharacters1(){
        assertTrue(testPassword.hasAllowedSpecialCharacters("()#$?!othes%/@"));
    }
    @Test
    @DisplayName("Password has wrong special characters")
    public void testForSpecialCharacters2(){
        assertFalse(testPassword.hasAllowedSpecialCharacters("()><!%/@#$?"));
    }
    @Test
    @DisplayName("Password has no special characters")
    public void testForSpecialCharacters3(){
        assertFalse(testPassword.hasAllowedSpecialCharacters("nospecialchars"));
    }



    @Test
    @DisplayName("This password fulfils all criterias")
    public void fulfilsAllCriteria(){
        assertTrue(testPassword.checkPassword("A#veryGood48Password"));
    }

    @Test
    @DisplayName("Correct Feedback")
    public void fulfillsAllCriteriaMessageTest(){
        String actual = testPassword.showFeedback(true);
        String expected = "Valid Password.";
        assertEquals(expected, actual);
    }




}
