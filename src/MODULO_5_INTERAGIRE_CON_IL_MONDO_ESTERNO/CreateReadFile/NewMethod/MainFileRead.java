package MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO.CreateReadFile.NewMethod;

import java.io.*;
import java.nio.*;

public class MainFileRead {
    public static void main(String[] args) {
        String filePath="/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO/CreateReadFile/NewMethod/file.txt";

        //Il metodo con il BufferReader + FileReader è il migliore per leggere file.txt
        try(BufferedReader readerMethods= new BufferedReader(new FileReader(filePath))) {

            //Creo una barra di caricamento
            System.out.println("Lettura avvenuta con successo:");
            Thread time=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=10;i>=0;i--){
                        System.out.print("*");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
            System.out.print("Caricamento in corso: ");
            time.start();
            time.join();

            System.out.println("\n\n");

            //Stampo nel terminale il contenuto del file
            String riga;
            while((riga = readerMethods.readLine())!=null){
                System.out.println(riga);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Il metodo FileInputReader è il migliore per i file binari (immagini, audio, ecc...)


        //Il metodo RandomAccessFile è il migliore per leggere/scrivere parti specifiche di un file di grandi dimensioni
    }

}
