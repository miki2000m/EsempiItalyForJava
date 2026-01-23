package MODULO_1_BASI_E_CONTROLLO.dArrayVettori.dArray;

import java.util.Random;

public class MainArray {
    public static void main(String[] args){
        Random random=new Random();

        //gli array o anche vettori sono "liste" ordinate è con una dimensione fissa
        //tipo vNome[]= new tipo[lunghezza];

        int vNumeri[]=new int[10];
        //quando noi andiamo a inizializzare un vettore si genererà così
        //vNumeri[]= 0 0 0 0 0 0 0 0 0 0
        //gli index dei vettori partono sempre da 0 quindi l'ultimo valore di vNumeri sarà 9

        System.out.println("Stampa vettore vuoto tramite ciclo for");
        //index -> indice
        System.out.println("0 1 2 3 4 5 6 7 8 9");
        //stampa di un vettore vuoto
        for(int i =0;i< vNumeri.length;i++){
            //andiamo a chiedere di stampare i numeri nell'indice i
            System.out.printf("%d ",vNumeri[i]);
        }


        System.out.println("\n\nGenerazione di numeri casuali (con stampa)");
        //possiamo caricare il vettore magri se dobbiamo trovare un valore maggiore all'interno del vettore possiamo trovarlo con un ciclo che itera ogni valore di vNumeri
        //generiamo dei numeri casuali all'interno del array
        for(int i=0;i<vNumeri.length;i++){
            vNumeri[i]=random.nextInt(10)+1;//da 1 a 10
            //stampa per dimostrazione dei numeri generati
            System.out.printf("%d ",vNumeri[i]);
        }

        System.out.println("\n\nAdesso troviamo il valore maggiore e minore");
        int max=vNumeri[0];
        int min=vNumeri[0];

        for(int i=0;i< vNumeri.length;i++){
            max=(max>vNumeri[i])? max : vNumeri[i];//-> sono Ternary Operator
            min=(min<vNumeri[i])? min : vNumeri[i];

            //scrittura semplice più didattica
            /*
            if(max<vNumeri[i]){
                max=vNumeri[i];
            }
            if(min>vNumeri[i]){
                min=vNumeri[i];
            }
            */

            //si puo fare in modo ancora più intelligente
            //qui andiamo ad usare i metodi all'intendo di Math
            max=Math.max(max,vNumeri[i]);
            min=Math.min(min,vNumeri[i]);
        }

        System.out.printf("Io sono il numero più grande all'interno del vettore: %d\n",max);
        System.out.printf("Io sono il numero più piccolo all'interno del vettore: %d\n",min);

    }
}
