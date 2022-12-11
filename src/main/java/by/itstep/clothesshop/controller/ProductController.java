package by.itstep.clothesshop.controller;

import by.itstep.clothesshop.bean.ProductDTO;
import by.itstep.clothesshop.model.Category;
import by.itstep.clothesshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    // категории
    @GetMapping("/dresses")
    public String getProductDresses(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.DRESS);
        model.addAttribute("product", list);
        return "dresses";
    }

    @GetMapping("/skirts")
    public String getProductSkirt(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.SKIRT);
        model.addAttribute("product", list);
        return "skirts";
    }

    @GetMapping("/bags")
    public String getProductBags(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.BAG);
        model.addAttribute("product", list);
        return "bags";
    }
    @GetMapping("/glasses")
    public String getProductGlasses(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.GLASSES);
        model.addAttribute("product", list);
        return "glasses";
    }
    @GetMapping("/shirts")
    public String getProductShirts(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.SHIRT);
        model.addAttribute("product", list);
        return "shirts";
    }
    @GetMapping("/shoes")
    public String getProductShoes(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.SHOES);
        model.addAttribute("product", list);
        return "shoes";
    }
    @GetMapping("/costumes")
    public String getProductCostumes(Model model) {
        List<ProductDTO> list = productService.findByCategory(Category.COSTUME);
        model.addAttribute("product", list);
        return "costumes";
    }

    @RequestMapping("/listPr")
    public String viewHomePage(Model model) {
        List<ProductDTO> listProducts = productService.findAll();
        model.addAttribute("listProducts", listProducts);
        return "listProd";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        ProductDTO product = new ProductDTO();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") ProductDTO productDTO) {
        productService.save(productDTO);
        return "redirect:/listPr";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("edit_product");
        ProductDTO product = productService.getProductById(id);
        mav.addObject("product", product);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        productService.delete(id);
        return "redirect:/listPr";
    }

}