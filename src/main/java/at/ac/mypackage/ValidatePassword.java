package at.ac.mypackage;

import java.util.Scanner;
import java.util.regex.*;

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
        return false;
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
        Scanner scanner = new Scanner(userPassword);
        String pw = scanner.findInLine("[^()#$?!%/@]");
        if (pw == null){
            valid = true;
        }
       /* char[] pw = userPassword.toCharArray();
        int specialValues=0;

        for (char c:pw){
            if (c == '(' || c==')'||c=='#'||c=='$'||
                    c=='?'||c=='!'||c=='%'||c=='/'||c=='@'){
                specialValues++;
            }
        }
        if (specialValues>0){
            valid = true;
        }*/
        return valid;
    }
}
