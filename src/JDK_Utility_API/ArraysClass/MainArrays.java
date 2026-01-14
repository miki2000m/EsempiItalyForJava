package JDK_Utility_API.ArraysClass;

import java.util.Arrays;
import java.util.List;

/**
 * GUIDA ENCICLOPEDICA ALLA CLASSE `java.util.Arrays`
 *
 * Questo file è un tutorial eseguibile che esplora le funzionalità della classe `Arrays`,
 * una classe di utilità che contiene metodi statici per manipolare gli array
 * (ordinamento, ricerca, confronto, ecc.).
 */
public class MainArrays {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA CLASSE `Arrays` ---\n");

        sezione1_Ordinamento();
        sezione2_Ricerca();
        sezione3_Confronto();
        sezione4_RiempimentoECopia();
        sezione5_RappresentazioneEConversione();
    }

    private static void sezione1_Ordinamento() {
        System.out.println("--- 1. Ordinamento di Array (`sort`) ---");
        System.out.println("Spiegazione: `Arrays.sort()` ordina un array 'in-place' (modifica l'array originale).\n");

        int[] numeri = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println("  Array originale: " + Arrays.toString(numeri));

        // Arrays.sort(array): Ordina l'intero array.
        Arrays.sort(numeri);
        System.out.println("  Array dopo `Arrays.sort()`: " + Arrays.toString(numeri));

        String[] parole = {"Java", "Python", "C++", "JavaScript"};
        Arrays.sort(parole);
        System.out.println("  Array di stringhe ordinato: " + Arrays.toString(parole));
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_Ricerca() {
        System.out.println("--- 2. Ricerca in Array (`binarySearch`) ---");
        System.out.println("Spiegazione: `Arrays.binarySearch()` esegue una ricerca binaria, che è molto efficiente (O(log n)).\n" +
                "ATTENZIONE: L'array DEVE essere ordinato prima di usare questo metodo!\n");

        int[] numeriOrdinati = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        // Cerca il valore 7 nell'array.
        int indice = Arrays.binarySearch(numeriOrdinati, 7);
        System.out.println("  Ricerca di '7' in " + Arrays.toString(numeriOrdinati));
        System.out.println("  -> Risultato: L'elemento è stato trovato all'indice " + indice);

        // Cerca un valore non presente.
        int indiceNonPresente = Arrays.binarySearch(numeriOrdinati, 10);
        System.out.println("\n  Ricerca di '10' (non presente)...");
        System.out.println("  -> Risultato: " + indiceNonPresente);
        System.out.println("  Spiegazione del risultato negativo: Se l'elemento non viene trovato, restituisce `(-(punto di inserimento) - 1)`.");
        System.out.println("    Il 'punto di inserimento' per 10 sarebbe l'indice 9. Quindi, `(-9 - 1) = -10`.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_Confronto() {
        System.out.println("--- 3. Confronto di Array (`equals` e `compare`) ---");
        System.out.println("Spiegazione: Metodi per confrontare il contenuto di due array.\n");

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {3, 2, 1};

        // Arrays.equals(arr1, arr2): Confronta il contenuto degli array.
        // Restituisce true se gli array hanno la stessa lunghezza e tutti gli elementi sono uguali e nello stesso ordine.
        boolean sonoUguali = Arrays.equals(arr1, arr2);
        System.out.println("  - `Arrays.equals(arr1, arr2)` -> " + sonoUguali); // true

        boolean sonoUguali2 = Arrays.equals(arr1, arr3);
        System.out.println("  - `Arrays.equals(arr1, arr3)` -> " + sonoUguali2); // false
        System.out.println();

        // Arrays.compare(arr1, arr3): Confronta gli array lessicograficamente.
        // Restituisce < 0 se il primo array è "minore", 0 se sono uguali, > 0 se è "maggiore".
        int confronto = Arrays.compare(arr1, arr3);
        System.out.println("  - `Arrays.compare(arr1, arr3)` -> " + confronto + " (negativo perché 1 è minore di 3 al primo elemento diverso)");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione4_RiempimentoECopia() {
        System.out.println("--- 4. Riempimento e Copia di Array ---");
        System.out.println("Spiegazione: Metodi per inizializzare o copiare array.\n");

        // Arrays.fill(array, valore): Riempie l'intero array con un valore specifico.
        int[] arrayDaRiempire = new int[5];
        System.out.println("  Array prima di `fill`: " + Arrays.toString(arrayDaRiempire));
        Arrays.fill(arrayDaRiempire, 42);
        System.out.println("  Array dopo `Arrays.fill(array, 42)`: " + Arrays.toString(arrayDaRiempire));
        System.out.println();

        // Arrays.copyOf(original, newLength): Crea una copia di un array.
        int[] originale = {1, 2, 3};
        System.out.println("  Array originale: " + Arrays.toString(originale));
        
        int[] copia = Arrays.copyOf(originale, 5); // Copia e allunga l'array
        System.out.println("  Copia allungata con `copyOf(originale, 5)`: " + Arrays.toString(copia));
        
        int[] copiaTroncata = Arrays.copyOf(originale, 2); // Copia e tronca l'array
        System.out.println("  Copia troncata con `copyOf(originale, 2)`: " + Arrays.toString(copiaTroncata));
        System.out.println("----------------------------------------\n");
    }

    private static void sezione5_RappresentazioneEConversione() {
        System.out.println("--- 5. Rappresentazione e Conversione ---");
        System.out.println("Spiegazione: Metodi per ottenere una rappresentazione testuale o per convertire un array.\n");

        String[] nomi = {"Anna", "Marco", "Luca"};

        // Arrays.toString(array): Restituisce una rappresentazione leggibile dell'array.
        // È il metodo più comune per stampare il contenuto di un array 1D.
        System.out.println("  - `Arrays.toString()`: " + Arrays.toString(nomi));

        // Arrays.deepToString(array): Per array multidimensionali.
        String[][] matrix = {{"a", "b"}, {"c", "d"}};
        System.out.println("  - `Arrays.deepToString()` per array 2D: " + Arrays.deepToString(matrix));
        System.out.println();

        // Arrays.asList(elementi...): Converte una sequenza di elementi (o un array) in una List.
        // ATTENZIONE: La lista restituita è a dimensione fissa! Non si possono aggiungere o rimuovere elementi.
        List<String> lista = Arrays.asList(nomi);
        System.out.println("  - Lista creata con `Arrays.asList()`: " + lista);
        // lista.add("Giulia"); // Se decommentato, lancia UnsupportedOperationException
        System.out.println("----------------------------------------");
    }
}
