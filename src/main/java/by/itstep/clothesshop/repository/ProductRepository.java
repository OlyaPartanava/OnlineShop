package by.itstep.clothesshop.repository;


import by.itstep.clothesshop.model.Category;
import by.itstep.clothesshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(Category nameCategory);

    List<Product> findAll();

    List<Product> findByName(String name);

    void deleteById(Integer id);

    Product save(Product product);

    Product getProductById(Integer id);


}
