package pl.opole.uni.springWebApp.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.opole.uni.springWebApp.models.AppUser;
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
  public ResponseEntity<AppUser> createUser(@RequestBody AppUser appUser) {
    AppUser createdAppUser = userService.createUser(appUser);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdAppUser);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<AppUser> updateUser(@PathVariable Long userId, @RequestBody AppUser appUser) {
    AppUser updatedAppUser = userService.updateUser(userId, appUser);
    return ResponseEntity.ok(updatedAppUser);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{userId}")
  public ResponseEntity<AppUser> getUser(@PathVariable Long userId) {
    AppUser appUser = userService.getUserById(userId);
    return ResponseEntity.ok(appUser);
  }

  @GetMapping
  public ResponseEntity<List<AppUser>> getAllUsers() {
    List<AppUser> appUsers = userService.getAllUsers();
    return ResponseEntity.ok(appUsers);
  }
}


