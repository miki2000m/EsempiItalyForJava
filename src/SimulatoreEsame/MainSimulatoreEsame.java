package SimulatoreEsame;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * Questo è il programma principale che avvia il simulatore d'esame.
 * Permette all'utente di scegliere tra una simulazione completa (con o senza timer)
 * o una pratica per modulo.
 */
public class MainSimulatoreEsame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- BENVENUTO AL SIMULATORE D'ESAME OCP ---");

        while (true) {
            System.out.println("\nScegli un'opzione:");
            System.out.println("1. Simulazione Completa (Senza Timer)");
            System.out.println("2. Simulazione Completa (Con Timer - 90 secondi per domanda)");
            System.out.println("3. Pratica per Modulo");
            System.out.println("0. Esci");
            System.out.print("Inserisci la tua scelta: ");

            String scelta = scanner.nextLine();

            switch (scelta) {
                case "1" -> avviaSimulazioneCompleta(scanner, false);
                case "2" -> avviaSimulazioneCompleta(scanner, true);
                case "3" -> avviaPraticaPerModulo(scanner);
                case "0" -> {
                    System.out.println("Grazie per aver usato il simulatore. Buono studio!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Scelta non valida. Riprova.");
            }
        }
    }

    private static void avviaSimulazioneCompleta(Scanner scanner, boolean conTimer) {
        List<Domanda> domande = BancaDatiDomande.getTutteLeDomande();
        Collections.shuffle(domande);
        String titolo = "Simulazione Completa" + (conTimer ? " (con Timer)" : " (senza Timer)");
        eseguiSessioneDiTest(titolo, domande, scanner, conTimer);
    }

    private static void avviaPraticaPerModulo(Scanner scanner) {
        while (true) {
            System.out.println("\nScegli il modulo su cui vuoi esercitarti:");
            System.out.println("1. Basi e Controllo");
            System.out.println("2. OOP");
            System.out.println("3. API Fondamentali");
            System.out.println("4. Programmazione Funzionale e Moderna");
            System.out.println("5. I/O e Eccezioni");
            System.out.println("6. Argomenti Avanzati e da Certificazione");
            System.out.println("0. Torna al menu principale");
            System.out.print("Inserisci la tua scelta: ");

            String sceltaModulo = scanner.nextLine();
            if (sceltaModulo.equals("0")) {
                return;
            }

            try {
                int numeroModulo = Integer.parseInt(sceltaModulo);
                if (numeroModulo >= 1 && numeroModulo <= 6) {
                    List<Domanda> domande = BancaDatiDomande.getDomandePerModulo(numeroModulo);
                    Collections.shuffle(domande);
                    eseguiSessioneDiTest("Pratica - Modulo " + numeroModulo, domande, scanner, false);
                    break;
                } else {
                    System.out.println("Numero di modulo non valido.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero.");
            }
        }
    }

    private static void eseguiSessioneDiTest(String titolo, List<Domanda> domande, Scanner scanner, boolean conTimer) {
        if (domande.isEmpty()) {
            System.out.println("Nessuna domanda disponibile per questa selezione.");
            return;
        }

        System.out.println("\n--- INIZIO: " + titolo + " ---");
        System.out.println("Numero di domande: " + domande.size());
        System.out.println("Rispondi con la lettera (o le lettere) dell'opzione corretta e premi Invio.\n");

        int punteggio = 0;
        int numeroDomanda = 1;

        for (Domanda domanda : domande) {
            System.out.println(">>> DOMANDA " + numeroDomanda + "/" + domande.size() + " <<<");
            domanda.visualizza();

            String rispostaUtente;
            if (conTimer) {
                rispostaUtente = chiediRispostaConTimer(scanner, 90);
            } else {
                System.out.print("La tua risposta: ");
                rispostaUtente = scanner.nextLine();
            }

            if (rispostaUtente.equals("TIMEOUT")) {
                System.out.println("\nTEMPO SCADUTO! La risposta corretta era: " + domanda.rispostaCorretta());
            } else if (domanda.controllaRisposta(rispostaUtente)) {
                System.out.println("RISPOSTA CORRETTA!\n");
                punteggio++;
            } else {
                System.out.println("RISPOSTA SBAGLIATA. La risposta corretta era: " + domanda.rispostaCorretta());
            }

            System.out.println("\n--- SPIEGAZIONE ---");
            System.out.println(domanda.spiegazione());
            System.out.println("-------------------\n");
            numeroDomanda++;
            pausa(1);
        }

        System.out.println("--- FINE SESSIONE ---");
        System.out.println("Hai completato la sessione: " + titolo);
        System.out.println("Punteggio finale: " + punteggio + " su " + domande.size());
        double percentuale = (double) punteggio / domande.size() * 100;
        System.out.printf("Percentuale di risposte corrette: %.2f%%\n", percentuale);
    }

    private static String chiediRispostaConTimer(Scanner scanner, int secondiTimeout) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.print("Hai " + secondiTimeout + " secondi. La tua risposta: ");

        Future<String> future = executor.submit(() -> scanner.nextLine());

        try {
            return future.get(secondiTimeout, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            future.cancel(true); // Interrompe il task di lettura
            return "TIMEOUT";
        } catch (Exception e) {
            return ""; // Gestisce altre eccezioni
        } finally {
            executor.shutdownNow();
        }
    }

    private static void pausa(int secondi) {
        try {
            TimeUnit.SECONDS.sleep(secondi);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
