package com.example.api_online_shop;

import com.example.api_online_shop.Product.model.Product;
import com.example.api_online_shop.Product.repository.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ApiOnlineShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiOnlineShopApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner (ProductRepo productRepo){
        return args -> {


             List<Long> ids=new ArrayList<>();

             ids.add(1L);
             ids.add(2L);
            // ids.add(33);
             ids.add(4L);

            Optional<List<Product>> lists= productRepo.getAllProdusctsWithIds(ids);

            if(lists.isPresent()){
                List<Product>lists1=lists.get();

                if(!lists1.isEmpty()){
                    for (Product product : lists1) {
                        System.out.println(product);
                    }
                }
            }
        };






        }

}
