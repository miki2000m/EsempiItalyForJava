package JDK_Utility_API.CollectionsClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * GUIDA ENCICLOPEDICA ALLA CLASSE `java.util.Collections`
 *
 * Questo file è un tutorial eseguibile che esplora le funzionalità della classe `Collections`,
 * una classe di utilità che contiene metodi statici per operare sulle collezioni,
 * in particolare sulle `List`.
 *
 * ATTENZIONE: Non confondere `java.util.Collections` (con la 's' finale) con
 * `java.util.Collection` (l'interfaccia base di molte collezioni).
 */
public class MainCollections {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA CLASSE `Collections` ---\n");

        sezione1_OrdinamentoEMescolamento();
        sezione2_Ricerca();
        sezione3_Manipolazione();
        sezione4_WrapperDiSincronizzazioneEImmutabilita();
    }

    private static void sezione1_OrdinamentoEMescolamento() {
        System.out.println("--- 1. Ordinamento e Mescolamento ---");
        System.out.println("Spiegazione: Metodi per ordinare e mescolare gli elementi di una `List` 'in-place'.\n");

        List<String> nomi = new ArrayList<>(List.of("Zelda", "Mario", "Link", "Samus"));
        System.out.println("  Lista originale: " + nomi);

        // Collections.sort(list): Ordina la lista secondo l'ordine naturale degli elementi.
        Collections.sort(nomi);
        System.out.println("  Lista dopo `sort()`: " + nomi);

        // Collections.sort(list, comparator): Ordina usando un criterio personalizzato.
        // Qui ordiniamo per lunghezza della stringa.
        nomi.sort(Comparator.comparingInt(String::length));
        System.out.println("  Lista ordinata per lunghezza: " + nomi);

        // Collections.shuffle(list): Mescola gli elementi della lista in ordine casuale.
        Collections.shuffle(nomi);
        System.out.println("  Lista dopo `shuffle()`: " + nomi);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_Ricerca() {
        System.out.println("--- 2. Ricerca in una Lista (`binarySearch`) ---");
        System.out.println("Spiegazione: Come `Arrays.binarySearch`, esegue una ricerca binaria su una `List`.\n" +
                "ATTENZIONE: La lista DEVE essere ordinata prima di usare questo metodo!\n");

        List<Integer> numeriOrdinati = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        
        int indice = Collections.binarySearch(numeriOrdinati, 30);
        System.out.println("  Ricerca di '30' in " + numeriOrdinati);
        System.out.println("  -> Risultato: L'elemento è stato trovato all'indice " + indice);

        int indiceNonPresente = Collections.binarySearch(numeriOrdinati, 35);
        System.out.println("\n  Ricerca di '35' (non presente)...");
        System.out.println("  -> Risultato: " + indiceNonPresente);
        System.out.println("  Spiegazione del risultato negativo: `(-(punto di inserimento) - 1)` -> `(-3 - 1) = -4`.");
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_Manipolazione() {
        System.out.println("--- 3. Manipolazione degli Elementi ---");
        System.out.println("Spiegazione: Metodi per modificare l'ordine o il contenuto di una collezione.\n");

        List<Character> lettere = new ArrayList<>(List.of('A', 'B', 'C', 'D', 'E'));
        System.out.println("  Lista originale: " + lettere);

        // Collections.reverse(list): Inverte l'ordine degli elementi.
        Collections.reverse(lettere);
        System.out.println("  Lista dopo `reverse()`: " + lettere);

        // Collections.fill(list, obj): Sostituisce tutti gli elementi della lista con un oggetto specificato.
        Collections.fill(lettere, 'X');
        System.out.println("  Lista dopo `fill('X')`: " + lettere);

        // Collections.replaceAll(list, oldVal, newVal): Sostituisce tutte le occorrenze di un valore con un altro.
        List<Integer> punteggi = new ArrayList<>(List.of(10, 20, 10, 30, 10));
        System.out.println("\n  Punteggi originali: " + punteggi);
        Collections.replaceAll(punteggi, 10, 99);
        System.out.println("  Punteggi dopo `replaceAll(10, 99)`: " + punteggi);
        System.out.println("----------------------------------------\n");
    }

    private static void sezione4_WrapperDiSincronizzazioneEImmutabilita() {
        System.out.println("--- 4. Wrapper per Sincronizzazione e Immutabilità ---");
        System.out.println("Spiegazione: `Collections` può 'avvolgere' una collezione esistente per cambiarne il comportamento.\n");

        // Creiamo una lista normale (mutabile e non thread-safe)
        List<String> listaOriginale = new ArrayList<>();
        listaOriginale.add("Elemento 1");

        // 1. Wrapper per l'immutabilità
        // Collections.unmodifiableList(list): Restituisce una VISTA immutabile della lista originale.
        List<String> vistaImmutabile = Collections.unmodifiableList(listaOriginale);
        System.out.println("  - Vista immutabile creata: " + vistaImmutabile);
        try {
            vistaImmutabile.add("Nuovo elemento");
        } catch (UnsupportedOperationException e) {
            System.out.println("    -> Tentativo di modifica ha lanciato correttamente: " + e.getClass().getSimpleName());
        }
        // Attenzione: se la lista originale viene modificata, la modifica si riflette sulla vista!
        listaOriginale.add("Elemento 2");
        System.out.println("  - Vista immutabile dopo aver modificato la lista originale: " + vistaImmutabile);
        System.out.println();

        // 2. Wrapper per la sincronizzazione (Thread-Safety)
        // Collections.synchronizedList(list): Restituisce una versione thread-safe della lista.
        // Ogni chiamata a un metodo della lista sincronizzata è avvolta in un blocco `synchronized`.
        List<String> listaSincronizzata = Collections.synchronizedList(new ArrayList<>());
        System.out.println("  - `synchronizedList` crea un wrapper thread-safe per una collezione.");
        System.out.println("    (Utile in vecchi progetti, ma le classi `java.util.concurrent` sono spesso una scelta migliore).");
        System.out.println("----------------------------------------");
    }
}
