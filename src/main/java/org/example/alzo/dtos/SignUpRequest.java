package org.example.alzo.dtos;

import lombok.Data;

@Data
public class SignUpRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String medicalCondition;
    private String emergencyContact;
}
