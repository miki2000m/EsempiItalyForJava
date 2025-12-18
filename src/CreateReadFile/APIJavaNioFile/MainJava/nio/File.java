package CreateReadFile.APIJavaNioFile.MainJava.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

/**
 * Esempio completo sull'uso della libreria java.nio.file per la gestione dei file.
 * NIO (New I/O) offre un approccio più moderno e potente rispetto al classico java.io.
 */
public class File { // Rinominato da MainNioExample per mantenere il nome del file

    public static void main(String[] args) {
        // Definiamo la directory di destinazione
        String destinationDir = "/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/CreateReadFile/APIJavaNioFile/MainJava/nio";

        // 1. CREAZIONE DI UN PERCORSO (PATH)
        // Path è l'equivalente moderno di java.io.File.
        // Usiamo Paths.get() per creare un'istanza di Path.
        // Il percorso punta a un file che creeremo nella directory specificata.
        Path filePath = Paths.get(destinationDir, "nio_example.txt");
        System.out.println("Oggetto Path creato per: " + filePath);

        try {
            // 2. SCRITTURA SU FILE
            // Scriviamo una lista di stringhe nel file.
            // Files.write() si occupa di aprire, scrivere e chiudere il file.
            // Se il file esiste già, verrà sovrascritto. Se non esiste, verrà creato.
            List<String> linesToWrite = Arrays.asList(
                "Ciao mondo da Java NIO!",
                "Questa è la seconda riga.",
                "NIO rende tutto più semplice."
            );

            Files.write(filePath, linesToWrite);
            System.out.println("\n>> File scritto con successo!");

            // 3. LETTURA DA FILE
            // Leggiamo tutte le righe del file in una lista di stringhe.
            // Questo metodo è utile per file di piccole-medie dimensioni.
            System.out.println("\n>> Leggendo il contenuto del file:");
            List<String> linesRead = Files.readAllLines(filePath);
            for (String line : linesRead) {
                System.out.println(line);
            }

            // 4. OTTENERE INFORMAZIONI SUL FILE
            // Controlliamo se il file esiste e ne otteniamo la dimensione.
            System.out.println("\n>> Informazioni sul file:");
            System.out.println("Il file esiste? " + Files.exists(filePath));
            System.out.println("Dimensione del file: " + Files.size(filePath) + " bytes");
            System.out.println("È una directory? " + Files.isDirectory(filePath));

            // 5. COPIA DI UN FILE
            // Creiamo un percorso per la copia del file nella stessa directory.
            Path copyPath = Paths.get(destinationDir, "nio_example_copy.txt");
            // Copiamo il file originale nel nuovo percorso.
            // StandardCopyOption.REPLACE_EXISTING sovrascrive la destinazione se esiste già.
            Files.copy(filePath, copyPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("\n>> File copiato in: " + copyPath);
            System.out.println("La copia esiste? " + Files.exists(copyPath));

            // 6. CANCELLAZIONE DEI FILE
            // Cancelliamo sia il file originale che la sua copia per fare pulizia.
            // Files.deleteIfExists() non lancia un'eccezione se il file non esiste.
            Files.deleteIfExists(filePath);
            Files.deleteIfExists(copyPath);
            System.out.println("\n>> File originali e copie cancellati con successo.");
            System.out.println("Il file originale esiste ancora? " + Files.exists(filePath));
            System.out.println("La copia esiste ancora? " + Files.exists(copyPath));

        } catch (IOException e) {
            // Gestiamo eventuali errori di I/O che potrebbero verificarsi.
            System.err.println("\nSi è verificato un errore durante le operazioni sul file:");
            e.printStackTrace();
        }
    }
}
