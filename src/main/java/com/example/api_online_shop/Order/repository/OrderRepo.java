package com.example.api_online_shop.Order.repository;

import com.example.api_online_shop.Order.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo  extends JpaRepository<Order, Long> {

    @Query("SELECT o from Order o where o.orderEmail= ?1")
    Optional<Order> findOrderByOrderEmail(String orderEmail);


}
