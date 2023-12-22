package com.example.api_online_shop.Product.service;

import com.example.api_online_shop.Order.exceptions.NoUpdateException;
import com.example.api_online_shop.Product.dtos.CreateProductRequest;
import com.example.api_online_shop.Product.dtos.CreateProductResponse;
import com.example.api_online_shop.Product.dtos.UpdateProductRequest;
import com.example.api_online_shop.Product.exceptions.ProductDoesntExistException;
import com.example.api_online_shop.Product.exceptions.ProductExistException;
import com.example.api_online_shop.Product.model.Product;
import com.example.api_online_shop.Product.repository.ProductRepo;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product>getAllProducts(){
        List<Product>all=productRepo.findAll();
        if(all.size()==0){
            throw new ProductExistException();
        }
        return all;
    }



    @Transactional
    public CreateProductResponse addProduct(CreateProductRequest createProductRequest){
        Optional<Product> productByName=productRepo.findProductByName(createProductRequest.getName());

        if(productByName.isPresent()){

            throw new ProductExistException();
        }

        Product product=Product.builder()
                .name(createProductRequest.getName())
                .price(createProductRequest.getPrice())
                .weight(createProductRequest.getWeight())
                .localDate(createProductRequest.getLocalDate())
                .build();

        Product product1=productRepo.saveAndFlush(product);

        return CreateProductResponse.builder().product(product1).build();
    }


    @Transactional
    public void deleteProduct(long id){
        Optional<Product>product=productRepo.findById(id);

        if(product.isPresent()){
            productRepo.delete(product.get());
        }else{
            throw new ProductDoesntExistException();
        }
    }


    @Transactional
    public void updateProduct(UpdateProductRequest updateProductRequest){
        Optional<Product> productOptional=productRepo.findProductByName(updateProductRequest.getName());

        if(productOptional.isPresent()){
            Product product=productOptional.get();

            if(updateProductRequest.getPrice()==0){
                product.setPrice(updateProductRequest.getPrice());
            }

            productRepo.saveAndFlush(product);
        }else {
            throw new NoUpdateException();
        }
    }







}
