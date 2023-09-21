package homework47_48;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SequenceOptimizer {
    /*
    Задача 2
    Представьте, у вас есть робот, который понимает команды:
    'С' - шаг на север
    'Ю' - шаг на юг
    'З' - шаг на запад
    'В' - шаг на восток
    Команды роботу поступают в виде строки вида "CЗВЗЗТЮ". Очевидно, если в строке присутствуют рядом взаимно
    противоположные команды например "ЗВ" или "СЮ" их можно сократить. Очевидно, что после сокращения, в строке опять
    взаимно противоположные команды могут оказаться рядом, и их опять можно сократить.
    Напишите метод, который оптимизирует строку команд для робота, сокращая лишние шаги.
    Примеры: "СЮСЗ" -> "СЗ"
    "СЮВЗ" -> ""
    "СВЮЗ" -> "СВЮЗ"
    "СВЗЮВЮЗССЮ" -> "ВЮЗС"
    */
    public static void main(String[] args) {
        String commandLine = "NEWSESWNNS";
        String commandLine1 = "NSWE";
        String commandLine2 = "NESW";

        System.out.println(finalCommandLine(commandLine));
        System.out.println(finalCommandLine(commandLine1));
        System.out.println(finalCommandLine(commandLine2));
    }
    public static String finalCommandLine(String str) {
        Deque<Character> newLine = new LinkedList<>();
        for (Character ch : str.toCharArray()) {
            switch (ch) {
                case 'N' -> controlStack(ch, 'S', newLine);
                case 'S' -> controlStack(ch, 'N', newLine);
                case 'W' -> controlStack(ch, 'E', newLine);
                case 'E' -> controlStack(ch, 'W', newLine);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('"');
        for (Character ch : newLine) {
            sb.append(ch);
        }
        sb.append('"');
        return sb.reverse().toString();
    }

    public static void controlStack(Character inCh, Character outCh, Deque<Character> newLine) {
        if (!newLine.isEmpty() && newLine.getFirst().equals(outCh)) {
            newLine.pop();
        } else newLine.push(inCh);
    }
}
