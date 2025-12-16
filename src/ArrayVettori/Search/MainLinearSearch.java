package ArrayVettori.Search;

public class MainLinearSearch {
    public static void main(String[] args){
        //Questo tipo di ricerca è lento perché deve iterare ogni elemento della lista

                   //0 1 2 3 4 5 6
        int[] array={9,1,8,2,7,3,6};
        int index= linearSearch(array,7);// è posizionato nell'indice 4

        if(index!=-1){
            System.out.println("Elemento trovato nell'indice: "+index);
        }
        else {
            System.out.println("Elemento non trovato");
        }
    }

    private static int linearSearch(int[] array, int value) {

        for(int i=0;i<array.length;i++){
            if(array[i]==value){
                return i;
            }
        }

        return -1;
    }
}
