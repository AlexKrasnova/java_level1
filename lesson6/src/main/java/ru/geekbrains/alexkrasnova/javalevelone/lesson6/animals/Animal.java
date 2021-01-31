package ru.geekbrains.alexkrasnova.javalevelone.lesson6.animals;

public abstract class Animal {

    protected static int animalCount;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static void printCount() {
        System.out.println("Количество животных " + animalCount);
    };
}
