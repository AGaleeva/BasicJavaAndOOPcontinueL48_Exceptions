package homework47_48.bank;

public class BankAppl {
    /*
    Задача 2
    Представьте, вы пишете банковскую программу. Создайте два checked exception: AccountFormatException и
    WrongAccountCountryCodeException. Напишите метод, который получает строку с номером вида: DE171271782891.
    Если строка короче 14 символов или длиннее 16 - > AccountFormatException.
    Если строка не начинается с символов "DE" - WrongAccountCountryCodeException, если что-то другое
    (например передан null) -> IllegalArgumentException. При нормальном потоке выполнения, метод создает
    новый объект Account и возвращает его.
    Напишите вызов вашего метода с обработкой возможных исключений.
    */
    public static void main(String[] args) {

        try {
            Account acc1 = createNewAccount("DE171245212891");
            System.out.println(acc1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Account createNewAccount(String accNum) throws AccountFormatException,
            WrongAccountCountryCodeException {
        if (accNum == null || !accNum.substring(2)
                .matches("^[0-9]+$"))
            throw new IllegalArgumentException("Account number: " + accNum);
        if (accNum.length() < 14 || accNum.length() > 16)
            throw new AccountFormatException("Wrong account number length.");
        if (!accNum.startsWith("DE"))
            throw new WrongAccountCountryCodeException("Wrong country code. Only DE is allowed.");
        Account acc = new Account(accNum);
        return acc;
    }
}
