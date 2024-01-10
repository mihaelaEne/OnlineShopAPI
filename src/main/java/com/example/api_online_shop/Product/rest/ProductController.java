package com.example.api_online_shop.Product.rest;

import com.example.api_online_shop.Product.dtos.CreateProductRequest;
import com.example.api_online_shop.Product.dtos.CreateProductResponse;
import com.example.api_online_shop.Product.dtos.UpdateProductRequest;
import com.example.api_online_shop.Product.model.Product;
import com.example.api_online_shop.Product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
@Slf4j
public class ProductController {

    private ProductService productService;

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>>getAllProducts(){
        List<Product>products=productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping("/createProduct")
    public ResponseEntity<CreateProductResponse>addProduct(@RequestBody CreateProductRequest createProductRequest){
        CreateProductResponse createProductResponse=productService.addProduct(createProductRequest);
        return new ResponseEntity<>(createProductResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @PutMapping("/updateProduct")
    public ResponseEntity<Void>updateProductPrice(@RequestBody UpdateProductRequest updateProductRequest){
        productService.updateProduct(updateProductRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}

