package com.tutorialspoint;

import com.tutorialspoint.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
public class HelloController{

    private ProductService productService;

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping(value = "/hobby", method = RequestMethod.GET)
    public String printHobby(Model model) {
        model.addAttribute("hobby", "Hobby");
        model.addAttribute("products", productService.findAllProducts());
        return "hobby";
    }

}