package homework47_48;

public class handleException {

    /*
    Задача 1
    Написать метод, который получает в качестве параметра строку длинной 16 символов и, если строка не соответствует
    этому требованию, выбрасывает IllegalArgumentException.
    */

    public static void main(String[] args) {

        getArgument("dfgfgshhsh");

    }

    public static void getArgument(String str) {
        if (str.length() != 16) throw new IllegalArgumentException();
    }
}
