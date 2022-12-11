package by.itstep.clothesshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "order_orderDate")
    private Date orderDate;

    @Column(name = "order_deliveryDate")
    private Date deliveryDate;

    @Column(name = "order_totalPrice")
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_orderStatus")
    private OrderStatus orderStatus;

    @Column(name = "order_notes")
    private String notes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderDetail> orderDetailList;

    public enum OrderStatus {
        CREATED,
        IN_PROGRESS,
        SENT,
        DELIVERED
    }
}

