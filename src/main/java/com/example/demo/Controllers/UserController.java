package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Enteties.User;
import com.example.demo.Services.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        return userService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> creds) {
        String email = creds.get("email");
        String motDePasse = creds.get("motDePasse");
        return userService.getByEmail(email)
                .filter(user -> user.getMotDePasse().equals(motDePasse))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
