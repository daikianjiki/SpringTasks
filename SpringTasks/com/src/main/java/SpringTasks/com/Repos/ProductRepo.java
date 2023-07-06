package SpringTasks.com.Repos;

import SpringTasks.com.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();

    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    @Query("SELECT COUNT(*) FROM Product")
    long countAllProducts();
}
