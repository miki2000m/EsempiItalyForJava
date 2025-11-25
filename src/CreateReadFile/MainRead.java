package CreateReadFile;

import java.io.*;

public class MainRead {
    public static void main(String[] args)  {
        //creo un oggetto fileReader

        try {
            FileReader reader = new FileReader("/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/CreateReadFile/newCartella/file.txt");

            //in questo caso mi resistance il valore ASCI della prima lettera
            int data =reader.read();
            //System.out.println("P in asci è: "+data);

            //per leggere tutto serve un while
            //-1 perché quando non trova più caratteri restituisce 1
            while(data != -1) {
                System.out.print((char) data);

                //continuiamo con la lettura del file
                data = reader.read();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
