package org.example.alzo.servicesImp;

import lombok.AllArgsConstructor;
import org.example.alzo.daos.TaskRepository;
import org.example.alzo.daos.UserRepository;
import org.example.alzo.dtos.TaskRequest;
import org.example.alzo.dtos.TaskUpdateRequest;
import org.example.alzo.entities.Task;
import org.example.alzo.entities.User;
import org.example.alzo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {
    // Implement methods defined in the service interface
    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Task createTask(TaskRequest taskRequest) {
        // Fetch the user associated with the task
        User user = userRepository.findById(taskRequest.getUserId())
                .orElseThrow(() -> new IllegalStateException("User not found"));

        // Create a new Task object and populate it with values from the request
        Task task = new Task();
        task.setDescription(taskRequest.getDescription());
        task.setFrequency(taskRequest.getFrequency());
        task.setDayOfWeek(taskRequest.getDayOfWeek());
        task.setDayOfMonth(taskRequest.getDayOfMonth());
        task.setTime(taskRequest.getTime());
        task.setIntervale(taskRequest.getInterval());
        task.setCompleted(taskRequest.isCompleted());
        task.setCategory(taskRequest.getCategory());
        task.setUser(user);  // Associate the task with the user

        // Save the task to the database
        return taskRepository.save(task);
    }



    @Override
    public Task updateTask(TaskUpdateRequest taskUpdateRequest) {
        // Fetch the existing task
        Task task = taskRepository.findById(taskUpdateRequest.getTaskId())
                .orElseThrow(() -> new IllegalStateException("Task not found"));

        // Update the task's attributes based on the request
        task.setDescription(taskUpdateRequest.getDescription());
        task.setFrequency(taskUpdateRequest.getFrequency());
        task.setDayOfWeek(taskUpdateRequest.getDayOfWeek());
        task.setDayOfMonth(taskUpdateRequest.getDayOfMonth());
        task.setTime(taskUpdateRequest.getTime());
        task.setIntervale(taskUpdateRequest.getInterval());
        task.setCompleted(taskUpdateRequest.isCompleted());
        task.setCategory(taskUpdateRequest.getCategory());

        // Save the updated task
        return taskRepository.save(task);
    }



}