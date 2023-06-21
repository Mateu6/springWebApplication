package pl.opole.uni.springWebApp.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
    User updatedUser = userService.updateUser(userId, user);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{userId}")
  public ResponseEntity<User> getUser(@PathVariable Long userId) {
    User user = userService.getUserById(userId);
    return ResponseEntity.ok(user);
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
  }
}


