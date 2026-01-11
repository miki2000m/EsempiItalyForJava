package MODULO_3_API_FONDAMENTALI.Generics;

public class Product <T,U>{
    T item;
    U price;

    Product(T item, U price){
        this.item = item;
        this.price = price;
    }

    //get
    public T getItem(){
        return item;
    }
    public U getPrice(){
        return price;
    }

    //to String
    public String toString(){
        return "Product: \nitem = " + item + "\nprice = " + price +" €";
    }
}
