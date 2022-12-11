package by.itstep.clothesshop.service.impl;


import by.itstep.clothesshop.bean.OrderDTO;
import by.itstep.clothesshop.converter.IOrderConverter;
import by.itstep.clothesshop.model.Basket;
import by.itstep.clothesshop.model.CartItem;
import by.itstep.clothesshop.model.Order;
import by.itstep.clothesshop.model.OrderDetail;
import by.itstep.clothesshop.repository.BasketRepository;
import by.itstep.clothesshop.repository.OrderRepository;
import by.itstep.clothesshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static by.itstep.clothesshop.model.Order.OrderStatus.CREATED;
import static java.util.stream.Collectors.toList;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private BasketRepository basketRepository;
    @Autowired
    private IOrderConverter orderConverter;


    @Override
    public OrderDTO saveOrder(Integer basketId) {
        if (basketId == null) {
            return null;
        }

        Basket basket = getBasket(basketId);
        if (basket == null) {
            throw new RuntimeException("Basket not found");
        }

        Order newOrder = new Order();
        newOrder.setOrderStatus(CREATED);
        newOrder.setOrderDate(new Date());
        newOrder.setUser(basket.getUser());
        newOrder.setTotalPrice(basket.getTotalPrice());
        orderRepository.save(newOrder);
        return orderConverter.toDto(newOrder);
    }


    private Basket getBasket(Integer basketId) {
        return basketRepository.findById(basketId).orElse(null);
    }







}

