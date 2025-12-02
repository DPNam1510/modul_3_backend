package com.example.customer.repository;

import com.example.customer.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
