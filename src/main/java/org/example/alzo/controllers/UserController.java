package org.example.alzo.controllers;

import lombok.AllArgsConstructor;
import org.example.alzo.dtos.SignInRequest;
import org.example.alzo.dtos.SignInResponse;
import org.example.alzo.dtos.SignUpRequest;
import org.example.alzo.entities.User;
import org.example.alzo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody SignUpRequest signUpRequest) {
        User user = userService.signUp(signUpRequest);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest signInRequest) {
        SignInResponse response = userService.signIn(signInRequest);
        return ResponseEntity.ok(response);  // Return user details in the response
    }


    @GetMapping("/hola")
    public String Hello()
    {
        return "hello";
    }

}