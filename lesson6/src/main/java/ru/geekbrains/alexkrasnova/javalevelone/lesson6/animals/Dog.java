package ru.geekbrains.alexkrasnova.javalevelone.lesson6.animals;

public class Dog extends Animal{

    private final int MAX_RUNNING_DISTANCE = 500;
    private final int MAX_SWIMMING_DISTANCE = 150;

    private static int dogCount;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUNNING_DISTANCE) {
            System.out.printf("Собака %s пробежала %d м\n", getName(), distance);
        } else if (distance > MAX_RUNNING_DISTANCE) {
            System.out.printf("Собака %s пробежала %d м, а потом устала.\n", getName(), MAX_RUNNING_DISTANCE);
        }

    }

    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIMMING_DISTANCE) {
            System.out.printf("Собака %s проплыла %d м\n", getName(), distance);
        } else if (distance > MAX_SWIMMING_DISTANCE) {
            System.out.printf("Собака %s проплыла %d м, а потом устала.\n", getName(), MAX_SWIMMING_DISTANCE);
        }
    }

    public static void printCount(){
        System.out.println("Количество собак " + dogCount);
        Animal.printCount();
    }
}
