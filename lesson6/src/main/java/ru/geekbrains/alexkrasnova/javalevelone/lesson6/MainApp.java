package ru.geekbrains.alexkrasnova.javalevelone.lesson6;

import ru.geekbrains.alexkrasnova.javalevelone.lesson6.animals.Animal;
import ru.geekbrains.alexkrasnova.javalevelone.lesson6.animals.Cat;
import ru.geekbrains.alexkrasnova.javalevelone.lesson6.animals.Dog;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();

        Dog dog1 = new Dog("Жучка");
        Dog.printCount();
        animals.add(dog1);

        Cat cat1 = new Cat("Мурка");
        Cat.printCount();
        animals.add(cat1);

        Animal cat2 = new Cat("Кисоня");
        Cat.printCount();
        animals.add(cat2);

        Dog dog2 = new Dog("Лада");
        Dog.printCount();
        animals.add(dog2);

        Dog dog3 = new Dog("Рекс");
        Dog.printCount();
        animals.add(dog3);

        Dog dog4 = new Dog("Кора");
        Dog.printCount();
        animals.add(dog4);

        Dog dog5 = new Dog("Джек");
        Dog.printCount();
        animals.add(dog5);

        Cat cat3 = new Cat("Барсик");
        Cat.printCount();
        animals.add(cat3);
        System.out.println();

        for (Animal animal : animals) {
            animal.run(100);
            animal.swim(50);
            animal.run(600);
            animal.swim(500);
            System.out.println();
        }


    }
}
