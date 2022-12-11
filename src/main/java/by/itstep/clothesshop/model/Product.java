package by.itstep.clothesshop.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description", length = 1000)
    private String description;

    @Column(name = "product_price", columnDefinition = "text")
    private Double price;

    @Column(name = "product_currentQuantity")
    private int currentQuantity;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.ORDINAL)
    private SizeProd size;
    @Column(name = "product_is_deleted")
    private boolean is_deleted;
    @Column(name = "product_is_activated")
    private boolean is_activated;
}