package MODULO_3_API_FONDAMENTALI.cArrayVettori;

import java.util.Arrays;

public class MainBubbleSort {
    public static void main(String[] args){
        // Bubble Sort è un semplice algoritmo di ordinamento.
        // Funziona scorrendo ripetutamente la lista, confrontando ogni coppia di elementi adiacenti
        // e scambiandoli se sono nell'ordine sbagliato. Ad ogni passata, l'elemento più grande
        // "galleggia" (bubbles up) verso la sua posizione finale in fondo all'array.
        // È un algoritmo molto inefficiente (O(n²)) e non viene usato in pratica, ma è ottimo per scopi didattici.

        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};

        System.out.println("Array prima dell'ordinamento: " + Arrays.toString(array));

        bubbleSort(array);

        System.out.println("Array dopo l'ordinamento:  " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;

        // Il ciclo esterno controlla il numero di passate.
        // Dopo ogni passata, l'elemento più grande è al suo posto, quindi possiamo ridurre il range di una unità.
        for (int i = 0; i < n - 1; i++) {

            // Il ciclo interno scorre l'array e confronta gli elementi adiacenti.
            // Si ferma a `n - i - 1` perché gli ultimi `i` elementi sono già ordinati.
            for (int j = 0; j < n - i - 1; j++) {

                // Se l'elemento corrente è maggiore del successivo, li scambiamo.
                if (array[j] > array[j + 1]) {
                    // Scambio degli elementi
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // (Opzionale) Puoi decommentare questa riga per vedere lo stato dell'array dopo ogni passata completa.
            // System.out.println("Stato dopo passata " + (i + 1) + ": " + Arrays.toString(array));
        }
    }
}
