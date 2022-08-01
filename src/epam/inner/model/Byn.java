package epam.inner.model;


import epam.inner.Exeption.CointOutOfRenchException;
import epam.inner.Exeption.NegativeArgumentException;
import epam.inner.Exeption.OutOfRangeException;
import epam.inner.Exeption.PatternArgumentException;

public class Byn {
    private int value;

    public Byn(int value) {
        if (value < 0){
            throw new NegativeArgumentException("Coins");
        }
        this.value = value;
    }
    public Byn(){

    }
    public Byn(String strByn){
        this(strByn(strByn));
    }


    public int getValue() {
        return value;
    }

    public Byn(Byn byn){
        this(byn.getValue());
    }
    public Byn(int rubs, int coins){
        this(getValidValue(rubs, coins));
    }

    private static int getValidValue(int rubs,int coins){
        if (coins > 100){
            throw new CointOutOfRenchException( "Coins",coins);
        }
        if (coins < 0){
            throw new NegativeArgumentException("Coins",coins);
        }
        if (rubs < 0){
            throw new NegativeArgumentException("Rubs",rubs);
        }
        //rubs * 100 + coins <= максимальное значение поля value в классе Byn.
        long a = (long) rubs * 100 + coins;
         if (a >= Integer.MAX_VALUE){
            throw new OutOfRangeException("Rubs", rubs);
        }
         return rubs * 100 + coins;
    }
    public String toString(){
        return Integer.toString(getValue());
    }
    private static int strByn(String string){
        if (!string.matches("\\d+.\\d\\d")){ // matches делает проверку есть ли такое значение
           throw new PatternArgumentException(string);
        }
        String [] array = string.split("\\.");
        String a = array[0];
        String b = array[1];
       int c = Integer.parseInt(a);
        int d = Integer.parseInt(b);
        return getValidValue(c,d);
    }

}
