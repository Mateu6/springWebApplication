package pl.opole.uni.springWebApp.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.opole.uni.springWebApp.models.Product;
import pl.opole.uni.springWebApp.repositories.ProductRepository;

import java.util.List;

@ResponseStatus(HttpStatus.NOT_FOUND)
class ProductNotFoundException extends RuntimeException {
  public ProductNotFoundException(String message) {
    super(message);
  }
}

@Service
@Transactional
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product createProduct(Product product) {
    // logika walidacji i przetwarzania danych

    // zapisanie produktu
    return productRepository.save(product);
  }

  public Product updateProduct(Product product) {
    // logika walidacji i przetwarzania danych

    // aktualizacja produktu
    return productRepository.save(product);
  }

  public void deleteProduct(Long productId) {
    // usuwanie produktu
    productRepository.deleteById(productId);
  }

  public Product getProductById(Long productId) {
    // pobieranie produktu po ID
    return productRepository.findById(productId)
      .orElseThrow(() -> new ProductNotFoundException("Product not found"));
  }

  public List<Product> getAllProducts() {
    // pobieranie wszystkich produktów
    return productRepository.findAll();
  }
}

