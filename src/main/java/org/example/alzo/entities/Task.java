package org.example.alzo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.example.alzo.entities.enums.Category;
import org.example.alzo.entities.enums.Frequency;

import java.util.Date;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long taskID;
    String description;
    @Enumerated(EnumType.STRING)
    Frequency frequency;
    @Enumerated(EnumType.STRING)
    DayOfWeek dayOfWeek;

    int dayOfMonth;
    LocalTime time;
    int intervale;
    boolean isCompleted;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    @JsonIgnore
    private List<Reminder> reminderList;


}
