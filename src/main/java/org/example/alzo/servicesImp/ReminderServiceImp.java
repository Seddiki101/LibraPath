package org.example.alzo.servicesImp;

import lombok.AllArgsConstructor;
import org.example.alzo.daos.ReminderRepository;
import org.example.alzo.daos.TaskRepository;
import org.example.alzo.entities.Reminder;
import org.example.alzo.dtos.ReminderRequest;
import org.example.alzo.services.ReminderService;
import org.springframework.stereotype.Service;
import org.example.alzo.entities.Task;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReminderServiceImp implements ReminderService {
    // Implement methods defined in the service interface
    private final ReminderRepository reminderRepository;
    private final TaskRepository taskRepository; // To associate reminders with tasks

    @Override
    public Reminder createReminder(ReminderRequest reminderRequest) {
        // Check if the task exists
        Task task = taskRepository.findById(reminderRequest.getTaskId())
                .orElseThrow(() -> new IllegalStateException("Task not found"));

        // Create a new reminder
        Reminder reminder = new Reminder();
        reminder.setTime(reminderRequest.getTime());
        reminder.setSent(reminderRequest.isSent());

        // Save the reminder
        return reminderRepository.save(reminder);
    }

    @Override
    public List<Reminder> getRemindersByTask(Long taskId) {
        // Retrieve all reminders associated with the specified task
        return reminderRepository.findAll()
                .stream()
                .filter(reminder -> reminder.getTask().getTaskID().equals(taskId)) // Adjust if necessary
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReminder(Long reminderId) {
        // Check if the reminder exists
        Reminder reminder = reminderRepository.findById(reminderId)
                .orElseThrow(() -> new IllegalStateException("Reminder not found"));

        // Delete the reminder
        reminderRepository.delete(reminder);
    }

}