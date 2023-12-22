package com.example.api_online_shop.Customer.rest;

import com.example.api_online_shop.Customer.dtos.CreateCustomerRequest;
import com.example.api_online_shop.Customer.dtos.CreateCustomerResponse;
import com.example.api_online_shop.Customer.dtos.UpdateCustomerRequest;
import com.example.api_online_shop.Customer.model.Customer;
import com.example.api_online_shop.Customer.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/online-shop-customer")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private CustomerService customerService;

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers=customerService.getAllCustomer();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CreateCustomerResponse>addCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        CreateCustomerResponse createCustomerResponse=customerService.addCustomer(createCustomerRequest);
        return new ResponseEntity<>(createCustomerResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Void> updateCustomer(@RequestBody UpdateCustomerRequest updateCustomerRequest){
        customerService.updateCustomer(updateCustomerRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
