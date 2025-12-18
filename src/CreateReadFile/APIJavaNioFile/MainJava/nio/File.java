package CreateReadFile.APIJavaNioFile.MainJava.nio;

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
public class File {

    public static void main(String[] args) {
        // --- CONCETTO TEORICO: Il Filesystem ---
        // Un filesystem è la struttura con cui un sistema operativo organizza, memorizza e gestisce i dati su un disco
        // (HDD, SSD, etc.). Puoi immaginarlo come un enorme schedario.
        // All'interno di questo schedario ci sono 'cartelle' (directory) e 'documenti' (file).

        // --- CONCETTO TEORICO: Directory e Root Directory ---
        // Una 'Directory' (o cartella) è un contenitore che può contenere file e altre directory.
        // La 'Root Directory' è la directory di partenza, la più alta nella gerarchia, che contiene tutto il resto.
        // Su Windows è tipicamente `C:\`. Su sistemi Unix-like (macOS, Linux) è `/`.

        // --- CONCETTO TEORICO: Path (Percorso) ---
        // Un 'Path' è l'indirizzo univoco di un file o di una directory all'interno del filesystem.
        // È come l'indirizzo di una casa: parte dal paese (la root), passa per la città (le directory) fino al numero civico (il file).

        Path testRoot = Paths.get("/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/CreateReadFile/APIJavaNioFile/MainJava/nio/nio_encyclopedia_test_area");

        try {
            System.out.println("Azione Iniziale: Preparazione dell'area di test con `Files.createDirectories`.");
            System.out.println("Spiegazione Concettuale: Stiamo chiedendo al sistema operativo di assicurarsi che esista una 'cartella' all'indirizzo specificato. Se mancano le cartelle intermedie, le crea tutte.");
            Files.createDirectories(testRoot);
            System.out.println("Risultato: Area di test pronta in -> " + testRoot + "\n" + "--------------------------------------\n");

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
                        // --- SPIEGAZIONE DELL'OVERRIDE: visitFile ---
                        // Questo metodo viene chiamato per ogni file incontrato. Lo sovrascriviamo (override)
                        // per definire un'azione personalizzata: la cancellazione. È fondamentale cancellare
                        // i file PRIMA delle directory che li contengono.
                        @Override
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            System.out.println("  Azione di pulizia: Cancello il 'documento' -> " + file.getFileName());
                            Files.delete(file);
                            return FileVisitResult.CONTINUE;
                        }

                        // --- SPIEGAZIONE DELL'OVERRIDE: postVisitDirectory ---
                        // Questo metodo viene chiamato DOPO aver visitato tutti i file e le sottodirectory
                        // di una directory. Lo sovrascriviamo perché questo è il momento giusto per cancellare
                        // la directory stessa, dato che ora è garantito che sia vuota.
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
        //Definizione di un oggetto Path
        System.out.println("--- 1. Path e Paths: L'Anatomia di un Indirizzo ---");
        System.out.println("Spiegazione Concettuale: `Path` è un oggetto che rappresenta un 'indirizzo' nel filesystem. Non è il file stesso, ma solo la sua posizione." +
                " È 'immutabile', cioè una volta creato non può essere modificato; ogni operazione crea un nuovo oggetto Path." +
                " `Paths` è la classe 'fabbrica' per creare questi indirizzi.\n");

        //Creazione di un oggetto Path
        System.out.println("Azione: Creazione di un oggetto `Path` con `Paths.get(root, \"dir1\", \"file.txt\")`.");
        System.out.println("Spiegazione: Stiamo costruendo un indirizzo che parte dalla nostra area di test," +
                " entra nella cartella 'dir1' e punta al file 'file.txt'.");

        Path p1 = Paths.get(root.toString(), "dir1", "file.txt");
        System.out.println("Risultato: Creato oggetto Path (non ancora un file reale) -> " + p1);

        //Estrazione nome del file e directory
        System.out.println("\nAzione: Estrarre il nome del file con `p1.getFileName()`.");
        System.out.println("Spiegazione: Dall'indirizzo completo, isoliamo solo il NOME DEL DOCUMENTO FINALE.");
        System.out.println("Risultato: " + p1.getFileName());

        System.out.println("\nAzione: Ottenere la directory genitore con `p1.getParent()`.");
        System.out.println("Spiegazione: Dall'indirizzo completo, otteniamo l'indirizzo della CARTELLA che lo contiene.");
        System.out.println("Risultato: " + p1.getParent());

        //Estrazione della root directory
        System.out.println("\nAzione: Ottenere la radice del percorso con `p1.getRoot()`.");
        System.out.println("Spiegazione: Questo isola la parte iniziale e assoluta del percorso, la 'Root Directory' del filesystem in cui si trova.");
        System.out.println("Risultato: " + p1.getRoot());

        //Creazione di una sottocartella nella root directory
        System.out.println("\nAzione: Creare un percorso figlio con `root.resolve(\"sottocartella\")`.");
        System.out.println("Spiegazione: Stiamo creando un nuovo indirizzo che punta a 'sottocartella' all'interno della nostra cartella 'root'.");
        System.out.println("Risultato: " + root.resolve("sottocartella"));

        //Mutazione più semplificativa del Path
        Path p3 = Paths.get(root.toString(), "dir_temp", "..", "dir_reale");
        System.out.println("\nAzione: Normalizzare un percorso non pulito (`" + p3 + "`) con `p3.normalize()`.");
        System.out.println("Spiegazione: `..` significa 'vai su di un livello'. Normalizzare un percorso come '.../dir_temp/../dir_reale' significa calcolare il percorso finale effettivo, che in questo caso è '.../dir_reale'.");
        System.out.println("Risultato: Il percorso viene semplificato in -> " + p3.normalize());
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione2_OperazioniBase(Path root) throws IOException {
        System.out.println("--- 2. Creare e Cancellare: Interagire con il Disco ---");
        System.out.println("Spiegazione Concettuale: Queste operazioni sono 'Operazioni di I/O' (Input/Output). Java chiede al Sistema Operativo di modificare fisicamente il disco. Per questo possono fallire (es. disco pieno, permessi mancanti) e lanciano `IOException`.\n");
        Path file = root.resolve("mio_file.txt");
        Path dir = root.resolve("mia_cartella");

        System.out.println("Azione: Creazione di un file vuoto con `Files.createFile(file)`.");
        System.out.println("Spiegazione: Stiamo chiedendo al S.O. di creare un 'documento' vuoto a questo indirizzo.");
        Files.createFile(file);
        System.out.println("Risultato: File creato. `Files.exists(file)` ora restituisce -> " + Files.exists(file));

        System.out.println("\nAzione: Creazione di una directory con `Files.createDirectory(dir)`.");
        System.out.println("Spiegazione: Stiamo chiedendo al S.O. di creare una 'cartella' vuota a questo indirizzo.");
        Files.createDirectory(dir);
        System.out.println("Risultato: Directory creata. `Files.isDirectory(dir)` ora restituisce -> " + Files.isDirectory(dir));

        System.out.println("\nAzione: Cancellazione del file con `Files.delete(file)`.");
        System.out.println("Spiegazione: Stiamo chiedendo al S.O. di rimuovere il 'documento' da questo indirizzo.");
        Files.delete(file);
        System.out.println("Risultato: File cancellato. `Files.exists(file)` ora restituisce -> " + Files.exists(file));

        System.out.println("\nAzione: Cancellazione sicura della directory con `Files.deleteIfExists(dir)`.");
        System.out.println("Spiegazione: Chiediamo di cancellare la 'cartella', ma diciamo al S.O. 'se non la trovi, non è un problema'.");
        boolean cancellato = Files.deleteIfExists(dir);
        System.out.println("Risultato: Directory cancellata. Il metodo ha restituito -> " + cancellato);
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione3_ScritturaLettura(Path root) throws IOException {
        System.out.println("--- 3. Scrivere e Leggere: Gestire i Dati ---");
        System.out.println("Spiegazione Concettuale: La differenza tra leggere/scrivere 'tutto in memoria' e usare uno 'stream' è cruciale per le performance.\n");
        Path file = root.resolve("poesia.txt");

        System.out.println("Metodo 1: 'Tutto in memoria', per file piccoli.");
        System.out.println("Spiegazione: Questo approccio carica l'intero contenuto del file nella RAM. È semplice e veloce per file piccoli, ma disastroso per file grandi (può esaurire la memoria).");
        List<String> righeDaScrivere = Arrays.asList("Nel mezzo del cammin di nostra vita", "mi ritrovai per una selva oscura,");
        System.out.println("Azione: Scrittura di " + righeDaScrivere.size() + " righe con `Files.write()`.");
        Files.write(file, righeDaScrivere, StandardCharsets.UTF_8);
        System.out.println("Risultato: File scritto.");

        System.out.println("\nAzione: Lettura dell'intero file in una lista con `Files.readAllLines()`.");
        List<String> righeLette = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("Risultato: Lette " + righeLette.size() + " righe. Contenuto: " + righeLette);

        System.out.println("\nMetodo 2: 'Streaming', efficiente per file di qualsiasi dimensione.");
        System.out.println("Spiegazione: Questo approccio usa un 'buffer', una piccola area di memoria temporanea. I dati vengono letti/scritti a pezzi, usando pochissima RAM. È il metodo professionale per file di dimensioni sconosciute o grandi.");
        System.out.println("Azione: Scrittura efficiente tramite `Files.newBufferedWriter()` in un blocco `try-with-resources`.");
        System.out.println("Spiegazione: `try-with-resources` è una magia di Java che garantisce la chiusura automatica del file, anche in caso di errori. `StandardOpenOption.APPEND` dice di aggiungere in coda invece di cancellare il contenuto esistente.");
        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            writer.write("ché la diritta via era smarrita.");
            writer.newLine(); // Aggiunge un a-capo indipendente dal sistema operativo.
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
        System.out.println("Spiegazione Concettuale: I metadati sono 'dati sui dati'. Non sono il contenuto del file, ma le informazioni che lo descrivono: dimensione, data di creazione, proprietario, etc.\n");
        Path file = root.resolve("documento.pdf");
        Files.write(file, "Contenuto di test.".getBytes());

        System.out.println("Azione: Ottenere la dimensione con `Files.size()`.");
        System.out.println("Spiegazione: Chiediamo al filesystem quanto spazio occupa il contenuto del file, in byte.");
        System.out.println("Risultato: " + Files.size(file) + " bytes.");

        System.out.println("\nAzione: Ottenere la data di ultima modifica con `Files.getLastModifiedTime()`.");
        System.out.println("Spiegazione: Chiediamo al filesystem quando è stata l'ultima volta che il contenuto di questo file è stato cambiato.");
        System.out.println("Risultato: " + Files.getLastModifiedTime(file));

        System.out.println("\nAzione: Lettura efficiente di un blocco di attributi con `Files.readAttributes()`.");
        System.out.println("Spiegazione: Invece di fare tante piccole richieste al S.O. per ogni attributo, ne facciamo una sola, molto più efficiente, e otteniamo un oggetto che li contiene tutti.");
        BasicFileAttributes attrs = Files.readAttributes(file, BasicFileAttributes.class);
        System.out.println("Risultati ottenuti in un colpo solo:");
        System.out.println("  - Data di creazione: " + attrs.creationTime());
        System.out.println("  - È una directory? " + attrs.isDirectory());
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione5_CopiaSposta(Path root) throws IOException {
        System.out.println("--- 5. Copiare e Spostare: Manipolare File e Directory ---");
        System.out.println("Spiegazione Concettuale: 'Copiare' crea un duplicato del file. 'Spostare' cambia l'indirizzo di un file. Se lo spostamento avviene sullo stesso disco, è un'operazione quasi istantanea (rinomina); se avviene tra dischi diversi, è una copia seguita da una cancellazione.\n");
        Path sorgente = root.resolve("originale.txt");
        Files.write(sorgente, "contenuto".getBytes());
        Path destinazioneCopia = root.resolve("copia.txt");

        System.out.println("Azione: Copia di '" + sorgente.getFileName() + "' in '" + destinazioneCopia.getFileName() + "' usando `REPLACE_EXISTING`.");
        System.out.println("Spiegazione: `REPLACE_EXISTING` è un'opzione di sicurezza: 'se esiste già un file con quel nome, cancellalo e sostituiscilo con questa copia'. Senza, l'operazione fallirebbe.");
        Files.copy(sorgente, destinazioneCopia, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Risultato: Copia completata. Sorgente esiste? " + Files.exists(sorgente) + ". Destinazione esiste? " + Files.exists(destinazioneCopia));

        Path destinazioneSpostamento = root.resolve("rinominato.txt");
        System.out.println("\nAzione: Spostamento (rinomina) di '" + sorgente.getFileName() + "' in '" + destinazioneSpostamento.getFileName() + "'.");
        System.out.println("Spiegazione: Stiamo cambiando l'indirizzo del file originale. Il contenuto su disco non viene spostato, cambia solo il riferimento nello 'schedario' del filesystem.");
        Files.move(sorgente, destinazioneSpostamento, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Risultato: Spostamento completato. Il file originale non esiste più? " + !Files.exists(sorgente) + ". Il file rinominato esiste? " + Files.exists(destinazioneSpostamento));
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione6_StreamAPI(Path root) throws IOException {
        System.out.println("--- 6. Integrare NIO.2 con le Stream API di Java 8 ---");
        System.out.println("Spiegazione Concettuale: Le Stream API permettono di scrivere codice 'dichiarativo' invece che 'imperativo'. Invece di dire 'come' fare un'operazione (con cicli for, if, etc.), dici 'cosa' vuoi ottenere (es. 'dammi tutti i file che finiscono per .txt'). È più leggibile e meno propenso a errori.\n");
        Path streamDir = root.resolve("directory_per_stream");
        Files.createDirectories(streamDir.resolve("sottocartella"));
        Files.write(streamDir.resolve("documento.txt"), "".getBytes());
        Files.write(streamDir.resolve("immagine.jpg"), "".getBytes());

        System.out.println("Azione: Elencare il contenuto di '" + streamDir.getFileName() + "' con `Files.list()` (non ricorsivo).");
        System.out.println("Spiegazione: `Files.list` crea uno 'stream' (un flusso di dati) che rappresenta il contenuto della directory. Lo stream è 'lazy' (pigro), cioè non carica tutto subito, ma produce gli elementi solo quando richiesti. Mostra solo il primo livello.");
        System.out.println("Risultato:");
        try (Stream<Path> stream = Files.list(streamDir)) {
            stream.forEach(p -> System.out.println("  - Trovato: " + p.getFileName()));
        }

        System.out.println("\nAzione: Attraversare l'albero da '" + streamDir.getFileName() + "' con `Files.walk()` (ricorsivo).");
        System.out.println("Spiegazione: `Files.walk` è come `list`, ma è ricorsivo: 'cammina' in tutte le sottocartelle. Qui usiamo lo stream per filtrare e tenere solo i file che ci interessano.");
        System.out.println("Risultato (filtrando solo i file con estensione .txt):");
        try (Stream<Path> stream = Files.walk(streamDir)) {
            stream.filter(path -> path.toString().endsWith(".txt")) // Filtra lo stream
                  .forEach(p -> System.out.println("  - Trovato file di testo: " + p.getFileName()));
        }
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione7_FileVisitor(Path root) throws IOException {
        System.out.println("--- 7. FileVisitor: Il Controllo Totale sull'Attraversamento ---");
        System.out.println("Spiegazione Concettuale: `FileVisitor` è un 'design pattern' (una soluzione progettuale standard). L'idea è separare l'algoritmo di attraversamento (la 'camminata' nell'albero dei file, gestita da Java) dall'azione da compiere (il 'visitatore', scritto da noi). Offre un controllo granulare, permettendoci di eseguire codice in 4 momenti chiave.\n");
        Path visitorRoot = root.resolve("directory_da_visitare");
        Files.createDirectories(visitorRoot.resolve("sottocartella"));
        Files.write(visitorRoot.resolve("file_principale.txt"), "".getBytes());

        System.out.println("Azione: Avvio di un attraversamento controllato con `Files.walkFileTree()` e un `FileVisitor` personalizzato.");
        System.out.println("Spiegazione: `walkFileTree` avvia la 'camminata' e, per ogni file e cartella, chiama il metodo corrispondente del nostro 'visitatore'.");
        Files.walkFileTree(visitorRoot, new MyDetailedFileVisitor());
        System.out.println("Risultato: Attraversamento completato. Vedi l'output del Visitor qui sopra.");
        System.out.println("\n--------------------------------------\n");
    }

    private static void sezione8_WatchService(Path root) throws IOException, InterruptedException {
        System.out.println("--- 8. WatchService: Spiare le Modifiche del Filesystem ---");
        System.out.println("Spiegazione Concettuale: Invece di controllare continuamente una cartella per vedere se è cambiato qualcosa ('polling', un approccio inefficiente che consuma CPU), usiamo un `WatchService`. È un approccio 'event-driven': diciamo al S.O. 'avvisami tu quando succede qualcosa'. Il nostro programma può 'dormire' finché non riceve una notifica, risparmiando risorse.\n");
        Path watchDir = root.resolve("dir_sorvegliata");
        Files.createDirectory(watchDir);

        WatchService watchService = FileSystems.getDefault().newWatchService();
        watchDir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Azione: Inizio sorveglianza su -> " + watchDir.getFileName());

        System.out.println("\nAzione: Simulo la creazione, modifica e cancellazione di un file per triggerare il servizio...");
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

/**
 * Implementazione di `FileVisitor` estremamente dettagliata.
 * Estendere `SimpleFileVisitor` è una scorciatoia che ci permette di implementare (fare l'override) solo i metodi che ci interessano.
 * Altrimenti, dovremmo implementare tutti e 4 i metodi dell'interfaccia `FileVisitor`.
 */
class MyDetailedFileVisitor extends SimpleFileVisitor<Path> {
    // --- SPIEGAZIONE DELL'OVERRIDE: preVisitDirectory ---
    // Questo metodo viene chiamato PRIMA di entrare in una directory.
    // Lo sovrascriviamo per eseguire un'azione all'inizio della visita di una cartella.
    // Il valore `FileVisitResult` che restituiamo permette di controllare il flusso della visita.
    // Ad esempio, potremmo restituire `SKIP_SUBTREE` per dire: "non entrare in questa cartella".
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        System.out.println("  -> [Visitor] Sto per entrare nella directory: " + dir.getFileName());
        // `FileVisitResult.CONTINUE` dice: "Sì, procedi con la visita di questa directory".
        return FileVisitResult.CONTINUE;
    }

    // --- SPIEGAZIONE DELL'OVERRIDE: visitFile ---
    // Questo metodo viene chiamato per OGNI file incontrato durante la "camminata".
    // Lo sovrascriviamo perché è qui che, di solito, si compie l'azione principale sul file
    // (es. leggerlo, copiarlo, analizzarlo, etc.).
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        System.out.println("    -> [Visitor] Sto visitando il file: " + file.getFileName() + " (dimensione: " + attrs.size() + " bytes)");
        return FileVisitResult.CONTINUE;
    }

    // --- SPIEGAZIONE DELL'OVERRIDE: postVisitDirectory ---
    // Questo metodo viene chiamato DOPO aver visitato una directory e TUTTO il suo contenuto.
    // Lo sovrascriviamo per eseguire azioni di "pulizia" o di riepilogo alla fine della visita
    // di una cartella. È il posto ideale per cancellare una directory, come visto nella pulizia finale.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.println("  <- [Visitor] Ho finito di visitare la directory: " + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    // --- SPIEGAZIONE DELL'OVERRIDE: visitFileFailed ---
    // Questo metodo viene chiamato se l'accesso a un file fallisce (es. per permessi mancanti).
    // Lo sovrascriviamo per gestire gli errori in modo controllato, invece di far terminare
    // l'intera operazione con un'eccezione. Possiamo decidere se terminare (`TERMINATE`) o continuare (`CONTINUE`).
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println("  !! [Visitor] ERRORE: Impossibile accedere a: " + file.getFileName() + ". Causa: " + exc.getMessage());
        return FileVisitResult.CONTINUE; // Decidiamo di continuare comunque.
    }
}
