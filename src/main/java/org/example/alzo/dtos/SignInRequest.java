package org.example.alzo.dtos;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
