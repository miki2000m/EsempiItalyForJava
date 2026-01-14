package TipiPrimitivi;

/**
 * GUIDA ENCICLOPEDICA AI TIPI DI DATO PRIMITIVI IN JAVA
 *
 * Questo file è un laboratorio eseguibile che esplora in dettaglio le caratteristiche,
 * i limiti e i comportamenti specifici di ogni tipo di dato primitivo di Java.
 */
public class MainTipiPrimitivi {

    public static void main(String[] args) {
        System.out.println("--- GUIDA AI TIPI DI DATO PRIMITIVI ---\n");

        sezione1_TipiInteri();
        sezione2_TipiDecimali();
        sezione3_CharEBoolean();
    }

    private static void sezione1_TipiInteri() {
        System.out.println("--- 1. Tipi Numerici Interi ---");
        System.out.println("Spiegazione: I tipi interi memorizzano numeri senza parte decimale, con diverse dimensioni di memoria e range.\n");

        // --- byte (8 bit) ---
        System.out.println("A) byte:");
        System.out.println("   - Peso in Memoria: " + Byte.BYTES + " byte (" + Byte.SIZE + " bit)");
        System.out.println("   - Valore Minimo: " + Byte.MIN_VALUE);   // -128
        System.out.println("   - Valore Massimo: " + Byte.MAX_VALUE);  // 127
        
        // Dimostrazione di Overflow e Underflow
        byte bMax = 127;
        bMax++; // Aggiungendo 1 al valore massimo, "gira" e diventa il valore minimo.
        System.out.println("   - Overflow: 127 + 1 = " + bMax); // Stampa -128
        
        byte bMin = -128;
        bMin--; // Sottraendo 1 al valore minimo, "gira" e diventa il valore massimo.
        System.out.println("   - Underflow: -128 - 1 = " + bMin); // Stampa 127
        System.out.println();

        // --- int (32 bit) ---
        System.out.println("B) int (Il tipo intero di default):");
        System.out.println("   - Peso in Memoria: " + Integer.BYTES + " bytes (" + Integer.SIZE + " bit)");
        System.out.println("   - Valore Minimo: " + Integer.MIN_VALUE);
        System.out.println("   - Valore Massimo: " + Integer.MAX_VALUE);
        System.out.println();

        // --- long (64 bit) ---
        System.out.println("C) long (Per numeri molto grandi):");
        System.out.println("   - Peso in Memoria: " + Long.BYTES + " bytes (" + Long.SIZE + " bit)");
        System.out.println("   - Valore Minimo: " + Long.MIN_VALUE);
        System.out.println("   - Valore Massimo: " + Long.MAX_VALUE);
        long l = 9_000_000_000_000_000_000L; // Il suffisso 'L' è obbligatorio. Gli underscore sono per leggibilità.
        System.out.println("   - Esempio con underscore e suffisso L: " + l);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_TipiDecimali() {
        System.out.println("--- 2. Tipi Numerici a Virgola Mobile (Floating-Point) ---");
        System.out.println("Spiegazione: Usati per numeri con parte decimale. Hanno problemi di precisione intrinseci.\n");

        // --- float (32 bit, precisione singola) ---
        System.out.println("A) float:");
        System.out.println("   - Peso in Memoria: " + Float.BYTES + " bytes (" + Float.SIZE + " bit)");
        float f = 3.1415926535f; // Il suffisso 'f' è obbligatorio.
        System.out.println("   - Esempio con suffisso f: " + f); // Notare la perdita di precisione
        System.out.println();

        // --- double (64 bit, precisione doppia) - Il tipo decimale di default ---
        System.out.println("B) double:");
        System.out.println("   - Peso in Memoria: " + Double.BYTES + " bytes (" + Double.SIZE + " bit)");
        double d = 3.141592653589793;
        System.out.println("   - Esempio: " + d);
        System.out.println();

        // Problema di precisione
        System.out.println("C) Dimostrazione del problema di precisione:");
        double d1 = 0.1 + 0.1 + 0.1;
        double d2 = 0.3;
        System.out.println("   - `0.1 + 0.1 + 0.1` = " + d1);
        System.out.println("   - `0.3`             = " + d2);
        System.out.println("   - Sono uguali? (d1 == d2) -> " + (d1 == d2)); // Stampa false!
        System.out.println("   - Spiegazione: I numeri decimali non possono essere rappresentati perfettamente in binario, causando piccoli errori di arrotondamento.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_CharEBoolean() {
        System.out.println("--- 3. Tipi `char` e `boolean` ---");
        System.out.println("Spiegazione: `char` rappresenta un singolo carattere Unicode. `boolean` rappresenta un valore logico.\n");

        // --- char (16 bit, Unicode) ---
        System.out.println("A) char:");
        System.out.println("   - Peso in Memoria: " + Character.BYTES + " bytes (" + Character.SIZE + " bit)");
        char c1 = 'A';
        char c2 = '\u0041'; // 'A' rappresentato con il suo codice Unicode esadecimale
        System.out.println("   - Carattere letterale 'A': " + c1);
        System.out.println("   - Carattere da codice Unicode '\\u0041': " + c2);

        // Comportamento numerico
        char c3 = c1;
        c3++; // Incrementare un char passa al carattere successivo nella tabella Unicode
        System.out.println("   - Comportamento numerico: 'A' + 1 = " + c3); // Stampa 'B'
        int valoreNumericoA = c1;
        System.out.println("   - Valore numerico di 'A': " + valoreNumericoA); // Stampa 65
        System.out.println();

        // --- boolean (~1 bit) ---
        System.out.println("B) boolean:");
        System.out.println("   - Peso in Memoria: Non definito precisamente dalla specifica JVM (tipicamente 1 byte).");
        boolean condizione = true;
        boolean altraCondizione = (10 > 5);
        System.out.println("   - Valore letterale: " + condizione);
        System.out.println("   - Valore da espressione: " + altraCondizione);
        System.out.println("----------------------------------------");
    }
}
