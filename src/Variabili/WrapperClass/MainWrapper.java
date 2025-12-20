package Variabili.WrapperClass;
/*
PRIMITIVE   |   WRAPPER
--------------------------
boolean     |   Boolean
char        |   Character
int         |   Integer
double      |   Double

i dati primitivi ci permettono di usare i metodi delle variabili
come String che ci permette di usare i metodi già prescritti nelle librerie standard di Java

pro:
sono molto utili grazie ai metodi

contro:
sono molto più lente delle primitive
 */


public class MainWrapper {
    public static void main(String[] args) {
        //Boolean vs boolean ----------------------------------
        Boolean veroW =true;
        boolean veroP =true;

        //metodo di comparazione ==
        if(veroW==veroP){
            //veroW viene unboxata in un boolean primitivo

            System.out.println("Boolean e boolean sono uguali");
        }

        //metodo di comparazione .equals
        if(veroW.equals(veroP)){
            System.out.println("Boolean e boolean sono uguali");
        }


        //Character vs char ------------------------------------
        Character carattereW ='a';
        char carattereP ='a';

        //metodo di comparazione ==
        if(carattereW==carattereP){
            //carattereW viene unboxato in un char primitivo

            System.out.println("Character e char sono uguali");
        }

        //metodo di comparazione .equals
        if(carattereW.equals(carattereP)){
            System.out.println("Character e char sono uguali");
        }


        //Integer vs int --------------------------------------
        Integer numeroW=5;
        int numeroP=5;

        //metodo di comparazione ==
        if(numeroW==numeroP){
            //numeroW viene unboxato in un int primitivo

            System.out.println("Integer e int sono uguali");
        }

        //metodo di comparazione .equals
        if(numeroW.equals(numeroP)){
            System.out.println("Integer e int sono uguali");
        }


        //Double vs double ----------------------------------
        Double virgolaW=5.23;
        double virgolaP=5.23;

        //metodo di comparazione ==
        if(virgolaW==virgolaP){
            //virgolaW viene unboxato in un double primitivo

            System.out.println("Double e double sono uguali");
        }

        //metodo di comparazione .equals
        if(virgolaW.equals(virgolaP)){
            System.out.println("Double e double sono uguali");
        }

        //String
        String stringa ="bel corso";
        System.out.println("La stringa è: " + stringa);
    }
}
