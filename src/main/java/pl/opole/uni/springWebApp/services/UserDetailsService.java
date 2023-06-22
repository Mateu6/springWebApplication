package pl.opole.uni.springWebApp.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.opole.uni.springWebApp.models.AppUser;
import pl.opole.uni.springWebApp.models.Role;
import pl.opole.uni.springWebApp.repositories.UserRepository;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser appUser = userRepository.findByUsername(username);
    if (appUser == null) {
      throw new UsernameNotFoundException("Invalid username or password.");
    }
    return new org.springframework.security.core.userdetails.User(
      appUser.getUsername(),
      appUser.getPassword(),
      appUser.isEnabled(),
      true,
      true,
      true,
      getAuthorities(appUser.getRoles())
    );
  }

  private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
    return roles.stream()
      .map(role -> new SimpleGrantedAuthority(role.getName()))
      .collect(Collectors.toList());
  }
}

