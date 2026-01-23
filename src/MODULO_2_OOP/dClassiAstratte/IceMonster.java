package MODULO_2_OOP.dClassiAstratte;

public class IceMonster extends Monster {
    IceMonster(String nome) {
        super(nome);
    }

    @Override
    public String attacco() {
        return "Lancio Iceberg";
    }

    @Override
    public String difesa() {
        return "Muro di Ghiaccio";
    }

    @Override
    public String saluta(){
        return "CIAOOOOO IO SONO UN ICE MONSTER DI NOME: "+getNome()+" ... SONO PRONTO ALLA BATTLE";
    }
}
