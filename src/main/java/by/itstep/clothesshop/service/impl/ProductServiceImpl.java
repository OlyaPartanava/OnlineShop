package by.itstep.clothesshop.service.impl;

import by.itstep.clothesshop.bean.ProductDTO;
import by.itstep.clothesshop.converter.IProductConverter;
import by.itstep.clothesshop.model.Category;
import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.repository.ProductRepository;
import by.itstep.clothesshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private IProductConverter productConverter;

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product save(ProductDTO productdto) {
        Product product = productConverter.fromDTO(productdto);
        return repository.save(product);
    }


    @Override
    public List<ProductDTO> findAll() {
        List<Product> productList = repository.findAll();
        List<ProductDTO> resultList = new ArrayList<>();
        for (Product product : productList) {

            resultList.add(productConverter.toDto(product));
        }
        return resultList;
    }

    @Override
    public List<ProductDTO> findByCategory(Category categoryName) {

        if (categoryName != null) {
            List<Product> productList = repository.findByCategory(categoryName);
            List<ProductDTO> resultList = new ArrayList<>();
            for (Product product : productList) {

                resultList.add(productConverter.toDto(product));
            }
            return resultList;
        }
        return new ArrayList<>();
    }

    @Override
    public void delete(Integer id) {
        String tes = null;
        try {
            repository.deleteById(id);
            tes = "all gight";
        } catch (Exception e) {
            tes = "ERROR";
        }
    }

    public ProductDTO getProductById(Integer id) {
        Product product = repository.findById(id).get();
        return productConverter.toDto(product);
    }

    public Product getProductByIdd(Integer id) {
        return productRepository.getProductById(id);
    }

}

