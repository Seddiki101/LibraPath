package org.example.alzo.controllers;

import lombok.AllArgsConstructor;
import org.example.alzo.dtos.TaskRequest;
import org.example.alzo.dtos.TaskUpdateRequest;
import org.example.alzo.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.alzo.entities.User;
import org.example.alzo.entities.Task;

@RestController
@AllArgsConstructor
@RequestMapping("/task")
public class TaskController {
    // Controller methods here
    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask(@RequestBody TaskRequest taskRequest) {
        Task task = taskService.createTask(taskRequest);

        if (task != null)
            return ResponseEntity.ok(task);
        else  return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody TaskUpdateRequest taskUpdateRequest) {
        Task updatedTask = taskService.updateTask(taskUpdateRequest);
        if (updatedTask != null)
            return ResponseEntity.ok(updatedTask);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}