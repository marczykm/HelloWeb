package com.tutorialspoint;

import com.tutorialspoint.model.Product;
import com.tutorialspoint.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
public class ProductController {

    private ProductService productService;

    @Autowired(required = true)
    @Qualifier(value = "myProductService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printIndex(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "index";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String printProduct(Model model) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("products", productService.findAllProducts());
        return "product";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(Model model, @ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/product";
    }

}