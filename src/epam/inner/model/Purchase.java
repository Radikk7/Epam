package epam.inner.model;


import epam.inner.Exeption.NegativeArgumentException;
import epam.inner.Exeption.PatternArgumentException;

public class Purchase {
    private final Product product;
    private final int unitsNumber;

    public Purchase(Product product, int unitsNumber) {
        this.product = product;
        this.unitsNumber = unitsNumber;
        getValidCost(product,unitsNumber);
    }
    //Cоздайте первичный конструктор и вторичные конструкторы, контролируя их аргументы.
    //Условия валидности:
    //	•	положительное количество товара,
    //	•	цена * количество <= максимальное значение поля value в классе Byn (не факт, что это максимум диапазона int).
    //В конструкторе из массива строк проверка длины массива обязательная, т.к. запрос на создание экземпляра покупки может прийти из любого класса,
    //а не только из фабричного класса, где проверяется длина массива.
    //Аналогично в конструкторе из csv строки надо проверить количество аргументов после расщепления csv строки, а далее попытаться создать экземпляр покупки из строковых аргументов.

    public static int validNumber(int number){
        if (number <= 0){
            throw new NegativeArgumentException("Count" + number);
        }
        return number;
    }
    public Purchase(Product product,String unitsNumber){
        this(product,convertStringInt(unitsNumber)); // вызвали первый конструктор
    }

    public static int convertStringInt(String unitsNumber){
        if (!unitsNumber.matches("\\d+")){ // выражение \\d+ значит не одно число а все
            throw new PatternArgumentException(unitsNumber);
        }
        int a = Integer.parseInt(unitsNumber);
        return a;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnitsNumber() {
        return unitsNumber;
    }

    public static void getValidCost(Product product, long count){
      long a = (long)product.getPrice().getValue() * count;
       if (a < 0){
           throw new NegativeArgumentException("Count",(int)a);
       }
       if (a > Integer.MAX_VALUE){
          throw new NegativeArgumentException("Count",(int)a);
       }
    }

    public String toString(){
        return "" + getProduct() + "," + " Count of Product = " + getUnitsNumber();
    }

}
