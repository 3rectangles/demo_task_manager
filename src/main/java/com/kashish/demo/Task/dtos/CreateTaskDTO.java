package com.kashish.demo.Task.dtos;

import lombok.*;

import java.util.Date;

@Data
public class CreateTaskDTO {
    String name;
    Date dueDate;

    public Date getDuedate() {
        return dueDate;
    }
}
