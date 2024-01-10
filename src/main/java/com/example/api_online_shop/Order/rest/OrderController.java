package com.example.api_online_shop.Order.rest;

import com.example.api_online_shop.Order.dtos.CreateOrderRequest;
import com.example.api_online_shop.Order.dtos.CreateOrderResponse;
import com.example.api_online_shop.Order.dtos.UpdateOrderRequest;
import com.example.api_online_shop.Order.model.Order;
import com.example.api_online_shop.Order.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/online-shop-order")
@AllArgsConstructor
@Slf4j
public class OrderController {

    private OrderService orderService;

    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders=orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @PostMapping("/createOrder")
    public ResponseEntity<CreateOrderResponse>addOrder(@RequestBody CreateOrderRequest createOrderRequest){
        CreateOrderResponse createOrderResponse=orderService.addOrder(createOrderRequest);
        return new ResponseEntity<>(createOrderResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<Void> updateOrder(@RequestBody UpdateOrderRequest updateOrderRequest){
        orderService.updateOrder(updateOrderRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
