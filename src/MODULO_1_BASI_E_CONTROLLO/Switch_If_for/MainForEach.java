package MODULO_1_BASI_E_CONTROLLO.Switch_If_for;

import java.util.ArrayList;

public class MainForEach {
    public static void main(String[] args) {
        int[] v={4,5,72,4};

        //veloce usato molto nei Vector/ArrayList senza counter
        //usato principalmente per non avere dei cicli for con all'interno righe lunghissime e per evitare di avere molte righe inutili
        for(int n: v){
            System.out.printf("%d ",n);
        }


        //classico e se si ha bisogno di un counter
        for(int i=0;i<v.length;i++){
            System.out.printf("%d ",v[i]);
        }

        System.out.println();

        //Questo forEach può essere sfruttato solo con gli ArrayList
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Io sono un foreach più furbo: \n(list.forEach(System.out::println);)");
        list.forEach(System.out::println);

        //modo più furbo usando lambda
        //si può mettere qualsiasi tipo di print all'interno del forEach
        System.out.println("Io sono un foreach più furbo con lambda formattato: \n(list.forEach(n -> System.out.printf(\"%5d\",n));)");
        list.forEach(n -> System.out.printf("%5d",n));

        System.out.println();
        System.out.println();

        System.out.println("Io sono un foreach più furbo con lambda: \n(list.forEach(n -> System.out.println(n+' '));)");
        list.forEach(n -> System.out.print(n+" "));
    }
}
