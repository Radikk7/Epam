package epam.inner.Exeption;

public class NegativeArgumentException extends IllegalArgumentException {
    public NegativeArgumentException(String s) {
        System.out.println(s + " < 0");
    }
    public NegativeArgumentException(int a) {
        System.out.println(a + " < 0");
    }

    public NegativeArgumentException(String business, int field) {
        System.out.println(business + "Ваше значение" + field + "Должно быть больше 0 ");
    }

}
