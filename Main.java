
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Часть 1. Математические операции с помощью лямбда-выражений
        Operation addition = (a, b) -> a + b;
        Operation subtraction = (a, b) -> a - b;
        Operation multiplication = (a, b) -> a * b;
        Operation division = (a, b) -> {
            if (b == 0) {
                throw new ArithmeticException("Деление на ноль невозможно");
            }
            return a / b;
        };

        double a = 20;
        double b = 5;

        System.out.println("Математические операции:");
        System.out.println(a + " + " + b + " = " + addition.apply(a, b));
        System.out.println(a + " - " + b + " = " + subtraction.apply(a, b));
        System.out.println(a + " * " + b + " = " + multiplication.apply(a, b));
        System.out.println(a + " / " + b + " = " + division.apply(a, b));

        // Часть 2. Обработка коллекции с помощью Stream API и лямбда-выражений
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> processedNumbers = numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * 2)
                .collect(Collectors.toList());

        System.out.println("\nОбработка коллекции:");
        System.out.println("Исходный список: " + numbers);
        System.out.println("Четные числа, умноженные на 2: " + processedNumbers);

        // Часть 3. Обработка строк с помощью функционального интерфейса
        StringOperation toUpperCase = str -> str.toUpperCase();
        StringOperation toLowerCase = str -> str.toLowerCase();
        StringOperation trim = str -> str.trim();
        StringOperation reverse = str -> new StringBuilder(str).reverse().toString();

        StringProcessor processor = new StringProcessor();
        String input = " Hello, World! ";

        System.out.println("\nОбработка строки:");
        System.out.println("Исходная строка: [" + input + "]");
        System.out.println("Верхний регистр: [" +
                processor.processString(input, toUpperCase) + "]");
        System.out.println("Нижний регистр: [" +
                processor.processString(input, toLowerCase) + "]");
        System.out.println("Удаление пробелов по краям: [" +
                processor.processString(input, trim) + "]");
        System.out.println("Обратная строка: [" +
                processor.processString(input, reverse) + "]");
    }
}
