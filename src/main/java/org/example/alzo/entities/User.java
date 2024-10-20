package org.example.alzo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userID;
    String email;
    String password ;
    String firstName;
    String lastName;
    int age;
    String medicalCondition;
    String emergencyContact;
    String description ; //like what he does for work
    Date birthday ;
    String location;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    @JsonIgnore
    private List<Task> taskList;

}
