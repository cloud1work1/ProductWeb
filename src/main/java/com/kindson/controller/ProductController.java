package com.kindson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kindson.model.Product;
import com.kindson.service.ProductService;
import com.kindson.service.ProductServiceProxy;

@RestController
@EnableFeignClients(basePackageClasses = ProductServiceProxy.class)
@ComponentScan(basePackageClasses = ProductServiceProxy.class)
public class ProductController implements ProductService {

	private ProductServiceProxy productServiceProxy;
	
	@Autowired
	public ProductController(ProductServiceProxy productServiceProxy) {
		this.productServiceProxy=productServiceProxy;
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productServiceProxy.getAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	public Product getProductById(@PathVariable("productId") String productId) {
		return productServiceProxy.getProductById(productId);
	}
}
