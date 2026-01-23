package MODULO_3_API_FONDAMENTALI.cHashMap;

// Importo HashSet e Set per gestire insiemi senza duplicati
import java.util.HashSet;
import java.util.Set;

// Import necessari per lavorare con liste
import java.util.Arrays;
import java.util.List;

public class MainHashSet {
    public static void main(String[] args) {

        // Negli HashSet gli elementi:
        // - NON sono ordinati
        // - NON hanno indice
        // - NON possono essere duplicati
        System.out.println("--- Esempio HashSet: proprietà principali ---");

        // 1) Creazione di un HashSet di String
        Set<String> frutti = new HashSet<>();

        // Aggiungo alcune stringhe al set
        frutti.add("mela");
        frutti.add("banana");
        frutti.add("arancia");
        frutti.add("mela");  // duplicato: NON verrà aggiunto di nuovo

        // Stampa il contenuto.
        // L’ordine NON è garantito (HashSet non ordina gli elementi)
        System.out.println("Contenuto frutti: " + frutti);

        // Stampa la dimensione (senza duplicati)
        System.out.println("Dimensione (senza duplicati): " + frutti.size());

        // Controlla se nel set c’è un elemento specifico
        System.out.println("Contiene 'banana'? " + frutti.contains("banana"));

        // Rimuove "arancia" dal set
        frutti.remove("arancia");

        // Stampa il set dopo la rimozione
        System.out.println("Dopo remove('arancia'): " + frutti);

        // Iterazione semplice del set con for-each
        System.out.print("Iterazione frutti: ");
        for (String s : frutti) System.out.print(s + " ");
        System.out.println();

        // 4) Esempio pratico: rimozione duplicati da una lista
        List<Integer> numeri = Arrays.asList(1, 2, 3, 2, 1, 4, 5);

        // Il Set rimuove automaticamente i duplicati
        Set<Integer> numeriSet = new HashSet<>(numeri);

        System.out.println("Lista numeri: " + numeri);
        System.out.println("Set creato dalla lista (duplicati rimossi): " + numeriSet);

        // 5) HashSet permette di inserire un singolo valore null
        Set<String> conNull = new HashSet<>();
        conNull.add(null);  // consentito
        conNull.add("x");

        // Stampa il set, includendo null
        System.out.println("HashSet con null: " + conNull);
    }
}
