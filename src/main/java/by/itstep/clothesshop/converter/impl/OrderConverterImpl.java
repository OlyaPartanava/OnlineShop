package by.itstep.clothesshop.converter.impl;

import by.itstep.clothesshop.bean.OrderDTO;
import by.itstep.clothesshop.converter.IOrderConverter;
import by.itstep.clothesshop.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConverterImpl implements IOrderConverter {

    @Override
    public OrderDTO toDto(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setStatusOrder(order.getOrderStatus().name());
        return orderDTO;
    }
}