package MODULO_1_BASI_E_CONTROLLO.AaVariabili;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * GUIDA A `var` - LOCAL VARIABLE TYPE INFERENCE
 *
 * Questo file è un tutorial eseguibile che spiega l'uso della keyword `var`,
 * introdotta in Java 10 per semplificare la dichiarazione delle variabili locali.
 */
public class MainVar {

    // ERRORE: `var` non può essere usato per i campi di una classe.
    // private var numeroCampo = 10;

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA KEYWORD `var` ---\n");

        System.out.println("--- 1. Uso di Base ---");
        System.out.println("Spiegazione: `var` permette al compilatore di 'inferire' (capire) il tipo di una variabile locale dal valore con cui viene inizializzata.\n" +
                "NON è un tipo dinamico come in JavaScript. Il tipo viene fissato al momento della compilazione.\n");

        // Dichiarazione tradizionale
        String testoTradizionale = "Ciao Mondo";

        // Dichiarazione con `var`
        var testoConVar = "Ciao Mondo";

        System.out.println("Variabile dichiarata con String: " + testoTradizionale);
        System.out.println("Variabile dichiarata con var:   " + testoConVar);
        System.out.println("Il tipo inferito per 'testoConVar' è: " + testoConVar.getClass().getName()); // Stampa java.lang.String

        var numero = 100; // Il tipo inferito è int
        System.out.println("\nIl tipo inferito per 'numero' è: " + ((Object)numero).getClass().getName()); // Stampa java.lang.Integer (dopo autoboxing)
        System.out.println("----------------------------------------\n");


        System.out.println("--- 2. Vantaggi: Migliorare la Leggibilità ---");
        System.out.println("Spiegazione: `var` è estremamente utile con tipi complessi e generici, riducendo il codice ripetitivo.\n");

        // Dichiarazione tradizionale verbosa
        HashMap<String, List<String>> mappaTradizionale = new HashMap<String, List<String>>();

        // Dichiarazione con `var`, molto più concisa e leggibile
        var mappaConVar = new HashMap<String, List<String>>();
        mappaConVar.put("frutti", new ArrayList<>());
        mappaConVar.get("frutti").add("Mela");

        System.out.println("Senza var: HashMap<String, List<String>> mappa = new HashMap<>();");
        System.out.println("Con var:   var mappa = new HashMap<String, List<String>>();");
        System.out.println("Contenuto della mappa: " + mappaConVar);
        System.out.println("----------------------------------------\n");


        System.out.println("--- 3. Regole e Limitazioni ---");
        System.out.println("Spiegazione: `var` ha delle regole precise.\n");

        // 1. Può essere usato solo per variabili locali (dentro un metodo o un blocco).
        System.out.println("1. `var` funziona solo per variabili locali.");

        // 2. Deve essere inizializzato sulla stessa riga della dichiarazione.
        // var x; // ERRORE DI COMPILAZIONE: Cannot infer type for local variable 'x'
        System.out.println("2. Una variabile `var` deve essere sempre inizializzata subito.");

        // 3. Non può essere inizializzato a `null`.
        // var y = null; // ERRORE DI COMPILAZIONE: Cannot infer type for local variable 'y'
        System.out.println("3. Non si può inizializzare una variabile `var` a `null`.");

        // 4. Non può essere usato per parametri di metodi o tipi di ritorno.
        System.out.println("4. `var` non può essere usato per parametri o tipi di ritorno di metodi.");
        System.out.println("----------------------------------------\n");


        System.out.println("--- 4. `var` con i Cicli ---");
        System.out.println("Spiegazione: `var` è molto comodo anche nei cicli for-each.\n");

        System.out.println("Iterazione di una mappa con `var`:");
        for (var entry : mappaConVar.entrySet()) {
            // Il tipo di 'entry' è inferito come Map.Entry<String, List<String>>
            System.out.println("  - Chiave: " + entry.getKey() + ", Valore: " + entry.getValue());
        }
        System.out.println("----------------------------------------");
    }

    // ERRORE: `var` non può essere usato come tipo di ritorno o per i parametri.
    /*
    public var mioMetodo(var parametro) {
        return "non valido";
    }
    */
}
