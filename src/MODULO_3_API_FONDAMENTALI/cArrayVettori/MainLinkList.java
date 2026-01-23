package MODULO_3_API_FONDAMENTALI.cArrayVettori;

import java.util.LinkedList;

public class MainLinkList {
    public static void main(String[] args){
        // Le LinkedList e le ArrayList sono entrambe implementazioni dell'interfaccia List,
        // ma hanno strutture interne e performance molto diverse.
        // - ArrayList: Veloce per l'accesso casuale (get(i)). Lento per inserire/rimuovere nel mezzo.
        // - LinkedList: Veloce per aggiungere/rimuovere elementi all'inizio o alla fine. Lenta per l'accesso casuale.

        // Stiamo usando la LinkedList come se fosse uno "Stack" (una pila).
        LinkedList<String> linkedList = new LinkedList<>();

        System.out.println("linkedList.push() -> io permetto di inserire dei valori alla lista ma ne 'inverto' l'ordine");

        // .push() aggiunge un elemento IN TESTA alla lista.
        linkedList.push("A"); // Lista: [A]
        linkedList.push("B"); // Lista: [B, A]
        linkedList.push("C"); // Lista: [C, B, A]
        linkedList.push("D"); // Lista: [D, C, B, A]
        linkedList.push("E"); // Lista: [E, D, C, B, A]

        // La stampa mostra l'ordine inverso rispetto all'inserimento, perché push() aggiunge all'inizio.
        System.out.println(linkedList);


        System.out.println("\nlinkList.pop() -> Io rimuovo l'ultimo elemento");
        // .pop() rimuove l'elemento IN TESTA alla lista (il primo).
        // È l'operazione inversa di push().
        linkedList.pop(); // Rimuove "E"

        System.out.println(linkedList);

        System.out.println("\nlinkedList.offer() -> io permetto di inserire dei valori alla lista in ordine");
        //Usiamo offer
        linkedList.clear();

        //la rende orinata
        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("E");

        System.out.println(linkedList);

        System.out.println("\nlinkList.add() -> io permetto di inserire dei valori alla lista in ordine");
        //Usiamo add
        linkedList.clear();

        //inserisce le cose in ordine
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add(4,"F");
        //0 1 2 3 4 5 6
        //A B C D E F G -> ordine corretto ma
        //F -> vuole stare al posto numero 4 quindi decide di spostare la E
        //0 1 2 3 4 5 6
        //A B C D F E G -> ordine basato sul volere di F
        linkedList.add("G");

        System.out.println(linkedList);

        System.out.println("\nlinkList.peekFirst() -> io stampo il primo elemento della linkList");
        System.out.println(linkedList.peekFirst());
        System.out.println("\nlinkList.peekLast() -> io stampo l'ultimo elemento della linkList");
        System.out.println(linkedList.peekLast());

        //Usiamo addFirst
        //permette di aggiungere un elemento alla prima posizione facendo spostare tutti di uno
        System.out.println("\nlinkList.addFirst() -> io aggiungo un elemento nella prima posizione");
        linkedList.addFirst("0");

        System.out.println(linkedList);

        //Usiamo addLast
        //permette di aggiungere un elemento alla ultima posizione
        System.out.println("\nlinkList.addLast() -> io aggiungo un elemento nella ultima posizione");
        linkedList.addLast("Z");

        System.out.println(linkedList);

        //Usiamo removeFirst
        //permette di rimuovere un elemento alla prima posizione facendo spostare tutti di uno
        System.out.println("\nlinkList.removeFirst() -> io rimuovo un elemento nella prima posizione");
        String first =linkedList.removeFirst();

        System.out.println(linkedList);

        //Usiamo removeLast
        //permette di rimuovere un elemento alla ultima posizione
        System.out.println("\nlinkList.removeLast() -> io rimuovo un elemento nella ultima posizione");
        String last =linkedList.removeLast();

        System.out.println(linkedList);
    }
}
