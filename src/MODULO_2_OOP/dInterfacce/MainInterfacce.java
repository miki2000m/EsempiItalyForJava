package MODULO_2_OOP.dInterfacce;

public class MainInterfacce {
    public static void main(String[] args) {
        //creo 2 oggetti Pesci
        Pesce pesceSmall = new Pesce();
        Pesce pesceBig = new Pesce();

        //Richiamo il metodo dell'interfaccia(Preda) che è stato sovrascritto
        System.out.println("Io sono un pesce piccolo");
        pesceSmall.scappa();

        //Richiamo il metodo dell'interfaccia(Predatore) che è stato sovrascritto
        System.out.println("\nIo sono un pesce grande");
        pesceBig.caccia();


        //creo un oggetto leone
        Leone lion = new Leone();

        //Richiamo il metodo dell'interfaccia(Predatore) che è stato sovrascritto
        System.out.println("\nIo sono un leone");
        lion.caccia();

        //creo un oggetto gazzella
        Gazzella gazzella = new Gazzella();

        //Richiamo il metodo dell'interfaccia(Preda) che è stato sovrascritto
        System.out.println("\nIo sono un gazzella");
        gazzella.scappa();
    }
}
