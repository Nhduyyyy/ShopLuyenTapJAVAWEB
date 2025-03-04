/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.role;
import models.user;
import userDAO.UserDAO;
import java.sql.SQLException;


public class updateUserService {
    private UserDAO userDao = new UserDAO();

    /**
     * Lấy đối tượng người dùng theo id.
     * @param id Mã người dùng.
     * @return Đối tượng user nếu tìm thấy, ngược lại trả về null.
     */
    public user getUserById(int id) {
        // Duyệt qua danh sách người dùng để tìm theo id
        for (user u : userDao.selectAllUsers()) {
            if (u.getUserId() == id) {
                return u;
            }
        }
        return null;
    }
    
    /**
     * Cập nhật thông tin người dùng.
     * @param id Mã người dùng.
     * @param username Tên đăng nhập.
     * @param email Email.
     * @param password Mật khẩu.
     * @param fullName Họ và tên.
     * @param phoneNumber Số điện thoại.
     * @param roleId Id của vai trò.
     * @param locked Trạng thái khóa.
     * @param avatar Ảnh đại diện.
     * @param sex Giới tính.
     * @param birthDateStr Ngày sinh dạng chuỗi ("yyyy-MM-dd").
     * @param score Điểm số.
     * @return true nếu cập nhật thành công, false nếu không.
     * @throws SQLException Nếu có lỗi khi cập nhật vào cơ sở dữ liệu.
     */
    public boolean updateUser(int id, String username, String email, String password,
                              String fullName, String phoneNumber, int roleId,
                              boolean locked, String avatar, String sex,
                              String birthDateStr, int score) throws SQLException {
        
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
        user updatedUser = new user();
        updatedUser.setUserId(id);
        updatedUser.setUsername(username);
        updatedUser.setEmail(email);
        updatedUser.setPassword(password);
        updatedUser.setFullName(fullName);
        updatedUser.setRole(role);
        updatedUser.setPhoneNumber(phoneNumber);
        updatedUser.setAvatar(avatar);
        updatedUser.setScore(score);
        updatedUser.setSex(sex);
        updatedUser.setBirthDate(birthDate);
        updatedUser.setUpdatedAt(currentTime);
        updatedUser.setLocked(locked);
        
        // Gọi phương thức updateUser của UserDAO
        return userDao.updateUser(updatedUser);
    }
}
