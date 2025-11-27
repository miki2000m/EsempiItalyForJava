package Timer;

import java.util.*;

public class MainTimer {
    public static void main(String[] args) {
        //Timer and TimerTask example
        //Timer usa un tempo specifico per eseguire un compito ripetutamente
        //TimerTask è il compito che deve essere eseguito

        Timer timer = new Timer();
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
        timer.schedule(task, 10000,2000); //stampa "Hello" dopo 0.5 secondi e poi ogni 2 secondi
    }
}
