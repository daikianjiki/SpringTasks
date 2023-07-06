package SpringTasks.com.Services;

import SpringTasks.com.Models.Product;
import SpringTasks.com.Repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    public ResponseEntity<Product> createProduct(Product product) {
        return new ResponseEntity<>(productRepo.save(product), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> getProductById(long id) {
        return new ResponseEntity<>(productRepo.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> getAllSortedProducts() {
        List<Product> sortedProducts = productRepo.findAllSortedByPrice();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    public ResponseEntity<List<Product>> filterProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> filteredProducts = productRepo.findByPriceBetween(minPrice, maxPrice);
        return new ResponseEntity<>(filteredProducts, HttpStatus.OK);
    }

    public ResponseEntity<Long> getProductCount() {
        long countedProducts = productRepo.countAllProducts();
        return new ResponseEntity<>(countedProducts, HttpStatus.OK);
    }
}
