package com.kindson.service;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kindson.model.Product;

public interface ProductService {

	@GetMapping("/products")
	public List<Product> getAllProducts();
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable("productId") String productId);
}
