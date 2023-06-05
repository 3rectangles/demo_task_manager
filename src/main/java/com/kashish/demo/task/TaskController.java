package com.kashish.demo.task;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    List<Task> tasklist= new ArrayList<>();
    private int nextTaskId=1;



    @GetMapping("")
    public List<Task> getAllTasks(){
        return  tasklist;

    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task task){
        task.setId(nextTaskId++);
        tasklist.add(task);
        return task;
    }

    //returns the first task thats equals to id
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Integer id) {
        System.out.println("\n\n\n#### " + id);
        for (Task x : tasklist) {
            if (x.getId().equals(id))
                return x;
        }
        return null;
    }

    }