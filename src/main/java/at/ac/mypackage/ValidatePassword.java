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
        if (userPassword.length() > 8 && userPassword.length() < 25){
            checkedPassword = true;
        }
        int upperCaseCheck = 0;
        for (int i = 0; i < userPassword.length(); i++){
            if (Character.isUpperCase(userPassword.charAt(i))){
                upperCaseCheck++;
            }
        }
        if (upperCaseCheck == 0 || upperCaseCheck == userPassword.length()){
            checkedPassword = false;
        }
        return checkedPassword;
    }
}
