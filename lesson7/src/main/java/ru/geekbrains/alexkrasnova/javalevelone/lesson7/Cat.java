package ru.geekbrains.alexkrasnova.javalevelone.lesson7;

public class Cat {
    private String name;
    private boolean satiety;
    private int appetite;
    private Plate plate;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public boolean isFull() {
        return satiety;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        if (!satiety) {
            System.out.printf("Кот %s пытается поесть из тарелки %d. ", name, plate.getNumber());
            if (plate.getFoodAmount() >= appetite) {
                satiety = true;
                System.out.println("Кот поел и теперь сыт.");
                plate.takeFood(appetite);
            } else {
                System.out.println("В тарелке недостаточно еды.");
            }

        } else {
            System.out.printf("Кот %s не голоден.\n", name);
        }
    }
}
