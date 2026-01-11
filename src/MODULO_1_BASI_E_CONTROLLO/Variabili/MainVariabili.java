package MODULO_1_BASI_E_CONTROLLO.Variabili;

public class MainVariabili {
    public static void main(String[] args){
        //Le variabili lì possiamo vedere come contenitori
        //e ogni tipo di variabile fa da contenitore specifico

        //Ci sono i valori numerici
        //Valori interi
        int interi=15;//Questo tipo di dato ha un limite di numero massimo
        long interiPlus=15;//Questo tipo di date è come un int ma ha un limite massimo molto più grande quindi è il PlusUltra dell'int

        //Valori decimali
        double decimali=3.14;
        float decimaliPlus=3.14f;

        //Ci sono valori boolean cioè valore che possono assumere un valore true(vero) o false(falso)
        boolean varBoolean=true;

        //Ci sono variabili che contendono del testo o dei caratteri
        //Insieme di caratteri
        String testo="Ciao io sono un testo semplice";
        String bloccoTesto= """
                Ciao io sono un Paragrago
                Quindi posso andare a capo senza il back slash
                """;

        //carattere singolo
        char carattere='A';//Il char funziona sia come numero che come carattere che come numero
    }
}
