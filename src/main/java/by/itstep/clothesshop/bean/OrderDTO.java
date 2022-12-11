package by.itstep.clothesshop.bean;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {

    private Integer id;
    private String nameOrder;
    private String statusOrder;
    private Double totalPrice;
    private List<ProductDTO> products = new ArrayList<>();
}