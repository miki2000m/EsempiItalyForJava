package Enum;

import java.util.Arrays;

/**
 * GUIDA COMPLETA AGLI ENUM (ENUMERAZIONI) IN JAVA
 *
 * Questo file è un tutorial eseguibile che spiega cosa sono gli enum, come si usano e le loro funzionalità avanzate.
 * Un enum è un tipo speciale che rappresenta un gruppo di costanti (valori immutabili e predefiniti).
 */

// --- 1. DICHIARAZIONE DI UN ENUM DI BASE ---
// Un enum semplice è una lista di costanti.
enum Livello {
    BASSO,
    MEDIO,
    ALTO
}

// --- 2. ENUM CON COSTRUTTORE, CAMPI E METODI ---
// Gli enum possono essere molto più potenti di una semplice lista di nomi.
// Possono avere campi, un costruttore (che è sempre privato) e metodi.
enum Pianeta {
    // Ogni costante dell'enum è in realtà un'istanza dell'enum stesso.
    // Qui invochiamo il costruttore per ogni pianeta.
    MERCURIO(3.303e+23, 2.4397e6),
    VENERE(4.869e+24, 6.0518e6),
    TERRA(5.976e+24, 6.37814e6),
    MARTE(6.421e+23, 3.3972e6),
    GIOVE(1.9e+27, 7.1492e7),
    SATURNO(5.688e+26, 6.0268e7),
    URANO(8.686e+25, 2.5559e7),
    NETTUNO(1.024e+26, 2.4746e7);

    // Campi (fields) per ogni costante dell'enum
    private final double massa; // in kg
    private final double raggio; // in metri

    // Costruttore (deve essere privato o package-private)
    Pianeta(double massa, double raggio) {
        this.massa = massa;
        this.raggio = raggio;
    }

    // Metodi disponibili per ogni costante
    public double getMassa() {
        return massa;
    }

    public double getRaggio() {
        return raggio;
    }

    // Esempio di un metodo che calcola un valore derivato
    public double gravitaSuperficiale() {
        final double G = 6.67300E-11;
        return G * massa / (raggio * raggio);
    }
}


public class MainEnum {

    public static void main(String[] args) {
        System.out.println("--- GUIDA AGLI ENUM IN JAVA ---\n");

        sezione1_UtilizzoBase();
        sezione2_IterazioneEValues();
        sezione3_SwitchConEnum();
        sezione4_EnumAvanzatiConMetodi();
    }

    private static void sezione1_UtilizzoBase() {
        System.out.println("--- 1. Utilizzo di Base ---");
        System.out.println(
         """
         Spiegazione: Gli enum si usano per rappresentare un set fisso di costanti,
         migliorando la leggibilità e la sicurezza del tipo.\n
         """);

        // Assegnazione di una costante enum a una variabile
        Livello difficolta = Livello.MEDIO;

        System.out.println("Azione: Assegnare un valore enum e stamparlo.");
        System.out.println("  - Livello di difficoltà scelto: " + difficolta);

        // Metodo name() -> restituisce il nome della costante come stringa
        System.out.println("  - Nome della costante (name()): " + difficolta.name());

        // Metodo ordinal() -> restituisce la posizione dell'enum nella sua dichiarazione (inizia da 0)
        System.out.println("  - Posizione della costante (ordinal()): " + difficolta.ordinal());
        System.out.println("  - Ordinale di " + Livello.ALTO.name() + ": " + Livello.ALTO.ordinal());
    }

