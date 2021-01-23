package ru.geekbrains.alexkrasnova.javalevelone.lesson4;

import java.util.Random;
import java.util.Scanner;

public class MainApp {

    private static final int SIZE = 3;
    private static final char EMPTY_SYMBOL = '*';
    private static final char PLAYER_SYMBOL = 'X';
    private static final char BOT_SYMBOL = 'O';

    public static char[][] map;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        playNoughtsAndCrosses();
    }

    public static void playNoughtsAndCrosses() {
        prepareMap();
        printMap();
        while (true) {
            makePlayerMove();
            printMap();
            if(isGameWon(PLAYER_SYMBOL)){
                System.out.println("Победил игрок");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

            makeBotMove();
            printMap();
            if(isGameWon(BOT_SYMBOL)){
                System.out.println("Победил бот");
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
    }

    public static void prepareMap() {
        map = new char[SIZE][SIZE];
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

    public static boolean isGameWon(char symbol) {
        boolean victory = true;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                victory = victory && (map[y][x] == symbol);
            }
            if (victory) {
                return true;
            }
        }

        victory = true;
        for (int x = 0; x < map[0].length; x++) {
            for (int y = 0; y < map.length; y++) {
                victory = victory && (map[y][x] == symbol);
            }
            if (victory) {
                return true;
            }
        }

        victory = true;
        for (int i = 0; i < map.length; i++) {
            victory = victory && (map[i][i] == symbol);
        }
        if(victory) {
            return true;
        }

        victory = true;
        for (int i = 0; i<map.length; i++){
            victory = victory && (map[i][map.length-1 -i]==symbol);
        }
        if (victory) {
            return true;
        }
        return false;
    }


/*    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
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

    public static void prepareMap() {
        map = new char[SIZE + 1][SIZE];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = EMPTY_SYMBOL;
            }
        }
    }*/


}
