package EccezioniAvanzate;

/**
 * GUIDA ALLA GESTIONE AVANZATA DELLE ECCEZIONI
 *
 * Questo file è un tutorial eseguibile che approfondisce due concetti chiave
 * per la gestione robusta delle eccezioni, spesso testati negli esami:
 * 1. Il costrutto `try-with-resources` con risorse personalizzate (`AutoCloseable`).
 * 2. La gestione delle "Eccezioni Soppresse" (Suppressed Exceptions).
 */

// --- 1. Creare una Risorsa Personalizzata AutoCloseable ---

// Per essere usata in un blocco `try-with-resources`, una classe deve implementare
// l'interfaccia `java.lang.AutoCloseable`.
// Questa interfaccia ha un solo metodo: `void close() throws Exception`.
class RisorsaPersonalizzata implements AutoCloseable {
    // Usiamo 'protected' per rendere il campo accessibile alle sottoclassi.
    protected String nome;

    public RisorsaPersonalizzata(String nome) {
        this.nome = nome;
        System.out.println("  [LOG] -> Risorsa '" + nome + "' APERTA.");
    }

    public void eseguiAzione(boolean lanciaEccezione) throws Exception {
        System.out.println("  [LOG] -> Eseguo azione sulla risorsa '" + nome + "'.");
        if (lanciaEccezione) {
            // Simula un errore durante l'uso della risorsa
            throw new Exception("!!! Errore durante l'esecuzione dell'azione!");
        }
    }

    // Questo metodo viene chiamato AUTOMATICAMENTE alla fine del blocco try-with-resources.
    @Override
    public void close() throws Exception {
        System.out.println("  [LOG] -> Risorsa '" + nome + "' CHIUSA automaticamente.");
    }
}

// Una versione della risorsa che lancia sempre un'eccezione nel metodo close().
class RisorsaCheFallaInChiusura extends RisorsaPersonalizzata {
    public RisorsaCheFallaInChiusura(String nome) { super(nome); }

    @Override
    public void close() throws Exception {
        // Ora possiamo accedere direttamente al campo 'nome' perché è 'protected'.
        System.out.println("  [LOG] -> Tentativo di chiudere la risorsa '" + this.nome + "'...");
        throw new Exception("!!! Errore fatale durante la CHIUSURA della risorsa!");
    }
}


public class MainEccezioniAvanzate {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA GESTIONE AVANZATA DELLE ECCEZIONI ---\n");

        sezione1_TryWithResources();
        sezione2_EccezioniSoppresse();
    }

    private static void sezione1_TryWithResources() {
        System.out.println("--- 1. `try-with-resources` con una Risorsa Personalizzata ---");
        System.out.println("Spiegazione: Il `try-with-resources` garantisce che il metodo `close()` di una risorsa venga sempre chiamato,\n" +
                "rendendo il codice più pulito e sicuro rispetto a un blocco `finally` manuale.\n");

        System.out.println("Azione: Uso di `RisorsaPersonalizzata` in un `try-with-resources` (caso senza errori).");
        try (RisorsaPersonalizzata risorsa = new RisorsaPersonalizzata("Test1")) {
            risorsa.eseguiAzione(false);
            // Appena il blocco try finisce, `risorsa.close()` viene chiamato automaticamente.
        } catch (Exception e) {
            System.err.println("  [ERRORE CATTURATO] -> " + e.getMessage());
        }
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_EccezioniSoppresse() {
        System.out.println("--- 2. Eccezioni Soppresse (Suppressed Exceptions) ---");
        System.out.println("Spiegazione: Cosa succede se un'eccezione viene lanciata sia nel blocco `try` SIA durante la chiusura automatica\n" +
                "della risorsa (nel metodo `close()`)? Java non perde l'informazione: l'eccezione del `close()` viene 'soppressa'\n" +
                "e allegata all'eccezione principale.\n");

        System.out.println("Azione: Uso di una risorsa che lancia un'eccezione sia nell'azione che nella chiusura.");
        try (RisorsaCheFallaInChiusura risorsa = new RisorsaCheFallaInChiusura("Test2")) {
            // Questa azione lancia la prima eccezione (l'eccezione "principale").
            risorsa.eseguiAzione(true);
        } catch (Exception e) {
            System.err.println("  [ERRORE PRINCIPALE CATTURATO] -> " + e.getMessage());

            // Possiamo ispezionare le eccezioni soppresse.
            if (e.getSuppressed().length > 0) {
                System.err.println("  --- Eccezioni Soppresse ---");
                for (Throwable soppressa : e.getSuppressed()) {
                    // L'eccezione lanciata da `close()` si trova qui.
                    System.err.println("    [ERRORE SOPPRESSO] -> " + soppressa.getMessage());
                }
            }
        }
        System.out.println("----------------------------------------");
    }
}
