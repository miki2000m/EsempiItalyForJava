package ArrayVettori.Search;

public class MainInterpolationSearch {
    public static void main(String[] args){
        // La ricerca per interpolazione stima la posizione di un elemento, è utile per dati distribuiti uniformemente.

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
        // Inizializza l'indice superiore (high) all'ultimo elemento dell'array
        int high=array.length-1;
        // Inizializza l'indice inferiore (low) al primo elemento dell'array
        int low=0;

        // Il ciclo continua finché il valore cercato è compreso nell'intervallo
        // degli elementi correnti e finché l'indice inferiore è minore o uguale a quello superiore.
        while(value>=array[low]&&value<=array[high] && low<=high){
            // Calcola la posizione stimata (probe) del valore.
            // Questa è la formula chiave della ricerca per interpolazione.
            // Stima la posizione del valore basandosi sulla sua distanza dagli elementi agli estremi.
            int probe=low+ (high-low) * (value-array[low]) /
                    (array[high]-array[low]);

            System.out.println("Probe: "+probe);

            // Se l'elemento nella posizione 'probe' è il valore che stiamo cercando
            if(array[probe]==value){
                // Restituisce l'indice, l'elemento è stato trovato
                return  probe;
            }
            // Se l'elemento nella posizione 'probe' è maggiore del valore cercato
            else  if(array[probe]>value){
                // Il valore deve trovarsi nella parte inferiore dell'array, quindi aggiorniamo l'indice 'high'
                high=probe-1;
            }
            // Se l'elemento nella posizione 'probe' è minore del valore cercato
            else {
                // Il valore deve trovarsi nella parte superiore dell'array, quindi aggiorniamo l'indice 'low'
                low=probe+1;
            }
        }

        // Se il ciclo termina, significa che l'elemento non è stato trovato.
        // Restituisce -1 per indicare che il valore non è presente nell'array.
        return -1;
    }
}
