package ClassiAstratte;

public class StoneMonster extends Monster{

    StoneMonster(String nome) {
        super(nome);
    }

    //java richiede l'implementazione dei metodi all'intero della classe astratta
    @Override
    public String attacco() {
        return "Lancio Pietre";
    }

    @Override
    public String difesa() {
        return "Muro di Roccia";
    }

    //metodi Override -> sono io a richiedere un Override perché sono io a voler modificare il metodo in un modo specifico
    @Override
    public String resa(){
        return "Io scappo... \nLe mie pietre non fanno niente";
    }
}
