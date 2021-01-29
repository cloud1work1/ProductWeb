package com.kindson.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
		name="productservice-proxy",
		url="http://localhost:8028",
		fallback = ProductServiceAlternateProxyImpl.class
		)
public interface ProductServiceProxy extends ProductService{

}
