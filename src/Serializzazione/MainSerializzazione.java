package Serializzazione;

import java.io.*;

/**
 * GUIDA ALLA SERIALIZZAZIONE DI OGGETTI IN JAVA
 *
 * Questo file è un tutorial eseguibile che spiega come funziona la serializzazione.
 *
 * La serializzazione è il processo di convertire lo stato di un oggetto in un flusso di byte.
 * Questo flusso può essere salvato su un file, inviato attraverso una rete o memorizzato in un database.
 * Il processo inverso, che ricostruisce l'oggetto dal flusso di byte, è chiamato deserializzazione.
 */

// --- 1. L'INTERFACCIA `Serializable` ---
// Per rendere una classe serializzabile, deve implementare l'interfaccia `java.io.Serializable`.
// Questa è un'"interfaccia marcatore" (marker interface), cioè non ha metodi da implementare.
// Serve solo a dire a Java: "Gli oggetti di questa classe possono essere convertiti in byte".

class Utente implements Serializable {

    // --- 2. `serialVersionUID` ---
    // È un ID di versione per la classe serializzabile. È una buona pratica specificarlo esplicitamente.
    // Se non lo fai, Java ne genera uno basato sulla struttura della classe.
    // Se dopo aver serializzato un oggetto modifichi la classe (es. aggiungi un campo),
    // la deserializzazione fallirà perché i `serialVersionUID` non corrisponderanno più.
    // Specificandolo, puoi gestire l'evoluzione della classe in modo più controllato.
    private static final long serialVersionUID = 1L;

    String username;
    int livello;

    // --- 3. La keyword `transient` ---
    // Se non vuoi che un campo venga serializzato (es. per sicurezza o perché non ha senso salvarlo),
    // puoi marcarlo come `transient`.
    // Durante la deserializzazione, questo campo verrà inizializzato al suo valore di default (es. `null` per oggetti, 0 per `int`).
    transient String password; // La password non verrà salvata nel file.

    public Utente(String username, int livello, String password) {
        this.username = username;
        this.livello = livello;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", livello=" + livello +
                ", password='" + password + '\'' + // Stampiamo la password per vedere cosa succede dopo la deserializzazione
                '}';
    }
}


public class MainSerializzazione {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA SERIALIZZAZIONE ---\n");

        // Creiamo un oggetto da serializzare
        Utente utenteOriginale = new Utente("Mario_Rossi", 5, "Password123");
        System.out.println("Oggetto originale prima della serializzazione:");
        System.out.println("  -> " + utenteOriginale + "\n");

        String nomeFile = "utente.ser"; // L'estensione .ser è una convenzione comune

        // --- FASE 1: SERIALIZZAZIONE (Salvataggio dell'oggetto su file) ---
        System.out.println("--- 1. Serializzazione: Scrivo l'oggetto nel file '" + nomeFile + "' ---");
        try (FileOutputStream fileOut = new FileOutputStream(nomeFile);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            // `writeObject` è il metodo che fa la magia: converte l'oggetto in byte e lo scrive sul file.
            objectOut.writeObject(utenteOriginale);
            System.out.println("Oggetto serializzato con successo!\n");

        } catch (IOException e) {
            System.err.println("Errore durante la serializzazione: " + e.getMessage());
        }


        // --- FASE 2: DESERIALIZZAZIONE (Caricamento dell'oggetto dal file) ---
        System.out.println("--- 2. Deserializzazione: Leggo l'oggetto dal file '" + nomeFile + "' ---");
        Utente utenteDeserializzato = null;
        try (FileInputStream fileIn = new FileInputStream(nomeFile);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            // `readObject` legge il flusso di byte e lo riconverte in un oggetto.
            // Poiché `readObject` può leggere qualsiasi tipo di oggetto, restituisce `Object`.
            // È necessario fare un cast esplicito alla classe corretta.
            utenteDeserializzato = (Utente) objectIn.readObject();
            System.out.println("Oggetto deserializzato con successo!\n");

        } catch (IOException | ClassNotFoundException e) {
            // `ClassNotFoundException` viene lanciata se la classe dell'oggetto non viene trovata durante la deserializzazione.
            System.err.println("Errore durante la deserializzazione: " + e.getMessage());
        }

        System.out.println("--- Risultato Finale ---");
        System.out.println("Oggetto dopo la deserializzazione:");
        System.out.println("  -> " + utenteDeserializzato);
        System.out.println("\nNotare come il campo 'password', marcato come `transient`, sia `null` dopo la deserializzazione.");
    }
}
