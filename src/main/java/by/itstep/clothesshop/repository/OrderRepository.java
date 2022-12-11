package by.itstep.clothesshop.repository;

import by.itstep.clothesshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {


}