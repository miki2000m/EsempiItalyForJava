package JDK_Utility_API.ObjectsClass;

import java.util.Objects;

/**
 * GUIDA ENCICLOPEDICA ALLA CLASSE `java.util.Objects`
 *
 * Questo file è un tutorial eseguibile che esplora le funzionalità della classe `Objects`,
 * una classe di utilità introdotta in Java 7 per operare sugli oggetti in modo sicuro,
 * specialmente per la gestione dei `null`.
 *
 * La classe `Objects` è `final` e non può essere istanziata. Tutti i suoi metodi sono `static`.
 */
public class MainObjects {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA CLASSE `Objects` ---\n");

        sezione1_GestioneNull();
        sezione2_ConfrontoSicuro();
        sezione3_HashCode();
    }

    private static void sezione1_GestioneNull() {
        System.out.println("--- 1. Gestione dei Valori `null` ---");
        System.out.println("Spiegazione: Questi metodi forniscono un modo standard e pulito per controllare e gestire i `null`.\n");

        String testoNonNull = "Java";
        String testoNull = null;

        // Objects.isNull(obj): Restituisce true se l'oggetto è null, altrimenti false.
        System.out.println("A) `Objects.isNull()`:");
        System.out.println("   - `Objects.isNull(testoNonNull)` -> " + Objects.isNull(testoNonNull)); // false
        System.out.println("   - `Objects.isNull(testoNull)`    -> " + Objects.isNull(testoNull));    // true
        System.out.println();

        // Objects.nonNull(obj): Il contrario di isNull().
        System.out.println("B) `Objects.nonNull()`:");
        System.out.println("   - `Objects.nonNull(testoNonNull)` -> " + Objects.nonNull(testoNonNull)); // true
        System.out.println();

        // Objects.requireNonNull(obj, "messaggio"): Lancia NullPointerException se l'oggetto è null.
        // È un modo standard per validare i parametri dei metodi (precondizioni).
        System.out.println("C) `Objects.requireNonNull()`:");
        try {
            String risultato = processaTesto(testoNonNull);
            System.out.println("   - Chiamata con oggetto non nullo: OK. Risultato: " + risultato);

            processaTesto(testoNull); // Questa chiamata lancerà l'eccezione
        } catch (NullPointerException e) {
            System.out.println("   - Chiamata con oggetto nullo ha lanciato correttamente l'eccezione:");
            System.out.println("     -> " + e.getMessage());
        }
        System.out.println("----------------------------------------\n");
    }

    // Metodo di esempio che usa requireNonNull per validare il suo input
    public static String processaTesto(String testo) {
        // Se 'testo' è null, questo metodo lancia subito una NullPointerException
        // con il messaggio fornito, impedendo al resto del metodo di essere eseguito.
        Objects.requireNonNull(testo, "Il testo non può essere nullo per essere processato.");
        return "Processato: " + testo.toUpperCase();
    }


    private static void sezione2_ConfrontoSicuro() {
        System.out.println("--- 2. Confronto Sicuro con `Objects.equals()` ---");
        System.out.println("Spiegazione: `a.equals(b)` lancia un `NullPointerException` se `a` è `null`.\n" +
                "`Objects.equals(a, b)` gestisce correttamente i `null`.\n");

        String s1 = "Java";
        String s2 = new String("Java");
        String s3 = null;

        System.out.println("A) Confronto tradizionale (rischioso):");
        System.out.println("   - `s1.equals(s2)` -> " + s1.equals(s2)); // true
        // System.out.println(s3.equals(s1)); // Se decommentato, lancia NullPointerException!

        System.out.println("\nB) Confronto sicuro con `Objects.equals()`:");
        System.out.println("   - `Objects.equals(s1, s2)` -> " + Objects.equals(s1, s2)); // true
        System.out.println("   - `Objects.equals(s1, s3)` -> " + Objects.equals(s1, s3)); // false (nessuna eccezione)
        System.out.println("   - `Objects.equals(s3, s1)` -> " + Objects.equals(s3, s1)); // false (nessuna eccezione)
        System.out.println("   - `Objects.equals(s3, s3)` -> " + Objects.equals(s3, null)); // true (nessuna eccezione)
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_HashCode() {
        System.out.println("--- 3. Calcolo dell'Hash Code ---");
        System.out.println("Spiegazione: Metodi di utilità per calcolare l'hash code, gestendo i `null`.\n");

        String str = "test";
        String strNull = null;

        // Objects.hashCode(obj): Restituisce l'hash code dell'oggetto, o 0 se l'oggetto è null.
        System.out.println("A) `Objects.hashCode()` per un singolo oggetto:");
        System.out.println("   - Hash code di '" + str + "': " + Objects.hashCode(str));
        System.out.println("   - Hash code di `null`: " + Objects.hashCode(strNull)); // Restituisce 0
        System.out.println();

        // Objects.hash(values...): Calcola un hash code combinando più oggetti.
        // È il modo standard e corretto per implementare il metodo hashCode() in una classe.
        System.out.println("B) `Objects.hash()` per più oggetti:");
        int hashCombinato = Objects.hash("Java", 21, true);
        System.out.println("   - Hash code combinato di (\"Java\", 21, true): " + hashCombinato);
        System.out.println("----------------------------------------");
    }
}
