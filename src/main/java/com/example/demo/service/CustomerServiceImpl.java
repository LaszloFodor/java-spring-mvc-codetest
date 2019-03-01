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

    private final CustomerDTOToCustomer customerDTOToCustomer = new CustomerDTOToCustomer();

    private final CustomerToCustomerDTO customerToCustomerDTO = new CustomerToCustomerDTO();

    private final LocalDateTime localDateTime = new LocalDateTime();

    @Override
    public List<CustomerDTO> sort(CustomerDTO[] customerArray) {
        List<Customer> customerList = Arrays.asList(customerArray)
                .stream()
                .map(customerDTO -> customerDTOToCustomer.convert(customerDTO))
                .collect(Collectors.toList());

        Collections.sort(customerList);

        List<CustomerDTO> convertedList = customerList
                .stream()
                .map(customer -> customerToCustomerDTO.convert(customer))
                .collect(Collectors.toList());

        return convertedList;
    }
}
