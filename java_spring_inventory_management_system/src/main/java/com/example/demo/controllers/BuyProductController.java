package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Product;
import com.example.demo.repositories.ProductRepository;

@Controller
public class BuyProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long productID) {

        Optional<Product> productOptional = productRepository.findById(productID);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            if (product.getInv() > 0) {
                product.setInv(product.getInv() - 1);
                productRepository.save(product);
                return "redirect:/purchaseSuccess";
            }
        }

        return "redirect:/purchaseError";
    }

    @GetMapping("/purchaseSuccess")
    public String purchaseSuccess() {
        return "purchaseSuccess";
    }

    @GetMapping("/purchaseError")
    public String purchaseError() {
        return "purchaseError";
    }
}