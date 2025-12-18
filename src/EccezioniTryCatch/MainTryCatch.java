package EccezioniTryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTryCatch {
    private static Scanner input = new Scanner(System.in);

    //Si forma ... throws ECCEZIONE
    //Questo permette di non dover avere try-catch con quella eccezione
    //in questo caso ci permette di non avere try-catch con le eccezioni di Exception (quindi qualsiasi tipo di eccezione all'interno della classe)
    public static void main(String[] args) throws Exception{
        double n1=0;
        double n2=0;
        double result=0;


        //try{} = Prova la porzione di cod che si trova dentro le {}
        try{
            System.out.print("inserisci il nominatore: ");
            n1=input.nextDouble();

            System.out.print("inserisci il denominatore: ");
            n2=input.nextDouble();

            result=n1/n2;

            input.nextLine();
        }
        //catch(tipo di eccezione){} = se c'è il tipo di eccezione dentro le () fa quello che c'è dentro le {}
        catch (ArithmeticException e){
            System.out.println("\n!!! Errore rilevato !!!");
            System.out.printf("non puoi dividere per: %d",n2);
        }
        catch (InputMismatchException e){
            System.out.println("\n!!! Errore rilevato !!!");
            System.out.println("errore di input inserito");
        }
        catch (Exception e){
            System.out.println("\n!!! Errore rilevato !!!");
            System.out.println("errore generico");
        }

        System.out.printf("%.2f",result);

        input.close();
    }
}
