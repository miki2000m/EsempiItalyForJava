package MODULO_3_API_FONDAMENTALI.eRandom;

import java.util.Random;

public class MainRandom {
    private static final Random random = new Random();

    public static void main(String[] args) {
        //RANDOM INT ----------------------------------------------------------------------

        //recupero la lunghezza di Inetger
        int maxInteger= Integer.MAX_VALUE;//2147483647
        System.out.println("Max Integer: " + maxInteger);

        int minInteger= Integer.MIN_VALUE;//-2147483648
        System.out.println("Min Integer: " + minInteger);
        
        //numero casuale tra maxInteger e minInteger
        int int1 = random.nextInt();
        System.out.printf("\nrandom maxInteger - minInteger: %d\n",int1);


        //random tra 1 e 10 e 0 10
        int int2 = random.nextInt(10)+1;//1 - 10
        System.out.printf("\nrandom 1 - 10: %d\n",int2);

        int int3 = random.nextInt(10);//0 - 10
        System.out.printf("\nrandom 0 - 10: %d\n",int3);


        //RANDOM DOUBLE ---------------------------------------------------------------------
        double maxDouble = Double.MAX_VALUE;//1.7976931348623157E308
        System.out.println("\nMax Double: " + maxDouble);

        double minDouble = Double.MIN_VALUE;//4.9E-324
        System.out.println("Min Double: " + minDouble);

        //numero casuale tra maxDouble e minDouble
        double double1 = random.nextDouble();
        System.out.printf("\nrandom maxDouble - minDouble: %f\n",double1);

        //numero casuale da 0 - 10.5
        double double2=random.nextDouble(10.5);
        System.out.printf("\nrandom 0 - 10.5: %.2f\n",double2);

        double double3=random.nextDouble(10.5)+1;
        System.out.printf("\nrandom 1 - 10.5: %.2f\n",double3);


        //FORMULA PER UN NUMERO TRA MAX E MIN
        //(max-min+1)+min
        int max=40;
        int min=22;

        int randMaxMai=random.nextInt(max-min+1)+min;
        System.out.printf("\nrandom min - max: %d\n",randMaxMai);
    }
}
