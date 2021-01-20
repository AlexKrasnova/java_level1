package ru.geekbrains.lesson1;

public class MyApp {

    public static void main(String[] args) {

        // Целочисленные типы
        byte byteNumber = 5;
        short shortNumber = -129;
        int intNumber = 24;
        long longNumber = -3344000L;

        // Числа с плавающей точкой
        float floatNumber = 1.2f;
        double doubleNumber = -133.52;

        // Символ
        char charVariable = 'c';

        // Строка
        String stringVariable = "Hello, world!";

        // Логический тип данных
        boolean booleanVariable = true;

        //Проверка написанных функций
        testFunctions();
    }

    //Расчет значения по заданной формуле
    public static float calculate(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    //Проверяет, входит ли сумма двух чисел в интервал [10, 20]
    public static boolean isSumIn10to20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // Проверяет, является ли число положительным или отрицательным, и выводит результат в консоль
    public static void checkAndPrintPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " is positive");
        } else {
            System.out.println("Число " + a + " is negative");
        }
    }

    // Проверяет, является ли число положительным
    public static boolean isPositive(int a) {
        return a >= 0;
    }

    // Печатает в консоли приветствие
    public static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    // Проверяет, является ли год високосным
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    // Проверяет работу всех функций из дз
    public static void testFunctions() {

        float a = 1.2f;
        float b = 1.0f;
        float c = 4.4f;
        float d = -199.34f;
        System.out.println("Задание 3. a = " + a + ", b = " + b + ", c = " + c + ", d = " + d + ". a * (b + (c / d)) = " + calculate(a, b, c, d));

        int number1 = -3;
        int number2 = 6;
        System.out.println("Задание 4. Число 1 = " + number1 + ", Число 1 = " + number2 + ". Сумма лежит в пределах от 10 до 20 - " + isSumIn10to20(number1, number2));

        System.out.println("Задание 5.");
        checkAndPrintPositiveOrNegative(number1);

        System.out.println("Задание 6. Число " + number1 + " положительно - " + isPositive(number1));

        String name = "Андрей";
        System.out.println("Задание 7. name = 'Андрей'.");
        printHello(name);

        int year = 76;
        System.out.println(year + " год високосный - " + isLeapYear(year));
    }
}
