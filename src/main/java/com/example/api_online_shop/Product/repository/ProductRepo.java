package com.example.api_online_shop.Product.repository;

import com.example.api_online_shop.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.PropertyPermission;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.name= ?1")
    Optional<Product>findProductByName (String name);

    @Query("select p from Product p where p.price= ?1")
    Optional<Product>findproductByPrice(int price);



    @Query("select p from Product p where p.id in (:ids)")
    Optional<List<Product>> getAllProdusctsWithIds(List<Long>ids);


}
