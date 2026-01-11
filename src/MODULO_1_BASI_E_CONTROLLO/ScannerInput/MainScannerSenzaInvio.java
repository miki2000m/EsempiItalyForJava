package MODULO_1_BASI_E_CONTROLLO.ScannerInput;

import java.util.Scanner;

public class MainScannerSenzaInvio {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        // Flag per sapere se l'utente ha premuto invio
        final boolean[] invioPremuto = {false};

        System.out.println("Premi INVIO entro 5 secondi...");

        // 1️⃣ Thread separato che aspetta l'input
        Thread inputThread = new Thread(() -> {
            scanner.nextLine(); // aspetta che l'utente prema invio
            invioPremuto[0] = true; // segnala che l'invio è stato premuto
        });
        inputThread.start();

        // 2️⃣ Loop principale che controlla il flag per 5 secondi
        int timeout = 5000;   // 5 secondi
        int intervallo = 50;  // controllo ogni 50ms
        int tempoTrascorso = 0;

        while (tempoTrascorso < timeout && !invioPremuto[0]) {
            Thread.sleep(intervallo);
            tempoTrascorso += intervallo;
        }

        // 3️⃣ Controllo finale
        if (invioPremuto[0]) {
            System.out.println("Hai premuto INVIO! Faccio l'azione A.");
        } else {
            System.out.println("Non hai premuto nulla. Faccio l'azione B.");
        }

        // Interrompo il thread se è ancora in ascolto
        inputThread.interrupt();
        scanner.close();
    }
}
