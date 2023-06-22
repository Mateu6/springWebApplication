package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.AppUser;
import pl.opole.uni.springWebApp.models.Role;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
  // Przykładowe metody do pobierania danych
  AppUser findByUsername(String username);
  List<AppUser> findByEmail(String email);
  Role findRoleByName(String roleName); // Dodana metoda do wyszukiwania roli po nazwie
}

