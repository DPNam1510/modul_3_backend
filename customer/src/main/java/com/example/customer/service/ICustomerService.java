package com.example.customer.service;
import com.example.customer.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
