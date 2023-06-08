package com.kashish.demo.Task;

import com.kashish.demo.Task.dtos.CreateTaskDTO;
import com.kashish.demo.Task.dtos.ResponseBodyDTO;
import com.kashish.demo.Task.dtos.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TasksService tasksService;

    public TaskController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<ResponseBodyDTO>> getAllTasks() {
        List<Task> tasks = tasksService.getAllTasks();
        List<ResponseBodyDTO> responseBody = tasks.stream()
                .map(task -> new ResponseBodyDTO(task.getName(), task.getDuedate(), task.getCompleted()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("")
    ResponseEntity<ResponseBodyDTO> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        Task createdTask = tasksService.createTask(createTaskDTO.getName(), createTaskDTO.getDuedate());
        ResponseBodyDTO responseBody = new ResponseBodyDTO(createdTask.getName(), createdTask.getDuedate(), createdTask.getCompleted());
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseBodyDTO> getTaskById(@PathVariable("id") Integer id) {
        Task task = tasksService.getTaskById(id);
        ResponseBodyDTO responseBody = new ResponseBodyDTO(task.getName(), task.getDuedate(), task.getCompleted());
        return ResponseEntity.ok(responseBody);
    }

    @PatchMapping("/{id}")
    ResponseEntity<ResponseBodyDTO> updateTask(@PathVariable("id") Integer id, @RequestBody UpdateTaskDTO updateTaskDTO) {
        Task updatedTask = tasksService.updateTask(id,  updateTaskDTO.getDueDate(), updateTaskDTO.getCompleted());
        ResponseBodyDTO responseBody = new ResponseBodyDTO(updatedTask.getName(), updatedTask.getDuedate(), updatedTask.getCompleted());
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteTask(@PathVariable("id") Integer id) {
        tasksService.deleteTask(id);
        return ResponseEntity.ok("Task with ID " + id + " has been deleted.");
    }

    // Todo 5: create a ResponseBodyDTO - only return name, dueDate, completed

    // Todo 3 - handle exception for IllegalArgumentException (due date, name)
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // Todo 4 - in error responses, also send the error message in the response body
    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
