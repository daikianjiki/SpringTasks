package SpringTasks.com.Services;

import SpringTasks.com.Models.Product;
import SpringTasks.com.Repos.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        if (productRepo.existsById(id)) {
            return new ResponseEntity<>(productRepo.findById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

    public ResponseEntity<Product> searchProductsByName(String name) {
        Product productByName = productRepo.findProductByName(name);
        return new ResponseEntity<>(productByName, HttpStatus.OK);
    }

    public ResponseEntity<Product> updateProduct(Product product, long id) {
        if (productRepo.existsById(id)) {
            Product updatedProduct = productRepo.findById(id).get();
            updatedProduct.setName(product.getName());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setDescription(product.getDescription());
            productRepo.save(updatedProduct);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteProduct(long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
