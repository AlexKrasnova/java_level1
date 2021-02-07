package ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game;

import ru.geekbrains.alexkrasnova.javalevelone.lesson8.version2.game.ui.UI;

import java.util.Random;

public class GuessNumberGame {

    UI ui;

    private final int MAX_TRY_COUNT;

    private final int MIN_NUMBER;

    private final int MAX_NUMBER;

    public GuessNumberGame(UI ui, int maxTryCount, int minNumber, int maxNumber) {
        this.ui = ui;
        this.MAX_TRY_COUNT = maxTryCount;
        this.MIN_NUMBER = minNumber;
        this.MAX_NUMBER = maxNumber;
    }

    public GuessNumberGame(UI ui) {
        this.ui = ui;
        this.MAX_TRY_COUNT = 3;
        this.MIN_NUMBER = 0;
        this.MAX_NUMBER = 9;
    }

    public void play() {

        ui.showMessage("Я загадал тебе число от " + MIN_NUMBER + " до " + MAX_NUMBER + ", попробуй его угадать.\nМаксимальное число попыток: " + MAX_TRY_COUNT + ".\nВведи целое число от " + MIN_NUMBER + " до " + MAX_NUMBER + ":");
        int rightAnswer = new Random().nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;

        int userAnswer;
        for (int i = 1; i <= MAX_TRY_COUNT; i++) {
            userAnswer = ui.getNumberFromUser();
            if (userAnswer == rightAnswer) {
                ui.showMessage("Поздравляю, ты угадал!");
                break;
            } else if (i >= MAX_TRY_COUNT) {
                ui.showMessage("Ты проиграл. Правильный ответ: " + rightAnswer + ".");
            } else if (userAnswer < rightAnswer) {
                ui.showMessage("Ты ввел слишком маленькое число, попробуй еще раз. \nОсталось попыток: " + (MAX_TRY_COUNT - i) + ".");
            } else {
                ui.showMessage("Ты ввел слишком большое число, попробуй еще раз. \nОсталось попыток: " + (MAX_TRY_COUNT - i) + ".");
            }
        }
    }

}
