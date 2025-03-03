/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDAO;

import dao.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.role;
import models.user;

/**
 *
 * @author nhatduy261179
 */
public class UserDAO implements IUserDAO{
    
    
    /*
     * ---------------------------------------------------------------------------
     * Mục đích và Nhu cầu:
     * ---------------------------------------------------------------------------
     * Phương thức authenticateUser được thiết kế để xác thực thông tin đăng nhập
     * của người dùng. Nó kiểm tra xem thông tin được cung cấp (identifier và password)
     * có khớp với một bản ghi nào trong cơ sở dữ liệu hay không. Đây là bước quan trọng
     * để đảm bảo chỉ những người dùng hợp lệ mới có thể truy cập vào các chức năng bảo mật
     * của ứng dụng.
     */
    @Override
    public user authenticateUser(String identifier, String password) {
        
        // Khởi tạo đối tượng user với giá trị mặc định là null.
        // Nếu truy vấn không trả về kết quả (không tìm thấy người dùng phù hợp),
        // biến user vẫn giữ giá trị null, giúp xử lý trường hợp đăng nhập không thành công.
        user user = null;
        
        // Xây dựng chuỗi truy vấn SQL để lấy thông tin người dùng và vai trò từ bảng Users và Roles.
        // Truy vấn sẽ lấy các cột cần thiết của người dùng (UserID, Username, Email, Password, FullName, 
        // PhoneNumber, Avatar, Score, Sex, BirthDate, CreatedAt, UpdatedAt, Locked) từ bảng Users (alias u)
        // và các thông tin vai trò (RoleID, RoleName, Description) từ bảng Roles (alias r) thông qua phép nối INNER JOIN.
        // Điều kiện WHERE:
        //   - Cho phép đăng nhập bằng Username, Email hoặc PhoneNumber (3 tham số đầu)
        //   - Và kiểm tra mật khẩu khớp với giá trị được cung cấp (tham số thứ 4)
        String sql = "SELECT u.UserID, u.Username, u.Email, u.Password, u.FullName, "
                + "       u.PhoneNumber, u.Avatar, u.Score, u.Sex, "
                + "       u.BirthDate, u.CreatedAt, u.UpdatedAt, u.Locked, " 
                + "       r.RoleID AS RoleId, r.RoleName, r.Description "
                + "FROM [Users] u "
                + "INNER JOIN Roles r ON u.RoleId = r.RoleID "
                + "WHERE (u.Username = ? OR u.Email = ? OR u.PhoneNumber = ?) AND u.password = ?";
        
        // Sử dụng try-with-resources để tự động quản lý và đóng các tài nguyên liên quan đến cơ sở dữ liệu.
        // Điều này giúp tránh rò rỉ tài nguyên (resource leak) và đảm bảo rằng các kết nối, câu lệnh truy vấn sẽ được đóng đúng cách
        // ngay cả khi có ngoại lệ xảy ra trong quá trình xử lý.
        // 
        // Connection conn = DBConnection.getConnection();
        //   - Mở kết nối đến cơ sở dữ liệu thông qua phương thức getConnection() của lớp DBConnection.
        //   - Đối tượng conn được sử dụng để gửi các truy vấn và lệnh đến cơ sở dữ liệu.
        // 
        // PreparedStatement stmt = conn.prepareStatement(sql);
        //   - Tạo một PreparedStatement từ chuỗi truy vấn SQL (được gán cho biến sql).
        //   - PreparedStatement giúp chuẩn bị và thực thi câu truy vấn với các tham số được gán sau này.
        //   - Việc sử dụng PreparedStatement cũng giúp bảo vệ khỏi các cuộc tấn công SQL injection.
        // 
        // Cả conn và stmt đều được khai báo trong khối try-with-resources, do đó sau khi khối try hoàn thành,
        // chúng sẽ tự động được đóng, giải phóng tài nguyên mà không cần phải gọi stmt.close() hoặc conn.close() thủ công.
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) 
        {
            
            // Gán giá trị cho các placeholder (dấu hỏi ?) trong câu truy vấn SQL bằng cách sử dụng PreparedStatement.
            // Câu truy vấn có 4 dấu hỏi (?) trong mệnh đề WHERE, với thứ tự sau:
            //   - Dấu hỏi thứ 1: So sánh với u.Username
            //   - Dấu hỏi thứ 2: So sánh với u.Email
            //   - Dấu hỏi thứ 3: So sánh với u.PhoneNumber
            //   - Dấu hỏi thứ 4: So sánh với u.password
            //
            // Vì vậy, ta gán giá trị như sau:          
            stmt.setString(1, identifier); // Gán 'identifier' cho u.Username
            stmt.setString(2, identifier); // Gán 'identifier' cho u.Email
            stmt.setString(3, identifier); // Gán 'identifier' cho u.PhoneNumber
            stmt.setString(4, password);   // Gán 'password' cho u.password  
                 
            // Thực thi câu truy vấn và lưu kết quả trả về trong đối tượng ResultSet.
            // ResultSet chứa tất cả các dòng dữ liệu trả về từ truy vấn SELECT.
            // Con trỏ của ResultSet ban đầu được đặt trước dòng đầu tiên,
            // và phương thức rs.next() sẽ di chuyển con trỏ tới dòng tiếp theo.
            try (ResultSet rs = stmt.executeQuery()) {
                
                // Kiểm tra xem có dữ liệu trả về không. Nếu có, con trỏ ResultSet sẽ được đặt vào dòng đầu tiên.
                if (rs.next()) {
                    
                    // Khởi tạo đối tượng role với các giá trị lấy từ ResultSet:
                    // - rs.getInt("RoleId"): Lấy giá trị số nguyên của RoleId.
                    // - rs.getString("RoleName"): Lấy giá trị chuỗi của RoleName.
                    // - rs.getString("Description"): Lấy giá trị chuỗi của Description.
                    role role = new role(rs.getInt("RoleId"), rs.getString("RoleName"), rs.getString("Description"));
                    
                    // Khởi tạo đối tượng user và gán các thuộc tính với giá trị từ ResultSet.
                    user = new user();
                    user.setUserId(rs.getInt("UserID"));
                    user.setRole(role); // Gán đối tượng role đã tạo
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
            // In ra ngăn xếp lỗi để xác định nguyên nhân và vị trí xảy ra lỗi.
            // Đây là công cụ hữu ích khi debug ứng dụng.
            e.printStackTrace();
        }
        return user;
    }
    
    @Override
    public void insertUser(user user) throws SQLException {
        String sql = "INSERT INTO [Users] (Username, Email, Password, FullName, RoleId, PhoneNumber, "
                + "Avatar, Score, Sex, BirthDate, CreatedAt, UpdatedAt, Locked) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), GETDATE(), ?)";
        
        try (Connection conn = DBConnection.getConnection(); 
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getFullName());
            stmt.setInt(5, user.getRole().getRoleId());
            stmt.setString(6, user.getPhoneNumber());
            stmt.setString(7, user.getAvatar());
            stmt.setInt(8, user.getScore());
            stmt.setString(9, user.getSex());
            stmt.setDate(10, new java.sql.Date(user.getBirthDate().getTime()));
            stmt.setBoolean(11, user.isLocked());          
            stmt.executeUpdate();
        }
    }
}
