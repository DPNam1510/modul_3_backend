package com.example.product.repository;

import com.example.product.entity.Product;

import java.util.List;
import java.util.ArrayList;

public class ProductRepository implements IProductRepository {
    private static final List<Product> productList = new ArrayList<>();
    private static int currentId = 1;
//    static {
//        productList.add(new Product(1,"Iphone",2000));
//        productList.add(new Product(2,"Samsung",1500));
//        productList.add(new Product(3,"Xiaomi",1000));
//    }
    @Override
    public List<Product> findAll() {
        return productList;
    }
    @Override
    public Product findById(int id) {
        for(Product product:productList){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }
    @Override
    public boolean add(Product product) {
        product.setId(currentId++);
        return productList.add(product);
    }
    @Override
    public boolean update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i, product);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        for(Product product:productList){
            if(product.getId()==id){
                productList.remove(product);
                return  true;
            }
        }
        return false;
    }
}
