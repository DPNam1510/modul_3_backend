package com.example.caculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DiscountServlet", value = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("Price"));
        double num2 = Double.parseDouble(req.getParameter("Discount"));
        double discountAmount = num1*num2*0.01;
        req.setAttribute("Discount_Amount",discountAmount);
        req.setAttribute("Discount_Price",discountAmount);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
