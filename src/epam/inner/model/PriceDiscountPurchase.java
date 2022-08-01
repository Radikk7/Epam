package epam.inner.model;


import epam.inner.Exeption.NegativeArgumentException;
import epam.inner.Exeption.PatternArgumentException;

public class PriceDiscountPurchase extends Purchase {
    private int discont;

    public PriceDiscountPurchase(int discont, Product product, int unitsNumber) {
        super(product, unitsNumber);
        this.discont=getValidDiscont(discont);
        getDiscontPriceCorrect(product,discont);
    }



    public PriceDiscountPurchase(String discont, Product product, String unitsnumber) {
        super(product,unitsnumber);
        this.discont=getValidDiscont(discont);
        getDiscontPriceCorrect(product,this.discont);
    }



    public static int getValidDiscont(String discont){
        if (!discont.matches("\\d+\\.\\d\\d")){
            throw new PatternArgumentException(discont);
        }
        String [] array = discont.split("\\.");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        int count = a *100 + b;
        return count;
    }

    public int getDiscont() {
        return discont;
    }

    public static int getValidDiscont(int discont){
        if (discont < 0){
            throw new NegativeArgumentException(discont);
        }
        return discont;
    }
    public static void getDiscontPriceCorrect(Product product,int discont){
        if (product.getPrice().getValue() < discont){
            throw new PatternArgumentException(discont);
        }
    }
    public String toString(){
        return super.toString() +  " Discont = " + getDiscont();
    }

}
