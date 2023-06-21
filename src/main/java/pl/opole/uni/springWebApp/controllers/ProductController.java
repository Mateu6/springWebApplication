package pl.opole.uni.springWebApp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.opole.uni.springWebApp.models.Product;
import pl.opole.uni.springWebApp.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  // Request mapping for creating a new product
  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    // Delegate to the productService to create the product
    Product createdProduct = productService.createProduct(product);
    return ResponseEntity.ok(createdProduct);
  }

  // Request mapping for updating an existing product
  @PutMapping("/{productId}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product product) {
    // Set the product ID based on the path variable
    product.setId(productId);

    // Delegate to the productService to update the product
    Product updatedProduct = productService.updateProduct(product);
    return ResponseEntity.ok(updatedProduct);
  }

  // Request mapping for retrieving a specific product
  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
    // Delegate to the productService to retrieve the product
    Product product = productService.getProductById(productId);
    return ResponseEntity.ok(product);
  }

  // Request mapping for deleting a product
  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
    // Delegate to the productService to delete the product
    productService.deleteProduct(productId);
    return ResponseEntity.noContent().build();
  }

  // Request mapping for retrieving all products
  @GetMapping
  public ResponseEntity<Object> getAllProducts() {
    // Delegate to the productService to retrieve all products
    List<Product> products = productService.getAllProducts();
    return ResponseEntity.ok(products);
  }

  // ... Additional request mappings for other product-related operations
}



