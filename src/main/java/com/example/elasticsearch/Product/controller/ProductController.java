package com.example.elasticsearch.Product.controller;

import com.example.elasticsearch.Product.dao.ProductSearchRepository;
import com.example.elasticsearch.Product.domain.ProductDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductSearchRepository productSearchRepository;


    @GetMapping("")
    public List<ProductDocument> getProducts() {
        return productSearchRepository.findAll();
    }

    @GetMapping("/condition")
    public List<ProductDocument> getProductsByDescription(@RequestParam("name") String name, @RequestParam("displayName") String displayName, @RequestParam("description") String description) {

        //return productSearchRepository.findByNameOrDisplayNameOrDescription(name, displayName, description);
        return productSearchRepository.findByNameContainsOrDisplayNameContainsOrDescriptionContains(name, displayName, description);

    }
}
