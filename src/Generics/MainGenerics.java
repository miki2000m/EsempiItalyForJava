package Generics;

public class MainGenerics {
    public static void main(String[] args) {
        //A lo stesso funzionamento alla base dei Vector/ArrayList
        //Vector<Integer> numbers = new Vector<>();
        //ArrayList<String> names = new ArrayList<>();
        Box<String> box = new Box<>();
        box.setItem("Banana");
        System.out.println(box);

        System.out.println();


        //con più di un tipo all'interno della classe
        Product<String, Double> product = new Product<>("iphone 12",400.0);
        System.out.println(product);

    }
}
