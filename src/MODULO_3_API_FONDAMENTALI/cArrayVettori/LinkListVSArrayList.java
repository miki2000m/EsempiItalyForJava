package MODULO_3_API_FONDAMENTALI.cArrayVettori;

//Chiamate API
import java.util.*;

public class LinkListVSArrayList {
    public static void main(String[] args){
        // Le LinkedList e le ArrayList sono entrambe implementazioni dell'interfaccia List,
        // ma hanno strutture interne e performance molto diverse.

        //I LinkedList permettono un collegamento di informazioni tramite nodi
        //Mentre gli ArrayList hanno un organizzazione lineare

        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;//-> tempo trascorso

        for(int i=0; i<1000000;i++){
            linkedList.add(i);
            arrayList.add(i);
        }

        System.out.println("--- Test di ACCESSO a un elemento a METÀ della lista ---");
        // Qui l'ArrayList vince, perché può accedere direttamente all'indice.
        // La LinkedList deve attraversare 500.000 nodi per arrivare all'elemento.

        //############# LINKEDLIST ##################
        startTime = System.nanoTime();

        linkedList.get(500000);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList: \t"+elapsedTime+" ns");

        //############ ARRAYLIST ####################
        startTime = System.nanoTime();

        arrayList.get(500000);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList: \t\t"+elapsedTime+" ns");

        System.out.println("\n--- Test di RIMOZIONE del PRIMO elemento ---");
        // Qui la LinkedList vince, perché deve solo cambiare il puntatore del primo nodo.
        // L'ArrayList deve spostare tutti i 999.999 elementi successivi di una posizione.

        //############# LINKEDLIST ##################
        startTime = System.nanoTime();

        linkedList.remove(0);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList: \t"+elapsedTime+" ns");

        //############ ARRAYLIST ####################
        startTime = System.nanoTime();

        arrayList.remove(0);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList: \t\t"+elapsedTime+" ns");
    }
}
