package com.sharath.productservice.productservice.service;

import com.sharath.productservice.productservice.dto.ProductRequest;
import com.sharath.productservice.productservice.dto.ProductResponse;
import com.sharath.productservice.productservice.model.Product;
import com.sharath.productservice.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ModelMapper mapper;

    public void createProduct(ProductRequest request){
        Product product = new Product();
        mapper.map(request, product);
        productRepository.save(product);
        log.info("Product is saved {} ", product.getId());
    }


    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> {
            ProductResponse response = new ProductResponse();
            mapper.map(product,response);
            return response;
        }).collect(toList());
    }
}
