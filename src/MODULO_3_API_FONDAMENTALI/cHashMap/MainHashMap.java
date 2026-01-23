package MODULO_3_API_FONDAMENTALI.cHashMap;

import java.util.HashMap;

public class MainHashMap {
    public static void main(String[] args) {
        //HashMap<key(indicatore), tipo> nome
        HashMap<String, String> capitali = new HashMap<>();

        //.put(key,y)
        //inserisce x come key
        //y è il soggetto indicato dalla kay
        capitali.put("Italia", "Roma");
        capitali.put("Francia", "Parigi");
        capitali.put("Germania", "Berlino");
        capitali.put("Inghilterra", "Londra");

        //stampa di un elemento
        //capitali.get(key)
        System.out.printf("capitali.get('Francia') -> %s\n\n",capitali.get("Francia"));

        //stampa di tutta la HashMap
        System.out.printf("All'intero della HashMap capitali ci sono: %s",capitali);

        //rimozione di un elemento
        capitali.remove("Francia");
        System.out.println("\n\ncapitali.remove('Francia')");
        System.out.println("capitali.get('Francia') -> "+capitali.get("Francia"));
        System.out.printf("All'interno della HashMap capitali ci sono: %s",capitali);

        //pulizia completa dell'HashMap
        capitali.clear();
        System.out.printf("\n\ncapitali.clear() -> %s",capitali);
    }
}
