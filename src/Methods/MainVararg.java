package Methods;

public class MainVararg {
    public static void main(String[] args) {

        System.out.println(add(1,2,3,4,5));

        System.out.println(media(1,2,3,4,5));
    }

    //tipo... nome -> crea un array
    //così mi permette di creare un metodo con un numero x di dati in ingresso
    public static int add(int... numbers){
        int somma=0;
        for(int number:numbers){
            somma+=number;
        }
        return somma;
    }

    public static double media(double... numbers){
        double media=0;
        for(double number:numbers){
            media+=number;
        }
        return media/numbers.length;
    }
}
