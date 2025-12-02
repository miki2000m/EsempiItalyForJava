package Threading;

import java.util.Scanner;

public class MainThreading {
    public static void main(String[] args){
        String nome;
        Scanner input=new Scanner(System.in);

        //così facendo rendo paralleli i due thread così da avere 2 azioni in parallelo
        MyRunnable myRunnable=new MyRunnable();
        Thread t1=new Thread(myRunnable);

        //sostanzialmente questo setDaemon(true)
        //rende il thread secondario,
        //permettendo al programma di chiudersi senza doverlo aspettare.
        t1.setDaemon(true);
        t1.start();

        System.out.println("Hai 5 secondi per inserire il tuo nome ");

        //input
        System.out.print("Inserisci il tuo nome: ");
        nome=input.nextLine();


        System.out.println("Ciao "+nome);


        input.close();
    }
}
