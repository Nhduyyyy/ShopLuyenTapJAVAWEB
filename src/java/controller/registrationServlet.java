/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import models.role;
import models.user;
import userDAO.UserDAO;

/**
 *
 * @author nhatduy261179
 */
@WebServlet(name = "registrationServlet", urlPatterns = {"/register"})
public class registrationServlet extends HttpServlet {
    
    private UserDAO userDao = new UserDAO();
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/authenticator_authorization/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String fullName = request.getParameter("fullName");
        String sex = request.getParameter("sex");
        String birthDateStr = request.getParameter("birthDate");
        
        role role = new role(3, "User");
        
        String avatar = "default.gif";
        
        int score = 0;
        
        boolean locked = false;
        
        Date birthDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthDate = sdf.parse(birthDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            
            birthDate = new Date();
        }
        
        java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
        
        user user = new user();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setRole(role);
        user.setPhoneNumber(phoneNumber);
        user.setAvatar(avatar);
        user.setScore(score);
        user.setSex(sex);
        user.setBirthDate(birthDate);  
        user.setCreatedAt(currentTime);
        user.setUpdatedAt(currentTime);
        user.setLocked(locked);
        
        try {
            userDao.insertUser(user);
            request.setAttribute("successMessage", "Đăng kí thành công, vui lòng đăng nhập.");
            request.getRequestDispatcher("/authenticator_authorization/login.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Đăng kí thất bại: " + e.getMessage());
            request.getRequestDispatcher("/authenticator_authorization/register.jsp").forward(request, response);
        }
    }
}
