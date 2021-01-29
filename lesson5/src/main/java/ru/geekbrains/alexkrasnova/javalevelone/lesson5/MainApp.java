package ru.geekbrains.alexkrasnova.javalevelone.lesson5;

import ru.geekbrains.alexkrasnova.javalevelone.lesson5.audiosystem.AudioSystem;
import ru.geekbrains.alexkrasnova.javalevelone.lesson5.audiosystem.Brand;
import ru.geekbrains.alexkrasnova.javalevelone.lesson5.audiosystem.Mode;
import ru.geekbrains.alexkrasnova.javalevelone.lesson5.coffeemachine.CoffeeMachine;

public class MainApp {
    public static void main(String[] args) {
        testEmployee();
        testAudioSystem();
        testCoffeeMachine();
    }

    public static void testEmployee() {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Василий Андреевич Пупкин", "директор", "vasiliy@gmail.com", "+7-905-234-22-54", 100000, 45);
        employees[1] = new Employee("Иван Алексеевич Иванов", "замдиректор", "ivanov@gmail.com", "+7-909-353-13-15", 70000, 39);
        employees[2] = new Employee("Камилла Алексеевна Яблонская", "старший научный сотрудник", "kamilla@yahoo.com", "+7-903-271-22-24", 60000, 51);
        employees[3] = new Employee("Александр Александрович Шишкин", "ведущий научный сотрудник", "a.a.shishkin@mail.ru", "+7-909-113-55-44", 65000, 77);
        employees[4] = new Employee("Андрей Андреевич Сидоров", "инженер", "tortik@gmail.com", "+7-909-433-14-54", 10000, 21);

        int age = 40;
        for (Employee employee : employees) {
            if (employee.isOlder(age)) {
                employee.printInfo();
            }
        }
    }

    public static void testAudioSystem() {
        AudioSystem audioSystem = new AudioSystem(Brand.SONY, "Черный");
        audioSystem.printInfo();
        audioSystem.play();
        audioSystem.turnOn();
        audioSystem.play();
        audioSystem.nextTrack();
        audioSystem.nextTrack();
        audioSystem.previousTrack();
        audioSystem.setMode(Mode.USB);
        audioSystem.printInfo();
        audioSystem.stop();
        audioSystem.play();
        audioSystem.setMode(Mode.PC);
        audioSystem.printInfo();
        audioSystem.setVolume(10);
        audioSystem.printInfo();
        audioSystem.setVolume(50);
        audioSystem.turnOff();

    }

    public static void testCoffeeMachine() {
        CoffeeMachine coffeeMachine = new CoffeeMachine("De'Longhi", "серебристый", 250, 1500);
        coffeeMachine.printInfo();
        coffeeMachine.makeCoffee();
        coffeeMachine.addCoffee(200);
        coffeeMachine.printInfo();
        coffeeMachine.makeCoffee();
        coffeeMachine.addWater(2000);
        coffeeMachine.printInfo();
        coffeeMachine.makeCoffee();
        coffeeMachine.printInfo();
        CoffeeMachine coffeeMachine1 = new CoffeeMachine("Philips", "черный", 200, 1000);
        coffeeMachine1.addCoffee(500);
        coffeeMachine1.makeCoffee();
        coffeeMachine1.addWater(2000);
        coffeeMachine1.printInfo();
        coffeeMachine1.makeCoffee();
    }
}
