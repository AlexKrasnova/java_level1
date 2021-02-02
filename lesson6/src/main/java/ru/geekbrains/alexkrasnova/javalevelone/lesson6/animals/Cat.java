package ru.geekbrains.alexkrasnova.javalevelone.lesson6.animals;

public class Cat extends Animal{

    private final int MAX_RUNNING_DISTANCE = 200;
    private static int catCount;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUNNING_DISTANCE) {
            System.out.printf("Котик %s пробежал %d м\n", getName(), distance);
        } else if (distance > MAX_RUNNING_DISTANCE) {
            System.out.printf("Кошка %s пробежала %d м, а потом устала.\n", getName(), MAX_RUNNING_DISTANCE);
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умеют плавать.");
    }

    public static void printCount() {
        System.out.println("Количество кошек " + catCount);
        Animal.printCount();
    }


}
