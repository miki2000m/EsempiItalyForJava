package OptionalExample;

import java.util.Optional;

/**
 * GUIDA COMPLETA ALLA CLASSE OPTIONAL DI JAVA
 *
 * Questo file è un tutorial eseguibile che illustra, con spiegazioni ed esempi,
 * come usare la classe `Optional` per scrivere codice più pulito, sicuro e leggibile,
 * evitando i tanto temuti `NullPointerException`.
 */
public class Main {

    // Metodo di esempio che potrebbe restituire un valore nullo.
    // Invece di `String`, restituisce `Optional<String>`.
    public static Optional<String> trovaUtenteById(int id) {
        if (id == 1) {
            return Optional.of("Mario Rossi"); // Trovato: incapsuliamo il valore in un Optional.
        }
        return Optional.empty(); // Non trovato: restituiamo un Optional vuoto.
    }

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA CLASSE OPTIONAL ---");
        System.out.println("Spiegazione Concettuale: `Optional` è un contenitore, una 'scatola' che può contenere un valore oppure essere vuota.");
        System.out.println("Il suo scopo è forzare il programmatore a gestire esplicitamente il caso in cui un valore è assente, eliminando la necessità di controlli `if (valore != null)` e prevenendo i `NullPointerException`.\n");

        sezione1_Creazione();
        sezione2_ControlloValore();
        sezione3_EstrazioneValore();
        sezione4_TrasformazioneValore();
    }

    private static void sezione1_Creazione() {
        System.out.println("\n--- 1. Creare un Optional ---");

        // Optional.of(valore) -> Crea un Optional che CONTIENE un valore.
        // ATTENZIONE: Lancia un `NullPointerException` se il valore passato è `null`.
        // Si usa quando si è sicuri che il valore non sia nullo.
        Optional<String> optionalPieno = Optional.of("Ciao Mondo");
        System.out.println("Optional.of(\"Ciao Mondo\") -> " + optionalPieno);

        // Optional.empty() -> Crea un Optional VUOTO.
        // È l'alternativa sicura a `null`.
        Optional<String> optionalVuoto = Optional.empty();
        System.out.println("Optional.empty() -> " + optionalVuoto);

        // Optional.ofNullable(valore) -> Crea un Optional che contiene il valore se non è nullo,
        // altrimenti crea un Optional vuoto. È il modo più sicuro e flessibile per creare un Optional.
        String valoreForseNullo = null;
        Optional<String> optionalDaNullo = Optional.ofNullable(valoreForseNullo);
        System.out.println("Optional.ofNullable(null) -> " + optionalDaNullo);

        String valoreNonNullo = "Valore presente";
        Optional<String> optionalDaNonNullo = Optional.ofNullable(valoreNonNullo);
        System.out.println("Optional.ofNullable(\"Valore presente\") -> " + optionalDaNonNullo);
    }

    private static void sezione2_ControlloValore() {
        System.out.println("\n--- 2. Controllare la Presenza di un Valore ---");
        Optional<String> utenteTrovato = trovaUtenteById(1);
        Optional<String> utenteNonTrovato = trovaUtenteById(2);

        // .isPresent() -> Restituisce `true` se l'Optional contiene un valore, `false` altrimenti.
        // È l'equivalente del vecchio `if (valore != null)`.
        System.out.println("\nControllo con `isPresent()`:");
        if (utenteTrovato.isPresent()) {
            System.out.println("  - Utente 1 è presente? " + utenteTrovato.isPresent() + ". Contiene: " + utenteTrovato.get()); // .get() è sicuro qui
        }
        System.out.println("  - Utente 2 è presente? " + utenteNonTrovato.isPresent());

        // .ifPresent(lambda) -> Esegue il codice della lambda SOLO SE l'Optional contiene un valore.
        // È il modo più elegante e funzionale per eseguire un'azione se un valore esiste.
        System.out.println("\nEsecuzione condizionale con `ifPresent()`:");
        utenteTrovato.ifPresent(nome -> System.out.println("  - `ifPresent` su utente 1: Ciao, " + nome));
        utenteNonTrovato.ifPresent(nome -> System.out.println("  - `ifPresent` su utente 2: Questo messaggio non verrà mai stampato."));
    }

    private static void sezione3_EstrazioneValore() {
        System.out.println("\n--- 3. Estrarre il Valore in Modo Sicuro ---");
        Optional<String> utenteTrovato = trovaUtenteById(1);
        Optional<String> utenteNonTrovato = trovaUtenteById(2);

        // .orElse(valoreDefault) -> Restituisce il valore se presente, altrimenti restituisce il `valoreDefault`.
        // Il valore di default viene sempre creato, anche se non serve.
        String nome1 = utenteTrovato.orElse("Utente Sconosciuto");
        String nome2 = utenteNonTrovato.orElse("Utente Sconosciuto");
        System.out.println("`orElse` su utente 1 -> " + nome1);
        System.out.println("`orElse` su utente 2 -> " + nome2);

        // .orElseGet(supplier) -> Restituisce il valore se presente, altrimenti esegue la lambda (`supplier`)
        // e restituisce il suo risultato. La lambda viene eseguita SOLO se l'Optional è vuoto.
        // È più efficiente di `orElse` se la creazione del valore di default è costosa.
        String nome3 = utenteNonTrovato.orElseGet(() -> {
            System.out.println("  (Eseguo la lambda di orElseGet perché l'Optional è vuoto...)");
            return "Default Calcolato";
        });
        System.out.println("`orElseGet` su utente 2 -> " + nome3);

        // .orElseThrow(supplierEccezione) -> Restituisce il valore se presente, altrimenti lancia l'eccezione
        // creata dalla lambda (`supplier`). È il modo corretto per gestire casi in cui un valore è obbligatorio.
        try {
            String nomeTrovato = utenteTrovato.orElseThrow(); // Versione moderna senza argomenti
            System.out.println("`orElseThrow` su utente 1 -> " + nomeTrovato);
            
            utenteNonTrovato.orElseThrow(() -> new IllegalStateException("L'utente non può essere nullo!"));
        } catch (Exception e) {
            System.out.println("`orElseThrow` su utente 2 ha lanciato correttamente -> " + e.getClass().getSimpleName());
        }
    }

    private static void sezione4_TrasformazioneValore() {
        System.out.println("\n--- 4. Trasformare il Valore con Metodi Funzionali ---");
        Optional<String> utenteOptional = Optional.of("Mario Rossi");

        // .map(lambda) -> Se l'Optional contiene un valore, applica la lambda di trasformazione a quel valore
        // e restituisce un nuovo Optional con il risultato. Se è vuoto, restituisce un Optional vuoto.
        Optional<Integer> lunghezzaNome = utenteOptional.map(nome -> nome.length());
        System.out.println("`map` per ottenere la lunghezza del nome -> " + lunghezzaNome);

        // .filter(predicato) -> Se l'Optional contiene un valore E quel valore soddisfa la condizione (predicato),
        // restituisce l'Optional stesso. Altrimenti, restituisce un Optional vuoto.
        Optional<String> utenteFiltrato = utenteOptional.filter(nome -> nome.startsWith("M"));
        Optional<String> utenteNonFiltrato = utenteOptional.filter(nome -> nome.startsWith("L"));
        System.out.println("`filter` con 'M' -> " + utenteFiltrato);
        System.out.println("`filter` con 'L' -> " + utenteNonFiltrato);

        // .flatMap(lambda) -> Simile a `map`, ma si usa quando la funzione di trasformazione
        // restituisce GIA' un Optional. `flatMap` evita di creare un Optional annidato (es. `Optional<Optional<Integer>>`).
        // Esempio: abbiamo un metodo che restituisce l'età come Optional.
        Optional<Integer> etaOptional = utenteOptional.flatMap(Main::getEtaByUsername);
        System.out.println("`flatMap` per ottenere l'età (che è già un Optional) -> " + etaOptional);
    }

    // Metodo di supporto per l'esempio di flatMap
    public static Optional<Integer> getEtaByUsername(String username) {
        if (username.equals("Mario Rossi")) {
            return Optional.of(30);
        }
        return Optional.empty();
    }
}
