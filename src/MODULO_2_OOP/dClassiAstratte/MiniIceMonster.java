package MODULO_2_OOP.dClassiAstratte;

public class MiniIceMonster extends IceMonster {
    //In questo caso non ho bisogno di importare le classi astratte perché sono ereditate
    //visto che questa classe oggetto ha come estensione IceMonster che a sua volta estende Monster

    MiniIceMonster(String nome) {
        super(nome);
    }

    //posso comunque modificare con l'Override il metodo che voglio
    //a patto che sia PRESENTE in Monster o IceMonster (COME SEMPRE)
    @Override
    public String attacco() {
        return "Lancio stalattiti";
    }

    //metodo
    public String gioco() {
        return "Mi piace giocare con la neve";
    }
}
