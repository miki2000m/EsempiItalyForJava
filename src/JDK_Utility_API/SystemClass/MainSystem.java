package JDK_Utility_API.SystemClass;

import java.util.Map;
import java.util.Properties;

/**
 * GUIDA ENCICLOPEDICA ALLA CLASSE `java.lang.System`
 *
 * Questo file è un tutorial eseguibile che esplora le funzionalità principali
 * della classe `System`, una delle classi fondamentali del JDK.
 *
 * La classe `System` è `final` e non può essere istanziata. Tutti i suoi
 * membri e metodi sono `static`.
 */
public class MainSystem {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA CLASSE `System` ---\n");

        sezione1_StandardStreams();
        sezione2_ProprietaDiSistema();
        sezione3_VariabiliDAmbiente();
        sezione4_Timing();
        sezione5_ControlloJVM();
    }

    private static void sezione1_StandardStreams() {
        System.out.println("--- 1. Standard I/O Streams ---");
        System.out.println("Spiegazione: La classe `System` fornisce tre stream statici predefiniti.\n");

        // System.out: Lo stream di output standard. Solitamente la console.
        System.out.println("  - Questo messaggio è stampato tramite `System.out`.");

        // System.err: Lo stream di errore standard. Solitamente la console, ma può essere rediretto.
        // Spesso visualizzato in rosso negli IDE.
        System.err.println("  - Questo messaggio di errore è stampato tramite `System.err`.");

        // System.in: Lo stream di input standard. Solitamente la tastiera.
        // Viene usato da classi come `Scanner` per leggere l'input dell'utente.
        System.out.println("  - `System.in` è lo stream usato da `Scanner` per leggere dalla tastiera.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_ProprietaDiSistema() {
        System.out.println("--- 2. Proprietà di Sistema (`System.getProperty`) ---");
        System.out.println("Spiegazione: Le proprietà di sistema sono informazioni sulla configurazione della JVM e dell'ambiente di esecuzione.\n");

        // Ottenere una singola proprietà
        String versioneJava = System.getProperty("java.version");
        System.out.println("  - Versione Java (da `java.version`): " + versioneJava);

        String nomeOS = System.getProperty("os.name");
        System.out.println("  - Sistema Operativo (da `os.name`): " + nomeOS);

        String userHome = System.getProperty("user.home");
        System.out.println("  - Directory Home dell'utente (da `user.home`): " + userHome);
        System.out.println();

        // Ottenere e stampare tutte le proprietà di sistema
        System.out.println("  Azione: Stampo tutte le proprietà di sistema disponibili...");
        Properties properties = System.getProperties();
        // properties.list(System.out); // Metodo rapido per stampare tutto
        for (String key : properties.stringPropertyNames()) {
            String value = properties.getProperty(key);
            // Stampiamo solo alcune per brevità
            if (key.startsWith("java.vm") || key.startsWith("os.arch")) {
                 System.out.println("    -> " + key + " = " + value);
            }
        }
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_VariabiliDAmbiente() {
        System.out.println("--- 3. Variabili d'Ambiente (`System.getenv`) ---");
        System.out.println("Spiegazione: Le variabili d'ambiente sono impostate dal sistema operativo, all'esterno della JVM.\n");

        // Ottenere una singola variabile d'ambiente
        String pathVar = System.getenv("PATH");
        System.out.println("  - Valore della variabile d'ambiente 'PATH' (primi 50 caratteri):");
        System.out.println("    -> " + (pathVar != null ? pathVar.substring(0, 50) + "..." : "Non definita"));
        System.out.println();

        // Ottenere tutte le variabili d'ambiente
        System.out.println("  Azione: Stampo alcune variabili d'ambiente...");
        Map<String, String> envVars = System.getenv();
        for (Map.Entry<String, String> entry : envVars.entrySet()) {
            if (entry.getKey().equals("USERNAME") || entry.getKey().equals("COMPUTERNAME") || entry.getKey().equals("JAVA_HOME")) {
                System.out.println("    -> " + entry.getKey() + " = " + entry.getValue());
            }
        }
        System.out.println("----------------------------------------\n");
    }

    private static void sezione4_Timing() {
        System.out.println("--- 4. Misurazione del Tempo ---");
        System.out.println("Spiegazione: Metodi per misurare il tempo trascorso.\n");

        // System.currentTimeMillis(): Restituisce i millisecondi trascorsi dall'epoca UNIX (1 Gen 1970 UTC).
        // Utile per misurare il tempo "reale".
        long startTimeMillis = System.currentTimeMillis();
        System.out.println("  - `currentTimeMillis()`: " + startTimeMillis);

        // System.nanoTime(): Restituisce il tempo da una sorgente ad alta risoluzione in nanosecondi.
        // NON è correlato all'ora del giorno. È utile SOLO per misurare intervalli di tempo.
        long startTimeNanos = System.nanoTime();
        // Simuliamo un'operazione
        for (int i = 0; i < 10000; i++) { Math.sqrt(i); }
        long endTimeNanos = System.nanoTime();
        long elapsedTime = endTimeNanos - startTimeNanos;
        System.out.println("  - `nanoTime()`: Usato per misurare un'operazione.");
        System.out.println("    -> Tempo trascorso per l'operazione: " + elapsedTime + " nanosecondi.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione5_ControlloJVM() {
        System.out.println("--- 5. Controllo della JVM ---");
        System.out.println("Spiegazione: Metodi che interagiscono direttamente con il ciclo di vita della JVM.\n");

        // System.gc(): Garbage Collector
        System.out.println("  - `System.gc()`: È solo un SUGGERIMENTO alla JVM per avviare il Garbage Collector.");
        System.out.println("    Non c'è garanzia che venga eseguito immediatamente o affatto.");
        // System.gc(); // Chiamata dimostrativa

        // System.exit(int status):
        System.out.println("\n  - `System.exit(int status)`: Termina bruscamente la JVM.");
        System.out.println("    ATTENZIONE: È un'operazione drastica. I blocchi `finally` non vengono eseguiti.");
        System.out.println("    Lo status code (0 per successo, non-zero per errore) viene restituito al sistema operativo.");
        // System.exit(0); // Se decommentato, il programma terminerebbe qui.
        System.out.println("----------------------------------------");
    }
}
