package com.example.api_online_shop.OrderDetails.rest;

import com.example.api_online_shop.OrderDetails.dtos.CreateOrderDetailsRequest;
import com.example.api_online_shop.OrderDetails.dtos.CreateOrderDetailsResponse;
import com.example.api_online_shop.OrderDetails.model.OrderDetails;
import com.example.api_online_shop.OrderDetails.service.OrderDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/online-shop-orderDetails")
@AllArgsConstructor
@Slf4j
public class OrderDetailsController {

    private OrderDetailsService orderDetailsService;

    @PostMapping("/createOrderDetails")
    public ResponseEntity<CreateOrderDetailsResponse>addOrder(@RequestBody CreateOrderDetailsRequest createOrderDetailsRequest) {
        CreateOrderDetailsResponse createOrderDetailsResponse = orderDetailsService.addOrderDetails(createOrderDetailsRequest);
        return new ResponseEntity<>(createOrderDetailsResponse, HttpStatus.CREATED);
    }

    @GetMapping("/allOrdersDetails")
    public ResponseEntity<List<OrderDetails>> getAllOrdersDetails() {
        List<OrderDetails> orderDetails=orderDetailsService.getAllOrders();
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        orderDetailsService.deleteOrderDetails(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
