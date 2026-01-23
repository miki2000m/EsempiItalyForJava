package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.cChiccheJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * GUIDA ALLE "CHICCHE" DI JAVA MODERNO
 *
 * Questo file è un tutorial eseguibile che raccoglie alcune delle API e delle funzionalità
 * più utili introdotte nelle versioni recenti di Java (da Java 9 in poi),
 * progettate per rendere il codice più conciso, leggibile e meno verboso.
 */
public class MainChicche {

    public static void main(String[] args) throws IOException {
        System.out.println("--- GUIDA ALLE CHICCHE DI JAVA MODERNO ---\n");

        sezione1_CollezioniImmutabili();
        sezione2_NuoviMetodiString();
        sezione3_IOFileSemplificato();
        sezione4_OptionalAvanzato();
    }

    private static void sezione1_CollezioniImmutabili() {
        System.out.println("--- 1. Factory Methods per Collezioni Immutabili (da Java 9) ---");
        System.out.println("Spiegazione: Metodi statici `of()` per creare al volo collezioni immutabili.\n" +
                "Una volta create, non possono essere modificate (lancia `UnsupportedOperationException`).\n");

        // Creazione di una Lista immutabile
        List<String> frutti = List.of("Mela", "Banana", "Arancia");
        System.out.println("Lista creata con List.of(): " + frutti);
        // frutti.add("Ananas"); // ERRORE: Lancia UnsupportedOperationException

        // Creazione di un Set immutabile (non ammette duplicati)
        Set<Integer> numeri = Set.of(1, 2, 3, 4);
        System.out.println("Set creato con Set.of() (senza duplicati): " + numeri);

        // Tentativo di creare un Set con duplicati: lancia IllegalArgumentException
        System.out.println("\nAzione: Tentativo di creare un Set con duplicati usando Set.of(1, 2, 3, 2).");
        System.out.println("Risultato Atteso: `IllegalArgumentException`, perché Set.of() non ammette duplicati.");
        try {
            Set.of(1, 2, 3, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("  -> Eccezione catturata correttamente: " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }

        // Creazione di una Mappa immutabile
        Map<String, String> capitali = Map.of(
            "Italia", "Roma",
            "Francia", "Parigi"
        );
        System.out.println("\nMappa creata con Map.of(): " + capitali);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_NuoviMetodiString() {
        System.out.println("--- 2. Nuovi Metodi Utili della Classe `String` ---");
        System.out.println("Spiegazione: Le versioni recenti di Java hanno arricchito la classe String con metodi molto comodi.\n");

        // isBlank() (da Java 11)
        String s1 = "   ";
        System.out.println("La stringa '   ' è vuota? " + s1.isEmpty()); // false
        System.out.println("La stringa '   ' è 'blank' (vuota o solo spazi)? " + s1.isBlank()); // true

        // lines() (da Java 11)
        String multiriga = "Prima riga\nSeconda riga\nTerza riga";
        System.out.println("\nUso di .lines() per processare un testo multiriga:");
        multiriga.lines() // Restituisce uno Stream<String>
                 .filter(linea -> linea.contains("Seconda"))
                 .forEach(linea -> System.out.println("  -> Trovata: " + linea));

        // strip(), stripLeading(), stripTrailing() (da Java 11)
        String conSpazi = "  ciao mondo  ";
        System.out.println("\nUso di .strip() per rimuovere spazi (Unicode-aware):");
        System.out.println("Stringa originale: '" + conSpazi + "'");
        System.out.println("Stringa con .strip(): '" + conSpazi.strip() + "'"); // Simile a trim(), ma più moderno

        // repeat() (da Java 11)
        String eco = "Eco... ";
        System.out.println("\nUso di .repeat() per ripetere una stringa:");
        System.out.println(eco.repeat(3)); // Stampa "Eco... Eco... Eco... "
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_IOFileSemplificato() throws IOException {
        System.out.println("--- 3. I/O su File Semplificato (da Java 11) ---");
        System.out.println("Spiegazione: La classe `Files` ora permette di leggere e scrivere file di testo con una sola riga di codice.\n");

        Path percorsoFile = Paths.get("chicche_file_test.txt");

        // Scrivere un'intera stringa su un file
        System.out.println("Azione: Scrittura di un file con Files.writeString().");
        String contenutoDaScrivere = "Ciao Mondo!\nQuesta è una prova di scrittura semplificata.";
        Files.writeString(percorsoFile, contenutoDaScrivere);
        System.out.println("Risultato: File '" + percorsoFile + "' scritto con successo.");

        // Leggere l'intero contenuto di un file in una stringa
        System.out.println("\nAzione: Lettura di un file con Files.readString().");
        String contenutoLetto = Files.readString(percorsoFile);
        System.out.println("Risultato: Contenuto letto dal file:\n---\n" + contenutoLetto + "\n---");

        // Pulizia
        Files.delete(percorsoFile);
        System.out.println("\nFile di test cancellato.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione4_OptionalAvanzato() {
        System.out.println("--- 4. Miglioramenti alla Classe `Optional` ---");
        System.out.println("Spiegazione: Nuovi metodi rendono `Optional` ancora più potente e integrato con la programmazione funzionale.\n");

        Optional<String> valorePresente = Optional.of("Valore");
        Optional<String> valoreAssente = Optional.empty();

        // ifPresentOrElse() (da Java 9)
        System.out.println("Uso di .ifPresentOrElse():");
        valorePresente.ifPresentOrElse(
            val -> System.out.println("  - Valore presente: " + val),
            () -> System.out.println("  - Valore non presente.")
        );
        valoreAssente.ifPresentOrElse(
            val -> System.out.println("  - Valore presente: " + val),
            () -> System.out.println("  - Valore non presente.")
        );

        // or() (da Java 9)
        System.out.println("\nUso di .or() per fornire un Optional alternativo:");
        // Se `valoreAssente` è vuoto, usa l'alternativa.
        Optional<String> risultato = valoreAssente.or(() -> Optional.of("Default"));
        System.out.println("  - Risultato di .or(): " + risultato.get());

        // stream() (da Java 9)
        System.out.println("\nUso di .stream() per convertire un Optional in uno Stream:");
        // Converte un Optional in uno Stream che contiene 0 o 1 elemento.
        // Utile per integrare un Optional in una pipeline di Stream.
        valorePresente.stream()
                      .map(String::toUpperCase)
                      .forEach(val -> System.out.println("  - Valore dallo stream: " + val));
        long count = valoreAssente.stream().count();
        System.out.println("  - Numero di elementi nello stream di un Optional vuoto: " + count);
        System.out.println("----------------------------------------");
    }
}
