package com.sda.controller;

import com.sda.domain.Product;
import com.sda.dto.CreateProductDto;
import com.sda.dto.UpdateProductDto;
import com.sda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService service;


    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestBody @Valid CreateProductDto dto) {

        Product p = service.save(dto);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = service.getAllProducts();

        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
    public  ResponseEntity<Void> deleteProduct (@PathVariable(value = "productId") Long id){
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findProductById (@PathVariable Long productId){
        Product product = service.findById(productId);

        return  ResponseEntity.ok(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> editProduct(@PathVariable Long productId, @RequestBody UpdateProductDto dto){

        Product product = service.update(productId, dto);
        return  ResponseEntity.ok(product);
    }
}
