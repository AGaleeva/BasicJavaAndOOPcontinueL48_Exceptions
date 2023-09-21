package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionsDemo {

    public static void main(String[] args) {

        /*try {

        } catch () {

        } finally {

        }*/

//        throw
//        throws

//        можно ввести обработку в методе, который вызвал метод, выбрасывающий ошибку, т.е. на уровень выше.
        int value = 0;
        try {
            value = readInt();
        } catch (InputMismatchException e) {
            System.out.println("not correct");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EXCEPTION!!!");
        }

//        int value = readInt();
//        System.out.println(value);
        System.out.println();

        try {
            System.out.println("method \"div\": " + div(18, 0));
        } catch (MyCheckedException e) {

        }

        div2(7, 0);
    }

    /*public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter int: ");
        int value = 0;
        try {
            value = scanner.nextInt();
            System.out.println("The given value: " + value);
            return value;
        } catch (Exception e) {
            System.out.println("not correct input");
            return value;
        } finally {
            System.out.println("This code must be DONE!");
        }
//        return можно поставить здесь, а можно в блоке "try";
//        можно и там и здесь, но здесь поставить: return 0.
    }*/

    /*   public static int readInt() {
           Scanner scanner = new Scanner(System.in);
           System.out.println("Enter int: ");
           int value = scanner.nextInt();
           value = 10 / value;
   //        System.out.println("The given value: " + value);
           return value;
       }
   */
    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter int: ");
        int value = 0;
        try {
            value = scanner.nextInt();
            System.out.println("The given value: " + value);
            return value;
        } catch (Exception e) {
            throw new ReadIntException();
        } finally {
            System.out.println("This code must be DONE!");
        }
    }

    public static int div(int a, int b) throws MyCheckedException {
        if (b == 0) throw new MyCheckedException("Not correct value");
        return a / b;
    }

    public static int div2(int a, int b) {
        if (b == 0) throw new MyUncheckedException("Not correct value");
        return a / b;
    }

    public static int div1(int a, int b) { // если мы внутри метода сами обрабатываем CheckedException,
                                           // то предупреждать об этом не надо, т.е. писать "throws MyCheckedException"
        try {
            if (b == 0) throw new MyCheckedException("Not correct value");
        } catch (MyCheckedException e) {
            System.out.println();
        }
        return a / b;
    }

}