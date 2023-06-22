package pl.opole.uni.springWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.opole.uni.springWebApp.models.AppUser;
import pl.opole.uni.springWebApp.models.Role;
import pl.opole.uni.springWebApp.repositories.RoleRepository;
import pl.opole.uni.springWebApp.repositories.UserRepository;

import java.util.Collections;
import java.util.HashSet;

@Component
public class UserInitializer {

  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @EventListener
  public void onApplicationEvent(ContextRefreshedEvent event) {
    //initUsers();
  }

  private void initUsers() {
    Role adminRole = roleRepository.findByName("admin");
    if (adminRole == null) {
      adminRole = new Role();
      adminRole.setName("admin");
      roleRepository.save(adminRole);
    }
    Role userRole = Role.createUserRole();

    AppUser adminUser = new AppUser();
    adminUser.setUsername("admin1");
    adminUser.setPassword(passwordEncoder.encode("admin123"));
    adminUser.setEnabled(true);
    adminUser.addRole(adminRole);

    AppUser regularUser = new AppUser();
    regularUser.setUsername("user");
    regularUser.setPassword(passwordEncoder.encode("user123"));
    regularUser.setEnabled(true);
    regularUser.addRole(userRole);

    userRepository.save(adminUser);
    userRepository.save(regularUser);
  }

  private Role createRoleIfNotFound(String roleName) {
    Role role = roleRepository.findByName(roleName);
    if (role == null) {
      role = new Role();
      role.setName(roleName);
      roleRepository.save(role);
    } else {
      if (!role.getName().equals(roleName)) {
        role.setName(roleName);
        roleRepository.save(role);
      }
    }
    return role;
  }

  private AppUser createUserIfNotFound(String username, String password, Role role) {
    AppUser user = userRepository.findByUsername(username);
    if (user == null) {
      user = new AppUser();
      user.setUsername(username);
      user.setPassword(passwordEncoder.encode(password));
      user.setEnabled(true);
      user.setRoles(new HashSet<>(Collections.singletonList(role)));
      userRepository.save(user);
    }
    return user;
  }
}
