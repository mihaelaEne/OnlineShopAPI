package com.example.api_online_shop.OrderDetails.service;

import com.example.api_online_shop.Order.exceptions.OrderExistException;
import com.example.api_online_shop.OrderDetails.dtos.CreateOrderDetailsRequest;
import com.example.api_online_shop.OrderDetails.dtos.CreateOrderDetailsResponse;
import com.example.api_online_shop.OrderDetails.exceptions.OrderDetailsDoesntExistException;
import com.example.api_online_shop.OrderDetails.exceptions.OrderDetailsExistException;
import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import com.example.api_online_shop.OrderDetails.repository.OrderDetailsRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {
    private OrderDetailsRepo orderDetailsRepo;


    public OrderDetailsService(OrderDetailsRepo orderDetailsRepo) {
        this.orderDetailsRepo = orderDetailsRepo;
    }


    @Transactional

    public CreateOrderDetailsResponse addOrderDetails(CreateOrderDetailsRequest createOrderDetailsRequestRequest) {
        Optional<OrderDetails> orderByOrderDetailsId = orderDetailsRepo.findByQuantity(createOrderDetailsRequestRequest.getQuantity());

        if (orderByOrderDetailsId.isPresent()) {
            throw new OrderDetailsDoesntExistException();
        }

        OrderDetails orderDetails = OrderDetails.builder()
                .quantity(createOrderDetailsRequestRequest.getQuantity())
                .build();

        OrderDetails orderDetails1=orderDetailsRepo.saveAndFlush(orderDetails);


        return CreateOrderDetailsResponse.builder().orderDetails(orderDetails1).build();
    }
    public List<OrderDetails> getAllOrders() {
        List<OrderDetails> all = orderDetailsRepo.findAll();
        if (all.size() == 0) {
            throw new OrderDetailsExistException();
        }
        return all;
    }

    @Transactional

    public CreateOrderDetailsResponse addOrderDetail(CreateOrderDetailsRequest createOrderDetailsRequest) {
        Optional<OrderDetails> orderDetailsByOrderId = orderDetailsRepo.findByQuantity(createOrderDetailsRequest.getQuantity());

        if (orderDetailsByOrderId.isPresent()) {
            throw new OrderExistException();
        }

        OrderDetails orderDetails = OrderDetails.builder()
                .quantity(createOrderDetailsRequest.getQuantity())
                .build();

        OrderDetails orderDetails1=orderDetailsRepo.saveAndFlush(orderDetails);


        return CreateOrderDetailsResponse.builder().orderDetails(orderDetails1).build();
    }

    @Transactional
    public void deleteOrderDetails(long id){
        Optional<OrderDetails>orderDetails=orderDetailsRepo.findById(id);

        if(orderDetails.isPresent()){
            orderDetailsRepo.delete(orderDetails.get());
        }
        else{
            throw new OrderDetailsDoesntExistException();
        }
    }




}
