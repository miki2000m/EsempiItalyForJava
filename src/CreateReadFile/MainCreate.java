package CreateReadFile;

import java.io.*;

public class MainCreate {
    public static void main(String[] args) {
        //creazione di una cartella -------------------------

        //creo un oggetto file
        //File(indirizzo,"nome(.tipo)")
        File cartella=new File("/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/CreateReadFile","newCartella");
        if(!cartella.exists()){
            //creo la cartella (come linux)
            boolean generate= cartella.mkdir();

            //controllo se la cartella è stata generata correttamente
            if(generate){
                System.out.println("Cartella creata con successo");
            }
            else {
                System.out.println("Errore nella creazione della Cartella");
            }
        }


        //creazione di un file -------------------------------

        //creo un oggetto file all'interno della cartella creata in precedenza
        File file=new File(cartella,"file.txt");

        //controllo se il file è stato creato correttamente
        try {
            //controllo se esiste
            if (!file.exists()) {
                //genero il file
                boolean generate = file.createNewFile();

                //controllo se è stato generato correttamente
                if (generate) {
                    System.out.println("file.txt creato con successo");
                }
                else {
                    System.out.println("Errore nella creazione del file.txt");
                }

            } else {
                System.out.println("Il file.txt esiste");

                //mi danno lo stesso risultato perché io nell'indirizzo avevo messo il percorso assoluto di dove lo volevo
                //quindi file.getPath() mi restituisce lo stesso valore di file.getAbsolutePath()
                System.out.println("L'indirizzo del file.txt è: " + file.getPath());
                System.out.println("L'indirizzo assoluto è: "+file.getAbsolutePath());

                //con file.isFile() -> restituisce true/false
                //controllo se è effettivamente un file
                System.out.println("è un file???: "+file.isFile());

                //file.delete() -> elimina il file creato


            }
        }
        catch (Exception e) {
            System.out.println("La creazione del file.txt è fallita");
        }

        //SCRITTURA SU UN FILE ###############

        //si può usare anche senza creare il file prima perché lo crea lui se non c'è
        //FileWriter("nomeFile",)
        try {
            FileWriter writer = new FileWriter(file);

            //writer.write("cosa voglio scrivere"); -> dentro alle parentesi ci va una stringa
            //\n per mandare a capo
            //scrivo effettivamente sul file
            writer.write("Prima riga di questo file.txt");

            //manda a capo
            writer.write(System.lineSeparator());

            writer.write("Seconda riga di questo file.txt usando prima write(System.lineSeparator());)");

            //aggiunge quello che scriviamo dopo quello che abbiamo scritto
            writer.append("\nTerza riga di questo file.txt tramite .append()");

            writer.write(System.lineSeparator());

            //inseriamo di una stringa
            String IVriga="Io sono la Quarta riga e sono una String";
            writer.write(IVriga);

            //chiudo il file
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
