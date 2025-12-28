package Localizzazione;

import java.text.NumberFormat;
import java.time.*;
import java.time.format.*;
import java.util.*;

/**
 * GUIDA ALLA LOCALIZZAZIONE (i18n) IN JAVA
 *
 * La localizzazione (spesso abbreviata in "i18n" - 18 sta per il numero di lettere tra 'i' e 'n')
 * è il processo di adattamento di un'applicazione a una specifica regione o lingua.
 * Questo include la traduzione di testi, la formattazione di date, orari, numeri e valute.
 */
public class MainLocalizzazione {

    public static void main(String[] args) {
        System.out.println("--- GUIDA ALLA LOCALIZZAZIONE IN JAVA ---\n");

        // --- 1. Locale: Il cuore della localizzazione ---
        // Un oggetto `Locale` rappresenta una specifica regione geografica, politica o culturale.
        // Non è un'impostazione globale, ma un identificatore che si passa ai metodi di formattazione.

        // Creazione di alcuni Locale
        Locale localeIT = new Locale("it", "IT"); // Lingua italiana, Paese Italia
        Locale localeUS = new Locale("en", "US"); // Lingua inglese, Paese Stati Uniti
        Locale localeJP = new Locale("ja", "JP"); // Lingua giapponese, Paese Giappone
        Locale localeDefault = Locale.getDefault(); // Il Locale del sistema su cui gira la JVM

        System.out.println("Locale di default della JVM: " + localeDefault.getDisplayName());
        System.out.println("----------------------------------------\n");

        sezione1_FormattareNumeriEValute(localeIT, localeUS, localeJP);
        sezione2_FormattareDateEOre(localeIT, localeUS, localeJP);
        sezione3_TradurreTestiConResourceBundle();
    }

    private static void sezione1_FormattareNumeriEValute(Locale localeIT, Locale localeUS, Locale localeJP) {
        System.out.println("--- 1. Formattare Numeri e Valute ---");
        System.out.println("Spiegazione: `NumberFormat` formatta i numeri secondo le convenzioni locali (es. virgola vs punto come separatore decimale).\n");

        double numero = 12345.67;

        // Formattazione numerica
        NumberFormat nfIT = NumberFormat.getNumberInstance(localeIT);
        NumberFormat nfUS = NumberFormat.getNumberInstance(localeUS);
        System.out.println("Numero " + numero + " formattato per l'Italia: " + nfIT.format(numero)); // Output: 12.345,67
        System.out.println("Numero " + numero + " formattato per gli USA:    " + nfUS.format(numero)); // Output: 12,345.67

        // Formattazione valuta
        NumberFormat cfIT = NumberFormat.getCurrencyInstance(localeIT);
        NumberFormat cfUS = NumberFormat.getCurrencyInstance(localeUS);
        NumberFormat cfJP = NumberFormat.getCurrencyInstance(localeJP);
        System.out.println("\nValuta " + numero + " formattata per l'Italia: " + cfIT.format(numero)); // Output: 12.345,67 €
        System.out.println("Valuta " + numero + " formattata per gli USA:    " + cfUS.format(numero)); // Output: $12,345.67
        System.out.println("Valuta " + numero + " formattata per il Giappone: " + cfJP.format(numero)); // Output: ￥12,346 (lo Yen non ha decimali)
        System.out.println("----------------------------------------\n");
    }

    private static void sezione2_FormattareDateEOre(Locale localeIT, Locale localeUS, Locale localeJP) {
        System.out.println("--- 2. Formattare Date e Orari ---");
        System.out.println("Spiegazione: `DateTimeFormatter` può usare stili predefiniti (SHORT, MEDIUM, LONG, FULL) specifici per un `Locale`.\n");

        LocalDateTime adesso = LocalDateTime.now();

        // Usiamo .ofLocalizedDateTime() con uno stile e un Locale
        DateTimeFormatter dtfIT = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localeIT);
        DateTimeFormatter dtfUS = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localeUS);
        DateTimeFormatter dtfJP = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(localeJP);

        System.out.println("Data e ora attuali (" + adesso.toLocalDate() + " " + adesso.toLocalTime().withNano(0) + ")");
        System.out.println("Formato MEDIUM per l'Italia: " + adesso.format(dtfIT));
        System.out.println("Formato MEDIUM per gli USA:    " + adesso.format(dtfUS));
        System.out.println("Formato MEDIUM per il Giappone: " + adesso.format(dtfJP));
        System.out.println("----------------------------------------\n");
    }

    private static void sezione3_TradurreTestiConResourceBundle() {
        System.out.println("--- 3. Gestire Testi Tradotti con ResourceBundle ---");
        System.out.println("Spiegazione: `ResourceBundle` carica testi da file di proprietà (.properties) in base a un `Locale`.\n" +
                "Questo permette di separare il codice dalla logica di traduzione.\n");

        System.out.println("Scegli una lingua: 1 per Italiano, 2 per Inglese");
        Scanner scanner = new Scanner(System.in);
        int scelta = scanner.nextInt();
        scanner.close();

        Locale localeScelto = (scelta == 1) ? new Locale("it") : new Locale("en");

        // Java cerca un file `messaggi_it.properties` o `messaggi_en.properties` nel classpath.
        // Il nome base del bundle è "Localizzazione.messaggi".
        ResourceBundle messaggi = ResourceBundle.getBundle("Localizzazione.messaggi", localeScelto);

        // Recuperiamo le stringhe tradotte usando le loro chiavi
        String saluto = messaggi.getString("saluto");
        String domanda = messaggi.getString("domanda");

        System.out.println("\nTesti caricati per il Locale '" + localeScelto.getLanguage() + "':");
        System.out.println("Chiave 'saluto':  " + saluto);
        System.out.println("Chiave 'domanda': " + domanda);
        System.out.println("----------------------------------------");
    }
}
