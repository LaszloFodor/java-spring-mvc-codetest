package com.example.demo;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {


    @Autowired
    CustomerService customerService;

    private CustomerDTO customer1;

    private CustomerDTO customer2;

    private CustomerDTO customer3;

    @Before
    public void setUp() {
        this.customer1 = new CustomerDTO();
        this.customer2 = new CustomerDTO();
        this.customer3 = new CustomerDTO();

    }

    private void setUpCustomer(CustomerDTO customer, int id, String name, String duetime, String jointime) {
        System.out.println("Test user created:\n id: " + id + " name: " + name + " duetime: " + duetime + "jointime: " + jointime);
        customer.setId(id);
        customer.setName(name);
        customer.setDuetime(duetime);
        customer.setJointime(jointime);
    }

    @Test
    public void testSort_SuccesfulWithDifferentDuetime() {
        setUpCustomer(customer1, 1, "Ulysses Leon", "2014-06-18T06:26:56-07:00", "2015-04-08T12:47:16-07:00");
        setUpCustomer(customer2, 2, "Bruce Cardenas", "2013-12-28T14:11:12-08:00", "2014-07-03T21:53:42-07:00");
        setUpCustomer(customer3, 3, "Barrett Peterson", "2013-12-29T22:33:23-08:00", "2014-10-23T21:46:24-07:00");
        CustomerDTO[] customers = new CustomerDTO[]{customer1, customer2, customer3};
        List<CustomerDTO> customersList = Arrays.asList(customer2, customer3, customer1);
        List<CustomerDTO> sortedList = customerService.sort(customers);
        assertTwoLists(customersList, sortedList);
    }

    @Test
    public void testSort_SuccesfulWithSameDuetime() {
        setUpCustomer(customer1, 1, "Ulysses Leon", "2014-06-18T06:26:56-07:00", "2015-04-08T12:47:16-07:00");
        setUpCustomer(customer2, 2, "Bruce Cardenas", "2014-06-18T06:26:56-07:00", "2014-07-03T21:53:42-07:00");
        setUpCustomer(customer3, 3, "Barrett Peterson", "2014-06-18T06:26:56-07:00", "2014-10-23T21:46:24-07:00");
        CustomerDTO[] customers = new CustomerDTO[]{customer1, customer2, customer3};
        List<CustomerDTO> customersList = Arrays.asList(customer1, customer2, customer3);
        List<CustomerDTO> sortedList = customerService.sort(customers);
        assertTwoLists(customersList, sortedList);
    }

    private void assertTwoLists(List<CustomerDTO> customersList, List<CustomerDTO> sortedList) {
        for (int i = 0; i < 3; i++) {
            assertEquals(sortedList.get(i).getId(), customersList.get(i).getId());
            assertEquals(sortedList.get(i).getName(), customersList.get(i).getName());
            assertEquals(sortedList.get(i).getDuetime(), new DateTime().parse(customersList.get(i).getDuetime()).toString());
            assertEquals(sortedList.get(i).getJointime(), customersList.get(i).getJointime());
        }
    }
}
