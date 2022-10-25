package by.itstep.clothesshop.service;

import by.itstep.clothesshop.model.Order;

import java.util.List;

public interface OrderService {
    void delete(Order order);
    Order save(Order order);

    List<Order> getAll();

    Order getById(Integer id);
}

