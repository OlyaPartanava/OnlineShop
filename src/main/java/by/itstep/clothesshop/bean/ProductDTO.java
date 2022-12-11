package by.itstep.clothesshop.bean;

import by.itstep.clothesshop.model.Category;
import by.itstep.clothesshop.model.SizeProd;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Double price;
    private int currentQuantity;
    private String image;
    private Category category;
    private SizeProd size;
    private boolean is_deleted;
    private boolean is_activated;
}

