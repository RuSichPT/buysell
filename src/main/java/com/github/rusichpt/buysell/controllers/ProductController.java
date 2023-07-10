package com.github.rusichpt.buysell.controllers;

import com.github.rusichpt.buysell.models.Product;
import com.github.rusichpt.buysell.services.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(@RequestParam Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.delete(id);
        return "redirect:/";
    }
}