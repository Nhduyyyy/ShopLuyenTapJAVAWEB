/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.role;
import models.user;
import userDAO.UserDAO;


@WebServlet(name = "createUserServlet", urlPatterns = {"/createUser"})
public class createUserServlet extends HttpServlet {

   private UserDAO userDao = new UserDAO();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/user/createUser.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String fullName = request.getParameter("fullName").trim();
        String phoneNumber = request.getParameter("phoneNumber").trim();
        String roleIdStr = request.getParameter("roleId");
        int roleId = Integer.parseInt(roleIdStr);
        String lockedStr = request.getParameter("locked");
        boolean locked = Boolean.parseBoolean(lockedStr);
        String avatar = request.getParameter("Avatar");
        String sex = request.getParameter("sex");
        String birthDateStr = request.getParameter("birthDate");
        int score = Integer.parseInt(request.getParameter("score"));
        
        // Xử lý chuyển đổi định dạng ngày sinh
        Date birthDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthDate = sdf.parse(birthDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            birthDate = new Date();
        }
        
        // Tạo đối tượng role theo roleId
        role role;
        if (roleId == 1) {
            role = new role(roleId, "Admin");
        } else if (roleId == 2) {
            role = new role(roleId, "Manager");
        } else {
            role = new role(roleId, "User");
        }
        
        // Nếu avatar rỗng thì sử dụng mặc định
        if (avatar == null || avatar.trim().isEmpty()) {
            avatar = "default.gif";
        }
        
        // Lấy thời gian hiện tại cho updatedAt
        java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
        
        // Tạo đối tượng user cập nhật
        user newUser = new user();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFullName(fullName);
        newUser.setRole(role);
        newUser.setPhoneNumber(phoneNumber);
        newUser.setAvatar(avatar);
        newUser.setScore(score);
        newUser.setSex(sex);
        newUser.setBirthDate(birthDate);
        newUser.setCreatedAt(currentTime);
        newUser.setUpdatedAt(currentTime);
        newUser.setLocked(locked);
        
        try {
            userDao.insertUser(newUser);
            response.sendRedirect(request.getContextPath() + "/userManagement");
        } catch (SQLException e) {
            e.printStackTrace();
            
            request.setAttribute("errorMessages", "Tạo người dùng thất bại");
            request.getRequestDispatcher("/user/createUser.jsp").forward(request, response);
        }
    }
}
