package epam.inner.Exeption;

public class PatternArgumentException extends IllegalArgumentException{
    public PatternArgumentException(String s){
        System.out.println(s  +   " Аргумент не соответсвует");
    }
    public PatternArgumentException(int a){
        System.out.println(a  +   " Аргумент не соответсвует");
    }
}
