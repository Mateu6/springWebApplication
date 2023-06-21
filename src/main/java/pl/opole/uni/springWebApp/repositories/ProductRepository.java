package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.Category;
import pl.opole.uni.springWebApp.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  // Przykładowe metody do pobierania danych
  List<Product> findByNameContaining(String keyword);
  List<Product> findByCategory(Category category);
}
