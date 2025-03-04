/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userDAO;

import java.sql.SQLException;
import java.util.List;
import models.user;

/*
 * =====================================================================
 * INTERFACE IUserDAO - LÝ DO SỬ DỤNG VÀ LỢI ÍCH
 * =====================================================================
 *
 * 1. Tách biệt giao diện và cài đặt (Abstraction):
 *    - Interface IUserDAO định nghĩa các phương thức cần có của lớp DAO (ví dụ: 
 *      authenticateUser(), createUser(), ...).
 *    - Các lớp khác (Service, Controller) chỉ cần sử dụng các phương thức này
 *      theo "hợp đồng" được định nghĩa trong IUserDAO mà không cần biết chi tiết
 *      cách thức thực hiện bên trong.
 *
 * 2. Độc lập với chi tiết triển khai:
 *    - Các lớp sử dụng IUserDAO không phụ thuộc vào cách triển khai cụ thể.
 *    - Nếu cần thay đổi cách truy cập dữ liệu (ví dụ chuyển từ JDBC sang ORM),
 *      chỉ cần thay đổi lớp cài đặt (như chuyển từ UserDAOJDBC sang UserDAOHibernate)
 *      mà không cần phải sửa đổi các lớp gọi đến giao diện IUserDAO.
 *
 * 3. Hỗ trợ kiểm thử (Unit Testing):
 *    - Sử dụng interface cho phép dễ dàng tạo ra các phiên bản giả (mock)
 *      của IUserDAO để kiểm thử mà không cần kết nối thực sự đến cơ sở dữ liệu.
 *
 * 4. Tăng tính mở rộng và bảo trì:
 *    - Việc tách giao diện và cài đặt giúp hệ thống dễ bảo trì, dễ mở rộng.
 *    - Tuân thủ các nguyên tắc thiết kế như Dependency Inversion và Open/Closed,
 *      giúp giảm thiểu rủi ro khi cần thay đổi logic truy cập dữ liệu.
 *
 * Tóm lại: 
 * Việc sử dụng IUserDAO không chỉ định nghĩa các phương thức cần thiết mà còn giúp 
 * giữ cho các lớp sử dụng trở nên độc lập với chi tiết triển khai, dễ kiểm thử, 
 * bảo trì và mở rộng trong quá trình phát triển ứng dụng.
 * =====================================================================
 */
public interface IUserDAO {

    /**
     * Xác thực người dùng dựa trên thông tin định danh và mật khẩu.
     *
     * Phương thức này kiểm tra xem có tồn tại một người dùng trong cơ sở dữ
     * liệu với thông tin định danh (username, email hoặc số điện thoại) và mật
     * khẩu tương ứng hay không. Nếu tìm thấy, nó trả về một đối tượng User chứa
     * đầy đủ thông tin của người dùng, bao gồm thông tin cá nhân và vai trò
     * (role) của họ.
     *
     * @param identifier Chuỗi định danh của người dùng (username, email hoặc số
     * điện thoại).
     * @param password Mật khẩu của người dùng.
     * @return Đối tượng User nếu thông tin xác thực khớp; ngược lại, trả về
     * null.
     */
    user authenticateUser(String identifier, String password);
    
    void insertUser(user user) throws SQLException;
    
    List<user> selectAllUsers();
}
