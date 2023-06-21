package pl.opole.uni.springWebApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.opole.uni.springWebApp.models.Address;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
  // Przykładowe metody do pobierania danych
  List<Address> findByCity(String city);
  List<Address> findByPostalCode(String postalCode);
}

