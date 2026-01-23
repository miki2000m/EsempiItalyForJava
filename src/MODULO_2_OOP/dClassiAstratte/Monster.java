package MODULO_2_OOP.dClassiAstratte;

//creazione di una classe oggetto astratta (abstract public class nome{})
abstract public class Monster {
    private String nome;

    Monster(String nome) {
        this.nome = nome;
    }

    //get
    public String getNome(){
        return nome;
    }

    //metodi astratti
    //non hanno bisogno delle {} perché sono metodi che devono essere modificati all'interno della classe che richiede il metodo astratto
    //come interfaccia
    abstract public String attacco();
    abstract public String difesa();

    //metodi
    public String saluta(){
        return "Ciao da Monster "+nome+" ... Sono pronto alla battaglia ";
    }

    public String resa(){
        //return "Io mi ritiro ho troppa paura ";
        return "";
    }


}
