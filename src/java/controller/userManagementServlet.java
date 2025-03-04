/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import models.user;
import userDAO.UserDAO;


@WebServlet(name = "userManagementServlet", urlPatterns = {"/userManagement"})
public class userManagementServlet extends HttpServlet {

    private UserDAO userDao = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách người dùng từ userDAO
        List<user> userList = userDao.selectAllUsers();
        
        // Gán danh sách vào thuộc tính của request
        request.setAttribute("userList", userList);
        
        // Forward sang trang JSP để hiển thị danh sách người dùng
        request.getRequestDispatcher("/user/adminManageUsers.jsp").forward(request, response);
    }

    
}
