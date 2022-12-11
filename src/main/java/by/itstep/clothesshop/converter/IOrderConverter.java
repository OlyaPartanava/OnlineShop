package by.itstep.clothesshop.converter;

import by.itstep.clothesshop.bean.OrderDTO;
import by.itstep.clothesshop.model.Order;

public interface IOrderConverter {

    OrderDTO toDto(Order order);
}
