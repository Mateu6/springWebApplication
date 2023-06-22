package pl.opole.uni.springWebApp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String name;

  @ManyToMany(mappedBy = "roles")
  private Set<AppUser> users;

  public Role() {
    this.users = new HashSet<>();
  }

  public Role(String name) {
    this.name = name;
    this.users = new HashSet<>();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<AppUser> getUsers() {
    return users;
  }

  public void setUsers(Set<AppUser> users) {
    this.users = users;
  }

  public static Role createAdminRole() {
    Role adminRole = new Role("admin");
    return adminRole;
  }

  public static Role createUserRole() {
    Role userRole = new Role("user");
    return userRole;
  }

  public void addUser(AppUser user) {
    this.users.add(user);
    user.getRoles().add(this);
  }

  public void removeUser(AppUser user) {
    this.users.remove(user);
    user.getRoles().remove(this);
  }
}

