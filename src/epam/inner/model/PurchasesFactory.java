package epam.inner.model;


import epam.inner.Exeption.CsvLineException;

public class PurchasesFactory {
    public static Purchase generatePurhase(String cvs){
    String [] array = cvs.split(";");
    try {
        switch (array.length){
            case 3:
                return new Purchase(new Product(array[0], new Byn(array[1])),array[2]);
            case 4:
               return new PriceDiscountPurchase(array[3] , new Product(array[0], new Byn(array[1])), array[2]);
            default:
                throw new CsvLineException(cvs);
        }
    }catch (IllegalArgumentException e){
        throw new CsvLineException(cvs);
    }
    }
}
