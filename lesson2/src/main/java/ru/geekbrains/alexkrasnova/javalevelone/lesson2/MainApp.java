package ru.geekbrains.alexkrasnova.javalevelone.lesson2;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        int[] array1 = {1, 3, 4, 3, 5};
        int[] array2 = {1, 1, 1, 3};
        int[] array3 = {3, 3, 4, 1};
        int[] array4 = {5, 5, 5, 2, 3, 1, 2, 1, 1, 5, 10, 5, 10, 6, 4, 5, 3, 2, 4, 1, 5, 5};

        System.out.println("hasBalancePoint(" + Arrays.toString(array1) + ") = " + hasBalancePoint(array1));
        System.out.println("hasBalancePoint(" + Arrays.toString(array2) + ") = " + hasBalancePoint(array2));
        System.out.println("hasBalancePoint(" + Arrays.toString(array3) + ") = " + hasBalancePoint(array3));
        System.out.println("hasBalancePoint(" + Arrays.toString(array4) + ") = " + hasBalancePoint(array4));

        int[] array5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("shift(" + Arrays.toString(array5) + ", 3) = " + Arrays.toString(shift(array5, 3)));
        System.out.println("shift(" + Arrays.toString(array5) + ", -3) = " + Arrays.toString(shift(array5, -3)));
    }

    // Проверяет, есть ли в массиве есть , в котором сумма левой и правой части массива равны. Если есть, возвращает true, иначе false.
    // На вход получает целочисленный массив.
    public static boolean hasBalancePoint(int[] array) {

        int sumLeft = 0;
        int sumRight = 0;

        for (int l = 0; l < array.length; l++) {
            sumRight += array[l];
        }

        for (int i = 0; i < array.length; i++) {
                sumLeft += array[i];
                sumRight -= array[i];

            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    // На вход получает целочисленный массив и целое число n.
    // Сдвигает элементы массива на n позиций вправо, если n положительно, и на n позиций влево, если n отрицательно.
    public static int[] shift(int[] array, int n) {

        if (n>=0) {
            for (int k = 0; k < n; k++) {
                int val = array[array.length - 1];

                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = val;

            }
        } else {
            for (int k = 0; k < -n; k++) {
                int val = array[0];

                for (int i = 0; i < array.length - 2; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length - 1] = val;

            }
        }
        return array;
    }
}
