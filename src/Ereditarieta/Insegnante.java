package Ereditarieta;

public class Insegnante extends Persona {
    private String materiaInsegnamento;

    Insegnante(String nome, String cognome,String materiaInsegnamento,String classe,String sezione) {
        super(nome, cognome);
        setClasse(classe);
        setSezione(sezione);
        setMateriaInsegnamento(materiaInsegnamento);
    }

    //set - get
    public String getMateriaInsegnamento() {
        return materiaInsegnamento;
    }
    public void setMateriaInsegnamento(String materiaInsegnamento) {
        this.materiaInsegnamento = materiaInsegnamento;
    }

    //metodi
    @Override
    public void saluta() {
        System.out.println("Io sono il metodo saluta() (MODIFICATO per insegnante)");
        System.out.println("Insegnante: Buongiorno studenti!");
    }

}
