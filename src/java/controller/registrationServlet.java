/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import models.role;
import models.user;
import service.registrationService;
import userDAO.UserDAO;

// Đánh dấu lớp loginServlet là một Servlet, và ánh xạ (mapping) nó đến URL /register.
// Khi có yêu cầu (request) gửi đến /register, container (ví dụ: Tomcat) sẽ khởi chạy Servlet này.
@WebServlet(name = "registrationServlet", urlPatterns = {"/register"})
public class registrationServlet extends HttpServlet {

    // Tạo đối tượng RegistrationService
    private registrationService registrationService = new registrationService();

    // Phương thức xử lý yêu cầu GET đến /register
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // request.getRequestDispatcher: 
        // Lấy đối tượng RequestDispatcher dựa trên đường dẫn đến tài nguyên cần chuyển giao.
        //  - Đường dẫn "/authenticator_authorization/register.jsp" chỉ định vị trí của trang JSP trong ứng dụng.
        //  - RequestDispatcher này cho phép chuyển giao yêu cầu HTTP hiện tại tới trang JSP đó,
        //    giữ nguyên tất cả các thông tin của request (tham số, thuộc tính, v.v.).
        // forward(request, response):
        // Phương thức forward chuyển giao toàn bộ yêu cầu và phản hồi hiện tại từ Servlet tới tài nguyên đã chỉ định.
        //  - Quá trình chuyển giao diễn ra hoàn toàn trên máy chủ, không tạo ra một yêu cầu mới.
        //  - Giúp tách biệt logic xử lý (trong Servlet) và giao diện hiển thị (trang JSP),
        //    đồng thời truyền dữ liệu đã được thiết lập trong request tới tài nguyên hiển thị.
        // Lợi ích:
        // 1. Tách biệt rõ ràng giữa logic xử lý của Servlet và giao diện hiển thị của JSP.
        // 2. Toàn bộ thông tin của request được giữ nguyên và truyền sang trang JSP, giúp dễ dàng xử lý dữ liệu hiển thị.
        // 3. Quá trình chuyển giao diễn ra trên máy chủ, giảm thiểu số lần yêu cầu HTTP và cải thiện hiệu năng.
        // 4. URL trên trình duyệt không bị thay đổi, giúp bảo mật và ẩn đi cấu trúc nội bộ của ứng dụng.
        request.getRequestDispatcher("/authenticator_authorization/register.jsp").forward(request, response);
    }

    // Phương thức xử lý yêu cầu POST khi người dùng gửi form đăng nhập
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy các tham số được gửi từ form đăng ký qua phương thức POST
        // Mỗi giá trị được lấy dựa trên tên của các trường input trong form
        // Các giá trị được lấy từ form HTML dựa trên thuộc tính "name" của từng input.
        // Ví dụ, trong HTML có:
        // <input type="text" name="username" placeholder="Tên đăng nhập" />
        // Khi form được gửi, dữ liệu của trường này sẽ được truy xuất thông qua:
        // request.getParameter("username")
        String username = request.getParameter("username");      // Tên đăng nhập của người dùng
        String email = request.getParameter("email");            // Địa chỉ email của người dùng
        String password = request.getParameter("password");      // Mật khẩu của người dùng
        String phoneNumber = request.getParameter("phoneNumber");  // Số điện thoại của người dùng
        String fullName = request.getParameter("fullName");        // Họ và tên đầy đủ của người dùng
        String sex = request.getParameter("sex");                  // Giới tính của người dùng
        String birthDateStr = request.getParameter("birthDate");   // Ngày sinh dưới dạng chuỗi - string ("yyyy-MM-dd")
            
         // Thực hiện lưu thông tin người dùng vào cơ sở dữ liệu và xử lý ngoại lệ nếu có lỗi xảy ra
        try {
            // Gọi service xử lý đăng ký
            registrationService.registerUser(username, email, password, phoneNumber, fullName, sex, birthDateStr);
            
            request.setAttribute("successMessage", "Đăng kí thành công, vui lòng đăng nhập.");
            request.getRequestDispatcher("/authenticator_authorization/login.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Đăng kí thất bại: " + e.getMessage());
            request.getRequestDispatcher("/authenticator_authorization/register.jsp").forward(request, response);
        }
    }
}
