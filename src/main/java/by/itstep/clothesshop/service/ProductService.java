package by.itstep.clothesshop.service;

import by.itstep.clothesshop.bean.ProductDTO;
import by.itstep.clothesshop.model.Category;
import by.itstep.clothesshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    void delete(Integer product);


    List<ProductDTO> findAll();


    Product save(ProductDTO productDTO);


    ProductDTO getProductById(Integer id);

    Product getProductByIdd(Integer id);


    List<ProductDTO> findByCategory(Category categoryName);


}