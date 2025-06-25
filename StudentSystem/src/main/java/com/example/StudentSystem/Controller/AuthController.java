package com.example.StudentSystem.Controller;

import com.example.StudentSystem.model.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        // This is just a dummy response; actual token logic can be added later
        return ResponseEntity.ok("Login successful for user: " + loginRequest.getUsername());
    }
}