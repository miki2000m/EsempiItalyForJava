package MODULO_6_ARGOMENTI_AVANZATI_E_DA_CERTIFICAZIONE.Threading.MULTITHREADING;

public class MainMULTITHREADING {
    public static void main(String[] args){
        System.out.println("Il countdown di 5 secondi inizia ora\n");

        //Questi due thread sono paralleli
        //cioè verranno eseguiti contemporaneamente
        Thread thread=new Thread(new MyRunnableMulty());

        Thread thread1=new Thread(new MyRunnableMulty());

        //Faccio partire i thread
        thread.start();
        thread1.start();

        //Questa parte di codice mi permette di eseguire prima l'azione decisa per i thread e poi tutto quello che segue
        //così creando un programma dritto e pulito senza problemi
        try{
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nIl countdown è terminato");
    }
}
