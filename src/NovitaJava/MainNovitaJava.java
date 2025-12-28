package NovitaJava;

// import static java.lang.StringTemplate.STR; // Commentato per evitare errori di compilazione

/**
 * GUIDA AD ALCUNE NOVITÀ RECENTI DI JAVA (POST-JAVA 17)
 *
 * Questo file è un tutorial eseguibile che illustra alcune delle funzionalità più interessanti
 * introdotte nelle versioni recenti di Java, con un focus su Java 21.
 */

// Record e Interfacce usati per gli esempi
record Punto(int x, int y) {}
sealed interface Forma permits Cerchio, Rettangolo {}
record Cerchio(double raggio) implements Forma {}
record Rettangolo(double base, double altezza) implements Forma {}

public class MainNovitaJava {

    public static void main(String[] args) {
        System.out.println("--- GUIDA AD ALCUNE NOVITÀ DI JAVA ---\n");

        sezione1_RecordPatterns();
        sezione2_PatternMatchingSwitch();
        sezione3_StringTemplates();
    }

    private static void sezione1_RecordPatterns() {
        System.out.println("--- 1. Record Patterns (Java 21, Final) ---");
        System.out.println("Spiegazione: I Record Patterns sono un'evoluzione del 'pattern matching for instanceof'.\n" +
                "Permettono non solo di controllare il tipo di un oggetto e fare il cast, ma anche di\n" +
                "de-costruire un record per accedere direttamente ai suoi componenti in modo sicuro e conciso.\n");

        Object obj = new Punto(10, 20);

        // --- MODO TRADIZIONALE (pre-Java 16) ---
        System.out.println("A) Modo tradizionale:");
        if (obj instanceof Punto) {
            Punto p = (Punto) obj;
            System.out.println("   x = " + p.x() + ", y = " + p.y());
        }

        // --- PATTERN MATCHING FOR INSTANCEOF (Java 16+) ---
        System.out.println("\nB) Con Pattern Matching per instanceof:");
        if (obj instanceof Punto p) {
            // `p` è già castata e disponibile in questo scope
            System.out.println("   x = " + p.x() + ", y = " + p.y());
        }

        // --- RECORD PATTERNS (Java 21) ---
        System.out.println("\nC) Con Record Patterns (la novità):");
        if (obj instanceof Punto(int x, int y)) {
            // Le variabili `x` e `y` sono estratte direttamente dal record e disponibili qui!
            // Non serve più nemmeno la variabile intermedia `p`.
            System.out.println("   x = " + x + ", y = " + y);
            System.out.println("   La somma è: " + (x + y));
        }
        System.out.println("\n----------------------------------------\n");
    }

    private static void sezione2_PatternMatchingSwitch() {
        System.out.println("--- 2. Pattern Matching per `switch` (Java 21, Final) ---");
        System.out.println("Spiegazione: Lo `switch` moderno può essere usato per testare il tipo di un oggetto e de-costruirlo\n" +
                "direttamente nei `case`, rendendo il codice estremamente leggibile e sicuro.\n");

        Forma forma1 = new Cerchio(5.0);
        Forma forma2 = new Rettangolo(4.0, 6.0);

        System.out.println("Azione: Calcolare l'area usando uno `switch` con Pattern Matching.");

        System.out.println("\nCalcolo area per un Cerchio:");
        processaForma(forma1);

        System.out.println("\nCalcolo area per un Rettangolo:");
        processaForma(forma2);

        System.out.println("\nEsempio con `case null` e clausola `when`:");
        processaForma(null); // Gestione del caso nullo
        processaForma(new Rettangolo(5.0, 5.0)); // Gestione del caso "quadrato"
        System.out.println("\n----------------------------------------\n");
    }

    // Metodo di supporto che usa lo switch con pattern matching
    private static void processaForma(Forma forma) {
        // Questo switch è un'espressione, quindi restituisce un valore.
        String risultato = switch (forma) {
            // Case 1: Se `forma` è un'istanza di Cerchio, de-costruiscila in `raggio`
            case Cerchio(double raggio) ->
                String.format("   -> Cerchio di raggio %.1f. Area = %.2f", raggio, Math.PI * raggio * raggio);

            // Case 2: Se `forma` è un Rettangolo, de-costruiscila in `b` e `h`
            // La clausola `when` aggiunge una condizione ulteriore.
            case Rettangolo(double b, double h) when b == h ->
                String.format("   -> Quadrato di lato %.1f. Area = %.2f", b, b * h);

            case Rettangolo(double b, double h) ->
                String.format("   -> Rettangolo di base %.1f e altezza %.1f. Area = %.2f", b, h, b * h);

            // Case 3: Gestione esplicita del caso `null`
            case null -> "   -> La forma è nulla.";

            // Case 4: Il `default` è obbligatorio se l'interfaccia non è `sealed`
            // o se non tutti i casi sono coperti.
            default -> "   -> Tipo di forma non riconosciuto.";
        };
        System.out.println(risultato);
    }


    private static void sezione3_StringTemplates() {
        System.out.println("--- 3. String Templates (Java 21, Preview) ---");
        System.out.println("Spiegazione: Le String Templates sono un nuovo modo per comporre stringhe, più sicuro e leggibile\n" +
                "rispetto alla concatenazione con `+` o a `String.format()`.\n" +
                "Usano un 'template processor' (come `STR`) e variabili incorporate nel testo con `\\{nomeVariabile}`.\n");

        String nome = "Maria";
        int eta = 30;

        // --- MODO TRADIZIONALE ---
        String saluto1 = "Ciao, mi chiamo " + nome + " e ho " + eta + " anni.";
        System.out.println("A) Concatenazione con '+':\n   " + saluto1);

        // --- MODO CON STRING.FORMAT ---
        String saluto2 = String.format("Ciao, mi chiamo %s e ho %d anni.", nome, eta);
        System.out.println("\nB) Con String.format():\n   " + saluto2);


        // ##################################################################################
        // ### IL CODICE SEGUENTE È STATO COMMENTATO PER EVITARE ERRORI DI COMPILAZIONE ###
        // ##################################################################################
        //
        // Le String Templates sono una "preview feature" in Java 21. Per attivarle,
        // devi configurare il tuo progetto in modo specifico.
        //
        // Per riattivare questo esempio:
        // 1. De-commenta il blocco di codice sottostante E la riga di import all'inizio del file.
        // 2. In IntelliJ IDEA, vai su: File -> Project Structure...
        // 3. In "Project", imposta "Project SDK" su Java 21 e "Project language level" su "21 (Preview)".
        // 4. In "Modules", seleziona il tuo modulo e imposta "Language level" su "21 (Preview)".
        //
        // ##################################################################################
        /*
        // --- MODO CON STRING TEMPLATES (Java 21 Preview) ---
        // `STR` è un "template processor" standard importato staticamente.
        // La sintassi `\{...}` permette di inserire variabili o espressioni direttamente nella stringa.
        String saluto3 = STR."Ciao, mi chiamo \{nome} e ho \{eta} anni.";
        System.out.println("\nC) Con String Templates (STR):\n   " + saluto3);

        // Le espressioni complesse sono permesse
        int x = 10;
        int y = 5;
        String calcolo = STR."La somma di \{x} e \{y} è \{x + y}.";
        System.out.println("\n   Le espressioni sono permesse: " + calcolo);
        */
        System.out.println("\nC) Esempio di String Templates commentato per evitare errori di compilazione.");
        System.out.println("   (Leggi i commenti nel codice per sapere come attivarlo).");
        System.out.println("\n----------------------------------------");
    }
}
