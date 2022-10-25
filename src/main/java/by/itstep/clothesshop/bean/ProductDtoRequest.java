package by.itstep.clothesshop.bean;

import by.itstep.clothesshop.model.Category;
import by.itstep.clothesshop.model.Order;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class ProductDtoRequest {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString

    public class Product {


        private Integer id;
        private String nameProduct;
        private String descriptionProduct;
        private BigDecimal priceProduct;
        private Integer numberProduct;
        private Category category;
        private List<Order> orders;
    }
}
