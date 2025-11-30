package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class MainSteamAPI {
    public static void main(String[] args) {
        //Pt 1: Creazione di una lista di titoli di libri
        List<String> libri=new ArrayList<String>();
        libri.add("Il potere di Java");
        libri.add("Java - La guida completa");
        libri.add("Clean Code");
        libri.add("Prima Java");

        System.out.println("Prima del filtraggio: ");
        libri.forEach(System.out::println);

        //########## Inserisco il filtraggio in un altra lista per essere più chiaro ##########

        System.out.println("\nDopo il filtraggio: ");
        //Filtro i titoli che contengono Java
        List<String> libriJava = libri.stream()
                //Filtraggio
                .filter(titolo -> titolo.contains("Java"))
                //Colleziono i risultati in una nuova lista
                .collect(Collectors.toList());


        //Stampa i titoli filtrati
        libriJava.forEach(System.out::println);

        //Pt 2: Somma dei numeri pari in una lista
        //Array.asList crea una lista a partire da un array
        List<Integer> numeri = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Calcolo la somma dei numeri pari usando Stream API
        int somma= numeri.stream()
                //Faccio la somma dei numeri contenuti nella lista
                .reduce(0, Integer::sum);

        System.out.println("\nLista di numeri: ");
        numeri.forEach((n) -> System.out.print(n + " "));

        System.out.println("\nSomma dei numeri della lista è: " + somma);
    }
}
