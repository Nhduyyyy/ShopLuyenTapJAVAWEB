/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import userDAO.UserDAO;


@WebServlet(name = "deleteUserServlet", urlPatterns = {"/deleteUser"})
public class deleteUserServlet extends HttpServlet {

    private UserDAO userDao = new UserDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            userDao.deleteUser(id);
        } catch (SQLException ex) {
            Logger.getLogger(deleteUserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect(request.getContextPath() + "/userManagement");
    }
    
}
