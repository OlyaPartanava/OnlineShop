package by.itstep.clothesshop.controller;

import by.itstep.clothesshop.model.Basket;
import by.itstep.clothesshop.model.CartItem;
import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.model.User;
import by.itstep.clothesshop.repository.CartItemRepository;
import by.itstep.clothesshop.service.BasketService;
import by.itstep.clothesshop.service.ProductService;
import by.itstep.clothesshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;


@Controller
public class BasketController {

    @Autowired
    private UserService userService;
    @Autowired
    private BasketService basketService;
    @Autowired
    private ProductService productService;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/basket")
    public String basket(Model model, Principal principal, HttpSession session) {
        if (principal == null) {
            return "redirect:/login";
        }

        String username = principal.getName();
        User user = userService.findByUserName(username);
        Basket basket = user.getBasket();
        if (basket == null) {
            model.addAttribute("check", "No item in your cart");
            return "basket";
        }

        session.setAttribute("totalItems", basket.getTotalItems());
        model.addAttribute("subTotal", basket.getTotalPrice());
        model.addAttribute("shoppingCart", basket);
        model.addAttribute("listCartItems", basket.getCartItem());
        return "basket";
    }



    @PostMapping("/add-to-cart")
    public String addItemToBasket(
            @RequestParam("id") Integer productId,
            @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,
            Principal principal,
            HttpServletRequest request) {

        if (principal == null) {
            return "redirect:/login";
        }
        Product product = productService.getProductByIdd(productId);
        String username = principal.getName();
        User user = userService.findByUserName(username);

        Basket cart = basketService.addItemToBasket(product, quantity, user);

        return "redirect:" + request.getHeader("Referer");
    }


    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=update")
    public String updateCart(@RequestParam("quantity") int quantity,
                             @RequestParam("id") Integer productId,
                             Model model,
                             Principal principal) {

        if (principal == null) {
            return "redirect:/login";
        } else {
            String username = principal.getName();
            User user = userService.findByUserName(username);
            Product product = productService.getProductByIdd(productId);
            Basket basket = basketService.updateItemInBasket(product, quantity, user);

            model.addAttribute("shoppingCart", basket);
            return "redirect:/basket";
        }
    }

    @RequestMapping(value = "/update-cart", method = RequestMethod.POST, params = "action=delete")
    public String deleteItemFromCart(@RequestParam("id") Integer productId,
                                     Model model,
                                     Principal principal){
        if(principal == null){
            return "redirect:/login";
        }else{
            String username = principal.getName();
            User user = userService.findByUserName(username);
            Product product = productService.getProductByIdd(productId);
            Basket basket = basketService.deleteItemFromBasket(product, user);
            model.addAttribute("shoppingCart", basket);
            return "redirect:/basket";
        }

    }




}