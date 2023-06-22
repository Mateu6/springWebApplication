package pl.opole.uni.springWebApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.transaction.annotation.Transactional;
import pl.opole.uni.springWebApp.models.AppUser;
import pl.opole.uni.springWebApp.models.Role;
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
  @Autowired
  UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public AppUser createUser(AppUser appUser) {
    // zapisanie użytkownika
    return userRepository.save(appUser);
  }

  public AppUser updateUser(Long id, AppUser appUser) {
    // aktualizacja użytkownika
    return userRepository.save(appUser);
  }

  public boolean deleteUser(Long userId) {
    // usuwanie użytkownika
    userRepository.deleteById(userId);
    return false;
  }

  public AppUser getUserById(Long userId){
    // pobieranie użytkownika po ID
    return userRepository.findById(userId)
      .orElseThrow(() -> new UserNotFoundException("User not found"));
  }

  public void saveUser (AppUser appUser) {
    userRepository.save(appUser);
  }

  public List<AppUser> getAllUsers() {
    // pobieranie wszystkich użytkowników
    return userRepository.findAll();
  }

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return (UserDetails) userRepository.findByUsername(username);
  }

  public void assignAdminRoleToUser(Long userId) {
    AppUser user = userRepository.findById(userId)
      .orElseThrow(() -> new UserNotFoundException("User not found"));

    Role adminRole = userRepository.findRoleByName("admin");
    if (adminRole == null) {
      adminRole = new Role();
      adminRole.setName("admin");
    }

    user.addRole(adminRole);
    userRepository.save(user);
  }

}

