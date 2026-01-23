package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.bSealedExample;

// --- SPIEGAZIONE TEORICA SEMPLICE ---
//
// Immagina di voler creare le regole per un gioco di carte. Vuoi definire una "Carta",
// e vuoi che le uniche carte possibili siano "CartaDiCuori", "CartaDiFiori", etc.
// Non vuoi che qualcuno in futuro possa inventarsi una "CartaDiMuri" e rompere il tuo gioco.
//
// Le `Sealed Classes` (Classi Sigillate) servono proprio a questo: a creare una "famiglia chiusa".
//
// 1. `sealed`: È la parola chiave che usi per "sigillare" una classe o un'interfaccia.
//    È come dire: "Sto creando una famiglia con regole di appartenenza precise".
//
// 2. `permits`: È la "lista degli invitati". Qui elenchi, separati da virgole,
//    tutti e soli i membri diretti che sono autorizzati a far parte della famiglia.

//Sigillo l'interfaccia Forma e gli invitati sono Cerchio, Quadrato e FormaStrana
sealed interface Forma permits Cerchio, Quadrato, FormaStrana {
    // Questo è il "capofamiglia". Definisce un comportamento che tutti i membri devono avere.
    double area();
}


// --- LE 3 REGOLE PER I MEMBRI DELLA FAMIGLIA ---
//
// Ogni classe nella lista `permits` (ogni "invitato") deve dichiarare come intende proseguire la sua discendenza.
// Ha tre scelte obbligatorie:

// REGOLA 1: `final` -> NON POSSONO ESSERE MODIFICATE IN FUTURO
// Questa è la scelta più comune. La classe `Cerchio` è un tipo di `Forma`, e basta.
// Nessuno potrà mai creare una classe che estende `Cerchio`.
final class Cerchio implements Forma {
    private final double raggio;

    public Cerchio(double raggio) { this.raggio = raggio; }

    @Override
    public double area() { return Math.PI * raggio * raggio; }

    public double raggio() { return raggio; }
}


// REGOLA 2: `non-sealed` -> "La mia discendenza è aperta a tutti."
// Questa classe "rompe il sigillo". Dice al compilatore: "Io, `Quadrato`, sono un tipo di `Forma`,
// ma chiunque può creare nuove sottoclassi di `Quadrato` in futuro".
// Si torna al comportamento normale di Java.
//Io non sigillo più Quadrato me implemento comunque Forma
non-sealed class Quadrato implements Forma {
    private final double lato;

    public Quadrato(double lato) { this.lato = lato; }

    @Override
    public double area() { return lato * lato; }

    public double lato() { return lato; }
}

// Infatti, ora possiamo estendere `Quadrato` liberamente.
class QuadratoColorato extends Quadrato {
    private final String colore;
    public QuadratoColorato(double lato, String colore) {
        super(lato);
        this.colore = colore;
    }
    public String colore() { return colore; }
}


// REGOLA 3: `sealed` -> "Anche la mia discendenza ha una lista di invitati."
// Questa classe continua la sigillatura. `FormaStrana` è un tipo di `Forma`,
// ma a sua volta permette solo a `Triangolo` e `Pentagono` di estenderla.
// Crea una "sotto-famiglia" chiusa.
sealed class FormaStrana implements Forma permits Triangolo, Pentagono {
    @Override
    public double area() { return 0; }
}

// E i suoi figli devono di nuovo seguire una delle 3 regole. Qui usiamo `final`.
final class Triangolo extends FormaStrana {}
final class Pentagono extends FormaStrana {}


public class Main {
    /**
     * GUIDA COMPLETA ALLE SEALED CLASSES (CLASSI SIGILLATE) IN JAVA
     *
     * Questo file è un tutorial eseguibile che illustra, con spiegazioni ed esempi,
     * come usare le `Sealed Classes` per controllare le gerarchie di ereditarietà.
     */
    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLE SEALED CLASSES ---");
        System.out.println("Spiegazione Concettuale: Le Sealed Classes permettono di creare gerarchie 'chiuse'.\n");

        Forma cerchio = new Cerchio(10.0);
        Forma quadrato = new Quadrato(5.0);
        Forma quadratoColorato = new QuadratoColorato(4.0, "Rosso");
        Forma triangolo = new Triangolo();

        System.out.println("--- IL VERO POTERE: Switch che non possono sbagliare ---");
        System.out.println("Spiegazione: Ora vedremo nel dettaglio il metodo `processaForma`, dove la magia accade.\n");

