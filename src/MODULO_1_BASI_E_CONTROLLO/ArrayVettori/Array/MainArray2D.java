package MODULO_1_BASI_E_CONTROLLO.ArrayVettori.Array;

//gli array 2d sono array con due dimensioni
//come una tabella

public class MainArray2D {
    public static void main(String[] args) {
        //METODO 1 (più chiaro e bello)

        //[3] = classi
        //[3] = studenti
        String[][] classi= new String[3][3];

        //classe 1
        classi[0][0]="Luca";//studente 1
        classi[0][1]="Simone";//studente 2
        classi[0][2]="Nicolò";//studente 3

        //classe 2
        classi[1][0]="James";//studente 1
        classi[1][1]="Mario";//studente 2
        classi[1][2]="Gianni";//studente 3

        //classe 3
        classi[2][0]="Lorenzo";//studente 1
        classi[2][1]="Marco";//studente 2
        classi[2][2]="Filippo";//studente 3


        //############# situazione creata ###############

        //indici:     0         1           2
        //classe 0 -> Luca      Simone      Nicolò
        //classe 1 -> James     Mario       Gianni
        //classe 2 -> Lorenzo   Marco       Filippo

        //------------ creiamo una specie di tabella


        //stampiamo uno studente di una classe
        //stampiamo all'indice [1][2]
        //cioè nella seconda classe il terzo studente
        System.out.printf("Stampiamo ciò che c'è nell'indice [1][2] (Gianni): %s\n\n",classi[1][2]);


        //stampiamo tutti gli studenti della prima classe
        System.out.println("Nella prima classe ci sono: ");
        for(int i=0;i<classi[0].length;i++){
            System.out.println(classi[0][i]);
        }

        System.out.println();

        //stampo tutte le classi
        System.out.print("Stampa di tutte le classi:");

        //prendo la lunghezza della classe
        for(int i=0;i<classi.length;i++){
            System.out.printf("\nClasse n%-5d",(i+1));

            //prendo gli studenti nella classe
            for(int j=0;j<classi[i].length;j++){
                System.out.printf("%-10s",classi[i][j]);
            }
        }

        System.out.println();

        //METODO 2 (MIGLIORE)
        String[][] classi1= {
                //classe 1(0)
                {"Luca","Simone","Nicolò"},
                //classe 2(1)
                {"James","Mario","Gianni"},
                //classe 3(2)
                {"Lorenzo","Marco","Filippo"}
        };

        int c=1;
        System.out.print("\nStampa di tutte le classi1: ");
        for(String[] classe : classi1){
            System.out.println();

            System.out.printf("Classe n%-5d",c);
            c++;
            for(String studente: classe){
                System.out.printf("%-10s",studente);
            }
        }
    }
}
