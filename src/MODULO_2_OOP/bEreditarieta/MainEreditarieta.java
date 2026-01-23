package MODULO_2_OOP.bEreditarieta;

public class MainEreditarieta {
    public static void main(String[] args) {
       /*
          Ereditarietà
          Creiamo una classe "Persona", che fungerà da classe genitore.
          All’interno di Persona definiamo alcuni metodi, ad esempio saluta().

          Poi creiamo nuove classi come "Studente" e "Insegnante",
          e nella dichiarazione della classe scriviamo "extends Persona",
          queste classi erediteranno automaticamente tutti i metodi e le proprietà
          definiti nella classe Persona.

          In questo modo Studente e Insegnante possono usare (o sovrascrivere)
          i metodi di Persona.
        */

        //Praticamente andiamo a creare dei figli con le proprietà dei genitori/genitore
        //ma il genitore non può sfruttare le proprietà dei figli
        //Genitori -> Figli

        //es. Genitore(Persona) -> Figlio1(Studente) e Figlio2(Insegnante)


        //creiamo un oggetto Persona
        Persona persona1 = new Persona("Michael","Cosio");

        //richiamiamo il metodo saluta contenuto in persona
        System.out.println("Io sono il Genitore1");
        System.out.print("Persona è un oggetto con un metodo: ");
        persona1.saluta();

        System.out.println();

        //creiamo un oggetto Studente
        Studente studente1 = new Studente("Simone","Banin","Inglese","4","P");

        //richiamiamo il metodo che è all'interno di Persona
        System.out.println("\nIo sono il Figlio1");
        System.out.println("Studente è un oggetto con estensione Persona\n");
        System.out.println("Quindi posso usare i metodi all'interno di Persona(Genitore1): ");
        studente1.saluta();

        System.out.println();

        //creiamo un oggetto Insegnante
        Insegnante insegnante1 = new Insegnante("Martino","Olivato","Sistemi","4","P");

        //richiamo il metodo che è all'interno di Persona
        System.out.println("\nIo sono il Figlio2");
        System.out.println("Insegnante è un oggetto con estensione Persona\n");
        System.out.println("Quindi posso usare i metodi all'interno di Persona(Genitore1): ");
        insegnante1.saluta();
    }
}
