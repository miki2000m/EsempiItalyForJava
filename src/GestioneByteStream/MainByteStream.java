package GestioneByteStream;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * GUIDA ALLA MANIPOLAZIONE DI BYTE E STREAM BINARI
 *
 * Questo file è un laboratorio eseguibile che mostra come convertire i tipi di dato Java
 * da e verso array di byte (`byte[]`), l'unità fondamentale per tutte le operazioni di I/O.
 */
public class MainByteStream {

    public static void main(String[] args) throws IOException {
        System.out.println("--- GUIDA ALLA MANIPOLAZIONE DI BYTE ---\n");

        sezione1_StringaToByte();
        sezione2_PrimitiviToByte();
        sezione3_FileToByte();
    }

    private static void sezione1_StringaToByte() {
        System.out.println("--- 1. Conversione tra Stringa e byte[] ---");
        System.out.println("Spiegazione: Una stringa è una sequenza di caratteri. Per salvarla o trasmetterla, deve essere 'codificata' in una sequenza di byte usando un Charset.\n");

        String testo = "Ciao, mondo! €";
        System.out.println("Stringa originale: " + testo);

        // Codifica da String a byte[] usando UTF-8 (lo standard)
        byte[] bytesUTF8 = testo.getBytes(StandardCharsets.UTF_8);
        System.out.println("A) String -> byte[] (UTF-8): " + bytesToHexString(bytesUTF8));
        System.out.println("   - Lunghezza in byte: " + bytesUTF8.length);

        // Decodifica da byte[] a String
        String testoDecodificato = new String(bytesUTF8, StandardCharsets.UTF_8);
        System.out.println("B) byte[] -> String (UTF-8): " + testoDecodificato);
        System.out.println();

        // Dimostrazione dell'importanza del Charset
        System.out.println("C) Errore comune: usare il Charset sbagliato!");
        byte[] bytesISO = testo.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println("   - Stringa codificata in ISO-8859-1: " + bytesToHexString(bytesISO));
        // Il carattere '€' non esiste in ISO-8859-1 e viene sostituito con '?' (codice 63)
        String testoErrato = new String(bytesISO, StandardCharsets.ISO_8859_1);
        System.out.println("   - Risultato decodificato: " + testoErrato);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_PrimitiviToByte() {
        System.out.println("--- 2. Conversione tra Tipi Primitivi e byte[] ---");
        System.out.println("Spiegazione: Per convertire tipi numerici (int, double, ecc.) si usa `java.nio.ByteBuffer`, che gestisce l'allocazione e l'ordine dei byte.\n");

        int id = 123456789;
        double valore = 987.654;

        // Creiamo un ByteBuffer con spazio sufficiente (4 byte per int + 8 per double)
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES + Double.BYTES);

        // Impostiamo l'ordine dei byte (opzionale, ma buona pratica essere espliciti)
        // BIG_ENDIAN è lo standard di rete e il default di Java.
        buffer.order(ByteOrder.BIG_ENDIAN);

        // Inseriamo i primitivi nel buffer
        buffer.putInt(id);
        buffer.putDouble(valore);

        // Estraiamo l'array di byte risultante
        byte[] byteArray = buffer.array();
        System.out.println("A) Primitivi -> byte[]:");
        System.out.println("   - int (" + id + ") + double (" + valore + ")");
        System.out.println("   - Array di byte risultante: " + bytesToHexString(byteArray));
        System.out.println();

        // Ora facciamo il processo inverso: da byte[] a primitivi
        ByteBuffer bufferLettura = ByteBuffer.wrap(byteArray);
        bufferLettura.order(ByteOrder.BIG_ENDIAN);

        int idLetto = bufferLettura.getInt();
        double valoreLetto = bufferLettura.getDouble();

        System.out.println("B) byte[] -> Primitivi:");
        System.out.println("   - int letto: " + idLetto);
        System.out.println("   - double letto: " + valoreLetto);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_FileToByte() throws IOException {
        System.out.println("--- 3. Conversione tra File e byte[] (NIO.2) ---");
        System.out.println("Spiegazione: La classe `Files` fornisce metodi diretti per leggere/scrivere file come array di byte. Utile per file piccoli.\n");

        Path percorso = Paths.get("file_binario_test.dat");
        String contenuto = "Dati di prova per il file.";
        byte[] datiOriginali = contenuto.getBytes(StandardCharsets.UTF_8);

        // Scrittura di un array di byte su un file
        System.out.println("A) Scrittura di " + datiOriginali.length + " byte su file con `Files.write()`.");
        Files.write(percorso, datiOriginali);
        System.out.println("   -> File scritto: " + percorso.toAbsolutePath());

        // Lettura di un intero file in un array di byte
        System.out.println("\nB) Lettura dell'intero file in un byte[] con `Files.readAllBytes()`.");
        byte[] datiLetti = Files.readAllBytes(percorso);
        System.out.println("   -> Letti " + datiLetti.length + " byte.");

        // Verifica
        System.out.println("   - I dati letti corrispondono a quelli originali? " + Arrays.equals(datiOriginali, datiLetti));

        // Pulizia
        Files.delete(percorso);
        System.out.println("\nFile di test cancellato.");
        System.out.println("----------------------------------------\n");
    }

    /**
     * Metodo di utilità per convertire un array di byte in una stringa esadecimale leggibile.
     */
    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString().trim();
    }
}
