package org.example.alzo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReminderRequest {

    private Long taskId;
    private LocalDateTime time;
    private boolean isSent;

}
