package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Record per rappresentare un Prodotto. I record sono classi immutabili concise, perfette per i dati.
record Prodotto(String nome, String categoria, double prezzo, int quantitaDisponibile) {}

/**
 * GUIDA ENCICLOPEDICA E INTERATTIVA ALLA STREAM API DI JAVA
 *
 * Questo file è un tutorial eseguibile che illustra, con spiegazioni passo-passo,
 * le funzionalità della Stream API, introdotta in Java 8, per l'elaborazione di collezioni di dati.
 */
public class MainSteamAPI {

    public static void main(String[] args) {
        // --- DATI DI ESEMPIO ---
        List<Prodotto> prodotti = Arrays.asList(
            new Prodotto("Laptop", "Elettronica", 1200.00, 10),
            new Prodotto("Tastiera", "Elettronica", 80.00, 50),
            new Prodotto("Caffè", "Alimentari", 10.00, 100),
            new Prodotto("Libro Java", "Libri", 35.00, 30),
            new Prodotto("Smartphone", "Elettronica", 800.00, 0), // Esaurito
            new Prodotto("Biscotti", "Alimentari", 5.00, 200),
            new Prodotto("Libro SQL", "Libri", 25.00, 15)
        );

        System.out.println("--- GUIDA ALLA STREAM API ---");
        System.out.println("Spiegazione Concettuale: Una Stream è una sequenza di elementi proveniente da una sorgente (es. una Lista) che supporta operazioni aggregate. Non memorizza dati, ma li processa 'on-demand' in una pipeline di operazioni.\n");

        sezione1_OperazioniIntermedie(prodotti);
        sezione2_OperazioniTerminali(prodotti);
        sezione3_Collectors(prodotti);
        sezione4_StreamPrimitivi();
        sezione5_StreamParalleli();
    }

    private static void sezione1_OperazioniIntermedie(List<Prodotto> prodotti) {
        System.out.println("\n--- 1. Operazioni Intermedie: Filtrare e Trasformare ---");
        System.out.println("Spiegazione: Le operazioni intermedie trasformano una stream in un'altra stream. Sono 'lazy' (pigre), cioè non vengono eseguite finché non viene chiamata un'operazione terminale.\n");

        System.out.println("Azione: Pipeline complessa che usa filter, map, sorted, limit, skip e peek.");
        System.out.println("Obiettivo: Trovare i nomi, in maiuscolo, dei 2 prodotti di categoria 'Elettronica' più economici, ma saltando il più economico in assoluto.\n");
        
        // .stream() -> Converte la collezione in una sorgente di dati elaborabile.
        List<String> risultato = prodotti.stream()
            // .filter(lambda) -> Filtra gli elementi, mantenendo solo quelli per cui la lambda restituisce `true`.
            .filter(p -> p.categoria().equals("Elettronica"))
            // .peek(lambda) -> Esegue un'azione su ogni elemento senza modificarlo. Utile per il debug per "sbirciare" dentro la stream.
            .peek(p -> System.out.println("  - peek (dopo filter): " + p.nome()))
            
            // .sorted(comparator) -> Ordina gli elementi della stream.
            .sorted(Comparator.comparing(Prodotto::prezzo))
            .peek(p -> System.out.println("  - peek (dopo sorted): " + p.nome() + " " + p.prezzo() + "€"))
            
            // .skip(n) -> Scarta i primi `n` elementi della stream.
            .skip(1)
            .peek(p -> System.out.println("  - peek (dopo skip): " + p.nome()))
            
            // .limit(n) -> Tronca la stream, mantenendo solo i primi `n` elementi.
            .limit(2)
            .peek(p -> System.out.println("  - peek (dopo limit): " + p.nome()))
            
            // .map(lambda) -> Trasforma ogni elemento della stream in un altro oggetto, applicando la funzione lambda.
            .map(p -> p.nome().toUpperCase())
            .peek(nome -> System.out.println("  - peek (dopo map): " + nome))
            
            // .collect(...) è un'operazione terminale che avvia tutta la pipeline.
            .collect(Collectors.toList());
            
        System.out.println("\n  - Risultato finale della pipeline: " + risultato);

        System.out.println("\nAzione: Uso di `flatMap` per creare una stream unica di tutte le parole nelle categorie.");
        // .flatMap(lambda) -> Simile a map, ma "appiattisce" una stream di stream in una singola stream.
        List<String> categorie = Arrays.asList("Elettronica Hi-Tech", "Libri e Manuali");
        List<String> singoleParole = categorie.stream()
            .flatMap(frase -> Stream.of(frase.split(" "))) // Ogni frase diventa una stream di parole, flatMap le unisce.
            .collect(Collectors.toList());
        System.out.println("  - Frasi originali: " + categorie);
        System.out.println("  - Risultato di flatMap (parole singole): " + singoleParole);
    }

