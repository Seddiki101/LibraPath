package org.example.alzo.dtos;

import lombok.Data;
import org.example.alzo.entities.enums.Category;
import org.example.alzo.entities.enums.Frequency;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
public class TaskUpdateRequest {
    private Long taskId;
    private String description;
    private Frequency frequency;
    private DayOfWeek dayOfWeek;
    private int dayOfMonth;
    private LocalTime time;
    private int interval;
    private boolean isCompleted;
    private Category category;
}
