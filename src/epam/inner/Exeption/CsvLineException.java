package epam.inner.Exeption;

public class CsvLineException extends IllegalArgumentException{
    public CsvLineException(String csv){
        System.out.println(csv + "Не верный размер строки");
    }
}
