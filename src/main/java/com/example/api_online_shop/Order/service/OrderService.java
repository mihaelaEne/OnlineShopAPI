package com.example.api_online_shop.Order.service;

import com.example.api_online_shop.Order.dtos.CreateOrderRequest;
import com.example.api_online_shop.Order.dtos.CreateOrderResponse;
import com.example.api_online_shop.Order.dtos.UpdateOrderRequest;
import com.example.api_online_shop.Order.exceptions.NoUpdateException;
import com.example.api_online_shop.Order.exceptions.OrderDoesntExistException;
import com.example.api_online_shop.Order.exceptions.OrderExistException;
import com.example.api_online_shop.Order.model.Order;
import com.example.api_online_shop.Order.repository.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> getAllOrders() {
        List<Order> all = orderRepo.findAll();
        if (all.size() == 0) {
            throw new OrderExistException();
        }
        return all;
    }

    @Transactional

    public CreateOrderResponse addOrder(CreateOrderRequest createOrderRequest) {
        Optional<Order> orderByOrderEmail = orderRepo.findOrderByOrderEmail(createOrderRequest.getOrderEmail());

        if (orderByOrderEmail.isPresent()) {
            throw new OrderExistException();
        }

        Order order = Order.builder()
                .ammount(createOrderRequest.getAmmount())
                .shippingAdress(createOrderRequest.getShippingAdress())
                .orderAdress(createOrderRequest.getOrderAdress())
                .orderEmail(createOrderRequest.getOrderEmail())
                .orderStatus(createOrderRequest.getOrderStatus())
                .build();

        Order order1=orderRepo.saveAndFlush(order);


        return CreateOrderResponse.builder().order(order1).build();
    }

    @Transactional
    public void deleteOrder(long id){
        Optional<Order>order=orderRepo.findById(id);

        if(order.isPresent()){
            orderRepo.delete(order.get());
        }
        else{
            throw new OrderDoesntExistException();
        }
    }

    @Transactional
    public void updateOrder(UpdateOrderRequest updateOrderRequest){
        Optional<Order> orderOptional= orderRepo.findOrderByOrderEmail(updateOrderRequest.getOrderEmail());

        if(orderOptional.isPresent()){
            Order order=orderOptional.get();

            if(!updateOrderRequest.getOrderAdress().equals("")){
                order.setOrderAdress(updateOrderRequest.getOrderAdress());
            }
            if(!updateOrderRequest.getShippingAdress().equals("")){
                order.setShippingAdress(updateOrderRequest.getShippingAdress());
            }

            orderRepo.saveAndFlush(order);
        }


        else {
            throw new NoUpdateException();
        }
    }


}
