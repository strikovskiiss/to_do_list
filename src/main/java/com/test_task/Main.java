package com.test_task;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("""
                Добро пожаловать в приложение To-Do List!
                1. Добавить новую задачу
                2. Просмотреть список задач
                3. Отметить задачу как выполненную
                4. Удалить задачу
                5. Выход
                """);
        int choice;
        var toDoList = new ToDoList();
        var in = new Scanner(System.in);
        do {
            System.out.print("Выберите действие (введите номер): ");
            try {
                choice = in.nextInt();
                switch (choice){
                    case 1 -> toDoList.addTask();
                    case 2 -> toDoList.viewTasks();
                    case 3 -> toDoList.markTaskAsCompleted();
                    case 4 -> toDoList.deleteTask();
                    case 5 -> System.out.println("До свидания!");
                    default -> System.out.println("Выберите действие из списка!");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Введите номер действия!");
                in.nextLine();
                choice = 0;
            }
        }
        while (choice != 5);
    }
}