        processaForma(cerchio);
        System.out.println(); // Aggiungo una riga vuota per leggibilità
        processaForma(quadrato);
        System.out.println();
        processaForma(quadratoColorato);
        System.out.println();
        processaForma(triangolo);
    }

    public static void processaForma(Forma forma) {
        System.out.println("Analizzando l'oggetto: " + forma.getClass().getSimpleName());

        // --- SPIEGAZIONE ULTRA-DETTAGLIATA DELLO SWITCH ---
        //
        // Questo non è un `switch` tradizionale. È uno "switch potenziato" di Java che usa il "Pattern Matching".
        // Analizziamolo passo dopo passo.
        //
        // L'idea generale è: "switch (sull'oggetto forma) { ... }".
        // Per ogni `case`, Java controllerà il TIPO dell'oggetto `forma`.

        String descrizione = switch (forma) {

            // --- PRIMO CASO: IL PIÙ SEMPLICE ---
            // `case Cerchio c`: Questa riga è una domanda e un'azione in una.
            // 1. La Domanda (Type Check): "Ehi, oggetto `forma`, sei per caso un `Cerchio`?"
            // 2. L'Azione (Pattern Variable): Se la risposta è "sì", Java fa una cosa potentissima:
            //    crea una nuova variabile chiamata `c` che è GIÀ del tipo `Cerchio`.
            //    Questo si chiama "Pattern Matching". Grazie a `c`, possiamo chiamare `c.raggio()`
            //    direttamente, senza bisogno di fare un cast manuale come `((Cerchio)forma).raggio()`.
            case Cerchio c -> {
                System.out.println("  -> L'oggetto è un `Cerchio`. Creo la variabile `c` di tipo `Cerchio`.");
                yield "È un cerchio con raggio " + c.raggio() + " e area " + String.format("%.2f", c.area());
            }

            // --- SECONDO CASO: GESTIRE L'EREDITARIETÀ ---
            // `case Quadrato s`: Anche qui, si fa la domanda: "Oggetto `forma`, sei un `Quadrato`?"
            //    La cosa interessante è che `QuadratoColorato` ESTENDE `Quadrato`, quindi un `QuadratoColorato`
            //    È ANCHE un `Quadrato`. Per questo motivo, questo `case` cattura sia gli oggetti `Quadrato`
            //    puri, sia tutte le sue sottoclassi come `QuadratoColorato`.
            case Quadrato s -> {
                System.out.println("  -> L'oggetto è un `Quadrato` (o una sua sottoclasse). Creo la variabile `s` di tipo `Quadrato`.");
                yield "È una forma quadrata con lato " + s.lato() + " e area " + String.format("%.2f", s.area());
            }

            // --- TERZO CASO: GESTIRE UNA SOTTO-FAMIGLIA ---
            // `case FormaStrana fs`: Questo caso gestisce l'intera sotto-famiglia sigillata.
            //    Cattura sia `Triangolo` che `Pentagono`, perché entrambi sono tipi di `FormaStrana`.
            case FormaStrana fs -> {
                System.out.println("  -> L'oggetto appartiene alla sotto-famiglia `FormaStrana`. Creo la variabile `fs`.");
                yield "È una forma strana (in questo caso, un " + fs.getClass().getSimpleName() + ").";
            }

            // --- LA MAGIA FINALE: PERCHÉ MANCA IL `default`? ---
            // In uno switch normale, saresti obbligato a mettere un `default:` per gestire tutti i casi non previsti.
            // QUI NON SERVE, e questo è il punto chiave delle classi sigillate.
            //
            // Perché? Perché hai "sigillato" l'interfaccia `Forma`. Hai dato al compilatore la "lista degli invitati":
            // `permits Cerchio, Quadrato, FormaStrana`.
            //
            // Il compilatore ha letto questa lista e ha controllato il nostro `switch`. Ha visto che abbiamo gestito
            // tutti e tre i casi. Quindi, è matematicamente certo che non ci siano altre possibilità.
            // Lo `switch` è "esaustivo" (cioè completo).
            //
            // PROVA TU: Prova a commentare una delle righe `case`. Il codice non compilerà più!
            // Il compilatore ti darà un errore del tipo "lo switch non copre tutti i possibili valori".
            // Questa è una garanzia di sicurezza potentissima contro i bug.
        };
        System.out.println("  Risultato: " + descrizione);
    }
}
