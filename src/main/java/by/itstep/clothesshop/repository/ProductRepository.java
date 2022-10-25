package by.itstep.clothesshop.repository;


import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.model.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

  List<Product> findAll() ;
//  List<ProductDescription> findAllProductsByProductName(String prodName);

//    void getOrderPage(Integer prodId);
}

