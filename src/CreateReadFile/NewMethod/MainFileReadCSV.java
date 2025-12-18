package CreateReadFile.NewMethod;

import java.io.*;

public class MainFileReadCSV {
    public static void main(String[] args) {
        String filePath = "/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/CreateReadFile/NewMethod/file.csv";

        // Implementazione per la lettura di file CSV
        BufferedReader reader = null;
        String riga="";

        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((riga = reader.readLine()) != null) {
                //Suddivido i tipi di dati separati da virgola
                String[] rigaStr = riga.split(",");

                //stampo il contenuto della riga
                for(String s:rigaStr){
                    System.out.printf("|%-13s",s);
                }

                System.out.println();

                }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
