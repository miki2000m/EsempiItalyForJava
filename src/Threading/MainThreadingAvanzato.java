package Threading;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * GUIDA AL THREADING AVANZATO IN JAVA
 *
 * Questo file è un tutorial eseguibile che illustra i moderni approcci alla concorrenza in Java.
 *
 * Argomenti trattati:
 * 1. ExecutorService: Per gestire pool di thread.
 * 2. Callable e Future: Per task che restituiscono un risultato.
 * 3. Classi Atomiche: Per gestire stato condiviso in modo thread-safe.
 * 4. Virtual Threads (da Java 21): Per una concorrenza massiva.
 */
public class MainThreadingAvanzato {

    public static void main(String[] args) throws Exception {
        System.out.println("--- GUIDA AL THREADING AVANZATO ---\n");

        sezione1_ExecutorService();
        sezione2_CallableEFuture();
        sezione3_ClassiAtomiche();
        sezione4_VirtualThreads();
    }

    private static void sezione1_ExecutorService() {
        System.out.println("--- 1. ExecutorService: Gestire Thread in un Pool ---");
        System.out.println("Spiegazione: Creare thread manualmente (`new Thread()`) è costoso. Un ExecutorService gestisce un 'pool' di thread riutilizzabili,\n" +
                "migliorando performance e gestione delle risorse.\n");

        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            System.out.println("Azione: Sottomissione di 5 task (Runnable) a un pool di 2 thread.");
            for (int i = 1; i <= 5; i++) {
                int taskNumero = i;
                executor.submit(() -> {
                    System.out.println("  -> Eseguo task " + taskNumero + " sul thread: " + Thread.currentThread().getName());
                    try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                    System.out.println("  <- Task " + taskNumero + " completato.");
                });
            }
        }
        System.out.println("Risultato: Tutti i task sono stati completati dai 2 thread del pool.\n");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_CallableEFuture() throws Exception {
        System.out.println("--- 2. Callable e Future: Task che Restituiscono Risultati ---");
        System.out.println("Spiegazione: `Runnable` non può restituire un valore. `Callable<V>` è un'interfaccia simile, ma il suo metodo `call()` può restituire un valore.\n" +
                "Quando sottometti un `Callable`, ottieni un `Future<V>` che rappresenta il risultato futuro dell'operazione.\n");

        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Callable<Long> calcoloFattoriale = () -> {
                System.out.println("  -> Inizio calcolo del fattoriale...");
                long risultato = 1;
                for (int i = 1; i <= 10; i++) {
                    risultato *= i;
                    Thread.sleep(100);
                }
                return risultato;
            };

            System.out.println("Azione: Sottomissione di un `Callable` per calcolare il fattoriale di 10.");
            Future<Long> risultatoFuturo = executor.submit(calcoloFattoriale);

            System.out.println("... Il thread main può fare altro mentre il calcolo è in corso...");

            System.out.println("Azione: Il thread main ora attende il risultato con `risultatoFuturo.get()`.");
            Long risultato = risultatoFuturo.get(); // Metodo bloccante: attende il risultato.

            System.out.println("Risultato: Il calcolo è terminato. Fattoriale di 10 = " + risultato);
        }
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_ClassiAtomiche() throws InterruptedException {
        System.out.println("--- 3. Classi Atomiche: Gestire Stato Condiviso in Sicurezza ---");
        System.out.println("Spiegazione: Quando più thread modificano una stessa variabile (es. un contatore), si possono avere errori (race conditions).\n" +
                "Le classi atomiche (es. `AtomicInteger`) forniscono operazioni 'atomiche' (indivisibili) e thread-safe, senza bisogno di blocchi `synchronized`.\n");

        // Usiamo un AtomicInteger come contatore condiviso.
        AtomicInteger contatoreAtomico = new AtomicInteger(0);

        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            System.out.println("Azione: 1000 task incrementano lo stesso contatore atomico.");

            // Sottomettiamo 1000 task, ognuno dei quali incrementa il contatore.
            for (int i = 0; i < 1000; i++) {
                executor.submit(() -> {
                    // `incrementAndGet()` è un'operazione atomica: legge, incrementa e scrive il valore
                    // come un'unica operazione indivisibile.
                    contatoreAtomico.incrementAndGet();
                });
            }
        }
        // Il try-with-resources si assicura che l'executor venga chiuso e attende la fine dei task.

        System.out.println("\nRisultato: Valore finale del contatore atomico = " + contatoreAtomico.get());
        System.out.println("Se il risultato è 1000, significa che non si è persa nessuna operazione di incremento, dimostrando la thread-safety.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione4_VirtualThreads() {
        System.out.println("--- 4. Virtual Threads (Java 21) ---");
        System.out.println("Spiegazione: I thread tradizionali ('Platform Threads') sono pesanti. I Virtual Threads sono estremamente leggeri e gestiti dalla JVM.\n" +
                "Questo permette di crearne milioni per gestire un numero enorme di task concorrenti (specialmente quelli I/O-bound).\n");

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            System.out.println("Azione: Sottomissione di 3 task a un executor che crea un virtual thread per ognuno.");

            IntStream.range(1, 4).forEach(i -> {
                executor.submit(() -> {
                    System.out.println("  -> Eseguo task " + i + " | È un virtual thread? " + Thread.currentThread().isVirtual() + " | Thread: " + Thread.currentThread());
                    try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
                });
            });
        }

        System.out.println("\nRisultato: Ogni task è stato eseguito su un virtual thread diverso, gestito in modo efficiente dalla JVM.");
        System.out.println("----------------------------------------");
    }
}
