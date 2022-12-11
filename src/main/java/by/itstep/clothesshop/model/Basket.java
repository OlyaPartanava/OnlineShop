package by.itstep.clothesshop.model;


import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "basket_id")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "totalPrice")
    private Double totalPrice;

    @Column(name = "totalItems")
    private int totalItems;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<CartItem> cartItem;
}
