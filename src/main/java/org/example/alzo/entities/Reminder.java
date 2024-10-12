package org.example.alzo.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

import java.util.Date;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reminderID;
    LocalDateTime time;
    boolean isSent;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
