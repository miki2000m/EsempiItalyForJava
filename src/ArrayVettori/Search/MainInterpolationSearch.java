package ArrayVettori.Search;

public class MainInterpolationSearch {
    public static void main(String[] args){
        //Questo tipo di ricerca sfrutta i logaritmi per trovare l'indice


                   //0 1 2 3 4 5 6 7 8
        //int[] array={1,2,3,4,5,6,7,8,9};
        int[] array={1,2,4,8,16,32,64,128,256,512,1024};

        int index= InterpolationSearch(array,256);
        if(index==-1){
            System.out.println("Elemento non trovato");
        }
        else {
            System.out.println("Elemento trovato nell'indice: "+index);
        }

    }

    private static int InterpolationSearch(int[] array, int value) {
        int high=array.length-1;
        int low=0;

        while(value>=array[low]&&value<=array[high] && low<=high){
            int probe=low+ (high-low) * (value-array[low]) /
                    (array[high]-array[low]);

            System.out.println("Probe: "+probe);

            if(array[probe]==value){
                return  probe;
            }
            else  if(array[probe]>value){
                high=probe-1;
            }
            else {
                low=probe+1;
            }
        }

        return -1;
    }
}
