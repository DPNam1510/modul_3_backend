package com.example.product.service;

import com.example.product.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    boolean add(Product product);
    boolean delete(int id);
    boolean update(Product product);

}
