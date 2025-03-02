/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDAO;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.role;
import models.user;

/**
 *
 * @author nhatduy261179
 */
public class UserDAO implements IUserDAO{

    @Override
    public user authenticateUser(String identifier, String password) {
        user user = null;
        String sql = "SELECT u.UserID, u.Username, u.Email, u.Password, u.FullName, "
                + "       u.PhoneNumber, u.Avatar, u.Score, u.Sex, "
                + "       u.BirthDate, u.CreatedAt, u.UpdatedAt, u.Locked, " 
                + "       r.RoleID AS RoleId, r.RoleName, r.Description "
                + "FROM [Users] u "
                + "INNER JOIN Roles r ON u.RoleId = r.RoleID "
                + "WHERE (u.Username = ? OR u.Email = ? OR u.PhoneNumber = ?) AND u.password = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            stmt.setString(1, identifier);
            stmt.setString(2, identifier);
            stmt.setString(3, identifier);
            stmt.setString(4, password);   
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    role role = new role(rs.getInt("RoleId"), rs.getString("RoleName"), rs.getString("Description"));

                    user = new user();
                    user.setUserId(rs.getInt("UserID"));
                    user.setRole(role);
                    user.setUsername(rs.getString("Username"));
                    user.setEmail(rs.getString("Email"));
                    user.setPassword(rs.getString("Password"));
                    user.setFullName(rs.getString("FullName"));
                    user.setPhoneNumber(rs.getString("PhoneNumber"));
                    user.setAvatar(rs.getString("Avatar"));
                    user.setScore(rs.getInt("Score"));
                    user.setSex(rs.getString("Sex"));
                    user.setBirthDate(rs.getDate("BirthDate"));
                    user.setCreatedAt(rs.getTimestamp("createdAt"));
                    user.setUpdatedAt(rs.getTimestamp("updatedAt"));
                    user.setLocked(rs.getBoolean("Locked"));                  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
}
