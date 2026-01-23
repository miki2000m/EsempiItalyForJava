package MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO.eInfoDiRete.NetworkingSockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * GUIDA ALLA PROGRAMMAZIONE DI RETE CON SOCKETS: IL SERVER
 *
 * Questo file implementa un semplice Server TCP. Un server è un programma che
 * si mette in "ascolto" su una porta di rete specifica e attende che un client
 * si connetta per stabilire una comunicazione.
 */
public class Server {

    public static void main(String[] args) {
        // La porta su cui il server si metterà in ascolto.
        // Deve essere un numero tra 1024 e 65535 (le porte inferiori sono spesso riservate).
        int porta = 6789;

        System.out.println("--- SERVER ---");

        // Usiamo un blocco try-with-resources per garantire che il ServerSocket venga chiuso.
        try (ServerSocket serverSocket = new ServerSocket(porta)) {

            System.out.println("1. Server avviato. In ascolto sulla porta " + porta + "...");

            // 2. Il metodo accept() è bloccante: il programma si ferma qui e attende
            //    che un client si connetta. Quando un client si connette, `accept()` restituisce
            //    un oggetto `Socket` che rappresenta la connessione con quel client specifico.
            Socket clientSocket = serverSocket.accept();
            System.out.println("2. Client connesso! Indirizzo: " + clientSocket.getInetAddress().getHostAddress());

            // Ora che abbiamo una connessione, possiamo comunicare.
            // Usiamo un altro try-with-resources per gestire gli stream di comunicazione.
            try (
                // Otteniamo lo stream di input per leggere i dati inviati dal client.
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                // Otteniamo lo stream di output per inviare dati al client.
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true) // `true` per l'autoflush
            ) {
                // 3. Leggiamo il messaggio inviato dal client.
                // Il metodo readLine() è di nuovo bloccante: attende finché il client non invia una riga di testo.
                String messaggioDalClient = in.readLine();
                System.out.println("3. Messaggio ricevuto dal client: \"" + messaggioDalClient + "\"");

                // 4. Prepariamo e inviamo una risposta al client.
                String risposta = "Ciao Client, ho ricevuto il tuo messaggio!";
                out.println(risposta);
                System.out.println("4. Risposta inviata al client: \"" + risposta + "\"");

            } // Gli stream 'in' e 'out' e il 'clientSocket' vengono chiusi automaticamente qui.

        } catch (Exception e) {
            System.err.println("Errore nel server: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("5. Server terminato.");
    }
}
