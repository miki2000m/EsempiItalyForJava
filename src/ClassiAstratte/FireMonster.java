package ClassiAstratte;

public class FireMonster extends Monster {
    FireMonster(String nome) {
        super(nome);
    }

    @Override
    public String attacco() {
        return "Lancio Sfere di Fuoco";
    }

    @Override
    public String difesa() {
        return "Muro di Fuoco";
    }
}
