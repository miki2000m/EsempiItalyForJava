package SimulatoreEsame;

import java.util.List;

/**
 * Rappresenta una singola domanda dell'esame.
 * È un record, quindi è un contenitore di dati immutabile.
 *
 * @param modulo L'ID del modulo di studio a cui appartiene la domanda.
 * @param testo Il testo completo della domanda, incluso eventuale codice.
 * @param opzioni Una lista di stringhe che rappresentano le opzioni di risposta (A, B, C, ...).
 * @param rispostaCorretta La lettera (o le lettere) della risposta corretta (es. "A", "BC").
 * @param spiegazione Una spiegazione dettagliata del perché la risposta è corretta e le altre sono sbagliate.
 */
public record Domanda(
    int modulo,
    String testo,
    List<String> opzioni,
    String rispostaCorretta,
    String spiegazione
) {
    /**
     * Metodo per visualizzare la domanda in un formato leggibile sulla console.
     */
    public void visualizza() {
        System.out.println("--------------------------------------------------");
        System.out.println(testo); // Stampa il testo della domanda e il codice
        System.out.println();
        char opzioneLettera = 'A';
        for (String opzione : opzioni) {
            System.out.println(opzioneLettera + ") " + opzione);
            opzioneLettera++;
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     * Controlla se la risposta fornita dall'utente è corretta.
     * Ignora maiuscole/minuscole e spazi.
     * @param rispostaUtente La stringa inserita dall'utente.
     * @return true se la risposta è corretta, false altrimenti.
     */
    public boolean controllaRisposta(String rispostaUtente) {
        String rispostaFormattata = rispostaUtente.trim().toUpperCase();
        return rispostaFormattata.equals(rispostaCorretta.toUpperCase());
    }
}
