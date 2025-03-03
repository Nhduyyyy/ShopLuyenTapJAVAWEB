<%-- 
    Document   : login
    Created on : 2 thg 3, 2025, 16:55:09
    Author     : nhatduy261179
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Đặt content type và mã hóa trang là UTF-8 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Import thư viện JSTL với prefix "c" để sử dụng các thẻ JSTL trong trang -->

<%@ include file="/common/nav.jsp" %>
<!-- Bao gồm file nav.jsp từ thư mục common để hiển thị thanh điều hướng chung -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>

        <!-- Bootstrap css -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <!-- Bootstrap Bundle JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <!-- Font Awesome: Thư viện icon phong phú, giúp thêm các biểu tượng vector dễ dàng vào giao diện web -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" 
              integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" 
              crossorigin="anonymous" 
              referrerpolicy="no-referrer" />
        <style>

            /* CSS cho trang đăng nhập, sử dụng class riêng biệt */
            .login-page-wrapper {
                background-color: #f2f2f2;
                padding: 50px 0;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
                font-family: Arial, sans-serif;
            }

            .login-container {
                background-color: #fff;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                width: 100%;
            }

            .login-container h2 {
                text-align: center;
                margin-bottom: 20px;
                color: #333;
            }

            .login-container label {
                display: block;
                margin-bottom: 5px;
                color: #555;
            }

            .login-container input[type="text"],
            .login-container input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 15px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .login-container input[type="submit"] {
                width: 100%;
                padding: 10px;
                border: none;
                border-radius: 4px;
                background-color: #4285f4;
                color: #fff;
                font-size: 16px;
                cursor: pointer;
            }

            .login-container input[type="submit"]:hover {
                background-color: #357ae8;
            }

            .login-container .error {
                color: red;
                margin-bottom: 15px;
                text-align: center;
            }
        </style>

    </head>
    <body>
        <div class="login-page-wrapper">
            <div class="login-container">
                <h2>Đăng nhập</h2>
                <!-- Hiển thị thông báo lỗi nếu có -->
                <!--
                    Sử dụng thẻ JSTL <_c:if> để kiểm tra điều kiện:
                    - Kiểm tra xem thuộc tính errorMessage có giá trị hay không.
                    - Biểu thức $_{not empty errorMessage} trả về true nếu errorMessage không rỗng.
                -->
                <c:if test="${not empty errorMessage}">
                    <!--
                        Nếu điều kiện trên đúng, tức là có thông báo lỗi được truyền từ Servlet,
                        thì hiển thị một div với class "error" để định dạng thông báo lỗi (theo CSS).
                        Nội dung của div được lấy từ biến errorMessage và hiển thị cho người dùng.
                    -->
                    <div class="error">${errorMessage}</div>
                </c:if>

                <!--
                    $_{pageContext.request.contextPath} lấy đường dẫn gốc (context path) của ứng dụng hiện tại.
                    Điều này giúp xây dựng các URL tuyệt đối, đảm bảo rằng các liên kết và tham chiếu tài nguyên luôn chính xác
                    bất kể ứng dụng được triển khai ở đâu trên máy chủ.
                    Ví dụ: Nếu ứng dụng được triển khai với context path là "/login", biểu thức này sẽ trả về "/login".
                -->
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <label for="identifier">Tên đăng nhập hoặc Email:</label>
                    <input type="text" id="identifier" name="identifier" required />

                    <label for="password">Mật khẩu:</label>
                    <input type="password" id="password" name="password" required />

                    <input type="submit" value="Đăng nhập" />
                </form>
            </div>
        </div>
    </body>
</html>


<%@ include file="/common/footer.jsp" %>
<!-- Bao gồm file footer.jsp từ thư mục common để hiển thị thanh điều hướng chung -->