package ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2;

import ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.GuessNumberGame;
import ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.ui.ConsoleUI;
import ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.ui.GraphicsUI;

import java.util.Scanner;

public class GuessNumberGameApplication {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int userChoice;

        System.out.println("Выберите интерфейс игры. \nДля запуска консольного приложения нажмите 1, для запуска графического приложения нажмите 2:");
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1: {
                new ConsoleUI();
                break;
            }
            case 2: {
                new GraphicsUI();
                break;
            }
        }
    }

}
