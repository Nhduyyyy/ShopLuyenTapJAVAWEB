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
import java.sql.SQLException;
import models.user;
import service.updateUserService;

@WebServlet(name = "updateUserServlet", urlPatterns = {"/updateUser"})
public class updateUserServlet extends HttpServlet {

    private updateUserService updateUserService = new updateUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userId"));
        user updateUser = updateUserService.getUserById(id);
        request.setAttribute("updateUser", updateUser);
        request.getRequestDispatcher("/user/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("userId"));
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

        try {
            boolean success = updateUserService.updateUser(id, username, email, password, fullName,
                    phoneNumber, roleId, locked, avatar, sex, birthDateStr, score);
            if (success) {
                response.sendRedirect(request.getContextPath() + "/userManagement");
            } else {
                request.setAttribute("errorMessage", "Cập nhật người dùng thất bại.");
                request.setAttribute("user", updateUserService.getUserById(id));
                request.getRequestDispatcher("/updateUser").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Cập nhật người dùng thất bại: " + e.getMessage());
            request.setAttribute("user", updateUserService.getUserById(id));
            request.getRequestDispatcher("/updateUser").forward(request, response);
        }
    }
}
