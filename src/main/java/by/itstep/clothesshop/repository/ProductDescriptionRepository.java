package by.itstep.clothesshop.repository;

import by.itstep.clothesshop.model.Order;
import by.itstep.clothesshop.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Integer> {
    List<ProductDescription> findAllProductsByNameDescriptionProduct(String prodName);
}
