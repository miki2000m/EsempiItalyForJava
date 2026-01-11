package MODULO_3_API_FONDAMENTALI.Generics;

//<xxxxx>
//<tipo> -> Integer, String, Double, ...
public class Box <T>{
    T item;

    //Non c'è bisogno di un costruttore specifico

    //set e get
    public void setItem(T item){
        this.item = item;
    }

    public T getItem(){
        return item;
    }

    //to String
    public String toString(){
    return "Box[item =® " + item + "]";
    }
}
