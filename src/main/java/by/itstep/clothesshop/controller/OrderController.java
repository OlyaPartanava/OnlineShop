package by.itstep.clothesshop.controller;

import by.itstep.clothesshop.model.Order;
import by.itstep.clothesshop.repository.OrderRepository;
import by.itstep.clothesshop.service.OrderService;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class OrderController {
    @Autowired
    private OrderService orderService;


}
