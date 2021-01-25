package ru.geekbrains.alexkrasnova.javalevelone.lesson5;

public class MainApp {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Василий Андреевич Пупкин", "директор", "vasiliy@gmail.com", "+7-905-234-22-54", 100000, 45);
        employees[1] = new Employee("Иван Алексеевич Иванов", "замдиректор", "ivanov@gmail.com", "+7-909-353-13-15", 70000, 39);
        employees[2] = new Employee("Камилла Алексеевна Яблонская", "старший научный сотрудник", "kamilla@yahoo.com", "+7-903-271-22-24", 60000, 51);
        employees[3] = new Employee("Александр Александрович Шишкин", "ведущий научный сотрудник", "a.a.shishkin@mail.ru", "+7-909-113-55-44", 65000, 77);
        employees[4] = new Employee("Андрей Андреевич Сидоров", "инженер", "tortik@gmail.com", "+7-909-433-14-54", 10000, 21);

        int age = 40;
        for (Employee employee : employees) {
            if(employee.isOlder(age)) {
                employee.printInfo();
            }
        }

    }
}
