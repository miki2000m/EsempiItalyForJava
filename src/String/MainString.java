package String;

public class MainString {
    private static final String nome="Leonardo";
    public static void main(String[] args) {
        //equals --------------
        boolean resultEquals;

        //xxxx.equals("xxxx")
        //restituisce un valore boolean (true/false)
        //per risultare un valore true ciò che è all'interno alle parentesi
        //deve essere IDENTICO alla stringa con cui lo compariamo
        //############ ATTEZIONE ALLE MAIUSCOLE E MINUSCOLE ################
        resultEquals= nome.equals("Leonardo");
        System.out.println("\nnome.equals('Leonardo') (controlla le minuscole e maiuscole) restituisce un valore boolean");
        System.out.println(resultEquals);

        System.out.println();

        //xxxx.equalsIgnoreCase("xxxXxx")
        //restutuisce un valore boolean (true/false)
        //non c'è bisogno di stare attenti alle maiuscole minusole
        resultEquals= nome.equalsIgnoreCase("lEonaRdo");
        System.out.println("\nnome.eqalsIgnoreCase('lEonaRdo') (non bada le maiuscole e minuscole) restituisce un valore boolean ");
        System.out.println(resultEquals);

        System.out.println();

        //length -------------
        int resultLength;

        //xxxx.length()
        //restituisce un valore intero
        //cioè ula lunghezza della stringa
        resultLength= nome.length();
        System.out.println("\nnome.length() restituisce il valore numerico della lunghezza della stringa nome (8)");
        System.out.println(resultLength);

        System.out.println();

        //charAt -------------
        char resultChar;

        //xxxx.charAt(y)
        //retituisce il carattere in una determinata posizione y
        resultChar= nome.charAt(0);
        System.out.println("\nnome.charAt(0) restituisce il carattere in posizione 0 ");
        System.out.println(resultChar);

        //indexOf ------------
        int resultIndex;

        //xxxx.indexOf("y")
        //restituisce il numero della posizione di y
        resultIndex= nome.indexOf("a");
        System.out.println("\nnome.indexOf('a') restituisce la posizione del carattere a ");
        System.out.println(resultIndex);

        System.out.println();

        //isEmpty -------------
        boolean resultEmpty;

        //xxxx.isEmpty
        //restituisce un valore boolean (true/false)
        //se la stringa è piena restutuisce false
        //se la stringa è vuota restituisce true
        resultEmpty= nome.isEmpty();
        System.out.println("\nnome.isEmpty() restituisce il valore boolean");
        System.out.println(resultEmpty);

        System.out.println();

        //toUpperCase - toLowerCase -------------
        String resultToUpperCase;
        String resultToLowerCase;

        //xxxx.toUpperCase
        //restituisce tutta la strigna in maiuscolo
        resultToUpperCase= nome.toUpperCase();
        System.out.println("\nnome.toUpperCase() restituisce la stringa in maiuscolo");
        System.out.println(resultToUpperCase);

        System.out.println();

        //xxxx.toLowerCase
        //restituisce la stringa in minuscolo
        resultToLowerCase= nome.toLowerCase();
        System.out.println("\nnome.toLowerCase() restituisce la stringa in minuscolo");
        System.out.println(resultToLowerCase);

        System.out.println();

        //trim -------------
        String resultTrim;

        //xxxx.trim
        //restituisce la stringa senza spazzi
        resultTrim= nome.trim();
        System.out.println("\nnome.trim() restituisce la stringa senza spazzi");
        System.out.println(resultTrim);

        System.out.println();

        //replace -----------
        String resultReplace;

        //xxxx.replace("y","z")
        //restituisce la stringa con il carattere y sostituito con z
        resultReplace= nome.replace("e", "3");
        System.out.println("\nnome.replace('e','3') retituisce la stringa con la e sostituita con 3");
        System.out.println(resultReplace);

        System.out.println();

        //split -------------
        //xxxx.split(regex) oppure xxxx.split(regex, limit)
        //restituisce un array di stringhe ottenute dividendo la stringa originale
        //in corrispondenza del separatore (espresso come regex).
        //Se si usa limit, si limita il numero di elementi nell'array.

        String csv = "Mario,Rossi,30";
        String[] parts = csv.split(","); //divide usando la virgola come separatore
        System.out.println("\ncsv.split(\",\") restituisce un array di stringhe");
        System.out.println("Lunghezza array: " + parts.length);
        for (int i = 0; i < parts.length; i++) {
            System.out.println("parts[" + i + "] = " + parts[i]);
        }
    }
}
