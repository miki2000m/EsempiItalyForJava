package Ereditarieta;

public class Persona extends Classe{
    private String nome;
    private String cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public void saluta(){
        System.out.println("Io sono il metodo saluta() (ORIGINALE)");
        System.out.println("Ciao!!!");
    }

}
