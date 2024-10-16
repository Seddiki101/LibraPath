package org.example.alzo.controllers;

import lombok.AllArgsConstructor;
import org.example.alzo.dtos.ReminderRequest;
import org.example.alzo.entities.Reminder;
import org.example.alzo.services.ReminderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.alzo.entities.User;
import org.example.alzo.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/reminder")
@AllArgsConstructor
public class ReminderController {
    // Controller methods here
    private final ReminderService reminderService;

    @PostMapping("/create")
    public ResponseEntity<Reminder> createReminder(@RequestBody ReminderRequest reminderRequest) {
        Reminder reminder = reminderService.createReminder(reminderRequest);
        if(reminder != null)
             return ResponseEntity.ok(reminder);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    // 2. Get all reminders for a task
    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Reminder>> getRemindersByTask(@PathVariable Long taskId) {
        List<Reminder> reminders = reminderService.getRemindersByTask(taskId);
        return ResponseEntity.ok(reminders);
    }

    // 3. Delete a reminder
    @DeleteMapping("/{reminderId}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long reminderId) {
        reminderService.deleteReminder(reminderId);
        return ResponseEntity.noContent().build();
    }

}