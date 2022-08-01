package epam.inner.Exeption;

public class OutOfRangeException extends  IllegalArgumentException{
    public OutOfRangeException(String business, int value) {
        System.out.println(business + " Выше число " +  value  + " Вышло за границы значения ");
    }
    public OutOfRangeException(String business) {
        System.out.println(business + " Выше число " +  " Вышло за границы значения ");
    }
}
