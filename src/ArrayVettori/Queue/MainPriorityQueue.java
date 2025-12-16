package ArrayVettori.Queue;

//Chiamate API
import java.util.*;

public class MainPriorityQueue {
    public static void main(String[] args){
        //Stessa struttura del queue normale (FI-FO)
        //è sempre costruito come una coda dovo l'ultimo cliente rimane uguale mentre il primo cambia
        //ovviamente se si aggiunge un cliente cambia l'ultimo cliente

        //Permette di dare priorità ai valori più piccoli
        Queue<Double> queue = new PriorityQueue<>();

        queue.offer(7.5);
        queue.offer(2.0);
        queue.offer(3.0);
        queue.offer(4.0);

        System.out.println("Io sono un priority Queue");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }

        //Differenza di stampa
        Queue<Double> queue2 = new LinkedList<>();
        queue2.offer(7.5);
        queue2.offer(2.0);
        queue2.offer(3.0);
        queue2.offer(4.0);

        System.out.println("\nIo sono un LinkedList Queue");
        while (!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }

        //Come potete notare stesso ordine di inserimento ma ordine differente di priorità
    }
}
