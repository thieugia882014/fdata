package com.example.fdata.controller.product;

import com.example.fdata.entity.Product;
import com.example.fdata.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProductServiet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = new ProductModel();
            List<Product> listObj = model.findAll();
            req.setAttribute("listObj", listObj);
            req.getRequestDispatcher("/admin/products/list.jsp").forward(req, resp);


    }
}