package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  // Przykładowe metody do pobierania danych
  List<User> findByUsername(String username);
  List<User> findByEmail(String email);
}

