package MODULO_2_OOP.bEreditarieta;

//Classe genitore di Persona cioè il nonno dei figli
//si possono creare infinite "Gerarchie" da xNonni -> xGenitori -> xFigli
//tutte le persone hanno una classe e una sezione
//ma non tutte le persone vanno a scuola quindi ho costruito un costruttore vuoto
public class Classe {

    private String sezione;
    private String classe;

    Classe(String sezione, String classe) {
        this.sezione = sezione;
        this.classe = classe;
    }
    Classe(){}

    //get - set
    public String getSezione() {
        return sezione;
    }
    public String getClasse() {
        return classe;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }
    public void setClasse(String classe) {
        this.classe = classe;
    }


}
