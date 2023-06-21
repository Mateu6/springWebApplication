package pl.opole.uni.springWebApp.services;


import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.transaction.annotation.Transactional;
import pl.opole.uni.springWebApp.models.User;
import pl.opole.uni.springWebApp.repositories.UserRepository;

import java.util.List;

// Definicja własnego wyjątku
@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}

@Service
@Transactional
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User createUser(User user) {
    // logika walidacji i przetwarzania danych

    // zapisanie użytkownika
    return userRepository.save(user);
  }

  public User updateUser(Long id, User user) {
    // logika walidacji i przetwarzania danych

    // aktualizacja użytkownika
    return userRepository.save(user);
  }

  public boolean deleteUser(Long userId) {
    // usuwanie użytkownika
    userRepository.deleteById(userId);
    return false;
  }

  public User getUserById(Long userId){
    // pobieranie użytkownika po ID
    return userRepository.findById(userId)
      .orElseThrow(() -> new UserNotFoundException("User not found"));
  }

  public List<User> getAllUsers() {
    // pobieranie wszystkich użytkowników
    return userRepository.findAll();
  }
}

