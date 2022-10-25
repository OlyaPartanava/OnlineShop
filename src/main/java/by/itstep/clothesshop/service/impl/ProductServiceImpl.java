package by.itstep.clothesshop.service.impl;

import by.itstep.clothesshop.model.Product;

import by.itstep.clothesshop.model.ProductDescription;
import by.itstep.clothesshop.repository.ProductRepository;
import by.itstep.clothesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    public void delete(Product product) {
        repository.delete(product);
    }

    public Product save(Product product) {
        return repository.save(product);
    }


    public Product getById(Integer id) {
        return repository.findById(id).get();

    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }
}
//    @Override
//    public List<ProductDescription> getOrderPage(String prodName) {
//        return    repository.findAllProductsByProductName(prodName);
//
//    }}


//    @Override
//    public List <Product> getPageAllProducts() {
//      return   repository.findAll();
//
//    }

//    @Override
//    public void getPageAllProducts() {
//
//    }


//    @Override
//    public void getPageAllProducts() {
//        List<Product> products = productRepository.findAll();
//        model.addAttribute("lady", products.stream().filter(x -> x.getCategory().getId().equals(2)).collect(Collectors.toList()));
//        model.addAttribute("man", products.stream().filter(x -> x.getCategory().getId().equals(3)).collect(Collectors.toList()));
////        model.addAttribute("products", products)
//    }
//}