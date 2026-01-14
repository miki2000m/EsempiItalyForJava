package SimulatoreEsame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Questa classe agisce come una "banca dati" statica per tutte le domande del simulatore.
 * Le domande sono create qui e possono essere recuperate per modulo o tutte insieme.
 */
public class BancaDatiDomande {

    private static final List<Domanda> tutteLeDomande = new ArrayList<>();

    // Blocco di inizializzazione statico: viene eseguito una sola volta quando la classe viene caricata.
    // Qui creiamo tutte le nostre domande di esempio.
    static {
        // --- MODULO 1: BASI E CONTROLLO (10 Domande) ---
        tutteLeDomande.add(new Domanda(1,
            """
            Analizza il seguente codice:
            int a = 5;
            int b = 2;
            double c = a / b;
            System.out.println(c);
            Cosa verrà stampato a console?
            """,
            List.of("2.5", "2.0", "2", "Errore di compilazione"),
            "B",
            """
            Spiegazione: La divisione `a / b` avviene tra due interi (`int`). In Java, la divisione tra interi
            tronca il risultato, scartando la parte decimale. Quindi, `5 / 2` risulta in `2`, non `2.5`.
            Solo dopo, il risultato `2` viene assegnato a una variabile `double`, diventando `2.0`.
            Per ottenere `2.5`, almeno uno degli operandi avrebbe dovuto essere un `double`, ad esempio `(double) a / b`.
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Quale delle seguenti dichiarazioni di variabile `var` è valida?
            """,
            List.of("var x;", "var y = null;", "var z = 10;", "public var w = 20;"),
            "C",
            """
            Spiegazione:
            A) `var x;` è invalido perché `var` richiede un'inizializzazione immediata per inferire il tipo.
            B) `var y = null;` è invalido perché `null` non fornisce informazioni sul tipo.
            C) `var z = 10;` è valido. Il compilatore inferirà `z` come `int`.
            D) `public var w = 20;` è invalido perché `var` può essere usato solo per variabili locali, non per campi di classe con modificatori di accesso.
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Cosa stampa il seguente codice?
            int x = 10;
            if (x > 5) {
                if (x < 15) {
                    System.out.println("Condizione 1");
                }
            } else {
                System.out.println("Condizione 2");
            }
            """,
            List.of("Condizione 1", "Condizione 2", "Nessuna stampa", "Errore di compilazione"),
            "A",
            """
            Spiegazione: La prima condizione `x > 5` (10 > 5) è vera. Entra nel primo blocco `if`.
            La seconda condizione `x < 15` (10 < 15) è anch'essa vera. Entra nel secondo blocco `if` e stampa "Condizione 1".
            Il blocco `else` esterno non viene mai raggiunto.
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Qual è il risultato del seguente codice?
            String day = "Martedi";
            String result = switch (day) {
                case "Lunedi", "Martedi" -> "Inizio settimana";
                case "Mercoledi", "Giovedi" -> "Metà settimana";
                default -> "Fine settimana";
            };
            System.out.println(result);
            """,
            List.of("Inizio settimana", "Metà settimana", "Fine settimana", "Errore di compilazione"),
            "A",
            """
            Spiegazione: Lo `switch expression` valuta la variabile `day`. Il valore "Martedi" corrisponde
            al primo `case "Lunedi", "Martedi"`, quindi l'espressione restituisce "Inizio settimana".
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Cosa succede se si esegue il seguente ciclo?
            for (int i = 0; i < 3; i++) {
                System.out.print(i + " ");
                if (i == 1) continue;
            }
            """,
            List.of("0 1 2 ", "0 1 ", "0 2 ", "Errore di compilazione"),
            "A",
            """
            Spiegazione: Il ciclo `for` itera da 0 a 2.
            - Quando `i` è 0, stampa "0 ". `i == 1` è falso.
            - Quando `i` è 1, stampa "1 ". `i == 1` è vero, `continue` salta il resto dell'iterazione e passa a `i=2`.
            - Quando `i` è 2, stampa "2 ". `i == 1` è falso.
            Il risultato è "0 1 2 ".
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Quale delle seguenti affermazioni è vera riguardo all'operatore ternario `? :`?
            """,
            List.of("Può essere usato solo con tipi booleani.", "È una forma abbreviata di `if-else` che restituisce un valore.", "Non può contenere espressioni complesse.", "È obsoleto in Java moderno."),
            "B",
            """
            Spiegazione: L'operatore ternario `? :` è una forma concisa di `if-else` che è un'espressione,
            quindi restituisce sempre un valore. È spesso usato per assegnazioni condizionali.
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Cosa stampa il seguente codice?
            int count = 0;
            do {
                System.out.print(count + " ");
                count++;
            } while (count < 0);
            """,
            List.of("0 ", "Nessuna stampa", "Errore di compilazione", "Loop infinito"),
            "A",
            """
            Spiegazione: Il ciclo `do-while` garantisce che il blocco di codice venga eseguito almeno una volta,
            prima di controllare la condizione. Quindi, `count` (0) viene stampato. Poi `count` diventa 1.
            La condizione `count < 0` (1 < 0) è falsa, quindi il ciclo termina.
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Qual è il valore di `x` dopo l'esecuzione del seguente codice?
            int x = 5;
            x += 3;
            x *= 2;
            """,
            List.of("10", "11", "16", "20"),
            "C",
            """
            Spiegazione:
            1. `x = 5;`
            2. `x += 3;` è equivalente a `x = x + 3;`, quindi `x = 5 + 3;` -> `x = 8;`
            3. `x *= 2;` è equivalente a `x = x * 2;`, quindi `x = 8 * 2;` -> `x = 16;`
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Quale delle seguenti opzioni è un tipo primitivo in Java?
            """,
            List.of("String", "Integer", "Boolean", "char"),
            "D",
            """
            Spiegazione: `String`, `Integer`, e `Boolean` sono classi wrapper (tipi riferimento).
            `char` è l'unico tipo primitivo tra le opzioni.
            """
        ));
        tutteLeDomande.add(new Domanda(1,
            """
            Cosa stampa il seguente codice?
            int[] arr = {1, 2, 3};
            for (int val : arr) {
                System.out.print(val + " ");
            }
            """,
            List.of("1 2 3 ", "arr[0] arr[1] arr[2] ", "Errore di compilazione", "1, 2, 3"),
            "A",
            """
            Spiegazione: Il ciclo `for-each` (enhanced for loop) itera su ogni elemento dell'array `arr`
            e assegna il valore dell'elemento corrente alla variabile `val`. Quindi stamperà i valori 1, 2, 3
            separati da uno spazio.
            """
        ));

        // --- MODULO 2: OOP (10 Domande) ---
        tutteLeDomande.add(new Domanda(2,
            """
            Date le seguenti classi:
            class Animale { public void mangia() { System.out.println("Animale mangia"); } }
            class Cane extends Animale { public void mangia() { System.out.println("Cane mangia"); } }
            
            E il seguente codice:
            Animale a = new Cane();
            a.mangia();
            
            Cosa verrà stampato?
            """,
            List.of("Animale mangia", "Cane mangia", "Errore di compilazione", "NullPointerException"),
            "B",
            """
            Spiegazione: Questo è un esempio di polimorfismo. La variabile `a` è di tipo `Animale` (tipo statico),
            ma l'oggetto a cui punta è di tipo `Cane` (tipo dinamico). A runtime, la JVM invoca il metodo
            sovrascritto (`@Override`) della classe dell'oggetto reale. Poiché l'oggetto è un `Cane`,
            viene chiamato il metodo `mangia()` della classe `Cane`.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Quale delle seguenti affermazioni su una classe `final` è VERA?
            """,
            List.of("Può essere estesa solo una volta.", "Non può essere istanziata.", "Non può essere estesa.", "I suoi metodi non possono essere chiamati."),
            "C",
            """
            Spiegazione: La keyword `final` applicata a una classe significa che la gerarchia di ereditarietà
            per quella classe termina lì. Nessun'altra classe può estenderla. Questo è utile per creare
            classi immutabili o per ragioni di sicurezza.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Data la seguente interfaccia:
            interface Volante { void vola(); }
            Quale delle seguenti classi implementa correttamente `Volante`?
            """,
            List.of("class Uccello implements Volante { public void vola() {} }", "class Aereo extends Volante { public void vola() {} }", "class Farfalla implements Volante {}", "class Pipistrello implements Volante { void vola() {} }"),
            "A",
            """
            Spiegazione:
            A) Corretto. La classe implementa l'interfaccia e fornisce un'implementazione `public` per il metodo `vola()`.
            B) Errato. Le interfacce si implementano con `implements`, non si estendono con `extends`.
            C) Errato. La classe deve fornire un'implementazione per il metodo astratto `vola()`.
            D) Errato. I metodi implementati da un'interfaccia devono essere `public`.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Quale delle seguenti affermazioni è vera riguardo a una classe astratta?
            """,
            List.of("Non può avere costruttori.", "Deve contenere almeno un metodo astratto.", "Non può avere metodi concreti.", "Non può essere istanziata direttamente."),
            "D",
            """
            Spiegazione: Una classe astratta non può essere istanziata direttamente (`new AbstractClass()`).
            Può avere costruttori (chiamati dalle sottoclassi), può avere zero metodi astratti (ma allora perché farla astratta?),
            e può avere metodi concreti.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Cosa stampa il seguente codice?
            class Base { public void metodo() { System.out.println("Base"); } }
            class Derivata extends Base { public void metodo() { System.out.println("Derivata"); } }
            public class Test {
                public static void main(String[] args) {
                    Base obj = new Derivata();
                    obj.metodo();
                }
            }
            """,
            List.of("Base", "Derivata", "Errore di compilazione", "NullPointerException"),
            "B",
            """
            Spiegazione: Questo è un esempio classico di polimorfismo e overriding.
            La variabile `obj` è di tipo `Base`, ma l'oggetto a cui punta è di tipo `Derivata`.
            Quando `obj.metodo()` viene chiamato, la JVM esegue il metodo della classe reale dell'oggetto,
            che è `Derivata`.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Quale delle seguenti affermazioni è vera riguardo al metodo `toString()` della classe `Object`?
            """,
            List.of("Deve essere sempre sovrascritto.", "Restituisce il nome della classe seguito da '@' e l'hash code dell'oggetto.", "Non può essere chiamato esplicitamente.", "È un metodo `static`."),
            "B",
            """
            Spiegazione: Il metodo `toString()` di default restituisce una stringa che include il nome della classe
            e la rappresentazione esadecimale dell'hash code dell'oggetto. È buona pratica sovrascriverlo,
            ma non è obbligatorio. Non è un metodo `static`.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Perché è importante creare classi immutabili?
            """,
            List.of("Per renderle più veloci.", "Per permettere la modifica dei loro campi dopo la creazione.", "Per garantire la thread-safety e la prevedibilità del loro stato.", "Per poterle estendere liberamente."),
            "C",
            """
            Spiegazione: Le classi immutabili (come `String` o `Integer`) non possono essere modificate
            dopo la loro creazione. Questo le rende intrinsecamente thread-safe (non ci sono race conditions
            sullo stato dell'oggetto) e il loro comportamento è sempre prevedibile.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Quale delle seguenti è una regola per creare una classe immutabile?
            """,
            List.of("La classe deve essere `abstract`.", "Tutti i campi devono essere `public`.", "Non devono esserci metodi `setter`.", "Deve implementare `Comparable`."),
            "C",
            """
            Spiegazione: Per garantire l'immutabilità, non devono esserci metodi che permettano di modificare
            lo stato dell'oggetto dopo la sua creazione. Questo include l'assenza di metodi `setter`.
            Altre regole includono rendere la classe `final` e i campi `private final`.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Cosa significa che un oggetto è "eleggibile per la Garbage Collection"?
            """,
            List.of("È stato creato con `new`.", "È ancora referenziato da una variabile `final`.", "Non ci sono più riferimenti attivi che puntano ad esso.", "Il suo metodo `finalize()` è stato chiamato."),
            "C",
            """
            Spiegazione: Un oggetto diventa eleggibile per la Garbage Collection (GC) quando non è più
            "raggiungibile" da nessuna parte del programma. Ciò significa che non ci sono più riferimenti
            attivi (variabili, elementi di collezioni, ecc.) che puntano a quell'oggetto. Il GC lo eliminerà
            per liberare memoria, ma non si sa esattamente quando.
            """
        ));
        tutteLeDomande.add(new Domanda(2,
            """
            Qual è la differenza principale tra `Comparable` e `Comparator`?
            """,
            List.of("`Comparable` è per l'ordinamento esterno, `Comparator` per quello naturale.", "`Comparable` definisce l'ordine naturale, `Comparator` un ordine alternativo.", "`Comparable` è un'interfaccia, `Comparator` una classe astratta.", "Non c'è differenza, sono sinonimi."),
            "B",
            """
            Spiegazione: `Comparable` è implementato dalla classe stessa per definire il suo "ordine naturale"
            (es. ordinare numeri per valore, stringhe alfabeticamente). `Comparator` è una classe esterna
            che definisce un "ordine alternativo" o specifico per un certo contesto.
            """
        ));

        // --- MODULO 3: API FONDAMENTALI (10 Domande) ---
        tutteLeDomande.add(new Domanda(3,
            """
            Cosa stampa il seguente codice?
            String s = "Hello";
            s.concat(" World");
            System.out.println(s);
            """,
            List.of("Hello World", "Hello", "Errore di compilazione", "Null"),
            "B",
            """
            Spiegazione: Le stringhe in Java sono immutabili. Il metodo `concat()` restituisce una NUOVA
            stringa con il risultato della concatenazione, ma non modifica la stringa originale `s`.
            Poiché il risultato di `s.concat(" World")` non viene assegnato a nessuna variabile,
            la stringa `s` rimane "Hello".
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Quale metodo della classe `String` è il più adatto per rimuovere spazi bianchi all'inizio e alla fine di una stringa,
            considerando anche caratteri Unicode di spaziatura?
            """,
            List.of("trim()", "strip()", "replace(\" \", \"\")", "substring()"),
            "B",
            """
            Spiegazione: `trim()` rimuove solo i caratteri di spaziatura ASCII. `strip()` (introdotto in Java 11)
            è la versione moderna e Unicode-aware di `trim()`, quindi è più robusto per gestire vari tipi di spazi bianchi.
            `replace()` rimuoverebbe tutti gli spazi, anche quelli interni. `substring()` non è adatto per questo scopo.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Qual è il risultato di `Math.round(4.5)` e `Math.round(4.4)`?
            """,
            List.of("5 e 4", "4 e 4", "5 e 5", "4 e 5"),
            "A",
            """
            Spiegazione: `Math.round()` arrotonda all'intero più vicino. Se la parte decimale è `.5` o superiore,
            arrotonda per eccesso. Quindi `Math.round(4.5)` è 5. `Math.round(4.4)` è 4.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Quale delle seguenti affermazioni è vera riguardo a `LocalDate`?
            """,
            List.of("Rappresenta una data e un'ora con fuso orario.", "È immutabile.", "Può essere istanziata con `new LocalDate()`.", "Non può essere formattata."),
            "B",
            """
            Spiegazione: `LocalDate` rappresenta solo una data (anno, mese, giorno) e, come tutte le classi
            dell'API `java.time`, è immutabile. Non ha un fuso orario (`ZonedDateTime` lo ha) e non si istanzia
            direttamente con `new` ma con metodi factory come `LocalDate.now()` o `LocalDate.of()`.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Cosa stampa il seguente codice?
            List<String> list = new ArrayList<>();
            list.add("A");
            list.add("B");
            list.add("C");
            System.out.println(list.get(1));
            """,
            List.of("A", "B", "C", "Errore di indice"),
            "B",
            """
            Spiegazione: Le liste in Java sono basate su indice 0. Quindi `list.get(1)` restituisce
            l'elemento alla seconda posizione, che è "B".
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Qual è la caratteristica principale di un `Set` rispetto a una `List`?
            """,
            List.of("Gli elementi sono ordinati.", "Non ammette elementi duplicati.", "Permette l'accesso tramite indice.", "È più veloce per l'inserimento."),
            "B",
            """
            Spiegazione: La caratteristica distintiva di un `Set` è che non ammette elementi duplicati.
            L'ordine non è garantito (in `HashSet`), e non si accede tramite indice.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Quale delle seguenti affermazioni è vera riguardo ai Generics in Java?
            """,
            List.of("Permettono di usare tipi dinamici a runtime.", "Eliminano la necessità di cast espliciti e migliorano la type safety a compilazione.", "Sono usati solo con le collezioni.", "Non supportano i tipi primitivi."),
            "B",
            """
            Spiegazione: I Generics spostano il controllo del tipo a tempo di compilazione,
            evitando `ClassCastException` a runtime e riducendo la necessità di cast manuali.
            Non sono tipi dinamici e possono essere usati anche con metodi e classi non-collezione.
            Non supportano direttamente i tipi primitivi, ma usano le loro classi wrapper.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Qual è il range di valori per un `byte` in Java?
            """,
            List.of("0 a 255", "-128 a 127", "-32768 a 32767", "Dipende dall'implementazione della JVM"),
            "B",
            """
            Spiegazione: Un `byte` è un tipo primitivo a 8 bit con segno, quindi il suo range va da -2^7 a 2^7-1,
            cioè da -128 a 127.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Cosa stampa il seguente codice?
            StringBuilder sb = new StringBuilder("Java");
            sb.append(" SE");
            sb.insert(0, "Hello ");
            System.out.println(sb);
            """,
            List.of("Java SE Hello", "Hello Java SE", "Hello JavaSE", "Errore di compilazione"),
            "B",
            """
            Spiegazione:
            1. `sb` è "Java".
            2. `sb.append(" SE")` modifica `sb` in "Java SE".
            3. `sb.insert(0, "Hello ")` inserisce "Hello " all'indice 0, modificando `sb` in "Hello Java SE".
            `StringBuilder` è mutabile, quindi le modifiche sono in-place.
            """
        ));
        tutteLeDomande.add(new Domanda(3,
            """
            Quale delle seguenti affermazioni è vera riguardo a `LinkedList` rispetto a `ArrayList`?
            """,
            List.of("È più veloce per l'accesso casuale (get(index)).", "È più lenta per l'aggiunta/rimozione all'inizio della lista.", "È più efficiente quando si effettuano frequenti inserimenti/cancellazioni al centro.", "Occupa meno memoria."),
            "C",
            """
            Spiegazione: `LinkedList` è basata su nodi collegati, il che la rende molto efficiente (O(1))
            per inserimenti e cancellazioni all'inizio, alla fine o al centro (una volta trovato il nodo).
            L'accesso casuale (`get(index)`) è lento (O(n)). `ArrayList` è l'opposto.
            """
        ));

        // --- MODULO 4: PROGRAMMAZIONE FUNZIONALE E MODERNA (10 Domande) ---
        tutteLeDomande.add(new Domanda(4,
            """
            Quale delle seguenti interfacce è una `Functional Interface`?
            """,
            List.of("java.util.List", "java.io.Serializable", "java.lang.Runnable", "java.util.Comparator"),
            "C",
            """
            Spiegazione: Una Functional Interface è un'interfaccia con un solo metodo astratto.
            `Runnable` ha il metodo `run()`. `Comparator` ha `compare()` ma anche `equals()` e metodi default/static.
            `List` e `Serializable` hanno più metodi o nessuno.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Cosa stampa il seguente codice?
            List<Integer> numbers = List.of(1, 2, 3);
            numbers.stream().map(n -> n * 2).forEach(System.out::print);
            """,
            List.of("123", "246", "1 2 3 ", "Errore di compilazione"),
            "B",
            """
            Spiegazione: Lo stream prende i numeri [1, 2, 3]. L'operazione `map(n -> n * 2)`
            trasforma ogni numero raddoppiandolo, risultando in [2, 4, 6].
            `forEach(System.out::print)` stampa ogni elemento senza spazi o a capo.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Quale delle seguenti affermazioni è vera riguardo alle operazioni intermedie di uno Stream?
            """,
            List.of("Vengono eseguite immediatamente.", "Possono essere solo `filter` o `map`.", "Sono `lazy` e restituiscono un nuovo Stream.", "Producono un risultato finale."),
            "C",
            """
            Spiegazione: Le operazioni intermedie (come `filter`, `map`, `sorted`) sono `lazy` (pigre),
            cioè non vengono eseguite finché non viene chiamata un'operazione terminale. Restituiscono
            sempre un nuovo Stream, permettendo la concatenazione.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Cosa restituisce `Optional.ofNullable(null).orElse("Default")`?
            """,
            List.of("Optional[Default]", "null", "Default", "NullPointerException"),
            "C",
            """
            Spiegazione: `Optional.ofNullable(null)` crea un `Optional` vuoto.
            Il metodo `orElse("Default")` restituisce il valore contenuto nell'Optional se presente,
            altrimenti restituisce il valore di default fornito ("Default").
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Qual è lo scopo principale della classe `Optional`?
            """,
            List.of("Rendere i valori mutabili.", "Evitare i `NullPointerException`.", "Sostituire completamente i `null`.", "Migliorare le performance."),
            "B",
            """
            Spiegazione: Lo scopo principale di `Optional` è fornire un modo per rappresentare
            l'assenza di un valore in modo esplicito, forzando il programmatore a gestire
            questo caso e prevenendo così i `NullPointerException`. Non sostituisce `null`
            completamente, ma ne gestisce l'uso in modo più sicuro.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Quale delle seguenti è una sintassi valida per un'espressione lambda?
            """,
            List.of("() -> { System.out.println(\"Hi\"); }", "(int x, y) -> x + y", "x -> return x * x;", "void -> System.out.println(\"Hello\");"),
            "A",
            """
            Spiegazione:
            A) `()` -> `{ System.out.println("Hi"); }` è una sintassi valida per una lambda senza parametri e con un corpo a blocco.
            B) `(int x, y)` è invalido, tutti i tipi devono essere specificati o inferiti.
            C) `x -> return x * x;` è invalido, se si usa `return` si devono usare le parentesi graffe `{}`.
            D) `void -> ...` è invalido, `void` non è un tipo di parametro.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Cosa fa l'operazione `flatMap` in uno Stream?
            """,
            List.of("Appiattisce uno stream di stream in un singolo stream.", "Filtra gli elementi dello stream.", "Trasforma ogni elemento in un altro tipo.", "Raggruppa gli elementi in una mappa."),
            "A",
            """
            Spiegazione: `flatMap` è un'operazione intermedia che prende uno stream di stream (o di collezioni)
            e li "appiattisce" in un unico stream. È utile quando una trasformazione produce più elementi
            per ogni elemento di input.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Qual è il risultato del seguente codice?
            Optional<String> opt = Optional.of("Java");
            opt.ifPresent(s -> System.out.print(s.length()));
            """,
            List.of("4", "Java", "Nessuna stampa", "Errore di compilazione"),
            "A",
            """
            Spiegazione: `Optional.of("Java")` crea un Optional contenente "Java".
            `ifPresent()` esegue la lambda fornita solo se l'Optional contiene un valore.
            La lambda `s -> System.out.print(s.length())` stampa la lunghezza della stringa "Java", che è 4.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Quale delle seguenti affermazioni è vera riguardo a una classe anonima?
            """,
            List.of("Deve sempre implementare un'interfaccia funzionale.", "Non può estendere una classe concreta.", "Viene dichiarata e istanziata in un'unica espressione.", "È stata completamente sostituita dalle espressioni lambda."),
            "C",
            """
            Spiegazione: Una classe anonima è una classe senza nome che viene definita e istanziata
            direttamente nel punto in cui serve. Può implementare qualsiasi interfaccia (anche non funzionale)
            o estendere qualsiasi classe (concreta o astratta). Non è stata completamente sostituita dalle lambda,
            che sono più specifiche per le interfacce funzionali.
            """
        ));
        tutteLeDomande.add(new Domanda(4,
            """
            Cosa stampa il seguente codice?
            List<String> names = List.of("Alice", "Bob", "Charlie");
            names.parallelStream().forEach(System.out::print);
            """,
            List.of("AliceBobCharlie", "BobCharlieAlice", "CharlieAliceBob", "L'ordine di stampa non è garantito"),
            "D",
            """
            Spiegazione: Quando si usa un `parallelStream()`, l'ordine di esecuzione delle operazioni
            (in questo caso `forEach`) non è garantito. I task possono essere eseguiti su thread diversi
            e in un ordine non deterministico. Quindi, l'output può variare ad ogni esecuzione.
            """
        ));

        // --- MODULO 5: I/O E ECCEZIONI (10 Domande) ---
        tutteLeDomande.add(new Domanda(5,
            """
            Qual è il vantaggio principale di usare `try-with-resources`?
            """,
            List.of("Rende il codice più veloce.", "Permette di catturare più eccezioni.", "Garantisce che le risorse vengano chiuse automaticamente.", "Funziona solo con i file."),
            "C",
            """
            Spiegazione: Il costrutto `try-with-resources` è stato introdotto per risolvere il problema
            della gestione manuale delle risorse. Garantisce che il metodo `close()` di qualsiasi risorsa
            che implementi `AutoCloseable` venga chiamato automaticamente alla fine del blocco `try`,
            evitando resource leak e rendendo il codice più pulito e sicuro.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Cosa succede se un'eccezione viene lanciata sia nel blocco `try` sia nel metodo `close()` di una risorsa
            usata con `try-with-resources`?
            """,
            List.of("Vengono lanciate entrambe le eccezioni.", "Solo l'eccezione del `close()` viene propagata.", "L'eccezione del `close()` viene 'soppressa' e allegata all'eccezione del `try`.", "Il programma termina senza eccezioni."),
            "C",
            """
            Spiegazione: In un `try-with-resources`, se si verificano due eccezioni (una nel `try` e una nel `close()`),
            l'eccezione del `try` è quella principale che viene propagata. L'eccezione del `close()` viene
            "soppressa" e aggiunta alla lista delle eccezioni soppresse dell'eccezione principale,
            accessibile tramite `Throwable.getSuppressed()`.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Quale delle seguenti è una `Checked Exception`?
            """,
            List.of("NullPointerException", "ArrayIndexOutOfBoundsException", "IOException", "ArithmeticException"),
            "C",
            """
            Spiegazione: Le `Checked Exception` sono eccezioni che il compilatore ti obbliga a gestire
            (con `try-catch` o `throws`). `IOException` è un esempio tipico. Le altre sono `Unchecked Exception`
            (sottoclassi di `RuntimeException`), che indicano errori di programmazione e non sono obbligatorie da gestire.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Qual è il modo corretto per creare un'eccezione personalizzata che il compilatore ti obblighi a gestire?
            """,
            List.of("Estendere `RuntimeException`.", "Estendere `Error`.", "Estendere `Exception`.", "Implementare `Serializable`."),
            "C",
            """
            Spiegazione: Per creare una `Checked Exception` personalizzata, devi estendere direttamente `Exception`
            (o una sua sottoclasse che non sia `RuntimeException`). Estendere `RuntimeException` creerebbe
            un'eccezione `Unchecked`.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Quale delle seguenti affermazioni è vera riguardo all'I/O binario (`DataInputStream`/`DataOutputStream`)?
            """,
            List.of("È usato per leggere/scrivere file di testo leggibili dall'uomo.", "I dati devono essere letti nello stesso ordine e tipo con cui sono stati scritti.", "È più lento dell'I/O testuale.", "Non supporta la scrittura di tipi primitivi."),
            "B",
            """
            Spiegazione: L'I/O binario lavora con sequenze di byte. È fondamentale leggere i dati
            nello stesso ordine e con lo stesso tipo con cui sono stati scritti per interpretare
            correttamente i byte. È più efficiente per dati non testuali e supporta i tipi primitivi.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Quale classe dell'API `java.nio.file` è usata per rappresentare un percorso nel filesystem?
            """,
            List.of("File", "Path", "Files", "FileSystem"),
            "B",
            """
            Spiegazione: `Path` è la classe immutabile introdotta con NIO.2 (Java 7) per rappresentare
            un percorso a un file o una directory in modo più robusto e astratto rispetto alla vecchia classe `File`.
            `Files` è una classe di utilità per operare su `Path`.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Cosa fa il metodo `Files.readAllLines(Path path)`?
            """,
            List.of("Legge il file byte per byte.", "Legge l'intero contenuto del file e lo restituisce come una singola String.", "Legge tutte le righe del file e le restituisce come `List<String>`.", "Lancia un'eccezione se il file è troppo grande."),
            "C",
            """
            Spiegazione: `Files.readAllLines()` (introdotto in Java 7) legge tutte le righe di un file
            di testo e le restituisce come una `List<String>`. È comodo per file piccoli.
            `Files.readString()` (Java 11) restituisce una singola String.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Quale delle seguenti affermazioni è vera riguardo a `ResourceBundle`?
            """,
            List.of("È usato per formattare date e orari.", "Carica testi tradotti da file `.properties` in base a un `Locale`.", "È una classe per la gestione di connessioni di rete.", "Non supporta più lingue contemporaneamente."),
            "B",
            """
            Spiegazione: `ResourceBundle` è il meccanismo standard di Java per la localizzazione dei testi.
            Carica stringhe tradotte da file di proprietà (`.properties`) in base al `Locale` corrente o specificato.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Quale eccezione viene lanciata se si tenta di accedere a un elemento di un array con un indice fuori dai limiti?
            """,
            List.of("NullPointerException", "IllegalArgumentException", "ArrayIndexOutOfBoundsException", "IndexOutOfBoundsException"),
            "C",
            """
            Spiegazione: `ArrayIndexOutOfBoundsException` è l'eccezione specifica lanciata quando si tenta
            di accedere a un array con un indice negativo o maggiore o uguale alla sua dimensione.
            `IndexOutOfBoundsException` è la superclasse di questa e di altre eccezioni simili per le collezioni.
            """
        ));
        tutteLeDomande.add(new Domanda(5,
            """
            Quale delle seguenti affermazioni è vera riguardo a `WatchService`?
            """,
            List.of("Permette di eseguire operazioni di I/O in modo asincrono.", "È usato per monitorare le modifiche a file e directory.", "Sostituisce completamente `Files.walkFileTree()`.", "È un servizio di streaming audio."),
            "B",
            """
            Spiegazione: `WatchService` (parte di NIO.2) è un meccanismo per monitorare eventi
            (creazione, modifica, cancellazione) che avvengono su file e directory in modo efficiente,
            senza dover fare polling continuo.
            """
        ));

        // --- MODULO 6: ARGOMENTI AVANZATI (10 Domande) ---
        tutteLeDomande.add(new Domanda(6,
            """
            Quale affermazione descrive meglio un Virtual Thread (introdotto in Java 21)?
            """,
            List.of("È un thread più veloce di un Platform Thread.", "È un thread gestito direttamente dal sistema operativo.", "È un thread leggero gestito dalla JVM, ideale per task I/O-bound.", "Non può eseguire operazioni bloccanti."),
            "C",
            """
            Spiegazione: I Virtual Threads sono la risposta di Java alla necessità di gestire un numero
            enorme di task concorrenti. A differenza dei Platform Threads (i thread tradizionali), non sono
            legati 1-a-1 a un thread del sistema operativo. Sono estremamente leggeri e gestiti dalla JVM.
            Sono ideali per task che passano molto tempo in attesa (I/O-bound), perché la JVM può
            "parcheggiarli" e usare il thread del S.O. per eseguire altro lavoro.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Qual è lo scopo principale della keyword `sealed` in una classe o interfaccia?
            """,
            List.of("Rendere la classe immutabile.", "Impedire l'ereditarietà.", "Limitare le classi che possono estenderla o implementarla.", "Rendere tutti i suoi metodi `final`."),
            "C",
            """
            Spiegazione: Le `sealed classes` (introdotte in Java 17) permettono di dichiarare
            esplicitamente quali classi o interfacce sono autorizzate a estenderle o implementarle,
            creando una gerarchia "chiusa" e controllata.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Cosa stampa il seguente codice se `obj` è un `Punto(1, 2)`?
            record Punto(int x, int y) {}
            Object obj = new Punto(1, 2);
            if (obj instanceof Punto(int x, int y)) {
                System.out.println(x + y);
            }
            """,
            List.of("1 2", "3", "Errore di compilazione", "NullPointerException"),
            "B",
            """
            Spiegazione: Questo è un `Record Pattern` (Java 21). L'operatore `instanceof` non solo
            controlla il tipo, ma "de-costruisce" il record `Punto` nelle sue componenti `x` e `y`,
            rendendole direttamente disponibili nello scope del blocco `if`. Quindi `1 + 2` stampa `3`.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Quale delle seguenti affermazioni è vera riguardo a un `record`?
            """,
            List.of("È una classe mutabile per default.", "Può estendere qualsiasi classe.", "È implicitamente `final` e immutabile.", "Non può avere costruttori personalizzati."),
            "C",
            """
            Spiegazione: Un `record` (introdotto in Java 16) è una classe speciale progettata per essere
            un contenitore di dati immutabile. È implicitamente `final` (non estendibile) e tutti i suoi
            campi sono `private final`. Può avere costruttori compatti per la validazione.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Qual è lo scopo principale di un `ExecutorService`?
            """,
            List.of("Creare un singolo thread per eseguire un task.", "Gestire un pool di thread riutilizzabili.", "Sincronizzare l'accesso a risorse condivise.", "Eseguire task in modo sequenziale."),
            "B",
            """
            Spiegazione: `ExecutorService` (parte del framework `java.util.concurrent`) fornisce un modo
            per gestire un pool di thread. Invece di creare un nuovo thread per ogni task, i task vengono
            sottomessi all'executor che li assegna ai thread disponibili nel pool, migliorando l'efficienza.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Quale delle seguenti affermazioni è vera riguardo a `AtomicInteger`?
            """,
            List.of("È un sostituto di `int` per tutti gli usi.", "Fornisce operazioni thread-safe su un `int` senza `synchronized`.", "È più lento dell'uso di `synchronized`.", "Non può essere usato in ambienti multi-threaded."),
            "B",
            """
            Spiegazione: `AtomicInteger` (e altre classi `Atomic`) fornisce operazioni atomiche
            (indivisibili) su un valore `int`. Questo garantisce che le operazioni come incremento
            o decremento siano thread-safe senza la necessità di blocchi `synchronized`,
            offrendo spesso migliori performance e scalabilità.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Qual è il ruolo di `Future` quando si usa un `Callable` con un `ExecutorService`?
            """,
            List.of("Rappresenta il task da eseguire.", "È il risultato immediato del task.", "Rappresenta il risultato di un task asincrono che sarà disponibile in futuro.", "È un'eccezione lanciata dal task."),
            "C",
            """
            Spiegazione: Quando un `Callable` viene sottomesso a un `ExecutorService`, restituisce un oggetto `Future`.
            Questo `Future` è un "promemoria" del task sottomesso e permette di controllare lo stato del task
            (se è finito, se è stato cancellato) e di recuperare il suo risultato (`get()`) quando è disponibile.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Quale delle seguenti affermazioni è vera riguardo a un `enum`?
            """,
            List.of("Può essere istanziato con `new`.", "Può estendere una classe.", "Può avere campi, costruttori e metodi.", "Non può essere usato negli `switch`."),
            "C",
            """
            Spiegazione: Un `enum` (introdotto in Java 5) è un tipo speciale di classe che può avere
            campi, costruttori (sempre impliciti `private`) e metodi. Le sue costanti sono istanze
            dell'enum stesso. Non si istanzia con `new` e non può estendere altre classi (estende implicitamente `java.lang.Enum`).
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Qual è lo scopo principale di un `module-info.java`?
            """,
            List.of("Definire le dipendenze di un JAR e i package che espone.", "Contenere il metodo `main` di un'applicazione.", "Gestire le eccezioni a livello di modulo.", "Definire le classi astratte di un modulo."),
            "A",
            """
            Spiegazione: Il file `module-info.java` (introdotto con JPMS in Java 9) è il descrittore
            di un modulo. Dichiara esplicitamente quali altri moduli richiede (`requires`) e quali
            package rende accessibili (`exports`) ad altri moduli, garantendo incapsulamento forte e affidabilità.
            """
        ));
        tutteLeDomande.add(new Domanda(6,
            """
            Quale delle seguenti affermazioni è vera riguardo a un'annotazione custom con `@Retention(RetentionPolicy.RUNTIME)`?
            """,
            List.of("È visibile solo nel codice sorgente.", "È inclusa nel file `.class` ma non è accessibile a runtime.", "È accessibile a runtime tramite Reflection.", "Non può avere elementi."),
            "C",
            """
            Spiegazione: La meta-annotazione `@Retention(RetentionPolicy.RUNTIME)` indica che l'annotazione
            sarà mantenuta nel file `.class` e sarà accessibile a runtime tramite l'API Reflection.
            Questo permette al programma stesso di leggere e agire sui metadati definiti dall'annotazione.
            """
        ));
    }

    /**
     * Restituisce una lista di tutte le domande disponibili.
     * @return Una nuova lista contenente tutte le domande.
     */
    public static List<Domanda> getTutteLeDomande() {
        return new ArrayList<>(tutteLeDomande);
    }

    /**
     * Restituisce una lista di domande filtrate per un modulo specifico.
     * @param numeroModulo L'ID del modulo da filtrare.
     * @return Una nuova lista contenente solo le domande del modulo specificato.
     */
    public static List<Domanda> getDomandePerModulo(int numeroModulo) {
        return tutteLeDomande.stream()
                .filter(d -> d.modulo() == numeroModulo)
                .collect(Collectors.toList());
    }
}
