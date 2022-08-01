package epam.inner.model;


import epam.inner.Exeption.CsvLineException;

import java.util.Date;

public class WrapperEntry {
    private final WrapperDate date;
    private final Purchase purchase;

    public WrapperEntry(WrapperDate date, Purchase purchase) {
        this.date = date;
        this.purchase = purchase;
    }

    public WrapperDate getDate() {
        return date;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public static WrapperEntry gerValidEntry(String csv) throws CsvLineException {
        String[] values = csv.split(";", 2);	//рассплитить line не более, чем  на 2 подстроки
        if (values.length < 2) {
            throw new CsvLineException(csv);
        }
        WrapperDate wrapperDate = new WrapperDate(values[0]);
        Purchase purchase = PurchasesFactory.generatePurhase(values[1]);

       // создать экземпляр WrapperDate date из values[0];
        //создать экземпляр Purchase purchase из values[1];
        return new WrapperEntry(wrapperDate , purchase);
    }
    public String toString(){
        return getDate() + " " + getPurchase();
    }

}
