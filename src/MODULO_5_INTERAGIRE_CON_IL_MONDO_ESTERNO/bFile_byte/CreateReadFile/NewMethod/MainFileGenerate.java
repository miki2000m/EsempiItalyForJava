package MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO.bFile_byte.CreateReadFile.NewMethod;

//Chiamate API
import java.io.*;

public class MainFileGenerate {
    public static void main(String[] args){
        File file = new File("/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/MODULO_5_INTERAGIRE_CON_IL_MONDO_ESTERNO/CreateReadFile/NewMethod","file.txt");

        //Per scrivere un file serve un gestore di eccezioni

        //Si può anche non creare un file prima ma scriverlo direttamente qui
        //FileWriter writer = new FileWriter("nome.estensione");

        //Come abbiamo visto il try-catch può essere scritto così
        //try(cosa vogliamo provare a eseguire){contenuto}
        //catch(tipo di eccezione){cosa fa se c'è l'eccezione}
        try(FileWriter writer = new FileWriter(file);) {
            writer.write("Questa prima porzione di codice viene scritta con FileWriter\n"+System.lineSeparator());

            writer.write("Prima riga di questo file.txt");

            //manda a capo si può usare sia questo che anche il \n o se vogliamo essere pro anche se dobbiamo aggiungere un nuovo oggetto facciamo
            writer.write(System.lineSeparator());

            writer.write("Seconda riga di questo file.txt usando prima write(System.lineSeparator());)\n\n"+System.lineSeparator());

            //Questo oggetto permette di scrivere con i print che abbiamo sempre usato all'interno del terminale e in oltre scrive le cose all'interno del terminale
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println("Questa seconda porzione di codice viene scritta con PrintWriter\n");

            printWriter.println("Terza riga scritta con printWriter");

            printWriter.println("Quarta riga e sono stata mandata in automatico a capo grazie al printWriter");

            System.out.println("il file è stato scritto");

            printWriter.close();
            writer.close();
        } catch (FileNotFoundException e){
            //Questa è un eccezione di file non trovato
            System.out.println("Non è stato trovato il file");
        } catch (IOException e) {
            System.out.println("Non è stato possibile scrivere il file");
        }
    }

}
