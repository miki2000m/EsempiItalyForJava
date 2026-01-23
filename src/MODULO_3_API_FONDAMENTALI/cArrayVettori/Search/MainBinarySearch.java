package MODULO_3_API_FONDAMENTALI.cArrayVettori.Search;

public class MainBinarySearch {
    public static void main(String[] args){
        //Questo tipo di ricerca prende l'elemento a meta dell'array e lo confronta con il valore cercato
        //se il valore è uguale apposto
        //mentre se il valore è diverso viene orientata la ricerca a una delle due metà a seconda di dove potrebbe trovarsi il valore cercato
        //e così via fino a trovare il valore cercato

        //Creiamo l'array con valori da 0 a 99
        int[] array= new int[100];
        for(int i=0;i< array.length;i++){
            array[i]=i;
        }

        int target= 42;

        //int index= Arrays.binarySearch(array,target); -> va bene anche così
        //Io lo ho scritto così solo per mostrare sotto il metodo come funziona
        //riscrivendolo in modo da mostrare meglio come funziona evitando di stampare solo il target ma anche il procedimento
        int index= binarySearch(array,target);

        if(index==-1){
            System.out.println("Elemento non trovato");
        }
        else {
            System.out.println("Elemento trovato nell'indice: "+index);
        }
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length-1;

        while(low<=high){
            int middle=low+(high-low)/2;

            int value=array[middle];

            System.out.println("Middle: "+value);

            if(value<target){
                low=middle+1;
            }
            else{
                if(value>target){
                    high=middle-1;
                }
                else {
                    return middle;//taget trovato
                }
            }
        }

        return -1;
    }
}
