package com.tutorialspoint;

import com.tutorialspoint.model.Product;
import com.tutorialspoint.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if (product != null && product.getId() == null)
            productService.add(product);
        else {
            productService.update(product);
        }
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        if (product != null)
            productService.delete(product);
        return "redirect:/product";
    }

    @RequestMapping(value = "/product/edit/{id}")
    public String updateProduct(Model model, @PathVariable("id") Long id) {
        Product product = productService.findById(id);
        model.addAttribute("newProduct", product);
        return "product";
    }


}