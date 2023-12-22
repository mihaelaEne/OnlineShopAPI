package com.example.api_online_shop.Customer.service;

import com.example.api_online_shop.Customer.dtos.CreateCustomerRequest;
import com.example.api_online_shop.Customer.dtos.CreateCustomerResponse;
import com.example.api_online_shop.Customer.dtos.UpdateCustomerRequest;
import com.example.api_online_shop.Customer.exceptions.CustomerDoesntExistException;
import com.example.api_online_shop.Customer.exceptions.CustomerExistException;
import com.example.api_online_shop.Customer.exceptions.NoUpdateException;
import com.example.api_online_shop.Customer.model.Customer;
import com.example.api_online_shop.Customer.repository.CustomerRespo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRespo customerRespo;

    public CustomerService(CustomerRespo customerRespo) {
        this.customerRespo = customerRespo;
    }

    public List<Customer> getAllCustomer(){
        List<Customer>all=customerRespo.findAll();
        if(all.size()==0){
            throw new CustomerExistException();
        }
        return all;
    }

    @Transactional

    public CreateCustomerResponse addCustomer(CreateCustomerRequest createCustomerRequest){

        Optional<Customer> customerByName=customerRespo.findCustomerByFullName(createCustomerRequest.getFullName());

        if(customerByName.isPresent()){
            throw  new CustomerExistException();
        }

       Customer customer=Customer.builder()
               .email(createCustomerRequest.getEmail())
               .password(createCustomerRequest.getPassword())
               .fullName(createCustomerRequest.getFullName())
               .billingAdress(createCustomerRequest.getBillingAdress())
               .defaultShippingAddress(createCustomerRequest.getDefaultShipping())
               .country(createCustomerRequest.getCountry())
               .phone(createCustomerRequest.getPhone())
               .build();


      Customer customer1=customerRespo.saveAndFlush(customer);

        return CreateCustomerResponse.builder().customer(customer1).build();
    }

    @Transactional
    public void deleteCustomer(long id){
        Optional<Customer>customer=customerRespo.findById(id);
        if(customer.isPresent()){
            customerRespo.delete(customer.get());
        }else{
            throw new CustomerDoesntExistException();
        }
    }

    @Transactional
    public void updateCustomer(UpdateCustomerRequest updateCustomerRequest){
        Optional<Customer>customerOptional=customerRespo.findCustomerByFullName(updateCustomerRequest.getFullName());
       if(customerOptional.isPresent()){
           Customer customer=customerOptional.get();

           if(!updateCustomerRequest.getCountry().equals("")){
               customer.setCountry(updateCustomerRequest.getCountry());
           }
           if(!updateCustomerRequest.getPhone().equals("")){
               customer.setPhone(updateCustomerRequest.getPhone());
           }

           else {
               throw new NoUpdateException();
           }
       }
    }
}
