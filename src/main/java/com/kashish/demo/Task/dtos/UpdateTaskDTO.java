package com.kashish.demo.Task.dtos;

import lombok.*;

import java.util.Date;

@Data
public class UpdateTaskDTO{
    Date dueDate;
    Boolean completed;
}