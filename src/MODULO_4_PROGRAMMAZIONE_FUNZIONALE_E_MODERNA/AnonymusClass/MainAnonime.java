package MODULO_4_PROGRAMMAZIONE_FUNZIONALE_E_MODERNA.AnonymusClass;

public class MainAnonime {
    public static void main(String[] args) {

        // Classe Anonima:
        // È una classe senza un nome, definita e istanziata in un'unica espressione.
        // Permette di creare al volo un'implementazione "usa e getta" di una classe o interfaccia.
        // È ideale per personalizzare un comportamento specifico senza dover creare un nuovo file .java.
        // Viene spesso usata per gestori di eventi (callback), thread (Runnable) o task temporizzati (TimerTask).

        Dog dog1 = new Dog();

        //creiamo un novo cane con un comportamento specifico per lo speak senza dover creare classi aggiunte ecc
        Dog dog2 = new Dog(){
            @Override
            public void speak(){
                System.out.println("Scooby Doo says *Ruh Roh*");
            }
        };

        dog1.speak();
        dog2.speak();
    }
}

