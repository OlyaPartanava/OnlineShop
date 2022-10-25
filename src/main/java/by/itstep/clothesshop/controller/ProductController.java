package by.itstep.clothesshop.controller;


import by.itstep.clothesshop.model.Product;
import by.itstep.clothesshop.model.ProductDescription;



import by.itstep.clothesshop.service.ProductDescriptionService;
import by.itstep.clothesshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;
    @Autowired
    private ProductDescriptionService productDescriptionService;

    @GetMapping("/main")
    public String getProduct(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("lady", products.stream().filter(x -> x.getCategory().getId().equals(2)).collect(Collectors.toList()));
        model.addAttribute("man", products.stream().filter(x -> x.getCategory().getId().equals(3)).collect(Collectors.toList()));
        return "main";

    }

    @GetMapping("/products/{prodName}")
    public String getProductDresses(@PathVariable String prodName, Model model) {
        List<ProductDescription> products = productDescriptionService.getProductPage(prodName);
        model.addAttribute("list", products);
        return "dresses";
    }

}

