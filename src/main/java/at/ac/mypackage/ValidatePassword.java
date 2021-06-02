package at.ac.mypackage;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class ValidatePassword {
    private String myPassword;

    public ValidatePassword() {
    }

    public ValidatePassword(String userPassword) {
        this.myPassword = userPassword;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }

    public boolean checkPassword(String userPassword) {
        if (checkValidLength(userPassword)
                && hasNumbers(userPassword) && hasAllowedSpecialCharacters(userPassword)
                && checkForAscendingNumbers(userPassword) && checkForDescendingNumbers(userPassword)
                && hasLessThanThreeSameNumbersInRow(userPassword)) {
            System.out.println(userPassword);
            System.out.println(showFeedback(true));
            return true;
        }
        System.out.println(userPassword);
        System.out.println(showFeedback(false));
        return false;
    }

    String showFeedback(boolean feedback){
        if (feedback){
            return "Valid Password.";
        }
        return "Invalid Password";
    }

    public boolean checkValidLength(String userPassword) {
        boolean valid = false;
        if (userPassword == null) {
            throw new IllegalArgumentException("Password should not be NULL.");
        }
        if (userPassword.length() > 8 && userPassword.length() < 25) {
            valid = true;
        }
        else if (userPassword.length() <= 8){
            System.out.println(userPassword);
            System.out.println("Password is too short");
        }
        if (userPassword.length() >= 25){
            System.out.println(userPassword);
            System.out.println("Password is too long");
        }
        return valid;
    }

    public boolean hasLetters(String userPassword) {
        boolean valid = false;
        boolean upper = false, lower = false;
        char[] pw = userPassword.toCharArray();
        for (char c : pw) {
            if (Character.isUpperCase(c)) {
                upper = true;
            }
            if (Character.isLowerCase(c)) {
                lower = true;
            }
            if (lower && upper) {
                valid = true;
                break;
            }
        }
        System.out.println(userPassword);;
        System.out.println("Password must contain uppercase & lowercase Letters.");
        return valid;
    }

    public boolean hasNumbers(String userPassword) {
        boolean valid = false;
        char[] pw = userPassword.toCharArray();
        for (char c : pw) {
            if (Character.isDigit(c)) {
                valid = true;
                break;
            }
        }
        if (!valid){
            System.out.println(userPassword);
            System.out.println("Password must contain numbers.");
        }

        return valid;
    }

    public boolean hasAllowedSpecialCharacters(String userPassword) {
        boolean valid = false;
        String checkForSymbols = "";
        checkForSymbols = userPassword.replaceAll("[()#$?!%/@]+", "");
        if (checkForSymbols.equals(userPassword)) {
            System.out.println(userPassword);
            System.out.println("Password must contain one of these ()#$?!%/@ letters.");
            return valid;
        }
        if (!checkForSymbols.equals("")) {
            checkForSymbols = checkForSymbols.toLowerCase().replaceAll("[a-z0-9]+", "");
            if (checkForSymbols.equals("")) {
                valid = true;
            }
        }
        return valid;
    }

    //Numbers extensions
    public boolean checkForAscendingNumbers(String userPassword) {
        char[] pw = userPassword.toCharArray();
        int firstNumber, secNumber, thirdNumber;
        for (int i = 0; i < pw.length; i++) {
            if (Character.isDigit(pw[i]) && (i + 2) <= pw.length) {
                firstNumber = Character.getNumericValue(pw[i]);
                if (Character.isDigit(pw[i + 1])) {
                    secNumber = Character.getNumericValue(pw[i + 1]);
                    if ((i + 2) < pw.length && Character.isDigit(pw[i + 2]) && secNumber - firstNumber == 1) {
                        thirdNumber = Character.getNumericValue(pw[i + 2]);
                        if (thirdNumber - secNumber == 1) {
                            System.out.println(userPassword);
                            System.out.println("Password must NOT contain more than two ascending numbers.");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean checkForDescendingNumbers(String userPassword) {
        char[] pw = userPassword.toCharArray();
        int firstNumber, secNumber, thirdNumber;
        for (int i = 0; i < pw.length; i++) {
            if (Character.isDigit(pw[i]) && (i + 2) <= pw.length) {
                firstNumber = Character.getNumericValue(pw[i]);
                if (Character.isDigit(pw[i + 1])) {
                    secNumber = Character.getNumericValue(pw[i + 1]);
                    if ((i + 2) < pw.length && Character.isDigit(pw[i + 2]) && firstNumber - secNumber == 1) {
                        thirdNumber = Character.getNumericValue(pw[i + 2]);
                        if (secNumber - thirdNumber == 1) {
                            System.out.println(userPassword);
                            System.out.println("Password must NOT contain more than two descending numbers.");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean hasLessThanThreeSameNumbersInRow(String userPassword) {
        char[] pw = userPassword.toCharArray();
        int controlNumber;
        for (int i = 0; i < pw.length; i++) {
            if (Character.isDigit(pw[i]) && (i + 3) <= pw.length) {
                controlNumber = Character.getNumericValue(pw[i]);
                if (Character.isDigit(pw[i + 1]) && Character.getNumericValue(pw[i + 1]) == controlNumber) {
                    if (Character.isDigit(pw[i + 2]) && Character.getNumericValue(pw[i + 2]) == controlNumber) {
                        if ((i + 3) < pw.length && Character.isDigit(pw[i + 3]) && Character.getNumericValue(pw[i + 3]) == controlNumber) {
                            System.out.println(userPassword);
                            System.out.println("Password must NOT contain more than three same number in a row.");

                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}


