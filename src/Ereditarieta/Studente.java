package Ereditarieta;

public class Studente extends Persona {
    private String materiaPreferita;

    Studente(String nome, String cognome, String materiaPreferita,String classe,String sezione) {
        //Usiamo super(...) perché Studente estende Persona
        //e il costruttore di Persona richiede dei parametri
        //che dobbiamo passare alla classe padre.

        super(nome, cognome);
        //vuol dire che fa riferimento alla classe genitore

        setMateriaPreferita(materiaPreferita);
        setClasse(classe);
        setSezione(sezione);
    }

    //set - get
    public String getMateriaPreferita() {
        return materiaPreferita;
    }
    public void setMateriaPreferita(String materiaPreferita) {
        this.materiaPreferita = materiaPreferita;
    }

    //metodi
    //@Override = dico che sto riscrivendo un metodo per questa classe
    //modifico il metodo che si trova in Persona
    @Override
    public void saluta() {
        System.out.println("Io sono il metodo saluta() (MODIFICATO per studente)");
        System.out.println("Studente: Buongiorno prof!");
    }
}
