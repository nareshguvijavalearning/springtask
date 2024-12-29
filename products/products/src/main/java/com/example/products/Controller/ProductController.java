package com.example.products.Controller;

import com.example.products.Entity.Product;
import com.example.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/addproduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute Product product) {
        if (product.getName() != null && product.getPrice() != null && product.getCategory() != null) {

            productService.saveProduct(product);
            return "redirect:/displayproducts";
        }
        return "redirect:/addproduct";

    }

    @GetMapping("/displayproducts")
    public String displayProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "displayProducts";
    }
}

