package Threading;

import java.util.Scanner;

public class MainThreading {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Hai 5 secondi per inserire il tuo nome ");

        for(int i=1;i<=5;i++){
            try{
                //ha bisogno di un try-catch
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Il Thread si è interrotto");
            }

            if(i==5){
                System.out.println("Il tempo è scaduto");
            }
        }

        //input
        System.out.print("Inserisci il tuo nome: ");
        String nome=input.nextLine();

        System.out.println("Ciao "+nome);


        input.close();
    }
}
