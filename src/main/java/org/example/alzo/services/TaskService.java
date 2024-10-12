package org.example.alzo.services;

import org.example.alzo.dtos.TaskRequest;
import org.example.alzo.dtos.TaskUpdateRequest;
import org.example.alzo.entities.Task;

public interface TaskService {
    // Define service methods here
    Task createTask(TaskRequest taskRequest);
    Task updateTask(TaskUpdateRequest taskUpdateRequest);
}