package MODULO_2_OOP.cPolimorfismo;

public class Persona{
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

    @Override
    public String toString() {
        return "nome: " + nome + "\ncognome: " + cognome +"\n";
    }
}
