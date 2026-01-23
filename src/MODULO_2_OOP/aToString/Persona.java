package MODULO_2_OOP.aToString;

public class Persona {
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    //set - get
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    //metodi
    public void copy(Persona persona) {
        setNome(persona.getNome());
        setCognome(persona.getCognome());
    }

    // Il metodo toString() è predefinito in Java e serve a restituire
    // una rappresentazione testuale dell'oggetto.
    // Possiamo sovrascriverlo (@Override) per mostrare solo le informazioni
    // che ci interessano, come nome e cognome.
    @Override
    public String toString() {
        return "nome: " + nome + "\ncognome: " + cognome + "\n";
    }

}