    private static void sezione2_IterazioneEValues() {
        System.out.println("\n--- 2. Iterare su un Enum e Metodo `values()` ---");
        System.out.println("""
        Spiegazione: Il metodo statico `values()` restituisce un array contenente tutte le costanti dell'enum,
        nell'ordine in cui sono state dichiarate.\n
         """);

        System.out.println("Azione: Stampare tutte le costanti dell'enum `Pianeta`.");
        Pianeta[] tuttiIPianeti = Pianeta.values();
        System.out.println("  - Tutti i pianeti nel nostro sistema solare (da `Pianeta.values()`):");
        for (Pianeta p : tuttiIPianeti) {
            System.out.println("    -> " + p);
        }
        System.out.println("  - L'array restituito da values(): " + Arrays.toString(tuttiIPianeti));

        System.out.println("\nAzione: Ottenere una costante enum da una stringa usando `valueOf()`.");
        // Il metodo valueOf() è case-sensitive e lancia un'eccezione se la stringa non corrisponde a nessuna costante.
        try {
            Pianeta pianetaScelto = Pianeta.valueOf("TERRA");
            System.out.println("  - `Pianeta.valueOf(\"TERRA\")` ha trovato: " + pianetaScelto);
        } catch (IllegalArgumentException e) {
            System.out.println("  - Errore: La costante non esiste.");
        }
    }

    private static void sezione3_SwitchConEnum() {
        System.out.println("\n--- 3. Usare gli Enum negli `switch` ---");
        System.out.println("""
        Spiegazione: Gli enum sono perfetti per essere usati nelle istruzioni `switch`,
        rendendo il codice più pulito e sicuro rispetto all'uso di stringhe o interi.\n
        """);

        Livello feedback = Livello.ALTO;

        System.out.println("Azione: Eseguire uno switch basato sul valore di un enum.");
        System.out.println("  - Valore di input per lo switch: " + feedback);
        System.out.print("  - Risultato dello switch: ");

        switch (feedback) {
            case BASSO:
                System.out.println("Qualità del servizio insufficiente.");
                break;
            case MEDIO:
                System.out.println("Qualità del servizio nella media.");
                break;
            case ALTO:
                System.out.println("Qualità del servizio eccellente!");
                break;
            // Non è necessario un caso 'default' se tutti i valori dell'enum sono coperti.
            // Il compilatore può avvisare se un caso manca.
        }
    }

    private static void sezione4_EnumAvanzatiConMetodi() {
        System.out.println("\n--- 4. Enum con Campi, Costruttore e Metodi ---");
        System.out.println("""
        Spiegazione: Un enum può incapsulare dati e comportamenti correlati a ogni costante,
        funzionando come una classe speciale.\n
        """);

        Pianeta pianetaCorrente = Pianeta.TERRA;

        System.out.println("Azione: Accedere ai campi e ai metodi di una costante enum.");
        System.out.println("  - Pianeta selezionato: " + pianetaCorrente);
        System.out.println("  - Massa: " + pianetaCorrente.getMassa() + " kg");
        System.out.println("  - Raggio: " + pianetaCorrente.getRaggio() + " m");
        System.out.printf("  - Gravità superficiale: %.2f m/s^2\n", pianetaCorrente.gravitaSuperficiale());

        System.out.println("\nAzione: Calcolare il proprio peso su un altro pianeta.");
        double mioPesoSullaTerra = 70.0; // kg
        double massaTerra = Pianeta.TERRA.getMassa();
        double gravitaTerra = Pianeta.TERRA.gravitaSuperficiale();
        double miaMassa = mioPesoSullaTerra; // In fisica, il peso è una forza, ma comunemente si usa come massa.

        Pianeta altroPianeta = Pianeta.MARTE;
        double gravitaAltroPianeta = altroPianeta.gravitaSuperficiale();
        // Formula: PesoSuAltroPianeta = (MassaPersona * GravitaSuAltroPianeta)
        // Semplificato: PesoSuAltroPianeta = PesoSullaTerra * (GravitaAltroPianeta / GravitaTerra)
        double mioPesoSuAltroPianeta = (miaMassa * gravitaAltroPianeta); // Questo è il peso in Newton
        double mioPesoInKgEquivalenti = mioPesoSullaTerra * (gravitaAltroPianeta / gravitaTerra);


        System.out.println("  - Il mio peso sulla Terra: " + mioPesoSullaTerra + " kg");
        System.out.printf("  - Il mio peso su %s sarebbe circa: %.2f kg\n", altroPianeta, mioPesoInKgEquivalenti);
    }
}
