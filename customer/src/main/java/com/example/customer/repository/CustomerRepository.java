package com.example.customer.repository;
import com.example.customer.entity.Customer;
import java.util.List;
import java.util.ArrayList;
public class CustomerRepository implements ICustomerRepository {
    private static final List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("Dinh Phuong Nam","0911574798","Nghe An","img"));
        customerList.add(new Customer("Vo Duc manh","0915138116","Hue","img"));
        customerList.add(new Customer("Nguyen Dang Bao Ngoc","0927988707","Nghe An","img"));
    }
    @Override
    public List<Customer> findAll(){
        return customerList;
    }
}
