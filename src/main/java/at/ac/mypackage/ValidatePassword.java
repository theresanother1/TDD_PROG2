package at.ac.mypackage;

import java.util.Locale;
import java.util.Scanner;

public class ValidatePassword {
    private String myPassword;

    public ValidatePassword(){}
    public ValidatePassword(String userPassword){
        this.myPassword = userPassword;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }

    public boolean checkPassword(String userPassword){
        boolean checkedPassword =false;
        if (hasUpperAndLowerCases(userPassword) && checkValidLength(userPassword)
                && hasNumbers(userPassword) && hasAllowedSpecialCharacters(userPassword)){
            checkedPassword = true;
        }

        return checkedPassword;
    }

    public boolean checkValidLength (String userPassword){
        boolean valid =false;
        if (userPassword == null){
            throw new IllegalArgumentException("Password should not be NULL.");
        }
        if (userPassword.length() > 8 && userPassword.length() < 25){
            valid = true;
        }
        return valid;
    }
    public boolean hasUpperAndLowerCases(String userPassword){
        boolean valid = true;
        int upperCaseCheck = 0;
        for (int i = 0; i < userPassword.length(); i++){
            if (Character.isUpperCase(userPassword.charAt(i))){
                upperCaseCheck++;
            }
        }
        if (upperCaseCheck == 0 || upperCaseCheck == userPassword.length()){
            valid = false;
        }
        return valid;
    }

    /**
     *
     *TODO: implement hasLetters -> check for String to contain letters
     * at least one lower & one upper case
     */
    public boolean hasLetters(String userPassword){
        boolean valid = false;
        boolean upper = false, lower = false;
        char[] pw = userPassword.toCharArray();
        for (char c:pw){
            if(Character.isUpperCase(c)){
                upper = true;
            }
            if (Character.isLowerCase(c)){
                lower = true;
            }
            if (lower && upper){
                valid = true;
                break;
            }
        }
        return valid;
    }

    public boolean hasNumbers(String userPassword){
        boolean valid = false;
        char[] pw = userPassword.toCharArray();
        for (char c:pw){
            if(Character.isDigit(c)){
                valid = true;
                break;
            }
        }
        return valid;
    }

    public boolean hasAllowedSpecialCharacters(String userPassword){
        boolean valid = false;

        String checkForSymbols = "";
        checkForSymbols = userPassword.toLowerCase().replaceAll("[()#$?!%/@]+", "");
        System.out.println(checkForSymbols);
        if (checkForSymbols.equals(userPassword)){
            return valid;
        }
        if (!checkForSymbols.equals("")){
            checkForSymbols = checkForSymbols.toLowerCase().replaceAll("[a-z0-9]+", "");
            if (checkForSymbols.equals("")){
                valid = true;
            }
        }
        return valid;
    }
}
