package by.itstep.clothesshop.controller;

import by.itstep.clothesshop.model.User;
import by.itstep.clothesshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserName(authentication.getName());
        model.addAttribute("user", user);

        return "index";
    }
}