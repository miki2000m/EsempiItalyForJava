package MODULO_4_PROGRAMMAZIONE_FUNZIONALE_E_MODERNA.dOptionalExample;

import java.util.Optional;

/**
 * GUIDA SEMPLIFICATA ALLA CLASSE OPTIONAL DI JAVA
 *
 * Questo file è un tutorial pensato per farti capire in modo semplice e pratico
 * a cosa serve la classe `Optional`. L'obiettivo principale di `Optional` è
 * evitare il famigerato `NullPointerException` e rendere il codice più chiaro.
 *
 * Immagina `Optional` come una "scatola": può contenere un valore oppure essere vuota.
 * Prima di aprirla, Java ti "costringe" a pensare a cosa fare se la scatola è vuota.
 */
public class Main {

    /**
     * Un metodo di ricerca che, invece di restituire `null` se non trova nulla,
     * restituisce un `Optional` vuoto. È molto più sicuro e chiaro.
     * @param id L'ID dell'utente da cercare.
     * @return Un `Optional` contenente il nome dell'utente se trovato, altrimenti un `Optional` vuoto.
     */
    public static Optional<String> trovaNomeUtente(int id) {
        if (id == 1) {
            // Trovato! Mettiamo il valore "Mario" dentro la scatola.
            return Optional.of("Mario");
        }
        // Non trovato. Restituiamo una scatola vuota.
        return Optional.empty();
    }

    public static void main(String[] args) {
        System.out.println("--- GUIDA PRATICA AGLI OPTIONAL ---\n");
        System.out.println("L'idea base: `Optional` è una scatola che può contenere un valore o essere vuota.\n" +
                "Questo ci obbliga a gestire il caso 'valore assente' e previene errori.\n");

        sezione1_CreareUnOptional();
        sezione2_ControllareSeLaScatolaEVuota();
        sezione3_EstrarreIlValoreInSicurezza();
        sezione4_TrasformareIlValoreNellaScatola();
    }

    private static void sezione1_CreareUnOptional() {
        System.out.println("--- 1. Come si crea una 'scatola' Optional ---");

        // Metodo 1: Optional.of() -> Per valori che SIAMO SICURI non siano null.
        // Se provi a metterci `null`, lancia un'eccezione subito.
        Optional<String> optionalPieno = Optional.of("Valore Sicuro");
        System.out.println("A) `Optional.of()`:      " + optionalPieno);

        // Metodo 2: Optional.empty() -> Per rappresentare l'assenza di un valore.
        // Questa è la "scatola vuota".
        Optional<String> optionalVuoto = Optional.empty();
        System.out.println("B) `Optional.empty()`:    " + optionalVuoto);

        // Metodo 3: Optional.ofNullable() -> Il più sicuro e usato.
        // Se il valore è presente, lo mette nella scatola. Se è `null`, restituisce una scatola vuota.
        String valoreForseNullo = null;
        Optional<String> optionalDaNull = Optional.ofNullable(valoreForseNullo);
        System.out.println("C) `ofNullable(null)`: " + optionalDaNull);

        String valorePresente = "Ciao";
        Optional<String> optionalDaValore = Optional.ofNullable(valorePresente);
        System.out.println("D) `ofNullable(\"Ciao\")`: " + optionalDaValore + "\n");
    }

    private static void sezione2_ControllareSeLaScatolaEVuota() {
        System.out.println("--- 2. Come controllare se la 'scatola' ha un valore ---");
        Optional<String> utenteTrovato = trovaNomeUtente(1); // Restituisce Optional.of("Mario")
        Optional<String> utenteNonTrovato = trovaNomeUtente(2); // Restituisce Optional.empty()

        // Modo 1: `isPresent()` e `isEmpty()` (il vecchio `if...!= null`)
        System.out.println("A) Controllo con `isPresent()`:");
        if (utenteTrovato.isPresent()) {
            System.out.println("   - L'utente 1 è presente? Sì. (`isPresent()` è true)");
        }
        if (utenteNonTrovato.isEmpty()) {
            System.out.println("   - L'utente 2 è vuoto? Sì. (`isEmpty()` è true)");
        }

        // Modo 2: `ifPresent()` (più moderno e leggibile)
        // "Se c'è un valore, fai qualcosa con esso."
        System.out.println("\nB) Esecuzione con `ifPresent()`:");
        utenteTrovato.ifPresent(nome -> System.out.println("   - Ciao, " + nome + "! (Eseguito solo perché l'Optional non era vuoto)"));

        // Modo 3: `ifPresentOrElse()` (la versione completa)
        // "Se c'è un valore, fai una cosa. Altrimenti, fanne un'altra."
        System.out.println("\nC) Esecuzione con `ifPresentOrElse()`:");
        utenteNonTrovato.ifPresentOrElse(
            nome -> System.out.println("   - Questo non verrà stampato."),
            () -> System.out.println("   - L'utente non è stato trovato. (Eseguito perché l'Optional era vuoto)")
        );
        System.out.println();
    }

