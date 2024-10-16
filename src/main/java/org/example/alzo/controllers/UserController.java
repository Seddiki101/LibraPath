package org.example.alzo.controllers;

import lombok.AllArgsConstructor;
import org.example.alzo.dtos.SignInRequest;
import org.example.alzo.dtos.SignInResponse;
import org.example.alzo.dtos.SignUpRequest;
import org.example.alzo.entities.Task;
import org.example.alzo.entities.User;
import org.example.alzo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        User user = userService.signUp(signUpRequest);
        if(user != null)
        return ResponseEntity.ok(user);
        else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        SignInResponse response = userService.signIn(signInRequest);

        if (response != null ) return ResponseEntity.ok(response);

        else return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }


    @GetMapping("/hola")
    public String Hello()
    {
        return "hello";
    }


    @GetMapping("/{userId}/tasks")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = userService.getTasksByUserId(userId);

        // Check if tasks is null or empty
        if (tasks == null || tasks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(tasks);
    }



}