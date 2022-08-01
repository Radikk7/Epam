package epam.inner;


import epam.inner.Exeption.CsvLineException;
import epam.inner.model.Byn;
import epam.inner.model.Purchase;
import epam.inner.model.WrapperDate;
import epam.inner.model.WrapperEntry;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class Raner {
    public static void main(String[] args) throws FileNotFoundException {


        Map<Purchase, WrapperDate>dateMap= new HashMap<>();
        Map<DayOfWeek, List<Purchase>> dayPurchasesMap = new EnumMap<>(DayOfWeek.class);
        String line = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("file.txt")))
        {
            //объявить 3 мэпа (lastPurchasesMap, firstPurchasesMap, dayPurchasesMap)
            //и 1 лист (priceDiscountPurchases);
            while ((line = bufferedReader.readLine()) != null)  {
                try {
                    WrapperEntry entry = WrapperEntry.gerValidEntry(line);
                    //System.out.println(entry);
                    dateMap.put(entry.getPurchase(), entry.getDate());
                    if (dayPurchasesMap.containsKey(entry.getDate().returnday())){
                   List<Purchase> purchaseList = dayPurchasesMap.get(entry.getDate().returnday());
                   purchaseList.add(entry.getPurchase());
                   dayPurchasesMap.replace(entry.getDate().returnday(),purchaseList);
                    }
                    else {
                        List<Purchase>purchaseList= new ArrayList<>();
                        purchaseList.add(entry.getPurchase());
                    dayPurchasesMap.put(entry.getDate().returnday(),purchaseList);
                    }

                } catch (CsvLineException e){

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

      Set<Map.Entry<DayOfWeek, List<Purchase>>>entrySet=dayPurchasesMap.entrySet();
        for (Map.Entry<DayOfWeek, List<Purchase>> i:entrySet) {
            System.out.println(i);
        }
        }

    }

