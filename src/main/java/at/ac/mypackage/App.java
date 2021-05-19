package at.ac.mypackage;

public class App {
    public static void main (String[] args){
        ValidatePassword pw = new ValidatePassword();

        pw.hasAllowedSpecialCharacters("nospecialchars");
        pw.checkForDescendingNumbers("%/567@()#soA$43");
        pw.hasLessThanThreeSameNumbersInRow("%/567@()#soA1111");
    }
}
