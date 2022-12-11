package by.itstep.clothesshop.controller;

import by.itstep.clothesshop.bean.OrderDTO;
import by.itstep.clothesshop.model.Basket;
import by.itstep.clothesshop.model.User;
import by.itstep.clothesshop.service.OrderService;
import by.itstep.clothesshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/create_order/{basketId}")
    public String createOrder(Model model, @PathVariable(value = "basketId") Integer basketId) {
        OrderDTO orderDTO = orderService.saveOrder(basketId);

        if (orderDTO != null) {
            model.addAttribute("orderDTO", orderDTO);
            return "orderSuccess";
        } else {
            model.addAttribute("error", "Some error, please try later");
            return "order";
        }
    }
}
