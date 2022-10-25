package by.itstep.clothesshop.service;

import by.itstep.clothesshop.model.ProductDescription;

import java.util.List;

public interface ProductDescriptionService {
    List<ProductDescription> getProductPage(String prodName);
}
