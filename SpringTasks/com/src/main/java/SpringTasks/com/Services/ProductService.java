package SpringTasks.com.Services;

import SpringTasks.com.Models.Product;
import SpringTasks.com.Repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
