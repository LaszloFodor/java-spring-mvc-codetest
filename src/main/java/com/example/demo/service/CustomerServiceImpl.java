package com.example.demo.service;

import com.example.demo.converter.CustomerDTOToCustomer;
import com.example.demo.converter.CustomerToCustomerDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public List<CustomerDTO> sort(CustomerDTO[] customerArray) {
        List<Customer> customerList = Arrays.asList(customerArray)
                .stream()
                .map(customerDTO -> new CustomerDTOToCustomer().convert(customerDTO))
                .collect(Collectors.toList());

        Collections.sort(customerList);

        List<CustomerDTO> convertedList = customerList
                .stream()
                .map(customer -> new CustomerToCustomerDTO().convert(customer))
                .collect(Collectors.toList());

        return convertedList;
    }
}
