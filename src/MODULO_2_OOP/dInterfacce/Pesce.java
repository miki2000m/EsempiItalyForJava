package MODULO_2_OOP.dInterfacce;

public class Pesce implements Preda,Predatore{
    @Override
    public void scappa() {
        System.out.println("Il Pesce piccolo scappa");
    }

    @Override
    public void caccia() {
        System.out.println("Il Pesce grande caccia");
    }
}
