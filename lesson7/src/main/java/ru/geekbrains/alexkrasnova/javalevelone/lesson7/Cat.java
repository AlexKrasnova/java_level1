package ru.geekbrains.alexkrasnova.javalevelone.lesson7;

public class Cat {
    private String name;
    private boolean hungry;
    private int appetite;
    private Plate plate;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        hungry = true;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void eat(Plate plate) {
        if (hungry) {
            System.out.printf("Кот %s пытается поесть из тарелки %d. ", name, plate.getNumber());
            if (plate.getFoodAmount() >= appetite) {
                hungry = false;
                System.out.println("Кот поел и теперь сыт.");
                plate.takeFood(appetite);
                hungry = false;
            } else {
                System.out.println("В тарелке недостаточно еды.");
            }

        } else {
            System.out.printf("Кот %s не голоден.\n", name);
        }
    }
}
