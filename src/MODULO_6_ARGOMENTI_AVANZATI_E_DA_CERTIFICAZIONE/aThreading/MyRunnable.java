package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.aThreading;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            try{
                //ha bisogno di un try-catch
                Thread.sleep(1000);

            }
            catch (InterruptedException e){
                System.out.println("Il Thread si è interrotto");
            }

            if(i==5){
                System.out.println("\nIl tempo è scaduto");

                //così il programma termina allo scadere dei 5s
                System.exit(0);
            }
        }
    }
}
