package com.test_task;

public class Task {

    private final String description;
    private boolean completed = false;

    public Task(String description){
        this.description = description;
    }

    public void markAsCompleted(){
        completed = true;
    }

    @Override
    public String toString(){
        return "[" + (completed ? "X" : "") + "] " + description;
    }
}
