package com.kindson.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.kindson.model.Product;

@EnableFeignClients(basePackageClasses = ProductServiceAlternateProxy.class)
@ComponentScan(basePackageClasses = ProductServiceAlternateProxy.class)
@Component
public class ProductServiceAlternateProxyImpl implements ProductServiceProxy{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ProductServiceAlternateProxy productServiceAlternateProxy;

	@Autowired
	public ProductServiceAlternateProxyImpl(ProductServiceAlternateProxy productServiceAlternateProxy) {
		this.productServiceAlternateProxy=productServiceAlternateProxy;
	}
	
	public List<Product> getAllProducts() {
		logger.info("Delilvered from alternate server");
		return productServiceAlternateProxy.getAllProducts();
	}
	
	public Product getProductById(String productId) {
		logger.info("Delilvered from alternate server");
		return productServiceAlternateProxy.getProductById(productId);
	}
}
