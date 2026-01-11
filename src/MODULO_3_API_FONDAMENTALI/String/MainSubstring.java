package MODULO_3_API_FONDAMENTALI.String;

public class MainSubstring {
    public static void main(String[] args) {
        String email= "michaelCosio2008@gmail.com";

        //.substring(x,y)
        //x = start point
        //y = Finish point
        //prende tutto quello che c'è dopo di x ma prima di y
        String userName= email.substring(0,email.indexOf("@"));
        System.out.printf("email.substring(0,email.indexOf('@'): %s",userName);

        String indirizzo= email.substring(email.indexOf('@')+1);
        System.out.println("\nemail.substring(email.indexOf('@'): "+indirizzo);
    }
}
