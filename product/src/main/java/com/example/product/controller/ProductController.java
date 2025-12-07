package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.service.IProductService;
import com.example.product.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = "/products")
public class ProductController extends HttpServlet {

    private final IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add":
                showFormAdd(request, response);
                break;

            case "update":
                showFormUpdate(request, response);
                break;
            default:
                showListForm(request, response);
                break;

        }
    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/add.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        if (product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("/view/update.jsp").forward(request, response);
        } else {
            response.sendRedirect("/products?message=Product not found");
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/view/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "add":
                addProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            default:
                response.sendRedirect("/products?");
        }
    }

    protected void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(name, price);
        boolean isAddSuccess = productService.add(product);
        String mess = isAddSuccess ? "Product added successfully" : "Product not added";
        try {
            response.sendRedirect("/products?message=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id, name, price);
        boolean isUpdateSuccess = productService.update(product);
        String mess = isUpdateSuccess ? "Product updated successfully" : "Product not updated";
        try {
            response.sendRedirect("/products?message=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean isDeleteSuccess = productService.delete(id);
        String mess = isDeleteSuccess ? "Product deleted successfully" : "Product not deleted";
        try {
            response.sendRedirect("/products?message=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
