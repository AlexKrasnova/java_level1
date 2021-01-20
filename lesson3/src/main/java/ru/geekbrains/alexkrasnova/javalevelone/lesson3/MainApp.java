package ru.geekbrains.alexkrasnova.javalevelone.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainApp {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        playWordsGame();
        playNumberGame();

    }

    public static void playNumberGame() {

        int play;
        System.out.print("Привет, давай сыграем в игру Угадай число? \nДля продолжения нажми 1, а для выхода 0:\n");
        play = scanner.nextInt();
        while (play == 1) {
            System.out.println("Поехали! Я загадаю тебе число от 0 до 9, а ты попробуешь его угадать.");
            int rightAnswer = random.nextInt(10);

            int userAnswer;
            for (int i = 1; i < 4; i++) {
                System.out.printf("У тебя есть %d попытки.\nВведи целое число от 0 до 9:\n", (4 - i));
                userAnswer = scanner.nextInt();
                if (userAnswer == rightAnswer) {
                    System.out.println("Поздравляю, ты угадал!");
                    break;
                } else if (i > 2) {
                    System.out.println("Ты проиграл.");
                } else if (userAnswer < rightAnswer) {
                    System.out.println("Ты ввел слишком маленькое число.");
                } else {
                    System.out.println("Ты ввел слишком большое число.");
                }
            }
            System.out.print("Хочешь сыграть еще раз? \nДля продолжения нажми 1, а для выхода 0:\n");
            play = scanner.nextInt();
        }
    }

    public static void playWordsGame() {
        String[] words = getWords();
        System.out.print("Привет, давай сыграем в слова на английском.\nЯ загадаю тебе фрукт или овощ на английском, а ты попробуешь его угадать.\n");
        String rightAnswer = words[random.nextInt(words.length)];
        do {
            System.out.println("Введи свой вариант:");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equals(rightAnswer)){
                System.out.println("Поздравляю ты угадал!");
                break;
            } else {
                int minAnswerLength = Math.min(userAnswer.length(), rightAnswer.length());
                for (int i = 0; i < minAnswerLength; i++) {
                    if (userAnswer.charAt(i) == rightAnswer.charAt(i)) {
                        System.out.print(userAnswer.charAt(i));
                    } else {
                        System.out.print("#");
                    }
                }
                for(int i = minAnswerLength; i<15; i++)
                {
                    System.out.print("#");
                }
                System.out.print("\n");
            }

        } while (true);
    }

    public static String[] getWords() {
        String[] words = {
                "apple",
                "apricot",
                "avocado",
                "banana",
                "broccoli",
                "carrot",
                "cherry",
                "garlic",
                "grape",
                "kiwi",
                "leak",
                "lemon",
                "mango",
                "melon",
                "mushroom",
                "nut",
                "olive",
                "orange",
                "pea",
                "peanut",
                "pear",
                "pepper",
                "pineapple",
                "potato",
                "pumpkin"
        };
        return words;
    }
}
