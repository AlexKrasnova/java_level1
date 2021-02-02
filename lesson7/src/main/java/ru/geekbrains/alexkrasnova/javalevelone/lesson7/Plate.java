package ru.geekbrains.alexkrasnova.javalevelone.lesson7;

public class Plate {
    private static int count;
    private int number;
    private int foodAmount;
    private int maxFoodAmount;

    public Plate(int maxFoodAmount) {
        this.maxFoodAmount = maxFoodAmount;
        count++;
        number = count;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public int getNumber() {
        return number;
    }

    public void fill() {
        System.out.printf("Тарелка %d наполнена.\n", number);
        foodAmount = maxFoodAmount;
    }

    public void addFood(int food) {
        if (food < 0) {
            System.out.println("Вы ввели некорректное значение.");
            return;
        }

        if (foodAmount < maxFoodAmount) {
            foodAmount += food;
            if (foodAmount > maxFoodAmount) {
                System.out.printf("Тарелка %d наполнена, осталось %d единиц невостребоавнной еды.\n", number, foodAmount - maxFoodAmount);
                foodAmount = maxFoodAmount;
            } else if (foodAmount == maxFoodAmount) {
                System.out.printf("Тарелка %d наполнена.\n", number);
                foodAmount = maxFoodAmount;
            } else {
                System.out.printf("В тарелку %d добавлено %d еды, текущее количество еды %d/%d.\n", number, foodAmount, food, maxFoodAmount);

            }
        } else {
            System.out.printf("Тарелка %d и так полна.\n", number);
        }
    }

    public void takeFood(int food) {
        if (food < 0) {
            System.out.println("Вы ввели некорректное значение.");
            return;
        }
        if (foodAmount < food) {
            System.out.printf("Из тарелки %d удалось забрать только %d еды, текущее количество еды %d/%d.\n", number, food, 0, maxFoodAmount);
            foodAmount = 0;
        } else if (foodAmount == food) {
            System.out.printf("Из тарелки %d забрали всю еду.\n", number);
            foodAmount = 0;
        } else {
            foodAmount -= food;
            System.out.printf("Из тарелки %d забрали %d еды, текущее количество еды %d/%d.\n", number, food, foodAmount, maxFoodAmount);
        }
    }
}
