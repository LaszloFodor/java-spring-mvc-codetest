package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> sort(CustomerDTO[] customerList);
}
