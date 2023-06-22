package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.Order;
import pl.opole.uni.springWebApp.models.AppUser;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  // Przykładowe metody do pobierania danych
  List<Order> findByUser(AppUser appUser);
  List<Order> findByStatus(String status);
}

