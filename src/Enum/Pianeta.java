package Enum;

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
