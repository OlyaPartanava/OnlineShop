package by.itstep.clothesshop.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "ProdDescription")
public class ProductDescription {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String nameDescriptionProduct;

    @Column(name = "description")
    private String descriptionProduct;

    @Column(name = "price_product")
    private BigDecimal priceProduct;
    // кол-во товара
    @Column(name = "number_product")
    private Integer numberProduct;

    @Column(name = "size")
    private String size;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductDescription productDescription;

    @OneToMany
    private List<Order> orders;

}
