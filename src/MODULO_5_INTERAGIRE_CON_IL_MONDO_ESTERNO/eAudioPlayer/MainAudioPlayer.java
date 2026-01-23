package MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO.eAudioPlayer;

import javax.sound.sampled.*;
import java.io.*;
import java.util.Scanner;

public class MainAudioPlayer {
    public static void main(String[] args) {
        //file audio accettati wav,au,aiff

        //prendiamo l'indirizzo del file audio di cui abbiamo bisogno
        // PERCORSO AGGIORNATO PER LA NUOVA STRUTTURA DEL PROGETTO
        String filePath="/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO/AudioPlayer/good-for-the-ghost-Alge.wav";

        //creo un oggetto File
        File file=new File(filePath);

        //Carico il file audio e lo trasformo in un AudioInputStream
        //poi apro un oggetto Clip che serve per riprodurre l'audio.
        //In pratica: leggo il file audio e preparo il lettore per farlo partire.
        try(Scanner scanner=new Scanner(System.in);){
            AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(file);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            System.out.println("Nessun problema rilevato");

            String response="";

            clip.start();

            while((!response.equals("Q"))){
                //opzioni
                System.out.println("P = play");
                System.out.println("S = stop");
                System.out.println("R = restart");
                System.out.println("Q = quit");
                System.out.print("Inserisci la tua scelta: ");

                //input
                response=scanner.nextLine().toUpperCase();

                switch(response){
                    //stoppa al momento in cui ci si trova
                    case "S" -> clip.stop();

                    //fa partire dal momento in cui ci si trova
                    case "P" -> clip.start();

                    //setta la posizione temporale del audio a 0
                    case "R" -> clip.setMicrosecondPosition(0);

                    //quit
                    case "Q" -> clip.close();

                    default -> System.out.println("opzione non disponibile");
                }
            }
        }
        //controllo le eccezioni
        catch(IOException e){
            System.out.println("C'è qualcosa che non va");
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Il file audio non è supportato");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        finally{

        }
    }
}
