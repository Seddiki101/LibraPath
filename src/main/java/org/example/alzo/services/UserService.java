package org.example.alzo.services;

import org.example.alzo.dtos.SignInRequest;
import org.example.alzo.dtos.SignInResponse;
import org.example.alzo.dtos.SignUpRequest;
import org.example.alzo.entities.Task;
import org.example.alzo.entities.User;

import java.util.List;

public interface UserService {
    // Define service methods here
    User signUp(SignUpRequest signUpRequest);
    SignInResponse signIn(SignInRequest signInRequest);

    List<Task> getTasksByUserId(Long userId);
}