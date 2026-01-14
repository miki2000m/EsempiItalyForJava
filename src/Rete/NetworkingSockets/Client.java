package Rete.NetworkingSockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * GUIDA ALLA PROGRAMMAZIONE DI RETE CON SOCKETS: IL CLIENT
 *
 * Questo file implementa un semplice Client TCP. Un client è un programma che
 * si connette attivamente a un server (che deve essere già in ascolto)
 * per iniziare una comunicazione.
 */
public class Client {

    public static void main(String[] args) {
        // L'indirizzo del server a cui connettersi. "localhost" (o "127.0.0.1")
        // si usa per connettersi a un server in esecuzione sulla stessa macchina.
        String indirizzoServer = "localhost";
        // La porta deve essere la stessa su cui il server è in ascolto.
        int portaServer = 6789;

        System.out.println("--- CLIENT ---");

        // Usiamo un blocco try-with-resources per gestire il Socket e gli stream.
        try (
            // 1. Creiamo un Socket per connetterci al server.
            // Questa operazione tenta di stabilire una connessione con il server
            // all'indirizzo e alla porta specificati.
            Socket socket = new Socket(indirizzoServer, portaServer);

            // Otteniamo gli stream per la comunicazione.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("1. Connesso al server all'indirizzo " + indirizzoServer + " sulla porta " + portaServer);

            // 2. Prepariamo e inviamo un messaggio al server.
            String messaggioDaInviare = "Ciao Server, sono il Client!";
            out.println(messaggioDaInviare);
            System.out.println("2. Messaggio inviato al server: \"" + messaggioDaInviare + "\"");

            // 3. Leggiamo la risposta del server.
            // Il metodo readLine() è bloccante: attende finché il server non invia una risposta.
            String rispostaDalServer = in.readLine();
            System.out.println("3. Risposta ricevuta dal server: \"" + rispostaDalServer + "\"");

        } catch (Exception e) {
            System.err.println("Errore nel client: " + e.getMessage());
            System.err.println("Assicurati che il server sia in esecuzione prima di avviare il client.");
        }

        System.out.println("4. Client terminato.");
    }
}
