package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.RecordExample;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- ESEMPIO SUI RECORD ---");

        // 2. CREAZIONE DI UN'ISTANZA (OGGETTO) DEL RECORD
        // Si usa il costruttore generato automaticamente.
        Utente utente1 = new Utente("MarioRossi", "mario.rossi@example.com", 30);
        Utente utente2 = new Utente("LuigiVerdi", "luigi.verdi@example.com", 25);
        Utente utente1Copia = new Utente("MarioRossi", "mario.rossi@example.com", 30);

        System.out.println("\n--- ACCESSO AI DATI ---");
        // 3. ACCESSO AI CAMPI
        // Si usano i metodi "accessor" generati automaticamente, che hanno lo stesso nome del campo.
        System.out.println("Username di utente1: " + utente1.username());
        System.out.println("Email di utente2: " + utente2.email());

        System.out.println("\n--- METODI GENERATI AUTOMATICAMENTE ---");

        // 4. METODO toString()
        // Il metodo toString() fornisce una rappresentazione chiara e leggibile dell'oggetto.
        System.out.println("toString() di utente1 -> " + utente1.toString());

        // 5. METODO equals()
        // Il metodo equals() confronta il contenuto dei record, non i riferimenti in memoria.
        System.out.println("\nConfronto tra utente1 e utente2 (dovrebbe essere false): " + utente1.equals(utente2));
        System.out.println("Confronto tra utente1 e la sua copia (dovrebbe essere true): " + utente1.equals(utente1Copia));

        // 6. IMMUTABILITÀ
        // I campi di un record sono `final`, quindi non puoi modificarli dopo la creazione.
        // La riga seguente, se decommentata, causerebbe un errore di compilazione:
        // utente1.eta = 31; // ERRORE: Cannot assign a value to final variable 'eta'
        System.out.println("\nUn record è immutabile: i suoi dati non possono essere cambiati dopo la creazione.");

        System.out.println("\n--- VALIDAZIONE NEL COSTRUTTORE ---");
        // Esempio di creazione che fallisce a causa della validazione nel costruttore compatto.
        try {
            new Utente("NomeValido", "email@valida.com", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Tentativo di creare un utente con età negativa ha lanciato correttamente un'eccezione: " + e.getMessage());
        }
    }
}
