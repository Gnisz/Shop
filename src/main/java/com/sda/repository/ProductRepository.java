package com.sda.repository;

import com.sda.domain.Product;
import com.sda.dto.UpdateProductDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {



    private List<Product> productList = new ArrayList<>();

    private AtomicLong idCounter = new AtomicLong(0);



    public Product save(Product product){
        product.setId(idCounter.getAndIncrement());


        productList.add(product);
        return product;

    }

    public List<Product> findAll(){
        return productList;
    }

    public void delete(Long productId){
        Optional<Product> anyProduct = productList.stream()
                .filter(p -> p.getId().equals(productId))
                .findAny();

        if (anyProduct.isEmpty()){
            return;
        }

        Product product =anyProduct.get();
        productList.remove(product);
    }

    public Product findById(Long productId){
        Optional<Product> anyProduct = productList.stream()
                .filter(p -> p.getId().equals(productId))
                .findAny();

        if (anyProduct.isEmpty()){
            return null;
        }

        Product product =anyProduct.get();
        return product;
    }

    public Product update(Long productId, UpdateProductDto dto){
        productList.stream()
                .filter(p -> p.getId().equals(productId))
                .findAny()
                .ifPresent(p-> {
                    p.setDescription(dto.getDescription());
                    p.setPrice(dto.getPrice());
                    p.setQuantity(dto.getQuantity());
                });

        return  findById(productId);
    }

    public List<Product> findAllByName(String name){
        return productList.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
