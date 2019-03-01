package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/sort")
    public List<CustomerDTO> sortCustomers(@RequestBody CustomerDTO[] customerArray) {
        return customerService.sort(customerArray);
    }

}
