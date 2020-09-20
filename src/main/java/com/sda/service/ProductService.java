package com.sda.service;

import com.sda.domain.Product;
import com.sda.dto.CreateProductDto;
import com.sda.dto.UpdateProductDto;
import com.sda.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService (ProductRepository repository){
        this.repository = repository;
    }

    public Product save(CreateProductDto dto) {
        Product product = Product.builder()
                .category(dto.getCategory())
                .description(dto.getDescription())
                .name((dto.getName()))
                .price((dto.getPrice()))
                .quantity((dto.getQuantity()))
                .creationTime(LocalDateTime.now())
                .build();

        repository.save(product);
        return product;
    }

    public List<Product> getAllProducts(){
        return repository.findAll();

    }

    public void delete (Long id){

        repository.delete(id);
    }

    public Product findById (Long id){
        Product product = repository.findById(id);
        return product;
    }

    public Product update (Long productId, UpdateProductDto dto){

        return repository.update(productId,dto);
    }

    public List<Product> findAllByName(String name){
        return  repository.findAllByName(name);
    }

//    public Product update(Long productId, CreateProductDto dto) {
//        Product product = Product.builder()
//                .category(dto.getCategory())
//                .description(dto.getDescription())
//                .name((dto.getName()))
//                .price((dto.getPrice()))
//                .quantity((dto.getQuantity()))
//                .creationTime(LocalDateTime.now())
//                .build();
//
//        repository.;
//        return product;
//    }


}
