/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Lớp DBConnection giúp quản lý kết nối đến SQL Server. Dùng trong Java Web
 * (Servlet & JSP) để thực hiện truy vấn database. Nó giúp mở kết nối
 * (Connection) đến database Game_PRJ, chạy trên localhost với cổng 57000. Lớp
 * này có phương thức getConnection() để lấy kết nối khi cần.
 */
public class DBConnection {

    // driverName: Chuỗi này chỉ định driver JDBC để kết nối với SQL Server.
    // "com.microsoft.sqlserver.jdbc.SQLServerDriver" là driver của Microsoft SQL Server.
    public static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    // dbURL: Đây là đường dẫn (URL) của database.
    // jdbc:sqlserver://localhost:57000 → Kết nối SQL Server chạy trên localhost với port 57000.
    // databaseName=Game_PRJ → Chỉ định database Game_PRJ.
    public static String dbURL = "jdbc:sqlserver://localhost:57000;databaseName=ShopLuyenTap";

    // userDB & passDB: Chứa tài khoản SA (System Administrator) và mật khẩu dùng để đăng nhập vào SQL Server.
    public static String userDB = "SA";
    public static String passDB = "Str#ng_Passw#rd";

    /**
     * Phương thức getConnection() giúp thiết lập kết nối với SQL Server, cho
     * phép ứng dụng Java Web tương tác với cơ sở dữ liệu một cách dễ dàng.
     *
     * ⚡ Tại sao phương thức này quan trọng? 
     * - Là cầu nối giữa ứng dụng và database, giúp lấy dữ liệu, thêm mới, cập nhật hoặc xóa thông tin. 
     * - Giúp tái sử dụng mã kết nối, tránh viết lại nhiều lần ở các nơi khác nhau trong chương trình. 
     * - Đảm bảo xử lý lỗi tốt hơn: nếu kết nối thất bại, chương trình có thể phát hiện và ghi log thay vì bị crash.
     *
     * @return Một đối tượng Connection nếu kết nối thành công, hoặc null nếu có lỗi xảy ra.
     */
    public static Connection getConnection() {
        
        // Khai báo một biến con kiểu Connection.
        // Ban đầu gán giá trị null, phòng trường hợp kết nối không thành công.
        Connection con = null;
        
        try {
            // Nạp JDBC Driver của SQL Server vào bộ nhớ Java.
            // Điều này giúp Java biết cách giao tiếp với SQL Server.
            Class.forName(driverName);
            
            // Mở kết nối đến database bằng DriverManager
            //    `DriverManager.getConnection(dbURL, userDB, passDB)` sẽ:
            //     Tìm driver JDBC phù hợp dựa trên `dbURL`.
            //     Tạo kết nối (`Connection`) đến SQL Server.
            //     Trả về một đối tượng `Connection` nếu kết nối thành công.
            //     Nếu có lỗi (sai mật khẩu, SQL Server không chạy), sẽ ném SQLException.
            con = DriverManager.getConnection(dbURL, userDB, passDB);
                       
            // Nếu kết nối thành công, con chứa đối tượng Connection và được trả về.
            return con;
                                   
        } catch (Exception ex) {
            
            // Nếu xảy ra lỗi khi kết nối đến database, hệ thống sẽ ghi lỗi vào log.
            // Câu lệnh này có nhiệm vụ giúp lập trình viên dễ dàng phát hiện lỗi và tìm cách khắc phục.

            // Logger.getLogger(DBConnection.class.getName()):
            //    - Lấy hoặc tạo một Logger dành riêng cho lớp DBConnection.
            //    - Điều này giúp phân biệt log lỗi của các lớp khác nhau trong hệ thống.

            // .log(Level.SEVERE, "Lỗi kết nối database", ex):
            //    - Ghi lỗi với mức độ SEVERE (nghiêm trọng).
            //    - Chuỗi "Lỗi kết nối database" giúp mô tả lỗi cụ thể.
            //    - `ex` là đối tượng SQLException, giúp hiển thị chi tiết lỗi và vị trí xảy ra lỗi.
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Nếu có lỗi xảy ra trong quá trình kết nối, phương thức sẽ trả về null.
        return null;
    }
    
    // Hàm test kết nối giữa database và code đã oke chưa
    public static void main(String[] args) {

        try (Connection con = getConnection()) {
            if (con != null) {
                System.out.println("Connect to ShopLuyenTap Success");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
