package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.ManipolazioneBit;

import java.util.BitSet;

/**
 * GUIDA ALLA MANIPOLAZIONE DEI BIT IN JAVA
 *
 * Questo file è un laboratorio eseguibile che esplora i due modi principali
 * per lavorare con i singoli bit in Java:
 * 1. Operatori Bitwise: Per manipolazioni dirette su tipi primitivi interi.
 * 2. La classe `java.util.BitSet`: Per gestire insiemi di bit in modo dinamico.
 */
public class MainManipolazioneBit {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA MANIPOLAZIONE DEI BIT ---\n");

        sezione1_OperatoriBitwise();
        sezione2_BitSet();
    }

    private static void sezione1_OperatoriBitwise() {
        System.out.println("--- 1. Operatori Bitwise su Tipi Primitivi ---");
        System.out.println("Spiegazione: Questi operatori lavorano direttamente sulla rappresentazione binaria dei numeri interi.\n");

        // Usiamo i byte per semplicità (8 bit).
        // 5  in binario = 0000 0101
        // 3  in binario = 0000 0011
        byte a = 5;
        byte b = 3;

        System.out.println("Valori iniziali: a = 5 (0101), b = 3 (0011)\n");

        // AND (&): Imposta un bit a 1 solo se entrambi i bit corrispondenti sono 1.
        //   0000 0101 (a)
        // & 0000 0011 (b)
        // -----------
        //   0000 0001 (risultato = 1)
        System.out.println("A) AND (&): a & b = " + (a & b));

        // OR (|): Imposta un bit a 1 se almeno uno dei due bit corrispondenti è 1.
        //   0000 0101 (a)
        // | 0000 0011 (b)
        // -----------
        //   0000 0111 (risultato = 7)
        System.out.println("B) OR (|): a | b = " + (a | b));

        // XOR (^): Imposta un bit a 1 se i due bit corrispondenti sono diversi.
        //   0000 0101 (a)
        // ^ 0000 0011 (b)
        // -----------
        //   0000 0110 (risultato = 6)
        System.out.println("C) XOR (^): a ^ b = " + (a ^ b));

        // NOT (~): Inverte tutti i bit (complemento a uno).
        // ~ 0000 0101 (a)
        // -----------
        //   1111 1010 (risultato = -6 in complemento a due)
        System.out.println("D) NOT (~): ~a = " + (~a));
        System.out.println();

        // SHIFT (Spostamento di bit)
        // 12 in binario = 0000 1100
        byte c = 12;
        System.out.println("Valore per lo shift: c = 12 (0000 1100)\n");

        // Left Shift (<<): Sposta i bit a sinistra, riempiendo con 0 a destra. Equivale a moltiplicare per 2.
        // 0000 1100 << 1  ->  0001 1000 (risultato = 24)
        System.out.println("E) Left Shift (<<): c << 1 = " + (c << 1));

        // Right Shift (>>): Sposta i bit a destra. Mantiene il bit del segno (il più a sinistra).
        // 0000 1100 >> 2  ->  0000 0011 (risultato = 3)
        System.out.println("F) Right Shift (>>): c >> 2 = " + (c >> 2));

        // Unsigned Right Shift (>>>): Sposta i bit a destra, riempiendo sempre con 0 a sinistra.
        // Utile per numeri negativi, per trattarli come se non avessero segno.
        byte neg = -8; // 1111 1000
        System.out.println("G) Unsigned Right Shift (>>>) su -8: " + (neg >>> 1));
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_BitSet() {
        System.out.println("--- 2. La Classe `java.util.BitSet` ---");
        System.out.println("Spiegazione: `BitSet` è una classe che rappresenta un array di bit a dimensione dinamica.\n" +
                "È ottimizzata per lo spazio e per le operazioni logiche su insiemi di flag.\n");

        // Creiamo due BitSet
        BitSet bs1 = new BitSet(8); // Capacità iniziale di 8 bit
        BitSet bs2 = new BitSet(8);

        // Impostiamo alcuni bit (flag) usando set(indice)
        bs1.set(1); // Imposta il bit all'indice 1 a true (1)
        bs1.set(3);
        bs1.set(5);
        System.out.println("A) BitSet 1 dopo set(1), set(3), set(5): " + bs1); // Stampa {1, 3, 5}

        bs2.set(3);
        bs2.set(6);
        System.out.println("   BitSet 2 dopo set(3), set(6): " + bs2);
        System.out.println();

        // Operazioni logiche
        // AND: Mantiene solo i bit che sono a 1 in entrambi i set.
        BitSet bsAnd = (BitSet) bs1.clone();
        bsAnd.and(bs2);
        System.out.println("B) bs1 AND bs2: " + bsAnd); // {3}

        // OR: Unisce i bit che sono a 1 in almeno uno dei due set.
        BitSet bsOr = (BitSet) bs1.clone();
        bsOr.or(bs2);
        System.out.println("C) bs1 OR bs2: " + bsOr); // {1, 3, 5, 6}
        System.out.println();

        // Altre operazioni utili
        System.out.println("D) Altre operazioni:");
        // get(indice): Controlla lo stato di un bit.
        System.out.println("   - bs1.get(3) -> " + bs1.get(3)); // true
        System.out.println("   - bs1.get(4) -> " + bs1.get(4)); // false

        // flip(indice): Inverte lo stato di un bit.
        bs1.flip(5);
        System.out.println("   - bs1 dopo flip(5): " + bs1); // {1, 3}

        // clear(indice): Imposta un bit a false (0).
        bs1.clear(1);
        System.out.println("   - bs1 dopo clear(1): " + bs1); // {3}
        System.out.println("----------------------------------------");
    }
}
