package ru.geekbrains.alexkrasnova.javalevelone.lesson5.coffeemachine;

public class CoffeeMachine {
    private String brand;
    private String color;
    private int coffeeAmount;
    private int maxCoffeeAmount;
    private int waterAmount;
    private int maxWaterAmount;

    public CoffeeMachine(String brand, String color, int maxCoffeeAmount, int maxWaterAmount) {
        this.brand = brand;
        this.color = color;
        this.maxCoffeeAmount = maxCoffeeAmount;
        this.maxWaterAmount = maxWaterAmount;
    }

    public void printInfo() {
        System.out.printf("Кофемашина %s %s:\nКоличество кофе %d/%d Количество воды %d/%d\n", brand, color, coffeeAmount, maxCoffeeAmount, waterAmount, maxWaterAmount);
    }

    public void addCoffee(int coffeeAmount) {
        this.coffeeAmount += coffeeAmount;
        if (coffeeAmount > maxCoffeeAmount) {
            this.coffeeAmount = maxCoffeeAmount;
        }
    }

    public void addWater(int waterAmount) {
        this.waterAmount += waterAmount;
        if (waterAmount > maxWaterAmount) {
            this.waterAmount = maxWaterAmount;
        }
    }

    public void makeCoffee() {
        int coffeePortion = 10;
        int waterPortion = 200;
        if (coffeeAmount < coffeePortion) {
            System.out.println("Приготовление кофе невозможно, добавьте кофе");
        }
        if (waterAmount < waterPortion) {
            System.out.println("Приготовление кофе невозможно, добавьте воды");
        }
        if (coffeeAmount >= coffeePortion && waterAmount >= waterPortion) {
            coffeeAmount -= coffeePortion;
            waterAmount -= waterPortion;
            System.out.println("Кофе готов");
        }

    }
}
