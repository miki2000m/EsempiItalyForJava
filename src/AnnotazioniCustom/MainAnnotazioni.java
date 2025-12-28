package AnnotazioniCustom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * GUIDA ALLE ANNOTAZIONI CUSTOM IN JAVA
 *
 * Questo file è un tutorial eseguibile che spiega come creare e utilizzare le proprie annotazioni personalizzate.
 * Le annotazioni sono una forma di metadati: forniscono informazioni aggiuntive sul codice
 * che possono essere lette e usate da altri strumenti o dal programma stesso a runtime.
 */

// --- 1. DEFINIRE UN'ANNOTAZIONE CUSTOM ---

// Per creare un'annotazione, si usa la keyword `@interface`.
// Vengono usate delle "meta-annotazioni" per configurare come la nostra annotazione deve comportarsi.

// @Retention: Specifica "fino a quando" l'annotazione deve essere mantenuta.
// - RetentionPolicy.SOURCE: L'annotazione viene scartata dal compilatore. Utile per analisi statica.
// - RetentionPolicy.CLASS: L'annotazione è nel file .class, ma non è disponibile a runtime. (Default)
// - RetentionPolicy.RUNTIME: L'annotazione è disponibile a runtime e può essere letta tramite Reflection.
@Retention(RetentionPolicy.RUNTIME)

// @Target: Specifica "dove" l'annotazione può essere applicata.
// - ElementType.TYPE: Su classi, interfacce, enum.
// - ElementType.METHOD: Su metodi.
// - ElementType.FIELD: Su campi (variabili d'istanza).
// - ElementType.CONSTRUCTOR: Su costruttori.
// Si possono specificare più target: @Target({ElementType.METHOD, ElementType.TYPE})
@Target(ElementType.METHOD)

@interface TestEseguibile {
    // Un'annotazione può avere "elementi", che sono dichiarati come metodi.
    String nomeTest() default "Test Generico";
    int priorita() default 3;
}


// --- 2. APPLICARE L'ANNOTAZIONE ---

class IMieiTest { // NOME DELLA CLASSE CORRETTO

    @TestEseguibile(nomeTest = "Test di Connessione", priorita = 1)
    public void testConnessioneDatabase() {
        System.out.println("Eseguendo il test di connessione...");
    }

    // Se non specifichiamo i valori, vengono usati quelli di default.
    @TestEseguibile
    public void testCalcoloMatematico() {
        System.out.println("Eseguendo il test di calcolo...");
    }

    // Questo metodo non ha l'annotazione, quindi verrà ignorato dal nostro "runner".
    public void metodoNormale() {
        System.out.println("Questo è un metodo normale.");
    }
}


public class MainAnnotazioni {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLE ANNOTAZIONI CUSTOM ---\n");
        System.out.println("Scopo: Creare un semplice 'Test Runner' che esegua solo i metodi marcati con @TestEseguibile.\n");

        // --- 3. PROCESSARE LE ANNOTAZIONI A RUNTIME (usando la Reflection) ---

        // Otteniamo l'oggetto Class della classe che vogliamo ispezionare.
        Class<IMieiTest> classeDaTestare = IMieiTest.class; // NOME CLASSE CORRETTO
        IMieiTest istanzaTest = new IMieiTest(); // NOME CLASSE CORRETTO

        System.out.println("--- Avvio del Test Runner ---");
        // Iteriamo su tutti i metodi dichiarati nella classe.
        for (Method metodo : classeDaTestare.getDeclaredMethods()) {

            // Controlliamo se il metodo corrente ha l'annotazione @TestEseguibile.
            if (metodo.isAnnotationPresent(TestEseguibile.class)) {

                // Se presente, otteniamo l'oggetto annotazione per leggere i suoi valori.
                TestEseguibile infoTest = metodo.getAnnotation(TestEseguibile.class);

                System.out.println("\nTrovato metodo di test: " + metodo.getName());
                System.out.println("  - Nome del Test: " + infoTest.nomeTest());
                System.out.println("  - Priorità: " + infoTest.priorita());

                try {
                    // Eseguiamo il metodo sull'istanza della classe.
                    System.out.print("  - Esecuzione: ");
                    metodo.invoke(istanzaTest);
                } catch (Exception e) {
                    System.err.println("Errore durante l'esecuzione del test: " + e.getCause());
                }
            }
        }
        System.out.println("\n--- Fine del Test Runner ---");
        System.out.println("\nIl 'metodoNormale' è stato ignorato perché non aveva l'annotazione.");
    }
}
