package epam.inner.Exeption;

public class CointOutOfRenchException extends IllegalArgumentException{
    public CointOutOfRenchException(String coint ,int coins) {
        System.out.println(coint + " Ваше значение" + coins +"Должно быть меньше 100");
    }
}
