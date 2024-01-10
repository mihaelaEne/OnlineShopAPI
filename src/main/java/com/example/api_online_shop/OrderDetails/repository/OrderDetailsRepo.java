package com.example.api_online_shop.OrderDetails.repository;

import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {

    @Query("SELECT o from OrderDetails o where o.quantity= ?1")
    @EntityGraph(attributePaths = {"products"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<OrderDetails> findByQuantity(int quantity);


}
