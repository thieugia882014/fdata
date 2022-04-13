package com.example.fdata.controller.product;

import com.example.fdata.entity.Product;
import com.example.fdata.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateProductServiet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        int amount = Integer.parseInt(req.getParameter("amount"));
        double price = Double.parseDouble(req.getParameter("price"));
        ProductModel model = new ProductModel();
        Product obj = new Product(name, amount, price);
        if (!obj.isvalid()) {
            req.setAttribute("errors", obj.getErrors());
            req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
            return;
        }
        model.save(obj);

        resp.sendRedirect("/products/list");
    }
}
