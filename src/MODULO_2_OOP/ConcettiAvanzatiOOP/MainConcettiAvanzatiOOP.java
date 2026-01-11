package MODULO_2_OOP.ConcettiAvanzatiOOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * GUIDA AI CONCETTI AVANZATI DI OOP PER L'ESAME
 *
 * Questo file è un tutorial eseguibile che approfondisce tre aree chiave della OOP
 * spesso testate nei casi limite durante gli esami di certificazione:
 * 1. Comparable vs Comparator: Ordinamento di oggetti.
 * 2. Immutabilità: Creare classi i cui oggetti non possono essere modificati.
 * 3. Ciclo di Vita e Garbage Collection: Come e quando gli oggetti vengono distrutti.
 */

// --- Sezione 1: Comparable vs Comparator ---

// `Prodotto` implementa `Comparable` per definire il suo "ordine naturale".
class Prodotto implements Comparable<Prodotto> {
    private String nome;
    private double prezzo;

    public Prodotto(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getNome() { return nome; }
    public double getPrezzo() { return prezzo; }

    @Override
    public String toString() {
        return "Prodotto{" + "nome='" + nome + '\'' + ", prezzo=" + prezzo + '}';
    }

    // Implementazione di compareTo: definisce l'ordine naturale (per prezzo).
    @Override
    public int compareTo(Prodotto altro) {
        // Restituisce < 0 se this è "minore" di altro
        // Restituisce 0 se sono "uguali"
        // Restituisce > 0 se this è "maggiore" di altro
        return Double.compare(this.prezzo, altro.prezzo);
    }
}

// Un `Comparator` esterno per definire un ordinamento alternativo (per nome).
class ComparatorePerNome implements Comparator<Prodotto> {
    @Override
    public int compare(Prodotto p1, Prodotto p2) {
        return p1.getNome().compareTo(p2.getNome());
    }
}


// --- Sezione 2: Immutabilità ---

// Questa classe è un esempio di oggetto MUTABILE.
class DatiSensibiliMutabili {
    private String dato;
    public DatiSensibiliMutabili(String dato) { this.dato = dato; }
    public String getDato() { return dato; }
    public void setDato(String dato) { this.dato = dato; } // Setter che permette la modifica
}

// Questa classe è IMMUTABILE.
final class LogImmutabile { // 1. La classe è `final` per impedire l'ereditarietà.
    private final String messaggio; // 2. I campi sono `private` e `final`.
    private final Date data; // Questo è un campo MUTABILE, richiede attenzione!
    private final DatiSensibiliMutabili datiSensibili; // Anche questo è MUTABILE.

    public LogImmutabile(String messaggio, Date data, DatiSensibiliMutabili dati) {
        this.messaggio = messaggio;
        // 3. Creiamo "copie difensive" degli oggetti mutabili nel costruttore.
        // Invece di salvare il riferimento all'oggetto originale, ne creiamo una copia.
        this.data = new Date(data.getTime());
        this.datiSensibili = new DatiSensibiliMutabili(dati.getDato());
    }

    // 4. Non ci sono metodi "setter".
    public String getMessaggio() { return messaggio; }

    // 5. Anche i "getter" per i campi mutabili restituiscono copie difensive.
    public Date getData() {
        return new Date(data.getTime());
    }
    public DatiSensibiliMutabili getDatiSensibili() {
        return new DatiSensibiliMutabili(datiSensibili.getDato());
    }

    @Override
    public String toString() {
        return "LogImmutabile{" + "messaggio='" + messaggio + '\'' + ", data=" + data + ", dati=" + datiSensibili.getDato() + '}';
    }
}


public class MainConcettiAvanzatiOOP {

    public static void main(String[] args) {
        System.out.println("--- GUIDA AI CONCETTI AVANZATI DI OOP ---\n");
        sezione1_Ordinamento();
        sezione2_Immutabilita();
        sezione3_GarbageCollection();
    }

    private static void sezione1_Ordinamento() {
        System.out.println("--- 1. Comparable vs Comparator ---");
        System.out.println("Spiegazione: `Comparable` definisce l'ordine naturale di un oggetto. `Comparator` definisce un ordinamento alternativo e esterno.\n");

        List<Prodotto> prodotti = new ArrayList<>();
        prodotti.add(new Prodotto("Tastiera", 79.99));
        prodotti.add(new Prodotto("Mouse", 25.50));
        prodotti.add(new Prodotto("Monitor", 199.90));

        System.out.println("Lista originale: " + prodotti);

        // Ordinamento usando l'ordine naturale (Comparable, per prezzo)
        Collections.sort(prodotti);
        System.out.println("Ordinata per prezzo (Comparable): " + prodotti);

        // Ordinamento usando un ordinamento alternativo (Comparator, per nome)
        prodotti.sort(new ComparatorePerNome());
        System.out.println("Ordinata per nome (Comparator):  " + prodotti);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_Immutabilita() {
        System.out.println("--- 2. Creare Oggetti Immobili ---");
        System.out.println("Spiegazione: Un oggetto immutabile non può essere modificato dopo la sua creazione. Questo è cruciale per la sicurezza in ambienti multi-threaded e per la prevedibilità del codice.\n");

        // Tentativo di modificare un oggetto immutabile
        Date dataOriginale = new Date();
        DatiSensibiliMutabili datiOriginali = new DatiSensibiliMutabili("password123");

        LogImmutabile log = new LogImmutabile("Accesso utente", dataOriginale, datiOriginali);
        System.out.println("Log originale: " + log);

        // Ora proviamo a modificare gli oggetti originali passati al costruttore.
        dataOriginale.setTime(0); // Modifichiamo la data originale
        datiOriginali.setDato("password_hackerata"); // Modifichiamo i dati originali

        System.out.println("\nOggetti originali modificati dopo la creazione del log.");
        System.out.println("Stato del log dopo la modifica esterna: " + log);
        System.out.println("Risultato: Lo stato interno del log è rimasto invariato grazie alle 'copie difensive' nel costruttore.\n");

        // Ora proviamo a modificare lo stato interno tramite un getter.
        Date dataInterna = log.getData();
        dataInterna.setTime(0); // Modifichiamo la copia restituita dal getter

        System.out.println("Stato del log dopo aver tentato di modificare l'oggetto restituito dal getter: " + log);
        System.out.println("Risultato: Lo stato interno del log è ancora invariato, perché il getter ha restituito una copia.\n");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_GarbageCollection() {
        System.out.println("--- 3. Ciclo di Vita e Garbage Collection (GC) ---");
        System.out.println("Spiegazione: Un oggetto 'muore' e diventa eleggibile per la Garbage Collection quando non è più 'raggiungibile', cioè quando non ci sono più riferimenti attivi che puntano ad esso.\n");

        System.out.println("Azione: Creazione di un oggetto Prodotto.");
        Prodotto p = new Prodotto("Libro", 20.0);
        System.out.println("  -> Oggetto creato: " + p);

        System.out.println("\nAzione: La variabile 'p' ora punta a null. L'oggetto 'Libro' non è più raggiungibile.");
        p = null;
        // A questo punto, l'oggetto Prodotto creato prima è "orfano".
        // Non abbiamo modo di accedervi. È diventato spazzatura (garbage).

        System.out.println("Risultato: L'oggetto 'Libro' è ora eleggibile per essere eliminato dal Garbage Collector.");
        System.out.println("Non possiamo sapere QUANDO il GC passerà, ma sappiamo che l'oggetto può essere rimosso per liberare memoria.");
        System.out.println("\n----------------------------------------");
    }
}
