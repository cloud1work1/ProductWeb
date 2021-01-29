package com.kindson.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="product-service-alternate-proxy",
url="http://localhost:8029")
public interface ProductServiceAlternateProxy extends ProductService{

}
