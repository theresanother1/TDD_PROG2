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

    public boolean checkForAscendingNumbers(String userPassword){
            char[] pw = userPassword.toCharArray();
            int firstNumber, secNumber, thirdNumber;
            for (int i = 0; i < pw.length; i++){
                if(Character.isDigit(pw[i])){
                    firstNumber = Character.getNumericValue(pw[i]);
                    if(Character.isDigit(pw[i+1])){
                        secNumber = Character.getNumericValue(pw[i+1]);
                        if(Character.isDigit(pw[i+2]) && secNumber-firstNumber == 1){
                            thirdNumber = Character.getNumericValue(pw[i+2]);
                            if(thirdNumber-secNumber == 1){
                               return false;
                               // break;
                            }

                        }
                    }
                }
            }
            return true;
    }

    public boolean checkForDescendingNumbers(String userPassword){
        char[] pw = userPassword.toCharArray();
        int firstNumber, secNumber, thirdNumber;
        for (int i = 0; i < pw.length; i++){
            if(Character.isDigit(pw[i])){
                firstNumber = Character.getNumericValue(pw[i]);
                if(Character.isDigit(pw[i+1])){
                    secNumber = Character.getNumericValue(pw[i+1]);
                    if(Character.isDigit(pw[i+2]) && firstNumber-secNumber == 1){
                        thirdNumber = Character.getNumericValue(pw[i+2]);
                        if(secNumber-thirdNumber == 1){
                            return false;
                        }

                    }
                }
            }
        }
        return true;
    }
}
