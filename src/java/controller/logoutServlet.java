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

// Đánh dấu lớp loginServlet là một Servlet, và ánh xạ (mapping) nó đến URL /logout.
// Khi có yêu cầu (request) gửi đến /logout, container (ví dụ: Tomcat) sẽ khởi chạy Servlet này.
@WebServlet(name = "logoutServlet", urlPatterns = {"/logout"})
public class logoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy phiên (session) hiện tại của người dùng.
        // Sử dụng getSession(false) có nghĩa là nếu phiên không tồn tại, nó sẽ trả về null và không tạo mới.
        HttpSession session = request.getSession(false);

        // Kiểm tra xem phiên có tồn tại không.
        // Nếu session khác null (tức là người dùng đã có phiên làm việc), tiến hành hủy phiên đó.
        if (session != null) {
            // Hủy phiên hiện tại, điều này sẽ xóa tất cả dữ liệu lưu trữ trong phiên.
            // Thao tác này thường được sử dụng khi người dùng đăng xuất khỏi hệ thống.
            session.invalidate();
        }

        // Chuyển hướng (redirect) người dùng đến trang chủ của ứng dụng.
        // request.getContextPath() trả về đường dẫn gốc của ứng dụng (ví dụ: /myApp)
        // Nối với "/home.jsp" để tạo URL đầy đủ của trang chủ.
        // Khi sendRedirect được gọi, trình duyệt của người dùng sẽ được chuyển hướng tới URL mới.
        response.sendRedirect(request.getContextPath() + "/home.jsp");
    }

}
