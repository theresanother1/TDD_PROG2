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
        return checkedPassword;
    }
}
