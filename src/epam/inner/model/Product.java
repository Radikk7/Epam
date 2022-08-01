package epam.inner.model;


import epam.inner.Exeption.NegativeArgumentException;
import epam.inner.Exeption.PatternArgumentException;

public class Product {
    private final String name;
    private final Byn price;

    public Product(String name, Byn price) {

        this.name = validName(name);
        this.price = validValue(price);
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    //Условие валидности: непустое имя товара и ненулевая цена.
    public static String validName(String str){
        String expression = "^[a-zA-Z\\s]+";
        if (!str.matches(expression)){
         throw new PatternArgumentException(str);
        }
        return str;
    }
    public static Byn validValue(Byn byn){
        if (byn.getValue() <= 0){
            throw new NegativeArgumentException("byn",byn.getValue());
        }
        return byn;
    }

    public String toString(){
        return "Product =  " + getName()+ "," +" Price =  " + getPrice();
    }

}
