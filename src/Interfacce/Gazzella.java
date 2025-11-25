package Interfacce;

//implements serve per implementare i metodi dell'interfaccia

public class Gazzella implements Preda {

    //creo un caso specifico per la gazzella
    @Override
    public void scappa() {
        System.out.println("la Gazzella scappa");
    }
}
