package com.example.demo.converter;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDTOToCustomer implements Converter<CustomerDTO, Customer> {

    private final DateTime dateTime = new DateTime();

    @Override
    public Customer convert(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setDuetime(dateTime.parse(customerDTO.getDuetime()));
        customer.setJointime(customerDTO.getJointime());
        return customer;
    }
}
