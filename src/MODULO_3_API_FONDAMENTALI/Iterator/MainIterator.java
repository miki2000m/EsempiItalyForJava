package MODULO_3_API_FONDAMENTALI.Iterator;

import java.util.*;

public class MainIterator {
    public static void main(String[] args) {
        //Questo metodo di Iterator è consigliato per rimuovere elementi da un ArrayList
        //perché il for o for-each possono creare problemi

        //creazione di un ArrayList
        ArrayList<String> persone=new ArrayList<>();

        //aggiungiamo elementi al ArrayList
        persone.add("John");
        persone.add("Mary");
        persone.add("Sam");
        persone.add("Samuel");

        //Iterator<tipo> nome= nome.Iterator();
        //tipo == tipo del ArrayList
        //va a prendere elemento per elemento
        Iterator<String> i=persone.iterator();

        //stampo cosa sta leggendo l'Iterator
        //nome.next() fa passare come lo scanner alla prossima riga da leggere
        //però in questo caso passa al prossimo elemento del ArrayList
        //la prima riga di default è la visione completa del ArrayList
        /*
        System.out.println(i.next());//John
        System.out.println(i.next());//Mary
        System.out.println(i.next());//Sam
        System.out.println(i.next());//Samuel
        */

        System.out.printf("persone: prima della rimozione: %s\n",persone);

        //per visualizzare tutti gli elementi x del ArrayList
        while(i.hasNext()){
            String persona=i.next();
            if(persona == "Sam"){
                //elimino dalla lista Sam
                i.remove();
            }
        }

        System.out.printf("\npersone: dopo la rimozione sono rimasti: %s",persone);
    }
}