    private static void sezione2_OperazioniTerminali(List<Prodotto> prodotti) {
        System.out.println("\n--- 2. Operazioni Terminali: Produrre un Risultato ---");
        System.out.println("Spiegazione: Le operazioni terminali avviano l'elaborazione della stream e producono un risultato. Una stream non può più essere usata dopo un'operazione terminale.\n");

        // .reduce(valoreIniziale, operatoreBinario) -> Combina gli elementi di una stream per produrre un singolo valore.
        System.out.println("Azione: Uso di `reduce` per calcolare il valore totale del magazzino (prezzo * quantità).");
        double valoreMagazzino = prodotti.stream()
            .map(p -> p.prezzo() * p.quantitaDisponibile()) // Calcola il valore di ogni stock di prodotto
            .reduce(0.0, (subtotale, valore) -> subtotale + valore); // Somma tutti i valori
        System.out.println("  - Valore totale magazzino (reduce): " + String.format("%.2f", valoreMagazzino) + "€");
    }

    private static void sezione3_Collectors(List<Prodotto> prodotti) {
        System.out.println("\n--- 3. Collectors: Raccogliere i Risultati in Contenitori ---");
        System.out.println("Spiegazione: `collect` è un'operazione terminale molto versatile che, usando un `Collector`, può trasformare una stream in quasi ogni tipo di struttura dati.\n");

        // .collect(Collectors.toList()) -> Raccoglie gli elementi in una `List`.
        List<Prodotto> elettronici = prodotti.stream().filter(p -> p.categoria().equals("Elettronica")).collect(Collectors.toList());
        System.out.println("Azione: `Collectors.toList()` -> " + elettronici.size() + " prodotti elettronici.");

        // .collect(Collectors.toSet()) -> Raccoglie gli elementi in un `Set` (rimuovendo i duplicati).
        Set<String> categorie = prodotti.stream().map(Prodotto::categoria).collect(Collectors.toSet());
        System.out.println("Azione: `Collectors.toSet()` -> Categorie uniche: " + categorie);

        // .collect(Collectors.groupingBy(funzioneDiClassificazione)) -> Raggruppa gli elementi in una `Map`.
        System.out.println("\nAzione: `groupingBy` per raggruppare i prodotti per categoria.");
        Map<String, List<Prodotto>> prodottiPerCategoria = prodotti.stream()
            .collect(Collectors.groupingBy(Prodotto::categoria));
        prodottiPerCategoria.forEach((cat, lista) -> System.out.println("  - Categoria '" + cat + "': " + lista.stream().map(Prodotto::nome).collect(Collectors.toList())));

        // .collect(Collectors.partitioningBy(predicato)) -> Divide la stream in due partizioni (una `Map<Boolean, List>`).
        System.out.println("\nAzione: `partitioningBy` per dividere i prodotti in 'disponibili' e 'esauriti'.");
        Map<Boolean, List<Prodotto>> partizioneDisponibilita = prodotti.stream()
            .collect(Collectors.partitioningBy(p -> p.quantitaDisponibile() > 0));
        System.out.println("  - Prodotti disponibili (true): " + partizioneDisponibilita.get(true).stream().map(Prodotto::nome).collect(Collectors.toList()));
        System.out.println("  - Prodotti esauriti (false): " + partizioneDisponibilita.get(false).stream().map(Prodotto::nome).collect(Collectors.toList()));
    }

    private static void sezione4_StreamPrimitivi() {
        System.out.println("\n--- 4. Stream Primitivi: IntStream, LongStream, DoubleStream ---");
        System.out.println("Spiegazione: Per i tipi primitivi (int, long, double), esistono stream specializzate che sono più efficienti (evitano il 'boxing'/'unboxing') e offrono operazioni statistiche.\n");

        // IntStream.range(start, endExclusive) -> Crea una stream di `int` da `start` a `end-1`.
        System.out.println("Azione: Uso di `IntStream` per calcolare la somma dei numeri da 1 a 100.");
        int somma = IntStream.rangeClosed(1, 100).sum(); // .rangeClosed include l'estremo finale; .sum() è un'op. terminale
        System.out.println("  - Somma con IntStream.sum(): " + somma);

        // .summaryStatistics() -> Calcola statistiche complete (conteggio, somma, min, media, max).
        System.out.println("\nAzione: Uso di `summaryStatistics` per ottenere statistiche sui prezzi.");
        List<Double> prezzi = List.of(10.50, 25.00, 80.25, 45.00);
        DoubleSummaryStatistics stats = prezzi.stream()
            .mapToDouble(Double::doubleValue) // Converte Stream<Double> in DoubleStream
            .summaryStatistics();
        System.out.println("  - Statistiche sui prezzi: " + stats);
    }

    private static void sezione5_StreamParalleli() {
        System.out.println("\n--- 5. Stream Paralleli ---");
        System.out.println("Spiegazione: Una stream parallela divide il lavoro su più core della CPU. Può velocizzare le operazioni su grandi quantità di dati, ma ha un costo di gestione (overhead) e non garantisce l'ordine di esecuzione.\n");

        // .parallelStream() o .stream().parallel() -> Crea una stream parallela.
        System.out.println("Azione: Esecuzione di un'operazione su una stream sequenziale e una parallela.");
        List<Integer> numeriGrandi = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        System.out.print("  - Esecuzione Sequenziale (ordine garantito): ");
        numeriGrandi.stream().forEach(n -> System.out.print(n + " "));

        System.out.print("\n  - Esecuzione Parallela (ordine NON garantito): ");
        numeriGrandi.parallelStream().forEach(n -> System.out.print(n + " "));
        System.out.println("\n  (Nota: l'output parallelo potrebbe apparire ordinato su collezioni piccole, ma non c'è garanzia).");
    }
}
