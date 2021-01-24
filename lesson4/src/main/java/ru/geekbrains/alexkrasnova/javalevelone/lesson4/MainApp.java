package ru.geekbrains.alexkrasnova.javalevelone.lesson4;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    private static final char EMPTY_SYMBOL = '*';
    private static final char PLAYER_SYMBOL = 'X';
    private static final char BOT_SYMBOL = 'O';

    public static char[][] map;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        int size = 3;
        int winningNumber = 3;
        playNoughtsAndCrosses(size, winningNumber);

        System.out.println();

        size = 5;
        winningNumber = 4;
        playNoughtsAndCrosses(size, winningNumber);
    }

    public static void playNoughtsAndCrosses(int size, int winningNumber) {
        prepareMap(size);
        printMap();
        while (true) {
            makePlayerMove();
            if (isGameWon(PLAYER_SYMBOL, winningNumber)) {
                System.out.println("Победил игрок");
                printMap();
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                printMap();
                break;
            }

            makeBotMove();
            printMap();
            if (isGameWon(BOT_SYMBOL, winningNumber)) {
                System.out.println("Победил бот");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void prepareMap(int size) {
        map = new char[size][size];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = EMPTY_SYMBOL;
            }
        }
    }

    public static void printMap() {
        for (int x = 0; x <= map[0].length; x++) {
            System.out.print(x + " ");
        }
        System.out.println();
        for (int y = 0; y < map.length; y++) {
            System.out.print((y + 1) + " ");
            for (int x = 0; x < map[y].length; x++) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void makePlayerMove() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате 'x y'");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellCorrectAndEmpty(x, y));
        map[y][x] = PLAYER_SYMBOL;
    }

    public static void makeBotMove() {
        int x, y;
        do {
            x = random.nextInt(map[0].length);
            y = random.nextInt(map.length);
        } while (!isCellCorrectAndEmpty(x, y));
        map[y][x] = BOT_SYMBOL;
    }

    public static boolean isCellCorrectAndEmpty(int x, int y) {
        if (y < 0 || x < 0 || y >= map.length || x >= map[0].length) {
            return false;
        } else if (map[y][x] == EMPTY_SYMBOL) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == EMPTY_SYMBOL) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isGameWon(char symbol, int winningNumber) {
        int numberOfSymbolsInLine = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                if (map[y][x] == symbol) {
                    numberOfSymbolsInLine += 1;
                } else {
                    numberOfSymbolsInLine = 0;
                }
                if (numberOfSymbolsInLine >= winningNumber) {
                    return true;
                }
            }
            numberOfSymbolsInLine = 0;
        }


        for (int x = 0; x < map[0].length; x++) {
            for (int y = 0; y < map.length; y++) {
                if (map[y][x] == symbol) {
                    numberOfSymbolsInLine += 1;
                } else {
                    numberOfSymbolsInLine = 0;
                }
                if (numberOfSymbolsInLine >= winningNumber) {
                    return true;
                }
            }

            numberOfSymbolsInLine = 0;
        }

        for (int k = winningNumber - map.length; k <= map.length - winningNumber; k++) {
            int x, y;
            for (int i = 0; i < map.length - Math.abs(k); i++) {
                if (k >= 0) {
                    x = i + k;
                    y = i;
                } else {
                    x = i;
                    y = i - k;
                }
                if (map[y][x] == symbol) {
                    numberOfSymbolsInLine += 1;
                } else {
                    numberOfSymbolsInLine = 0;
                }
                if (numberOfSymbolsInLine >= winningNumber) {
                    return true;
                }
            }
            numberOfSymbolsInLine = 0;
        }


        numberOfSymbolsInLine = 0;
        for (int k = winningNumber - map.length; k <= map.length - winningNumber; k++) {
            int x, y;
            for (int i = 0; i < map.length - Math.abs(k); i++) {
                if (k >= 0) {
                    x = map.length - 1 - i;
                    y = i + k;
                } else {
                    x = map.length - 1 - i + k;
                    y = i;
                }
                if (map[y][x] == symbol) {
                    numberOfSymbolsInLine += 1;
                } else {
                    numberOfSymbolsInLine = 0;
                }
                if (numberOfSymbolsInLine >= winningNumber) {
                    return true;
                }
            }
            numberOfSymbolsInLine = 0;
        }
        return false;
    }
}
