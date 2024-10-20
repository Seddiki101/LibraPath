package org.example.alzo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private String description ;
    private Date birthday ;
}
