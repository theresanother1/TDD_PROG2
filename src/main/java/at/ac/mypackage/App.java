package at.ac.mypackage;

public class App {
    public static void main (String[] args){
        ValidatePassword pw = new ValidatePassword();


        pw.checkPassword("niCe47#?One");

        pw.checkPassword("wRong#@234");
        pw.checkPassword("wRong#@765");
        pw.checkPassword("no4SpecIal67");
        pw.checkPassword("s(Hor5t");
        pw.checkPassword("Way#89To0LoooooongPa34()?1");
        pw.checkPassword("SholDbeWR0%1111");
    }
}
