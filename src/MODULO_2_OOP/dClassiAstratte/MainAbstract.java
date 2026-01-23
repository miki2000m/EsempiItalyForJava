package MODULO_2_OOP.dClassiAstratte;

import java.util.*;

public class MainAbstract {
    public static void main(String[] args) {
        //non si può (OVVIAMENTE) creare direttamente un oggetto Monster perchè è una classe oggetto astratta
        //Monster monsters=new Monster("nome);

        //SENZA VECTOR/ARRAYLIST

        //Possiamo creare i vari tipi di monsters
        IceMonster iceMonster=new IceMonster("Ice Monster");
        FireMonster fireMonster=new FireMonster("Fire Monster");
        MiniIceMonster miniIceMonster=new MiniIceMonster("Mini Ice Monster");
        StoneMonster stoneMonster=new StoneMonster("Stone Monster");

        //Utilizzo dei Monster
        System.out.println("Utilizzo i metodi astratti creati nell'oggetto astratto Monster (che è comune a tutti gli oggetti xMonster (tranne miniIceMonster))");
        System.out.println("Questi metodi sono totalmente personalizzati per tutti gli oggetti tramite l'Override\n");

        //Ice e MiniIce Monster
        System.out.println("Ice Monster:");
        System.out.println(iceMonster.attacco());
        System.out.println(iceMonster.difesa());

        System.out.println();

        System.out.println("Mini Ice Monster:");
        System.out.println(miniIceMonster.attacco());
        System.out.println(miniIceMonster.difesa());

        System.out.println();

        //FireMonster
        System.out.println("Fire Monster:");
        System.out.println(fireMonster.attacco());
        System.out.println(fireMonster.difesa());

        System.out.println();

        //StoneMonster
        System.out.println("Stone Monster:");
        System.out.println(stoneMonster.attacco());
        System.out.println(stoneMonster.difesa());

        System.out.println();

        //CON VECTOR/ARRAYLIST
        System.out.println("############################################# VECTOR/ARRAYLIST ###############################################");
        System.out.println("\nQuesta parte è totalmente dedicato all'implementazione di vector/arrayList con un parametro di tipo astratto");

        //creiamo la nostra lista
        ArrayList<Monster> monsters=new ArrayList<Monster>();

        //aggiungiamo definendo il tipo di monsters per ogni cosa che aggiungiamo
        //nomeArrayList.add(new tipo(parametri));
        monsters.add(new IceMonster("Ice Monster ArrayList"));
        monsters.add(new IceMonster("Ice Monster ArrayList (2)"));
        monsters.add(new FireMonster("Fire Monster"));
        monsters.add(new StoneMonster("Stone Monster"));
        monsters.add(new MiniIceMonster("Mini Ice Monster"));

        //stampo le azioni dei mostri e i mostri che le fanno
        for(Monster monster:monsters){
            System.out.println();

            System.out.println(monster.saluta());

            System.out.println(monster.attacco());
            System.out.println(monster.difesa());

            //System.out.println(monster.resa()); -> non stampa niente negli altri monster
            //se non abbiamo standardizzato un metodo all'interno della classe assoluta ma abbiamo riscritto il metodo in un altra classe
            //possiamo fare così:
            //se(monster è un istanza di StoneMonster)
            if(monster instanceof StoneMonster){
                //mi permette di stampare la resa che è presente all'interno di stone monster
                //perché nella classe astratta Monster non restituisce niente
                System.out.println(monster.resa());
            }
        }
    }
}
