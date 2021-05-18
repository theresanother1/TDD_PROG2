package at.ac.mypackage;

public class App {
    public static void main (String[] args){
        ValidatePassword pw = new ValidatePassword();

        pw.hasAllowedSpecialCharacters("nospecialchars");
        pw.hasAllowedSpecialCharacters("%/@()#$?><!");
    }
}
