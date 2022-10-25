package by.itstep.clothesshop.service.impl;

import by.itstep.clothesshop.model.Order;
import by.itstep.clothesshop.repository.OrderRepository;
import by.itstep.clothesshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl  implements OrderService {
    @Autowired
    private OrderRepository repository;

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void delete(Order order) {
        repository.delete(order);
        }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
        }

    @Override
    public Order getById(Integer id) {
        return repository.findById(id).get();
    }
}


