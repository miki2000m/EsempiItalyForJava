package ToString;

public class MainToString {
    public static void main(String[] args) {
        // Creo un oggetto Persona
        Persona persona = new Persona("Michael", "Cosio");

        //Stampando l'oggetto, Java richiama automaticamente il metodo toString()
        //che abbiamo sovrascritto nella classe Persona per mostrare nome e cognome.
        System.out.println(persona);
    }
}
