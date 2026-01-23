package MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO.JDBC;

import java.sql.*;

/**
 * ESEMPIO PRATICO DI JDBC
 *
 * NOTA IMPORTANTE:
 * JDBC richiede un "Driver" (una libreria .jar) specifico per il database che si vuole usare
 * (es. MySQL, PostgreSQL, H2, SQLite).
 *
 * Poiché questo è un progetto didattico base senza gestione delle dipendenze (come Maven/Gradle),
 * questo codice è scritto per essere COMPILABILE (usa le interfacce standard del JDK),
 * ma per essere ESEGUIBILE con successo richiederebbe di aggiungere manualmente un driver al progetto.
 *
 * Se provi ad eseguirlo senza driver, otterrai un errore:
 * "No suitable driver found..." -> È normale! Serve solo a mostrarti la sintassi corretta.
 */
public class MainJDBC {

    // URL di connessione: cambia in base al DB (es. "jdbc:mysql://localhost:3306/miodb")
    // Qui usiamo H2 in-memory come esempio
    private static final String DB_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        System.out.println("--- ESEMPIO JDBC (Java Database Connectivity) ---");

        // La query SQL che vogliamo eseguire
        // Usiamo il '?' come segnaposto per i parametri (Bind Variables)
        String sqlInsert = "INSERT INTO utenti (nome, email) VALUES (?, ?)";
        String sqlSelect = "SELECT * FROM utenti WHERE nome = ?";
        String sqlCreate = "CREATE TABLE utenti (id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255), email VARCHAR(255))";

        // 1. APERTURA CONNESSIONE
        // Usiamo il try-with-resources per garantire che Connection, Statement e ResultSet vengano chiusi.
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {

            System.out.println("Connessione al database stabilita!");

            // --- A. CREAZIONE TABELLA (DDL) ---
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(sqlCreate);
                System.out.println("Tabella 'utenti' creata.");
            }

            // --- B. INSERIMENTO DATI (PreparedStatement) ---
            // PreparedStatement è più sicuro ed efficiente di Statement
            try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                // Impostiamo i parametri al posto dei '?'
                pstmt.setString(1, "Mario Rossi");
                pstmt.setString(2, "mario@email.com");
                
                int righeModificate = pstmt.executeUpdate(); // executeUpdate per INSERT/UPDATE/DELETE
                System.out.println("Inserito utente Mario. Righe modificate: " + righeModificate);

                // Riutilizziamo lo stesso PreparedStatement per un altro inserimento
                pstmt.setString(1, "Luigi Verdi");
                pstmt.setString(2, "luigi@email.com");
                pstmt.executeUpdate();
                System.out.println("Inserito utente Luigi.");
            }

            // --- C. LETTURA DATI (SELECT) ---
            System.out.println("\n--- Ricerca Utente ---");
            try (PreparedStatement pstmt = conn.prepareStatement(sqlSelect)) {
                pstmt.setString(1, "Mario Rossi");

                // executeQuery restituisce un ResultSet (i risultati)
                try (ResultSet rs = pstmt.executeQuery()) {
                    // Iteriamo sui risultati
                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nome = rs.getString("nome");
                        String email = rs.getString("email");

                        System.out.println("Trovato: ID=" + id + ", Nome=" + nome + ", Email=" + email);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("ERRORE JDBC:");
            System.err.println("Messaggio: " + e.getMessage());
            System.err.println("Codice SQLState: " + e.getSQLState());
            
            if (e.getMessage().contains("No suitable driver")) {
                System.err.println("\n[NOTA DIDATTICA]: Questo errore appare perché non hai aggiunto la libreria (JAR) del driver del database al progetto.");
                System.err.println("Per farlo funzionare realmente, dovresti scaricare (es. H2 Database Engine) e aggiungerlo al Classpath.");
            }
        }
    }
}
