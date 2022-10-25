package by.itstep.clothesshop.service.impl;

import by.itstep.clothesshop.model.ProductDescription;
import by.itstep.clothesshop.repository.ProductDescriptionRepository;
import by.itstep.clothesshop.repository.ProductRepository;
import by.itstep.clothesshop.service.ProductDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDescriptionImpl implements ProductDescriptionService {

    @Autowired
    private ProductDescriptionRepository productDescriptionRepository;
    @Override
    public List<ProductDescription> getProductPage(String prodName) {
        return productDescriptionRepository.findAllProductsByNameDescriptionProduct(prodName);

    }}

