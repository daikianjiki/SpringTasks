package SpringTasks.com.Controllers;

import SpringTasks.com.Models.Product;
import SpringTasks.com.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @GetMapping("sorted")
    public ResponseEntity<List<Product>> getAllSortedProducts() {
        return productService.getAllSortedProducts();
    }

    @GetMapping("filter")
    public ResponseEntity<List<Product>> filterProductsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productService.filterProductsByPriceRange(minPrice, maxPrice);
    }
}
