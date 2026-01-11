package CreateReadFile.NIO2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * GUIDA ENCICLOPEDICA, TEORICA E INTERATTIVA A JAVA.NIO.FILE (NIO.2)
 *
 * Questo file è un tutorial eseguibile progettato per essere la guida definitiva alla libreria New I/O.
 * Ogni azione viene spiegata nei commenti (la teoria e il "perché") e stampata a console (il "cosa sta succedendo"),
 * rendendo l'apprendimento un'esperienza live e interattiva.
 */
public class MainNIO2 {

    public static void main(String[] args) {
        // Il Path della nostra area di test. Usiamo un percorso relativo che crea la cartella
        // all'interno della directory del progetto, rendendo l'esempio auto-contenuto.
        Path testRoot = Paths.get("nio2_test_area");

        try {
            System.out.println("Azione Iniziale: Preparazione dell'area di test con `Files.createDirectories`.");
            System.out.println("Spiegazione Concettuale: Stiamo chiedendo al sistema operativo di assicurarsi che esista una 'cartella' all'indirizzo specificato. Se mancano le cartelle intermedie, le crea tutte.");
            Files.createDirectories(testRoot);
            System.out.println("Risultato: Area di test pronta in -> " + testRoot.toAbsolutePath() + "\n" + "--------------------------------------\n");

            sezione1_Path(testRoot);
            sezione2_OperazioniBase(testRoot);
            sezione3_ScritturaLettura(testRoot);
            sezione4_Attributi(testRoot);
            sezione5_CopiaSposta(testRoot);
            sezione6_StreamAPI(testRoot);
            sezione7_FileVisitor(testRoot);
            sezione8_WatchService(testRoot);

        } catch (IOException | InterruptedException e) {
            System.err.println("ERRORE CRITICO: L'esecuzione del tutorial è stata interrotta da un'eccezione imprevista.");
            e.printStackTrace();
        } finally {
            System.out.println("\n--------------------------------------\n--- FASE FINALE: Pulizia dell'area di test ---");
            try {
                if (Files.exists(testRoot)) {
                    Files.walkFileTree(testRoot, new SimpleFileVisitor<Path>() {
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            System.out.println("  Azione di pulizia: Cancello il 'documento' -> " + file.getFileName());
                            Files.delete(file);
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                            System.out.println("  Azione di pulizia: Cancello la 'cartella' (ora vuota) -> " + dir.getFileName());
                            Files.delete(dir);
                            return FileVisitResult.CONTINUE;
                        }
                    });
                    System.out.println("Risultato: Pulizia completata. L'area di test è stata rimossa.");
                }
            } catch (IOException e) {
                System.err.println("ERRORE DI PULIZIA: Non è stato possibile cancellare l'area di test. Potrebbe essere necessario farlo manualmente.");
            }
        }
    }

    private static void sezione1_Path(Path root) {
        System.out.println("--- 1. Path e Paths: L'Anatomia di un Indirizzo ---");
        System.out.println("Spiegazione Concettuale: `Path` è un oggetto che rappresenta un 'indirizzo' nel filesystem. Non è il file stesso, ma solo la sua posizione. " +
                "\nÈ 'immutabile', cioè una volta creato non può essere modificato; ogni operazione crea un nuovo oggetto Path. " +
                "\n`Paths` è la classe 'fabbrica' per creare questi indirizzi.\n");

        System.out.println("Azione: Creazione di un oggetto `Path` con `Paths.get(root, \"dir1\", \"file.txt\")`.");
        Path p1 = Paths.get(root.toString(), "dir1", "file.txt");
        System.out.println("Risultato: Creato oggetto Path (non ancora un file reale) -> " + p1);

        System.out.println("\nAzione: Estrarre il nome del file con `p1.getFileName()`.");
        System.out.println("Risultato: " + p1.getFileName());

        System.out.println("\nAzione: Ottenere la directory genitore con `p1.getParent()`.");
        System.out.println("Risultato: " + p1.getParent());

        System.out.println("\nAzione: Ottenere la radice del percorso con `p1.getRoot()`.");
        System.out.println("Risultato: " + p1.getRoot());

        System.out.println("\nAzione: Creare un percorso figlio con `root.resolve(\"sottocartella\")`.");
        System.out.println("Risultato: " + root.resolve("sottocartella"));

        Path p3 = Paths.get(root.toString(), "dir_temp", "..", "dir_reale");
        System.out.println("\nAzione: Normalizzare un percorso non pulito (`" + p3 + "`) con `p3.normalize()`.");
        System.out.println("Risultato: Il percorso viene semplificato in -> " + p3.normalize());
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione2_OperazioniBase(Path root) throws IOException {
        System.out.println("--- 2. Creare e Cancellare: Interagire con il Disco ---");
        System.out.println("Spiegazione Concettuale: Queste operazioni sono 'Operazioni di I/O' (Input/Output)." +
                "\nJava chiede al Sistema Operativo di modificare fisicamente il disco e per questo possono fallire (es. disco pieno, permessi mancanti) e lanciano `IOException`.\n");

        Path file = root.resolve("mio_file.txt");
        Path dir = root.resolve("mia_cartella");

        System.out.println("Azione: Creazione di un file vuoto con `Files.createFile(file)`.");
        Files.createFile(file);
        System.out.println("Risultato: File creato. `Files.exists(file)` ora restituisce -> " + Files.exists(file));

        System.out.println("\nAzione: Creazione di una directory con `Files.createDirectory(dir)`.");
        Files.createDirectory(dir);
        System.out.println("Risultato: Directory creata. `Files.isDirectory(dir)` ora restituisce -> " + Files.isDirectory(dir));

        System.out.println("\nAzione: Cancellazione del file con `Files.delete(file)`.");
        Files.delete(file);
        System.out.println("Risultato: File cancellato. `Files.exists(file)` ora restituisce -> " + Files.exists(file));

        System.out.println("\nAzione: Cancellazione sicura della directory con `Files.deleteIfExists(dir)`.");
        boolean cancellato = Files.deleteIfExists(dir);
        System.out.println("Risultato: Directory cancellata. Il metodo ha restituito -> " + cancellato);
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione3_ScritturaLettura(Path root) throws IOException {
        System.out.println("--- 3. Scrivere e Leggere: Gestire i Dati ---");
        Path file = root.resolve("poesia.txt");

        System.out.println("Metodo 1: 'Tutto in memoria', per file piccoli.");
        List<String> righeDaScrivere = Arrays.asList("Nel mezzo del cammin di nostra vita", "mi ritrovai per una selva oscura,");
        
        System.out.println("\nAzione: Scrittura di " + righeDaScrivere.size() + " righe con `Files.write()`.");
        Files.write(file, righeDaScrivere, StandardCharsets.UTF_8);
        System.out.println("Risultato: File scritto.");

        System.out.println("\nAzione: Lettura dell'intero file in una lista con `Files.readAllLines()`.");
        List<String> righeLette = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("Risultato: Lette " + righeLette.size() + " righe. Contenuto: " + righeLette);

        System.out.println("\nMetodo 2: 'Streaming', efficiente per file di qualsiasi dimensione.");
        System.out.println("Spiegazione: Questo approccio usa un 'buffer' e legge/scrive dati a pezzi, usando pochissima RAM. È il metodo professionale per file grandi.");

        System.out.println("\nAzione: Scrittura efficiente tramite `Files.newBufferedWriter()` in un blocco `try-with-resources`.");
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write("ché la diritta via era smarrita.");
            writer.newLine();
        }
        System.out.println("Risultato: Una riga aggiunta in coda al file.");

        System.out.println("\nAzione: Lettura efficiente della prima riga con `Files.newBufferedReader()`.");
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String primaRiga = reader.readLine();
            System.out.println("Risultato: Prima riga letta -> '" + primaRiga + "'");
        }
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione4_Attributi(Path root) throws IOException {
        System.out.println("--- 4. Leggere gli Attributi: i 'Metadati' di un File ---");
        Path file = root.resolve("documento.pdf");
        Files.write(file, "Contenuto di test.".getBytes());

        System.out.println("Azione: Ottenere la dimensione con `Files.size()`.");
        System.out.println("Risultato: " + Files.size(file) + " bytes.");

        System.out.println("\nAzione: Ottenere la data di ultima modifica con `Files.getLastModifiedTime()`.");
        System.out.println("Risultato: " + Files.getLastModifiedTime(file));

        System.out.println("\nAzione: Lettura efficiente di un blocco di attributi con `Files.readAttributes()`.");
        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println("Risultati ottenuti in un colpo solo:");
        System.out.println("  - Data di creazione: " + attrs.creationTime());
        System.out.println("  - È una directory? " + attrs.isDirectory());
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione5_CopiaSposta(Path root) throws IOException {
        System.out.println("--- 5. Copiare e Spostare: Manipolare File e Directory ---");
        Path sorgente = root.resolve("originale.txt");
        Files.write(sorgente, "contenuto".getBytes());
        Path destinazioneCopia = root.resolve("copia.txt");

        System.out.println("Azione: Copia di '" + sorgente.getFileName() + "' in '" + destinazioneCopia.getFileName() + "' usando `REPLACE_EXISTING`.");
        Files.copy(sorgente, destinazioneCopia, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Risultato: Copia completata. Sorgente esiste? " + Files.exists(sorgente) + ". Destinazione esiste? " + Files.exists(destinazioneCopia));

        Path destinazioneSpostamento = root.resolve("rinominato.txt");
        System.out.println("\nAzione: Spostamento (rinomina) di '" + sorgente.getFileName() + "' in '" + destinazioneSpostamento.getFileName() + "'.");
        Files.move(sorgente, destinazioneSpostamento, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Risultato: Spostamento completato. Il file originale non esiste più? " + !Files.exists(sorgente) + ". Il file rinominato esiste? " + Files.exists(destinazioneSpostamento));
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione6_StreamAPI(Path root) throws IOException {
        System.out.println("--- 6. Integrare NIO.2 con le Stream API di Java 8 ---");
        Path streamDir = root.resolve("directory_per_stream");
        Files.createDirectories(streamDir.resolve("sottocartella"));
        Files.write(streamDir.resolve("documento.txt"), "".getBytes());
        Files.write(streamDir.resolve("immagine.jpg"), "".getBytes());

        System.out.println("Azione: Elencare il contenuto di '" + streamDir.getFileName() + "' con `Files.list()` (non ricorsivo).");
        try (Stream<Path> stream = Files.list(streamDir)) {
            stream.forEach(p -> System.out.println("  - Trovato: " + p.getFileName()));
        }

        System.out.println("\nAzione: Attraversare l'albero da '" + streamDir.getFileName() + "' con `Files.walk()` (ricorsivo).");
        System.out.println("Risultato (filtrando solo i file con estensione .txt):");
        try (Stream<Path> stream = Files.walk(streamDir)) {
            stream.filter(path -> path.toString().endsWith(".txt"))
                  .forEach(p -> System.out.println("  - Trovato file di testo: " + p.getFileName()));
        }
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione7_FileVisitor(Path root) throws IOException {
        System.out.println("--- 7. FileVisitor: Il Controllo Totale sull'Attraversamento ---");
        System.out.println("Spiegazione: `FileVisitor` è un pattern che separa l'algoritmo di attraversamento dall'azione da compiere, offrendo controllo granulare (prima/dopo una directory, su ogni file, in caso di errore).\n");
        Path visitorRoot = root.resolve("directory_da_visitare");
        Files.createDirectories(visitorRoot.resolve("sottocartella"));
        Files.write(visitorRoot.resolve("file_principale.txt"), "".getBytes());

        System.out.println("Azione: Avvio di un attraversamento controllato con `Files.walkFileTree()`.");
        Files.walkFileTree(visitorRoot, new MyDetailedFileVisitor());
        System.out.println("Risultato: Attraversamento completato.");
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione8_WatchService(Path root) throws IOException, InterruptedException {
        System.out.println("--- 8. WatchService: Spiare le Modifiche del Filesystem ---");
        System.out.println("Spiegazione: Invece di controllare continuamente una cartella ('polling'), `WatchService` è un approccio 'event-driven' che riceve notifiche dal sistema operativo, risparmiando risorse.\n");
        Path watchDir = root.resolve("dir_sorvegliata");
        Files.createDirectory(watchDir);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        watchDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Azione: Inizio sorveglianza su -> " + watchDir.getFileName());

        System.out.println("\nAzione: Simulo la creazione, modifica e cancellazione di un file...");
        Thread.sleep(500);
        Path fileDiTest = watchDir.resolve("file_spiato.txt");
        Files.write(fileDiTest, "contenuto iniziale".getBytes());
        Thread.sleep(100);
        Files.write(fileDiTest, "contenuto modificato".getBytes());
        Thread.sleep(100);
        Files.delete(fileDiTest);
        System.out.println("Risultato: Simulazione completata.");

        System.out.println("\nAzione: Attendo gli eventi dal WatchService (con timeout di 5 secondi)...");
        WatchKey key = watchService.poll(5, TimeUnit.SECONDS);

        if (key == null) {
            System.out.println("Risultato: Nessun evento rilevato.");
        } else {
            System.out.println("Risultato: Ricevuta una 'chiave' con degli eventi. Li elaboro:");
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("  - Evento Rilevato: " + event.kind() + " | File Coinvolto: " + event.context());
            }
            key.reset();
        }
        watchService.close();
        System.out.println("\n--------------------------------------\n");
    }
}

class MyDetailedFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("  -> [Visitor] Sto per entrare nella directory: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("    -> [Visitor] Sto visitando il file: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("  <- [Visitor] Ho finito di visitare la directory: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("  !! [Visitor] ERRORE: Impossibile accedere a: " + file.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
