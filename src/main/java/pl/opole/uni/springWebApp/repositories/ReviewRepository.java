package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.AppUser;
import pl.opole.uni.springWebApp.models.Product;
import pl.opole.uni.springWebApp.models.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  // Przykładowe metody do pobierania danych
  List<Review> findByProduct(Product product);
  List<Review> findByUser(AppUser appUser);
}

