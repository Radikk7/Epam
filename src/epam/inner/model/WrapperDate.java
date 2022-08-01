package epam.inner.model;

import epam.inner.Exeption.PatternArgumentException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class WrapperDate {
  private LocalDate date;

  public WrapperDate(String date1){
       date = convertStringtoDate(date1);
  }

    public LocalDate getDate() {
        return date;
    }

    public static LocalDate convertStringtoDate(String date) {
        String[] array = date.split("-");
        try {


            if (array.length != 3) {
                throw new PatternArgumentException(date);
            }
            if (!array[0].matches("\\d\\d")) {
                throw new PatternArgumentException("Не верно указан год");
            }
            if (!array[1].matches("\\d\\d")) {
                throw new PatternArgumentException("Не верно указан месяц");
            }
            if (!array[2].matches("\\d\\d")) {
                throw new PatternArgumentException("Не верно указан день");
            }
            if (Integer.parseInt(array[0]) < 15 && Integer.parseInt(array[0]) > 25) {
                throw new PatternArgumentException("Не верно указан год");
            }
            if (Integer.parseInt(array[1]) < 1 && Integer.parseInt(array[1]) > 12) {
                throw new PatternArgumentException("Не верно указан месяц");
            }
            if (Integer.parseInt(array[2]) < 1 && Integer.parseInt(array[2]) > 31) {
                throw new PatternArgumentException("Не верно указан день");
            }
            String a = (array[0] + array[1] + array[2]);
            LocalDate date1 = LocalDate.of(Integer.parseInt("20" + array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]));
            return date1;
        }
        catch (NullPointerException e){

        }
        return null;
    }
    public  DayOfWeek returnday(){
        DayOfWeek dayOfWeek = DayOfWeek.from(getDate());
        return dayOfWeek;

    }
  public String toString(){
      return getDate() + " ";
  }

}

