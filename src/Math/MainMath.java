package Math;

public class MainMath {
    public static void main(String[] args) {

        //OPERAZIONI BASE DI Math ------------------------------------

        //Math.abs(x) = valore assoluto
        //cioè trasforma un numero negativo in positivo
        System.out.println("\nVALORE ASSOLUTO");
        System.out.printf("Math.abs(-44): %d\n", Math.abs(-44));

        //Math.max(x,y) = valore massimo
        //cioè confronta 2 numeri e restituisce il più grande
        System.out.println("\nVALORE MASSIMO");
        System.out.printf("Math.max(5,10): %d\n", Math.max(5,10));

        //Math.min(x,y) = valore minimo
        //cioè confronta 2 numeri e restituisce il più piccolo
        System.out.println("\nVALORE MINIMO");
        System.out.printf("Math.min(-7,-5): %d\n", Math.min(-7,-5));

        //Math.sqrt(x) = radice quadrata
        //cioè calcola la radice quadrata del numero x
        System.out.println("\nRADICE QUADRATA");
        System.out.printf("Math.sqrt(4): %.2f\n", Math.sqrt(4));

        //Math.pow(x,y) = potenza
        //cioè eleva x alla potenza y → x^y
        System.out.println("\nPOTENZA");
        System.out.printf("Math.pow(3,2): %.2f\n", Math.pow(3,2));


        //ARROTONDAMENTI --------------------------------------------

        //Math.round(x) = arrotonda normalmente
        //cioè se la cifra decimale è < .5 arrotonda giù, altrimenti su
        System.out.println("\nARROTONDAMENTO NORMALE");
        System.out.printf("Math.round(4.49): %d\n", Math.round(4.49));
        System.out.printf("Math.round(4.50): %d\n", Math.round(4.50));

        //Math.ceil(x) = arrotonda sempre per eccesso
        //cioè prende sempre il numero intero superiore
        System.out.println("\nARROTONDAMENTO PER ECCESSO");
        System.out.printf("Math.ceil(4.01): %.2f\n", Math.ceil(4.01));

        //Math.floor(x) = arrotonda sempre per difetto
        //cioè prende sempre il numero intero inferiore
        System.out.println("\nARROTONDAMENTO PER DIFETTO");
        System.out.printf("Math.floor(4.99): %.2f\n", Math.floor(4.99));


        //NUMERI CASUALI --------------------------------------------

        //Math.random() = numero casuale da 0 a 1
        //cioè genera un numero DECIMALE casuale tra 0.0 e 1.0
        System.out.println("\nNUMERO CASUALE (0-1)");
        System.out.println("Math.random(): " + Math.random());

        //Per avere un numero casuale intero in un range
        //si moltiplica per il limite massimo e si aggiunge 1
        System.out.println("\nNUMERO CASUALE (1-10)");
        int random = (int)(Math.random() * 10) + 1;
        System.out.println("Random 1-10: " + random);


        //VALORI FISSI DI Math --------------------------------------

        //Math.PI = valore di π (pigreco)
        //cioè il famoso numero 3.1415...
        System.out.println("\nPIGRECO");
        System.out.printf("Math.PI: %f\n", Math.PI);

        //Math.E = numero di Eulero
        //cioè il valore della costante matematica ~2.71828
        System.out.println("\nNUMERO DI EULERO");
        System.out.printf("Math.E: %f\n", Math.E);


        //TRIGONOMETRIA ---------------------------------------------

        //Nei metodi trigonometrici si usano i radianti
        //quindi serve convertire i gradi se vogliamo lavorare in gradi
        System.out.println("\nTRIGONOMETRIA");

        double angolo = Math.toRadians(30);
        //converte 30 gradi in radianti
        System.out.printf("Radianti di 30°: %.4f\n", angolo);

        //Math.sin(x) = seno di x
        System.out.printf("Math.sin(30°): %.4f\n", Math.sin(angolo));

        //Math.cos(x) = coseno di x
        System.out.printf("Math.cos(30°): %.4f\n", Math.cos(angolo));

        //Math.tan(x) = tangente di x
        System.out.printf("Math.tan(30°): %.4f\n", Math.tan(angolo));

        //Math.toDegrees(x) = radianti → gradi
        //Math.toRadians(x) = gradi → radianti
        System.out.println("\nCONVERSIONE ANGOLI");
        System.out.printf("Math.toDegrees(PI/2): %.2f°\n", Math.toDegrees(Math.PI / 2));


        //OPERAZIONI SPECIALI ---------------------------------------

        System.out.println("\nOPERAZIONI SPECIALI");

        //Math.cbrt(x) = radice cubica
        //cioè la radice di ordine 3
        System.out.printf("Math.cbrt(27) (radice cubica): %.2f\n", Math.cbrt(27));

        //Math.exp(x) = e^x
        //cioè eleva il numero di Eulero alla potenza x
        System.out.printf("Math.exp(1): %.4f (cioè e^1)\n", Math.exp(1));

        //Math.log(x) = logaritmo naturale (base e)
        //cioè il logaritmo con base E
        System.out.printf("Math.log(E): %.2f\n", Math.log(Math.E));

        //Math.log10(x) = logaritmo in base 10
        //cioè quello che usiamo normalmente
        System.out.printf("Math.log10(1000): %.2f\n", Math.log10(1000));

        //Math.hypot(x,y) = radice di (x² + y²)
        //cioè applica direttamente il teorema di Pitagora
        System.out.printf("Math.hypot(3,4): %.2f (teorema di Pitagora)\n", Math.hypot(3,4));

        //Math.signum(x) = segno del numero
        //cioè restituisce -1 se negativo, 0 se zero, 1 se positivo
        System.out.println("\nSEGNO DEL NUMERO");
        System.out.println("Math.signum(-50): " + Math.signum(-50));
        System.out.println("Math.signum(0):   " + Math.signum(0));
        System.out.println("Math.signum(50):  " + Math.signum(50));
    }
}
