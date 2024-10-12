package org.example.alzo.services;

import org.example.alzo.entities.Reminder;
import org.example.alzo.dtos.ReminderRequest;

import java.util.List;

public interface ReminderService {
    // Define service methods here
    Reminder createReminder(ReminderRequest reminderRequest);
    List<Reminder> getRemindersByTask(Long taskId);
    void deleteReminder(Long reminderId);



}