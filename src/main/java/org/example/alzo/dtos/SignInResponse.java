package org.example.alzo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponse {
    private Long userID;
    private String email;
    private String firstName;
    private String lastName;
    private int age;
    private String medicalCondition;
    private String emergencyContact;
}
