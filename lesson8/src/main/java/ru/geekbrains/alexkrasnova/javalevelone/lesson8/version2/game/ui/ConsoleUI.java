package ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.ui;

import ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.GuessNumberGame;

import java.util.Scanner;

public class ConsoleUI implements UI {

    static Scanner scanner = new Scanner(System.in);

    public ConsoleUI() {
        System.out.print("Привет, давай сыграем в игру Угадай число? \nДля продолжения нажми 1, а для выхода 0:\n");
        int play = scanner.nextInt();
        while (play == 1) {
            new GuessNumberGame(this).play();
            System.out.print("Хочешь сыграть еще раз? \nДля продолжения нажми 1, а для выхода 0:\n");
            play = scanner.nextInt();
        }
    }

    @Override
    public int getNumberFromUser() {
        return scanner.nextInt();
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);;
    }
}
