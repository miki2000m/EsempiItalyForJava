package MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO.FileBinari;

import java.io.*;

/**
 * GUIDA ALLA GESTIONE DI FILE BINARI IN JAVA
 *
 * Questo file è un tutorial eseguibile che spiega come scrivere e leggere dati primitivi
 * su un file binario. A differenza dei file di testo, i file binari memorizzano dati
 * in un formato compatto e non leggibile dall'uomo, ideale per performance e precisione.
 *
 * Useremo le classi "decorator" per avvolgere gli stream di base, seguendo le best practice:
 * - DataOutputStream: Per scrivere tipi di dato primitivi Java.
 * - BufferedOutputStream: Per rendere la scrittura più efficiente (buffering).
 * - FileOutputStream: Per connettersi al file fisico.
 */
public class MainFileBinari {

    public static void main(String[] args) {
        String nomeFile = "dati.bin"; // L'estensione .bin è una convenzione per i file binari

        // --- DATI DI ESEMPIO DA SCRIVERE ---
        int punteggio = 1500;
        double temperatura = 24.5;
        boolean attivo = true;
        String utente = "Giocatore01";

        scriviDatiBinari(nomeFile, punteggio, temperatura, attivo, utente);
        leggiDatiBinari(nomeFile);
    }

    private static void scriviDatiBinari(String nomeFile, int p, double t, boolean a, String u) {
        System.out.println("--- 1. Scrittura su File Binario ---");
        System.out.println("Spiegazione: Stiamo per scrivere diversi tipi di dati primitivi su un file.\n" +
                "L'ordine in cui scriviamo è FONDAMENTALE, perché dovremo leggere nello stesso identico ordine.\n");

        // `try-with-resources` garantisce che tutti gli stream vengano chiusi automaticamente.
        try (
            // 3. Lo stream più esterno, che useremo per scrivere i dati.
            DataOutputStream dataOut = new DataOutputStream(
                // 2. Avvolgiamo lo stream del file in un buffer per efficienza.
                new BufferedOutputStream(
                    // 1. Lo stream che si connette fisicamente al file su disco.
                    new FileOutputStream(nomeFile)
                )
            )
        ) {
            System.out.println("Azione: Scrittura dei seguenti dati nel file '" + nomeFile + "':");
            System.out.println("  - int: " + p);
            System.out.println("  - double: " + t);
            System.out.println("  - boolean: " + a);
            System.out.println("  - String (UTF): " + u);

            // Scriviamo i dati usando i metodi specifici di DataOutputStream
            dataOut.writeInt(p);
            dataOut.writeDouble(t);
            dataOut.writeBoolean(a);
            dataOut.writeUTF(u); // writeUTF scrive una stringa in un formato binario standard

            System.out.println("\nRisultato: Scrittura completata con successo.");

        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file binario: " + e.getMessage());
        }
        System.out.println("----------------------------------------\n");
    }

    private static void leggiDatiBinari(String nomeFile) {
        System.out.println("--- 2. Lettura da File Binario ---");
        System.out.println("Spiegazione: Ora leggiamo i dati dal file. Dobbiamo usare i metodi `read...()`\n" +
                "nello stesso esatto ordine e tipo con cui abbiamo scritto.\n");

        try (
            DataInputStream dataIn = new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream(nomeFile)
                )
            )
        ) {
            // Leggiamo i dati nell'ordine corretto
            int punteggioLetto = dataIn.readInt();
            double temperaturaLetta = dataIn.readDouble();
            boolean attivoLetto = dataIn.readBoolean();
            String utenteLetto = dataIn.readUTF();

            System.out.println("Azione: Lettura dei dati dal file '" + nomeFile + "'.");
            System.out.println("Risultato: Dati letti con successo:");
            System.out.println("  - int letto: " + punteggioLetto);
            System.out.println("  - double letto: " + temperaturaLetta);
            System.out.println("  - boolean letto: " + attivoLetto);
            System.out.println("  - String (UTF) letta: " + utenteLetto);

        } catch (FileNotFoundException e) {
            System.err.println("Errore: File non trovato. Assicurarsi di averlo scritto prima.");
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file binario: " + e.getMessage());
        }
        System.out.println("----------------------------------------");
    }
}
