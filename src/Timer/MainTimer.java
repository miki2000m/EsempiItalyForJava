package Timer;

import java.util.*;

public class MainTimer {
    public static void main(String[] args) {
        //Timer and TimerTask example
        //Timer usa un tempo specifico per eseguire un compito ripetutamente
        //TimerTask è il compito che deve essere eseguito

        //Timer timer = new Timer();
        /*/
        TimerTask task = new TimerTask() {
            //qui ci sarà l'azione da eseguire tramite un semplice override del metodo run() (già presente in TimerTask)
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        //timer.schedule(task, delay, period);
        //task   -> compito da eseguire
        //delay  -> ritardo prima di eseguire il compito (in ms)
        //period -> intervallo di tempo tra un'esecuzione e l'altra (in ms
        timer.schedule(task, 300,200); //stampa "Hello" dopo 0.5 secondi e poi ogni 2 secondi
*/
        //Il metodo più furbo per farlo è così direttamente creando un nuovo timer task nel timer.schedule(new TimerTask(){}, delay, period)
        Timer timer1= new Timer();

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Ciao");
            }
        }, 700,500);
    }
}
