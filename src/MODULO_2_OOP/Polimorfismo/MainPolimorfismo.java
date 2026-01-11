package MODULO_2_OOP.Polimorfismo;

public class MainPolimorfismo {
    public static void main(String[] args) {
        // Il polimorfismo permette a oggetti di classi diverse.
        //Ma legate da ereditarietà, di rispondere in modo diverso
        //alla stessa chiamata di metodo.

        //creo un paio di stuendi
        Studente studente1=new Studente("Michael","Cosio");
        Studente studente2=new Studente("Fernando","Rossi");
        Studente studente3=new Studente("Michele","Bergantin");

        Insegnante insegnante1=new Insegnante("Alberto","Sponton");

        //Usiamo il tipo Persona perché Studente e Insegnante la estendono.
        //Entrambi sono "figli" della classe Persona
        //e possono essere gestiti tramite una variabile di tipo Persona.
        Persona[] persone={studente1,studente2,studente3,insegnante1};

        System.out.println("Stampo chiunque ci sia all'interno della classe");
        for(Persona p:persone){
            System.out.println(p);
        }
    }
}
