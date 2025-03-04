/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.role;
import models.user;
import userDAO.UserDAO;


public class registrationService {
    private UserDAO userDao = new UserDAO();

    /**
     * Phương thức thực hiện đăng ký người dùng.
     * @param username Tên đăng nhập
     * @param email Email của người dùng
     * @param password Mật khẩu
     * @param phoneNumber Số điện thoại
     * @param fullName Họ và tên
     * @param sex Giới tính
     * @param birthDateStr Ngày sinh dạng chuỗi ("yyyy-MM-dd")
     * @throws SQLException Nếu có lỗi khi lưu dữ liệu vào cơ sở dữ liệu.
     */
    public void registerUser(String username, String email, String password,
                             String phoneNumber, String fullName, String sex,
                             String birthDateStr) throws SQLException {
        
        // Chuyển đổi chuỗi ngày sinh (birthDateStr) sang đối tượng 
        // Date sử dụng định dạng "yyyy-MM-dd" và nó là "java.util.Date;"
        // Khởi tạo biến birthDate với giá trị null.
        // Biến này sẽ lưu trữ kết quả sau khi chuyển đổi chuỗi birthDateStr thành đối tượng Date.
        Date birthDate = null;
        try {
            
            // Tạo một đối tượng SimpleDateFormat với định dạng "yyyy-MM-dd".
            // Định dạng này khớp với kiểu dữ liệu ngày sinh được nhập từ form (ví dụ: "2004-11-13").
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            
            // Cố gắng chuyển đổi chuỗi birthDateStr thành đối tượng Date bằng cách sử dụng phương thức parse.
            // Nếu chuỗi birthDateStr có định dạng đúng ("yyyy-MM-dd"), parse sẽ trả về một đối tượng Date tương ứng.
            birthDate = sdf.parse(birthDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            
            // Để đảm bảo rằng biến birthDate luôn có giá trị hợp lệ (không null),
            // gán giá trị mặc định là thời gian hiện tại nếu xảy ra lỗi.
            birthDate = new Date();
        }

        // Tạo đối tượng role mặc định cho người dùng mới
        // Role này có id = 3 và tên "User", nhằm gán quyền truy cập cơ bản cho người dùng.
        role role = new role(3, "User");

        // Thiết lập các giá trị mặc định cho người dùng
        String avatar = "default.gif";  // Ảnh đại diện mặc định
        int score = 0;                  // Điểm ban đầu cho người dùng
        boolean locked = false;         // Trạng thái tài khoản: false nghĩa là tài khoản chưa bị khóa
        
        // Lấy thời gian hiện tại của hệ thống để ghi nhận thời gian tạo và cập nhật tài khoản
        // System.currentTimeMillis() trả về số mili giây tính từ thời điểm 00:00:00 UTC ngày 1/1/1970 (Unix Epoch)
        // Sử dụng giá trị mili giây này, ta tạo ra một đối tượng java.sql.Timestamp, 
        // đối tượng này phù hợp để lưu trữ thời gian theo kiểu TIMESTAMP trong cơ sở dữ liệu.
        java.sql.Timestamp currentTime = new java.sql.Timestamp(System.currentTimeMillis());
        
        // Biến currentTime chứa thời gian hiện tại của hệ thống.
        // Giá trị này sẽ được dùng để thiết lập thời gian tạo (createdAt) và cập nhật (updatedAt) của tài khoản người dùng.

        // Tạo đối tượng user và thiết lập các thuộc tính
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

        // Gọi hàm insert của UserDAO để lưu thông tin vào cơ sở dữ liệu
        userDao.insertUser(user);
    }
}
