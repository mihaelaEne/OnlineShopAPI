package com.example.api_online_shop.Order.service;

import com.example.api_online_shop.Order.dtos.CreateOrderRequest;
import com.example.api_online_shop.Order.dtos.CreateOrderResponse;
import com.example.api_online_shop.Order.dtos.ProductDetailsDto;
import com.example.api_online_shop.Order.dtos.UpdateOrderRequest;
import com.example.api_online_shop.Order.exceptions.NoUpdateException;
import com.example.api_online_shop.Order.exceptions.OrderDoesntExistException;
import com.example.api_online_shop.Order.exceptions.OrderExistException;
import com.example.api_online_shop.Order.model.Order;
import com.example.api_online_shop.Order.repository.OrderRepo;
import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import com.example.api_online_shop.Product.model.Product;
import com.example.api_online_shop.Product.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class OrderService {
    private OrderRepo orderRepo;
    private ProductRepo productRepo;





    public OrderService(OrderRepo orderRepo,ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo=productRepo;
    }

    public List<Order> getAllOrders() {
        List<Order> all = orderRepo.findAll();
        if (all.size() == 0) {
            throw new OrderExistException();
        }
        return all;
    }

//    @Transactional
//
//    public CreateOrderResponse addOrder(CreateOrderRequest createOrderRequest) {
//
//
//
//    }



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


//    @Transactional
//    public void addProductDetails(){
//
//        Optional <ProductDetailsDto> findProductById= productRepo.findById()
//    }


    public Order createOrderWithDetails() {
        Order newOrder = new Order();

        Optional<Product> product1 = productRepo.findById(1L);
        product1.ifPresent(p -> addOrderDetails(newOrder, p, 5));

        Optional<Product> product2 = productRepo.findById(2L);
        product2.ifPresent(p -> addOrderDetails(newOrder, p, 3));



        return orderRepo.save(newOrder);
    }

    private void addOrderDetails(Order order, Product product, int quantity) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProduct(product);
        orderDetails.setQuantity(quantity);
        orderDetails.setOrder(order);

        order.addOrderDetails(orderDetails);
    }



}
