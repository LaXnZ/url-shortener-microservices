package main.java.com.urlshortener.user_service.controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestParam String username, @RequestParam String password) {
        // Normally, you'd save this in a database with hashing.
        return Map.of("message", "User registered successfully", "username", username);
    }

    @GetMapping("/profile")
    public Map<String, String> getUserProfile(@RequestParam String username) {
        return Map.of("username", username, "status", "active");
    }
}
