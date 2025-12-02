package com.example.customer.service;
import com.example.customer.entity.Customer;
import com.example.customer.repository.ICustomerRepository;
import com.example.customer.repository.CustomerRepository;
import java.util.List;
import java.util.ArrayList;
public class CustomerService implements ICustomerService {
    private static final ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
