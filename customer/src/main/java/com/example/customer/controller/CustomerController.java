package com.example.customer.controller;

import com.example.customer.entity.Customer;
import com.example.customer.service.CustomerService;
import com.example.customer.service.ICustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/customers")
public class CustomerController extends HttpServlet {
    private final ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        List<Customer> customerList = customerService.findAll();
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/view/CustomerView/index.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
