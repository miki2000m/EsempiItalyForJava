package Rete.InfoDiRete;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.io.*;

/**
 * GUIDA ALLA SCOPERTA DELLE INFORMAZIONI DI RETE
 *
 * Questo file è un tutorial eseguibile che mostra come ottenere informazioni
 * di basso livello sulla configurazione di rete della macchina locale, come
 * gli indirizzi IP e gli indirizzi MAC, usando le classi del package `java.net`.
 *
 * NOTA: Questo è un argomento avanzato e NON è richiesto per l'esame OCP 1Z0-830.
 */
public class MainInfoDiRete {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLE INFORMAZIONI DI RETE IN JAVA ---\n");

        sezione1_InterfacceDiReteLocali();
        sezione2_InfoDaConnessioneRemota();
    }

    private static void sezione1_InterfacceDiReteLocali() {
        System.out.println("--- 1. Ispezione delle Interfacce di Rete Locali ---");
        System.out.println("Spiegazione: Usiamo la classe `NetworkInterface` per ottenere informazioni sulle schede di rete (fisiche o virtuali) installate su questa macchina.\n");

        try {
            // NetworkInterface.getNetworkInterfaces() restituisce un'enumerazione di tutte le interfacce di rete.
            Enumeration<NetworkInterface> interfacce = NetworkInterface.getNetworkInterfaces();

            while (interfacce.hasMoreElements()) {
                NetworkInterface ni = interfacce.nextElement();

                // Filtriamo per mostrare solo le interfacce "interessanti":
                // - isUp(): L'interfaccia è attiva.
                // - !isLoopback(): Non è l'interfaccia di loopback (127.0.0.1).
                // - getHardwareAddress() != null: Ha un indirizzo fisico (MAC).
                if (ni.isUp() && !ni.isLoopback() && ni.getHardwareAddress() != null) {

                    System.out.println("Trovata interfaccia: " + ni.getDisplayName());

                    // --- OTTENERE L'INDIRIZZO MAC ---
                    byte[] mac = ni.getHardwareAddress();
                    StringBuilder macBuilder = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macBuilder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("  -> Indirizzo MAC: " + macBuilder.toString());

                    // --- OTTENERE GLI INDIRIZZI IP ASSOCIATI ---
                    Enumeration<InetAddress> indirizzi = ni.getInetAddresses();
                    while (indirizzi.hasMoreElements()) {
                        InetAddress addr = indirizzi.nextElement();
                        System.out.println("  -> Indirizzo IP associato: " + addr.getHostAddress());
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.err.println("Errore durante il recupero delle informazioni di rete: " + e.getMessage());
        }
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_InfoDaConnessioneRemota() {
        System.out.println("--- 2. Informazioni su Mittente e Destinatario (Client/Server) ---");
        System.out.println("Spiegazione: Quando un client si connette a un server, il server può ottenere informazioni\n" +
                "sul client tramite l'oggetto `Socket` che rappresenta la connessione.\n");

        int porta = 12345;

        // Avviamo un mini-server in un thread separato
        Thread serverThread = new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(porta)) {
                // Attende una connessione e la accetta
                Socket clientSocket = serverSocket.accept();

                System.out.println("\n[Server] Client connesso!");

                // --- OTTENERE INFORMAZIONI SUL CLIENT (MITTENTE) ---
                InetAddress indirizzoClient = clientSocket.getInetAddress();
                System.out.println("[Server] Indirizzo IP del mittente: " + indirizzoClient.getHostAddress());
                System.out.println("[Server] Porta remota del mittente: " + clientSocket.getPort());

                // --- INFORMAZIONI SUL SERVER (DESTINATARIO) ---
                System.out.println("[Server] Il mio indirizzo IP locale (per questa connessione): " + clientSocket.getLocalAddress().getHostAddress());
                System.out.println("[Server] La mia porta locale: " + clientSocket.getLocalPort());

                System.out.println("\n[Server] NOTA IMPORTANTE: Non è possibile ottenere l'indirizzo MAC di un client remoto tramite Socket.");
                System.out.println("[Server] Il MAC address è un'informazione di livello 2 (Data Link) e non sopravvive al routing su Internet.");

                clientSocket.close();
            } catch (IOException e) {
                // Silenziamo l'errore per la demo
            }
        });

        serverThread.start();

        // Avviamo un mini-client per connetterci al nostro server
        try (Socket clientSocket = new Socket("localhost", porta)) {
            System.out.println("[Client] Connesso al server. La mia porta locale è: " + clientSocket.getLocalPort());
            // Il client potrebbe inviare dati qui...
        } catch (IOException e) {
            System.err.println("[Client] Errore: impossibile connettersi al server. " + e.getMessage());
        }

        // Attendiamo che il thread del server finisca
        try {
            serverThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("----------------------------------------");
    }
}
