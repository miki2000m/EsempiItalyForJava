package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.VariabiliAtomiche;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * GUIDA ALLE VARIABILI ATOMICHE
 *
 * Questo file è un tutorial eseguibile che dimostra l'importanza e l'uso
 * delle classi atomiche (es. `AtomicInteger`) per gestire lo stato condiviso
 * in un ambiente multi-threaded in modo sicuro ed efficiente.
 */
public class MainVariabiliAtomiche {

    // --- Scenario 1: Il Problema (Race Condition) ---
    private static int contatoreStandard = 0;

    // --- Scenario 2: La Soluzione (Variabile Atomica) ---
    // AtomicInteger è una classe che incapsula un valore `int` e fornisce
    // operazioni atomiche su di esso, come l'incremento.
    private static AtomicInteger contatoreAtomico = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- GUIDA ALLE VARIABILI ATOMICHE ---\n");

        sezione1_IlProblemaDellaRaceCondition();
        sezione2_LaSoluzioneConAtomicInteger();
        sezione3_OperazioniAvanzate();
    }

    private static void sezione1_IlProblemaDellaRaceCondition() throws InterruptedException {
        System.out.println("--- 1. Il Problema: Race Condition con un `int` primitivo ---");
        System.out.println("Spiegazione: Avviamo 1000 thread e ognuno incrementa un contatore `int` condiviso per 1000 volte.\n" +
                "L'operazione `contatore++` non è atomica: è una sequenza di 'leggi-modifica-scrivi'.\n" +
                "Se due thread leggono lo stesso valore prima che l'altro abbia scritto il nuovo, un incremento andrà perso.\n");

        // Usiamo un ExecutorService per gestire un pool di thread
        ExecutorService executor = Executors.newFixedThreadPool(10);

        int numeroIncrementi = 1000;
        for (int i = 0; i < numeroIncrementi; i++) {
            executor.submit(() -> contatoreStandard++);
        }

        // Attendiamo la fine di tutti i task
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Azione: 1000 thread hanno incrementato un `int` standard.");
        System.out.println("Risultato Atteso: " + numeroIncrementi);
        System.out.println("Risultato Ottenuto: " + contatoreStandard);
        System.out.println("Conclusione: Il risultato è quasi sempre INFERIORE a 1000 a causa delle race condition.\n");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_LaSoluzioneConAtomicInteger() throws InterruptedException {
        System.out.println("--- 2. La Soluzione: `AtomicInteger` ---");
        System.out.println("Spiegazione: Ripetiamo l'esperimento usando `AtomicInteger`. Il suo metodo `incrementAndGet()`\n" +
                "è un'operazione atomica, garantita per essere eseguita come un singolo blocco indivisibile.\n");

        ExecutorService executor = Executors.newFixedThreadPool(10);

        int numeroIncrementi = 1000;
        for (int i = 0; i < numeroIncrementi; i++) {
            executor.submit(() -> contatoreAtomico.incrementAndGet());
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Azione: 1000 thread hanno incrementato un `AtomicInteger`.");
        System.out.println("Risultato Atteso: " + numeroIncrementi);
        System.out.println("Risultato Ottenuto: " + contatoreAtomico.get());
        System.out.println("Conclusione: Il risultato è sempre 1000, dimostrando la thread-safety.\n");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_OperazioniAvanzate() {
        System.out.println("--- 3. Altre Operazioni Atomiche Utili ---");
        System.out.println("Spiegazione: Le classi atomiche offrono diversi metodi utili per la programmazione concorrente.\n");

        AtomicInteger valore = new AtomicInteger(10);

        // getAndSet(): Imposta un nuovo valore e restituisce quello vecchio.
        int vecchioValore = valore.getAndSet(20);
        System.out.println("Azione: `getAndSet(20)`");
        System.out.println("  - Valore precedente: " + vecchioValore); // 10
        System.out.println("  - Valore attuale: " + valore.get());      // 20
        System.out.println();

        // compareAndSet(expect, update): Operazione "Compare-and-Swap" (CAS).
        // Se il valore attuale è uguale a `expect`, lo imposta a `update` e restituisce `true`.
        // Altrimenti, non fa nulla e restituisce `false`. È il mattone fondamentale della concorrenza non bloccante.
        System.out.println("Azione: `compareAndSet(20, 30)` (avrà successo)");
        boolean successo = valore.compareAndSet(20, 30);
        System.out.println("  - Operazione riuscita? " + successo);
        System.out.println("  - Valore attuale: " + valore.get());
        System.out.println();

        System.out.println("Azione: `compareAndSet(10, 40)` (fallirà)");
        successo = valore.compareAndSet(10, 40); // Fallisce perché il valore attuale è 30, non 10.
        System.out.println("  - Operazione riuscita? " + successo);
        System.out.println("  - Valore attuale: " + valore.get());
        System.out.println("----------------------------------------");
    }
}
