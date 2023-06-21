package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  // Przykładowe metody do pobierania danych
  List<Category> findByName(String name);
}