    private static void sezione3_EstrarreIlValoreInSicurezza() {
        System.out.println("--- 3. Come prendere il valore dalla 'scatola' ---");
        Optional<String> utenteTrovato = trovaNomeUtente(1);
        Optional<String> utenteNonTrovato = trovaNomeUtente(2);

        // MODO DA EVITARE: .get()
        // ATTENZIONE! Usare .get() è pericoloso. Se l'Optional è vuoto, lancia un'eccezione.
        // È come aprire la scatola senza controllare: è la nuova versione del NullPointerException.
        // DA USARE SOLO SE SI È ASSOLUTAMENTE CERTI CHE IL VALORE CI SIA (es. dopo un `if (opt.isPresent())`).
        // System.out.println(utenteNonTrovato.get()); // Questo manderebbe in crash il programma!

        // MODO SICURO 1: `orElse(valoreDefault)`
        // "Prendi il valore dalla scatola, ma se è vuota, usa questo valore di default."
        String nome1 = utenteTrovato.orElse("Sconosciuto");
        String nome2 = utenteNonTrovato.orElse("Sconosciuto");
        System.out.println("A) `orElse()`: Se l'utente 1 esiste, ottengo -> " + nome1);
        System.out.println("   `orElse()`: Se l'utente 2 non esiste, ottengo -> " + nome2);

        // MODO SICURO 2: `orElseGet(supplier)`
        // Simile a `orElse`, ma il valore di default viene calcolato solo se serve.
        // Utile se creare il default è un'operazione "costosa" (es. una chiamata a un database).
        String nome3 = utenteNonTrovato.orElseGet(() -> {
            // Questo codice viene eseguito SOLO perché utenteNonTrovato è vuoto.
            System.out.println("   (Sto calcolando il valore di default...)");
            return "Default Calcolato";
        });
        System.out.println("B) `orElseGet()`: " + nome3);

        // MODO SICURO 3: `orElseThrow()`
        // "Dammi il valore, ma se non c'è, lancia un'eccezione".
        // Si usa quando il valore è obbligatorio per il proseguimento del programma.
        try {
            String nomeEsistente = utenteTrovato.orElseThrow();
            System.out.println("C) `orElseThrow()`: Se l'utente 1 esiste, ottengo -> " + nomeEsistente);
            utenteNonTrovato.orElseThrow(() -> new IllegalStateException("L'utente deve esistere!"));
        } catch (Exception e) {
            System.out.println("   `orElseThrow()`: Se l'utente 2 non esiste, viene lanciata un'eccezione -> " + e.getClass().getSimpleName() + "\n");
        }
    }

    private static void sezione4_TrasformareIlValoreNellaScatola() {
        System.out.println("--- 4. Lavorare con il valore senza estrarlo (Stile Funzionale) ---");
        Optional<String> utenteOptional = Optional.of("  Mario Rossi  ");

        // `map()` -> Trasforma il valore DENTRO la scatola.
        // Se la scatola è vuota, non fa nulla e restituisce una scatola vuota.
        Optional<String> utentePulito = utenteOptional.map(String::trim); // Rimuove spazi
        Optional<Integer> lunghezzaNome = utentePulito.map(String::length); // Prende la lunghezza

        System.out.println("A) `map()`: Trasformo '  Mario Rossi  ' in lunghezza -> " + lunghezzaNome.orElse(0));

        // `filter()` -> Mantiene la scatola solo se il valore soddisfa una condizione.
        // Altrimenti, la svuota.
        Optional<String> utenteFiltrato = utentePulito.filter(nome -> nome.startsWith("M"));
        System.out.println("B) `filter()`: Il nome inizia con 'M'? Sì -> " + utenteFiltrato);

        Optional<String> utenteScartato = utentePulito.filter(nome -> nome.startsWith("L"));
        System.out.println("   `filter()`: Il nome inizia con 'L'? No -> " + utenteScartato + " (diventa vuoto)");
    }
}
