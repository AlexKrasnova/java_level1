package ru.geekbrains.alexkrasnova.javalevelone.lesson5;

public class Employee {

    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.printf("Имя: %s; Должность: %s; E-mail: %s; Телефон: %s; Зарплата: %d; Возраст: %d. \n", name, position, email, phoneNumber, salary, age);
    }

    public boolean isOlder(int age) {
        if (this.age >= age) {
            return true;
        }
        return false;
    }
}
