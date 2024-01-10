package com.example.api_online_shop.Customer.repository;

import com.example.api_online_shop.Customer.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRespo extends JpaRepository<Customer, Long> {

    @Query("select c from Customer c where c.fullName= ?1")
    Optional<Customer> findCustomerByFullName(String fullName);

    @Query("select c from Customer c where c.email= ?1 and c.password= ?2")
    Optional<Customer>findCustomerByEmailAndPassWord();

}
