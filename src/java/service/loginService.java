/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import models.user;
import userDAO.UserDAO;


public class loginService {
    
    private UserDAO userDao = new UserDAO();

    // Phương thức xác thực đăng nhập
    public user authenticate(String identifier, String password) {
        return userDao.authenticateUser(identifier, password);
    }
}
