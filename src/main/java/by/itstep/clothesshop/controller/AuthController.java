package by.itstep.clothesshop.controller;

import by.itstep.clothesshop.bean.UserDTO;
import by.itstep.clothesshop.model.User;
import by.itstep.clothesshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register_form";
    }


    @PostMapping("/registration")
    public String processRegister(@ModelAttribute("userDTO") UserDTO userDTO,
                                  BindingResult result,
                                  Model model) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("userDTO", userDTO);
                return "register_form";
            }
            User user = userService.findByUserName(userDTO.getUsername());
            if (user != null) {
                model.addAttribute("username", "Username have been registered");
                model.addAttribute("userDTO", userDTO);
                return "register_form";
            }
            if (userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
                userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
                userService.save(userDTO);
                model.addAttribute("success", "Register successfully");
                return "register_form";
            } else {
                model.addAttribute("password", "Password is not same");
                model.addAttribute("userDTO", userDTO);
                return "register_form";
            }
        } catch (Exception e) {
            model.addAttribute("error", "error");
            model.addAttribute("userDTO", userDTO);
        }
        return "register_form";
    }
}
