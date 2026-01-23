package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.eAPI_Di_Utilita;

// =================================================================================
// !!! ATTENZIONE: QUESTO FILE È PURAMENTE DIMOSTRATIVO !!!
// =================================================================================
//
// Il codice in questo file utilizza librerie di terze parti (Lombok, Apache Commons, Guava).
// Per compilare ed eseguire questo codice, sarebbe necessario aggiungere i file JAR
// di queste librerie al classpath del progetto.
//
// Lo scopo di questo file è solo quello di MOSTRARE come queste librerie
// semplificano il codice Java, come spiegato nel file di riepilogo.
//
// Per questo motivo, le dichiarazioni di import e il codice che le usa
// sono stati commentati per evitare errori di compilazione nel progetto attuale.
// =================================================================================

// import lombok.Data;
// import org.apache.commons.lang3.StringUtils;
// import com.google.common.collect.ImmutableList;
// import com.google.common.base.Preconditions;

/**
 * GUIDA ALLE API DI UTILITÀ PER LA PRODUTTIVITÀ
 *
 * Questo file è una dimostrazione di come alcune librerie di terze parti molto popolari
 * possono ridurre drasticamente il codice boilerplate e semplificare operazioni comuni.
 */

// --- 1. LOMBOK: Addio Boilerplate ---
// L'annotazione @Data di Lombok genera automaticamente al momento della compilazione:
// - Getter per tutti i campi.
// - Setter per tutti i campi non final.
// - Un costruttore con tutti i campi richiesti.
// - Un'implementazione di toString(), equals() e hashCode().
//
// @Data
// class ProdottoLombok {
//     private final String nome;
//     private double prezzo;
// }


public class MainAPIUtili {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLE API DI UTILITÀ (ESEMPI DIMOSTRATIVI) ---\n");

        sezione1_Lombok();
        sezione2_ApacheCommons();
        sezione3_Guava();
    }

    private static void sezione1_Lombok() {
        System.out.println("--- 1. Lombok: Scrivere meno, fare di più ---");
        System.out.println("Spiegazione: Lombok usa le annotazioni per generare codice Java comune al posto tuo.\n");

        // Esempio di come si userebbe la classe ProdottoLombok:
        // ProdottoLombok prodotto = new ProdottoLombok("Laptop", 1200.0);
        // System.out.println(prodotto.toString()); // toString() generato automaticamente
        // prodotto.setPrezzo(1150.0); // setter generato automaticamente
        // System.out.println("Nuovo prezzo: " + prodotto.getPrezzo()); // getter generato automaticamente

        System.out.println("  // @Data");
        System.out.println("  // class Prodotto { private final String nome; private double prezzo; }");
        System.out.println("  // Con Lombok, questa semplice dichiarazione genera costruttori, getter, setter, toString(), equals() e hashCode().");
        System.out.println("  // (Il codice è commentato per permettere la compilazione senza la libreria).\n");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_ApacheCommons() {
        System.out.println("--- 2. Apache Commons Lang: Utilità per le basi ---");
        System.out.println("Spiegazione: Fornisce centinaia di metodi di utilità per operazioni comuni su stringhe, numeri e oggetti.\n");

        // Esempio con StringUtils
        String testo1 = null;
        String testo2 = "   ";
        String testo3 = "Ciao";

        // boolean isEmpty = StringUtils.isEmpty(testo1); // true
        // boolean isBlank = StringUtils.isBlank(testo2); // true
        // String defaultString = StringUtils.defaultIfBlank(testo1, "Default"); // "Default"

        System.out.println("  Esempio con StringUtils (codice commentato):");
        System.out.println("  - `StringUtils.isBlank(\"   \")` -> true (molto più sicuro di .trim().isEmpty())");
        System.out.println("  - `StringUtils.isNumeric(\"123\")` -> true");
        System.out.println("  - `StringUtils.abbreviate(\"Frase molto lunga\", 10)` -> \"Frase m...\"");
        System.out.println();
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_Guava() {
        System.out.println("--- 3. Google Guava: Collezioni Potenziate e Precondizioni ---");
        System.out.println("Spiegazione: Una libreria estremamente potente che arricchisce il JDK, specialmente per le collezioni.\n");

        // Esempio di collezioni immutabili
        // ImmutableList<String> listaImmutabile = ImmutableList.of("a", "b", "c");
        // ImmutableList<String> listaCopia = ImmutableList.copyOf(unaListaEsistente);

        System.out.println("  Esempio con Collezioni Guava (codice commentato):");
        System.out.println("  - `ImmutableList.of(\"a\", \"b\")` -> Crea una lista immutabile in modo sicuro.");
        System.out.println("  - `Multimaps.forListMultimap()` -> Crea una mappa che può avere più valori per la stessa chiave.\n");

        // Esempio di Preconditions per la validazione
        System.out.println("  Esempio con Preconditions (codice commentato):");
        System.out.println("  // public void setEta(int eta) {");
        System.out.println("  //   Preconditions.checkArgument(eta >= 0, \"L'età non può essere negativa\");");
        System.out.println("  //   this.eta = eta;");
        System.out.println("  // }");
        System.out.println("  Spiegazione: `Preconditions` fornisce metodi per la validazione degli argomenti, lanciando eccezioni chiare se una condizione non è rispettata.");
        System.out.println("----------------------------------------");
    }
}
