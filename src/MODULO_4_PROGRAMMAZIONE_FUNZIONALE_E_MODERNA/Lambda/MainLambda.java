package MODULO_4_PROGRAMMAZIONE_FUNZIONALE_E_MODERNA.Lambda;

public class MainLambda{
    public static void main(String[] args) {
        //Lambda è usata principalmente per rendere il codice più semplice e veloce
        //Operatore lambda (->)
        //(argomento)->{statement/s}

        String nome="Michael";
        char symbol='!';

        //così modifico il contenuto dell'azione all'interno dell'interfaccia
        //n è identificato come parametro della funzione
        //deve essere diverso dalla variabile nome
        Interface interfaccia=(n,s)-> {
            //qui si possono aggiungere più azioni come un semplice metodo di override che viene implementato nella classe
            System.out.println("Ciao Mondo");
            System.out.printf("Io ho come aggiunta un parametro(String): %s\n",n);
            System.out.printf("Io ho come aggiunta un parametro(char): %c\n",s);
        };

        interfaccia.messaggio(nome,symbol);

        //Ovviamente si può modificare in più casi
        //è così non si ha un metodo unico come le solite implementazioni
        Interface interfaccia1=(n,s)->{
            System.out.println("\nIo sono una seconda istanza");
            System.out.printf("Ciao %s%c\n",n,s);
        };

        interfaccia1.messaggio(nome,symbol);
    }

}
