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

import java.util.Optional;

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
        Optional<User> userOptional =  userRepository.findById(taskRequest.getUserId()) ;

        if (userOptional.isPresent()) {

            User user = userOptional.get();

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
        else return null;
    }



    @Override
    public Task updateTask(TaskUpdateRequest taskUpdateRequest) {

        Optional<Task> task = taskRepository.findById(taskUpdateRequest.getTaskId());

        if (task.isPresent()) {
            Task existingTask = task.get();  // Get the actual Task object


            existingTask.setDescription(taskUpdateRequest.getDescription());
            existingTask.setFrequency(taskUpdateRequest.getFrequency());
            existingTask.setDayOfWeek(taskUpdateRequest.getDayOfWeek());
            existingTask.setDayOfMonth(taskUpdateRequest.getDayOfMonth());
            existingTask.setTime(taskUpdateRequest.getTime());
            existingTask.setIntervale(taskUpdateRequest.getInterval());
            existingTask.setCompleted(taskUpdateRequest.isCompleted());
            existingTask.setCategory(taskUpdateRequest.getCategory());

            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }




}