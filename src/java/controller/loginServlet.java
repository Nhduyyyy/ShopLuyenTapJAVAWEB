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
import jakarta.servlet.http.HttpSession;
import models.user;
import service.loginService;
import userDAO.UserDAO;

// Đánh dấu lớp loginServlet là một Servlet, và ánh xạ (mapping) nó đến URL /login.
// Khi có yêu cầu (request) gửi đến /login, container (ví dụ: Tomcat) sẽ khởi chạy Servlet này.
@WebServlet(name = "loginServlet", urlPatterns = {"/login"})
public class loginServlet extends HttpServlet {

    // Tạo đối tượng LoginService
    private loginService loginService = new loginService();

    // Phương thức xử lý yêu cầu GET đến /login
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // request.getRequestDispatcher: 
        // Lấy đối tượng RequestDispatcher dựa trên đường dẫn đến tài nguyên cần chuyển giao.
        //  - Đường dẫn "/authenticator_authorization/login.jsp" chỉ định vị trí của trang JSP trong ứng dụng.
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
        request.getRequestDispatcher("/authenticator_authorization/login.jsp").forward(request, response);
    }

    // Phương thức xử lý yêu cầu POST khi người dùng gửi form đăng nhập
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy thông tin đăng nhập từ đối tượng request:
        //  - request.getParameter("identifier"): Lấy giá trị từ trường input có name="identifier"
        //    (có thể là username, email hoặc số điện thoại) được gửi từ form đăng nhập.
        //  - request.getParameter("password"): Lấy giá trị từ trường input có name="password"
        //    chứa mật khẩu của người dùng.
        // Những giá trị này được sử dụng để xác thực người dùng trong quá trình xử lý đăng nhập.
        String identifier = request.getParameter("identifier");
        String password = request.getParameter("password");

        // Sử dụng LoginService để xác thực người dùng.
        // Nếu thông tin đăng nhập hợp lệ, trả về đối tượng user; ngược lại trả về null.
        user user = loginService.authenticate(identifier, password);

        if (user != null) {

            /*
            * Các bước hoạt động của hàm locked:
            * 1. Đánh giá biểu thức điều kiện: 
            *    - Java sẽ gọi hàm isLocked() trên đối tượng user (đây chính là hàm getLocked được tạo trong get(), set() trong 
            *    class user nhưng tôi thích đặt là isLocked()), hàm này trả về giá trị boolean (true hoặc false).
            *
            * 2. Kiểm tra kết quả:
            *    - Nếu giá trị trả về là true, khối lệnh bên trong if sẽ được thực hiện.
            *    - Nếu giá trị trả về là false, khối lệnh bên trong if sẽ bị bỏ qua.
            *
            * Bản chất mặc định:
            * - Nếu biểu thức boolean là true => Thực hiện các câu lệnh trong if.
            * - Nếu biểu thức boolean là false => Bỏ qua các câu lệnh trong if.
            * Đây là cách hoạt động cơ bản của cấu trúc điều kiện if trong Java.
             */
            if (user.isLocked()) {
                // Đặt một thuộc tính cho đối tượng request với key "errorMessage"
                // và giá trị "Tài khoản của bạn đang bị khóa."
                // Mục đích: Khi chuyển giao yêu cầu đến trang JSP (ví dụ: trang đăng nhập),
                // thông báo lỗi này có thể được truy xuất và hiển thị cho người dùng.
                // Đây là cách truyền thông tin từ Servlet sang JSP để thông báo trạng thái lỗi hoặc thông tin cần thiết khác.
                request.setAttribute("errorMessage", "Tài khoản của bạn đang bị khóa.");
                request.getRequestDispatcher("login").forward(request, response);
                return;
            }

            // Lấy hoặc tạo một phiên làm việc (session) cho người dùng từ đối tượng request.
            // Nếu phiên làm việc đã tồn tại, nó sẽ được trả về; nếu không, một phiên làm việc mới sẽ được tạo.
            HttpSession session = request.getSession();

            // Lưu thông tin người dùng (đối tượng user) vào phiên làm việc với key "user".
            // Việc này cho phép lưu trữ trạng thái đăng nhập, từ đó các trang khác có thể truy xuất thông tin người dùng từ session.
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } else {
            request.setAttribute("errorMessage", "Tên đăng nhập hoặc mật khẩu không đúng.");
            request.getRequestDispatcher("login").forward(request, response);
        }
    }
}
