package com.example.demo.converter;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class CustomerToCustomerDTO implements Converter<Customer, CustomerDTO>{

    private final DateTime dateTime = new DateTime();

    @Override
    public CustomerDTO convert(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setDuetime(customer.getDuetime().toString());
        dto.setJointime(customer.getJointime());
        return dto;
    }
}
