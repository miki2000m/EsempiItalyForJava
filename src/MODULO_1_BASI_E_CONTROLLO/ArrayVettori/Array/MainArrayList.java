package MODULO_1_BASI_E_CONTROLLO.ArrayVettori.Array;

//sia ArrayList che Vector arrivano dalla libreria util
//chiamate API
import java.util.*;

public class MainArrayList {
    public static void main(String[] args) {
        //Tutto quello che c'è qui dentro vale per ogni variabile

        //##### Vector e ArrayList hanno gli stessi metodi ci sono solo differenze di memoria utilizzata ######
        //Qui devono essere usate le reference cioè le variabili Wrapper

        //creo un ArrayList e un Vector così da mostrare che i metodi non hano differenze
        //ArrayList<tipo> nome = new ArrayList<(opzionale) tipo>();
        //Vector<tipo> nome = new Vector<(opzionale) tipo>();
        ArrayList<String> personeAL =new  ArrayList<String>();
        Vector<String> personeV=new Vector<String>();


        //Inserimento elementi all'interno del Vector/ArrayList ------------------------------------------------

        //Vector ---------------
        personeV.add("Jaime");
        personeV.add("Samuel");
        personeV.add("Julian");

        //ArrayList ------------
        personeAL.add("Jaime");
        personeAL.add("Samuel");
        personeAL.add("Julian");

        //STAMPE #################################################################################################

        //stampe di determinati elementi
        //nome(ArrayList/Vector).get(x)

        //Vector ---------------
        //personeV.get(x)
        System.out.printf("personeV: nella posizione 2 si trova: %s",personeV.get(1));

        //ArrayList ------------
        //personeAL.get(x)
        System.out.printf("\n\npersoneAL: nella posizione 1 si trova: %s",personeAL.get(0));

        //stampa di tutti gli elementi (tramite lista normale)
        System.out.println("metodo con nomeLista");

        //Vector --------------
        System.out.printf("\n\npersoneV: Questi sono tutti gli elementi %s",personeV);

        //ArrayList -----------
        System.out.printf("\n\npersoneAL: Questi sono tutti gli elementi %s",personeAL);


        //stampa di tutti gli elementi (tramite for)
        //non si usa più .length ma .size() fanno la stessa cose prendono la "LUNGHEZZA" del vettore/lista
        System.out.println("metodo con for");

        //Vector -------------
        System.out.println("Vector");
        for(int i=0;i<personeV.size();i++){
            System.out.printf("%s \n",personeV.get(i));
        }

        System.out.println();

        //ArrayList ----------
        System.out.println("ArrayList");
        for(int i=0;i<personeAL.size();i++){
            System.out.printf("%s \n",personeAL.get(i));
        }



        //sostituire un elemento della lista con un altro elemento
        //.set(x,"y")

        //Vector ------------
        personeV.set(0,"Michael");
        System.out.printf("\n\npresoneV:\nSostituisco ciò che si trova nell'indice 1 con Michel: %s",personeV.get(0));

        //ArrayList ---------
        personeAL.set(0,"Michael");
        System.out.printf("\n\npersoneAL:\nSostituisco ciò che si trova nell'indice 1 con Michel: %s",personeAL.get(0));


        //rimuovere 1 elemento dalla lista
        //.remove(x) or .remove("xxxx")

        //Vector ------------
        //personeV.remove("Michael");
        personeV.remove(0);
        System.out.printf("\n\npersonaV:\nRimuovo il primo elemento: %s",personeV);

        //ArrayList ---------
        //personeAL.remove("Michael");
        personeAL.remove(0);
        System.out.printf("\n\npersoneAL:\nRimuovo il primo elemento: %s",personeAL);

        //Svuoto le liste

        personeAL.clear();

        personeV.clear();

        System.out.printf("personeAL: %s\npersoneV: %s",personeAL,personeV);
    }
}
