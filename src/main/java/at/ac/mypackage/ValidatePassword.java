package at.ac.mypackage;

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

    public boolean hasNumbers(String userPassword){
        return false;
    }

    public boolean hasAllowedSpecialCharacters(String userPassword){
        return false;
    }
}
