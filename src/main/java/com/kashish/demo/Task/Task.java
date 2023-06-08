package com.kashish.demo.Task;

import lombok.*;

import java.util.Date;

@Data
public class Task {
    Integer id;
    String name;
    Date duedate;
    Boolean completed;



    public Task(Integer id, String name, Date duedate, Boolean completed) {
        this.id = id;
        this.name = name;
        this.duedate = duedate;
        this.completed = completed;
    }
}