package MODULO_3_API_FONDAMENTALI.ArrayVettori.Queue;

//Chiamate API
import java.util.*;

public class MainPriorityQueue {
    public static void main(String[] args){
        //Stessa struttura del queue normale (FI-FO)
        //è sempre costruito come una coda dovo l'ultimo cliente rimane uguale mentre il primo cambia
        //ovviamente se si aggiunge un cliente cambia l'ultimo cliente

        //Permette di dare priorità ai valori più piccoli
        Queue<Double> queuePriority = new PriorityQueue<>();

        queuePriority.offer(7.5);
        queuePriority.offer(2.0);
        queuePriority.offer(3.0);
        queuePriority.offer(4.0);

        System.out.println("Io sono un priority Queue");
        while(!queuePriority.isEmpty()){
            System.out.println(queuePriority.poll());
        }

        //Differenza di stampa
        Queue<Double> queueLinkList = new LinkedList<>();

        queueLinkList.offer(7.5);
        queueLinkList.offer(2.0);
        queueLinkList.offer(3.0);
        queueLinkList.offer(4.0);

        System.out.println("\nIo sono un LinkedList Queue");
        while (!queueLinkList.isEmpty()){
            System.out.println(queueLinkList.poll());
        }

        //Come potete notare stesso ordine di inserimento ma ordine differente di priorità


        //Adesso invertiamo l'ordine
        Queue<Double> queueReversPriority = new PriorityQueue<>(Comparator.reverseOrder());

        queueReversPriority.offer(7.5);
        queueReversPriority.offer(2.0);
        queueReversPriority.offer(3.0);
        queueReversPriority.offer(4.0);

        System.out.println("\nIo sono un reverse Priority Queue");
        while (!queueReversPriority.isEmpty()){
            System.out.println(queueReversPriority.poll());
        }

        //Esempio con String -> ordine alfabetico
        Queue<String> queueString = new PriorityQueue<>();
        queueString.offer("B");
        queueString.offer("C");
        queueString.offer("A");
        queueString.offer("D");

        System.out.println("\nIo sono un Priority Queue String Queue ");
        while (!queueString.isEmpty()){
            System.out.println(queueString.poll());
        }

        //Esempio con String invertito -> ordine alfabetico invertito
        Queue<String> queueStringReverse = new PriorityQueue<>(Comparator.reverseOrder());
        queueStringReverse.offer("B");
        queueStringReverse.offer("C");
        queueStringReverse.offer("F");
        queueStringReverse.offer("A");
        queueStringReverse.offer("D");

        System.out.println("\nIo sono un reverse Priority Queue String Queue ");
        while (!queueStringReverse.isEmpty()){
            System.out.println(queueStringReverse.poll());
        }
    }
}
