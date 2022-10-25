package by.itstep.clothesshop.service;

import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.model.ProductDescription;

import java.util.List;

public interface ProductService {
    void delete(Product product);
    Product save(Product product);

//    List<Product> getAll();

    Product getById(Integer id);

    List<Product> getAll();

//   List <ProductDescription> getOrderPage(String prodName);



   // вывести все товары
//   List<Product> getPageAllProducts();

}

