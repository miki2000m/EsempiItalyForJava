package MODULO_1_BASI_E_CONTROLLO.eScannerInput;

import java.util.*;

public class MainScanner {
    //creo l'oggetto scanner che ha bisogno della libreria java.util
    private static final Scanner input = new Scanner(System.in);

    //variabili
    private static String nome;
    private static String cognome;
    private static int anni;
    private static String citta;

    public static void main(String[] args) {
        System.out.println("Questo esempio spiega la funzione di scanner (cioè input inserito nel terminale)\n");

        //stampo che cosa voglio che venga in serito all'interno del terminale
        System.out.print("Qual'è il tuo nome: ");

        //associo alla variabile nome ciò che verrà inserito dopo il print
        nome = input.nextLine();

        //stampo il dato inserito all'interno della variabile nome
        System.out.printf("\nQuesto è il nome inserito: %s\n",nome);

        System.out.print("\nQual'è il tuo cognome: ");
        cognome = input.nextLine();

        System.out.printf("\nQuesto è il congome inserito: %s\n",cognome);

        System.out.print("\nQuanti anni hai: ");
        anni = input.nextInt();

        System.out.printf("\nQuesti sono gli anni inseriti %d",anni);

        //svuoto il buffer
        input.nextLine();

        System.out.print("\nIn che città vivi: ");
        citta = input.nextLine();

        System.out.printf("\nQuesta è la citta inserita: %s\n ",citta);


        //chiudiamo gli input
        input.close();
    }
}
