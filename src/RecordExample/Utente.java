package RecordExample;

/**
 * Esempio che dimostra l'uso e i vantaggi dei Record in Java.
 */

// 1. DEFINIZIONE DI UN RECORD
// La parola chiave `record` crea una classe speciale, immutabile, progettata per contenere dati.
// Questa singola riga sostituisce decine di righe di codice boilerplate.
//
// `public record Utente(String username, String email, int eta)`
//
// Dietro le quinte, il compilatore Java genera automaticamente per noi:
//   - Campi privati e final per `username`, `email`, e `eta`.
//   - Un costruttore pubblico che accetta tutti i campi (`public Utente(String username, ...)`).
//   - Metodi "getter" per ogni campo (es. `public String username()`, `public String email()`).
//   - Un'implementazione sensata di `toString()` per stampare l'oggetto in modo leggibile.
//   - Un'implementazione corretta di `equals()` per confrontare due oggetti `Utente` in base ai loro dati.
//   - Un'implementazione corretta di `hashCode()` coerente con `equals`.
public record Utente(String username, String email, int eta) {
    // È anche possibile aggiungere costruttori compatti, metodi statici o metodi d'istanza.
    // Esempio: un costruttore compatto per la validazione dei dati in ingresso.
    public Utente {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("L'username non può essere nullo o vuoto.");
        }
        if (eta < 0) {
            throw new IllegalArgumentException("L'età non può essere negativa.");
        }
    }
}
