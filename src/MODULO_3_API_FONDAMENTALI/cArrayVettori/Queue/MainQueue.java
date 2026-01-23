package MODULO_3_API_FONDAMENTALI.cArrayVettori.Queue;

import java.util.*;

public class MainQueue {
    public static void main(String[] args){
        // Queue (Coda) = Struttura dati FIFO (First-In, First-Out).
        // Funziona come una vera fila: il primo che entra è il primo che esce.
        // Si aggiunge in fondo e si rimuove dall'inizio.

        // Poiché Queue è un'interfaccia, dobbiamo usare una classe concreta che la implementi, come LinkedList.
        Queue<String> coda = new LinkedList<>();

        // 1. AGGIUNGERE ELEMENTI con offer()
        // Il metodo offer() aggiunge un elemento in fondo (in coda) alla fila.
        coda.offer("Marco");
        coda.offer("Anna");
        coda.offer("Luca");
        coda.offer("Sofia");

        System.out.println("Clienti in coda: " + coda);
        System.out.println("---------------------------------");

        // 2. VISUALIZZARE L'ELEMENTO IN TESTA con peek()
        // Il metodo peek() "sbircia" chi è il primo della fila, senza rimuoverlo.
        // Se la coda è vuota, restituisce null.
        String primoCliente = coda.peek();
        System.out.println("Il primo cliente da servire è: " + primoCliente);
        System.out.println("La coda non è cambiata: " + coda);
        System.out.println("---------------------------------");

        // 3. RIMUOVERE ELEMENTI con poll()
        // Il metodo poll() rimuove e restituisce l'elemento in testa alla fila (il primo che è entrato).
        // Se la coda è vuota, restituisce null.
        String clienteServito = coda.poll();
        System.out.println("È stato servito: " + clienteServito);
        System.out.println("Clienti rimasti in coda: " + coda);

        clienteServito = coda.poll();
        System.out.println("È stato servito: " + clienteServito);
        System.out.println("Clienti rimasti in coda: " + coda);
        System.out.println("---------------------------------");

        // Altri metodi utili:
        // .isEmpty() -> controlla se la coda è vuota (restituisce true/false)
        System.out.println("La coda è vuota? " + coda.isEmpty());
        // .size() -> restituisce il numero di elementi nella coda
        System.out.println("Quanti clienti sono ancora in coda? " + coda.size());
        // .contains() -> controlla se un elemento è presente nella coda
        System.out.println("C'è ancora Luca in coda? " + coda.contains("Luca"));

    }
}
