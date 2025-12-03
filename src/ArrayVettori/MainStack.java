package ArrayVettori;

import java.util.Stack;

public class MainStack {
    public static void main(String[] args){
        // Questo file dimostra l'utilizzo della classe `Stack`.
        // Uno Stack è una struttura dati che segue il principio LIFO (Last-In, First-Out),
        // dove l'ultimo elemento aggiunto è il primo a essere rimosso, come una pila di piatti.
        // Qui viene istanziato uno Stack di Stringhe per mostrarne i metodi principali.

        Stack<String> stack=new Stack<>();

        //Usando il comando push
        //si inseriscono gli elementi uno sopra a l'altro come se fosse una colonna
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");

        System.out.println("Io sono il comando push -> inserisco elementi all'interno dello stack");
        System.out.println(stack);

        //Usiamo il comando pop
        //rimuove l'ultimo elemento inserito cioè quello in cima alla pila
        stack.pop();

        System.out.println("\nIo sono il comando pop -> elimino l'elemento in cima cioè l'ultimo inserito");
        System.out.println(stack);

        //si può assegnare a una variabile il valore rimosso con il comando pop
        String imPop=stack.pop();
        System.out.println("Io sono il comando pop assegnato a una variabile");
        System.out.println(imPop);
        System.out.printf("Io sono quello che rimane nello stack: %s\n",stack);

        //Usiamo il comando search
        //permette di fare la ricerca di un index tramite il nome che vogliamo cercare
        System.out.println("\nIo sono il comando search: io cerco l'indice del numero 2");
        System.out.println(stack.search("2"));//cerco in che index è 1 e lo stampo
        //in questo caso stamperà 1 perché
        //stamperà l'ordine inverso partendo da 1
        //quindi 4 3 2 1
        //index  1 2 3 4
        //se inseriamo un elemento che non esiste ci stamperà -1
        System.out.println("Io cerco l'indice del numero 6");
        System.out.println(stack.search("6"));
        }
}
