package com.kashish.demo.Task.dtos;

import lombok.*;

import java.util.Date;

@Data
public class ResponseBodyDTO {
    public ResponseBodyDTO(String name, Date dueDate, boolean completed) {
        this.name = name;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    private String name;
    private Date dueDate;
    private boolean completed;


}
