package CreateReadFile;

import java.io.*;

public class MainReadWords {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/Users/michel/Desktop/programmazione/JAVA/JAVAdallaBasi/src/CreateReadFile/newCartella/file.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parole = line.split(" "); // divide la linea in parole

            for (String parola : parole) {
                if (parola.equalsIgnoreCase("Prima")) {
                    System.out.println("Trovata la parola 'Prima' (ignorando maiuscole/minuscole)");
                }
            }
        }

        br.close();

    }
}
