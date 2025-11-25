package Switch_If_for;

public class MainIfEach {
    public static void main(String[] args) {
        //metodi per scrivere una condizione

        //metodo classico
        //if(condizione){...}
        //else{...}
        int n=10;
        if(n>=15){
            //condizione verificata
            System.out.println("n è maggiore o uguale di 15");
        }
        else {
            //condizione non verificata
            System.out.println("n è minore di 15");
        }


        //metodo veloce (VA USATO SOLO PER CASI VELOCI E NON COMPLESSI)
        //tipo nome =(condizione) ? return true : return false;
        String maxMin=(n>=15) ? "n è maggiore o uguale di 15" : "n è minore di 15";
        System.out.println(maxMin);
    }
}
