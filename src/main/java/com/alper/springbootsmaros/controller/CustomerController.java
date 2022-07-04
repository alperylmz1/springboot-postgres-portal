package com.alper.springbootsmaros.controller;


import com.alper.springbootsmaros.model.Customer;
import com.alper.springbootsmaros.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/maroapi")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> findAll(){
        try{
            List<Customer> customers = customerRepository.findAll();
            if (customers.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(customers , HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try {
            Customer _customer = customerRepository.save(new Customer(customer.getName() , customer.getLocation() , customer.getStatus() , customer.getCreateDate() , customer.getCreateUser()));
            return new ResponseEntity<>(_customer , HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id , @RequestBody Customer customer){
        Optional<Customer> customerData = customerRepository.findById(id);
        if (customerData.isPresent()){
            Customer _customer = customerData.get();
            _customer.setName(customer.getName());
            _customer.setLocation(customer.getLocation());
            _customer.setStatus(customer.getStatus());
            _customer.setCreateDate(customer.getCreateDate());
            _customer.setCreateUser(customer.getCreateUser());

            return new ResponseEntity<>(customerRepository.save(_customer) , HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id){
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
