package com.test_task;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class ToDoList {
    private LinkedList<Task> tasks;
    private Scanner in;

    public ToDoList(){
        tasks = new LinkedList<>();
        in = new Scanner(System.in);
    }

    public void addTask(){
        String description;
        System.out.print("Введите описание задачи: ");
        description = in.nextLine();
        tasks.add(new Task(description));
    }

    public void viewTasks(){
        if (tasks.isEmpty()) {
            System.out.println("Список пуст!");
        }
        else {
            for (int i = 0; i < tasks.size(); i++){
                System.out.println((i + 1) + ". " + tasks.get(i).toString());
            }
        }
    }

    private int getTaskNumber(){
        int taskNumber = 0;
        boolean validInput = false;
        do {
            try {
                System.out.print("Введите номер задачи: ");
                taskNumber = in.nextInt();
                in.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввести число!");
                in.hasNextLine();
            }
        }
        while (!validInput);
        return taskNumber;
    }

    public void markTaskAsCompleted(){
        if (!tasks.isEmpty()) {
            viewTasks();
            int taskNumber = getTaskNumber();
            if (taskNumber < 1 || taskNumber > tasks.size())
                System.out.println("Неправильный номер задачи!");
            else {
                tasks.get(taskNumber - 1).markAsCompleted();
                System.out.println("Задача помечена как выполненная!");
            }
        }
        else
            System.out.println("Список пуст!");
    }

    public void deleteTask(){
        if (!tasks.isEmpty()) {
            viewTasks();
            int taskNumber = getTaskNumber();
            if (taskNumber < 1 || taskNumber > tasks.size())
                System.out.println("Неправильный номер задачи!");
            else {
                tasks.remove(taskNumber - 1);
                System.out.println("Задача удалена!");
            }
        }
        else
            System.out.println("Список пуст!");
    }

}
