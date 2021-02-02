package ru.geekbrains.alexkrasnova.javalevelone.lesson7;

public class MainApp {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик", 30);
        Cat cat2 = new Cat("Барсик", 30);

        Plate plate1 = new Plate(20);
        plate1.fill();

        Plate plate2 = new Plate(50);
        plate2.addFood(30);
        plate2.addFood(30);
        plate2.addFood(30);

        Plate plate3 = new Plate(100);
        plate3.addFood(-100);
        plate3.addFood(100);

        cat1.eat(plate1);
        cat1.eat(plate2);
        cat1.eat(plate2);

        cat2.eat(plate2);
        cat2.eat(plate3);


    }
}
