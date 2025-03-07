<%-- 
    Document   : register
    Created on : 3 thg 3, 2025, 01:27:33
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
        <title>register</title>

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
            /* CSS cho trang đăng ký, sử dụng các class chuyên biệt */
            .register-page {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 20px;
            }

            .register-page h1 {
                text-align: center;
                color: #333;
            }

            .register-form {
                background-color: #fff;
                max-width: 500px;
                margin: 20px auto;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .register-form .form-group {
                margin-bottom: 15px;
            }

            .register-form label {
                display: block;
                margin-bottom: 5px;
                color: #555;
            }

            .register-form input[type="text"],
            .register-form input[type="email"],
            .register-form input[type="password"],
            .register-form input[type="date"],
            .register-form select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            .register-form button[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #4285f4;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                font-size: 16px;
            }

            .register-form button[type="submit"]:hover {
                background-color: #357ae8;
            }

            .register-form p {
                margin: 0;
            }
        </style>


    </head>

    <body class="register-page">
        <h1>Đăng ký tài khoản</h1>

        <!-- Hiển thị thông báo lỗi nếu có -->
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
            <p style="color:red;">${errorMessage}</p>
        </c:if>

        <form class="register-form" action="register" method="post">
            <div class="form-group">
                <label for="username">Tên đăng nhập:</label>
                <input type="text" id="username" name="username" required />
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required />
            </div>
            <div class="form-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required />
            </div>
            <div class="form-group">
                <label for="fullName">Họ và tên:</label>
                <input type="text" id="fullName" name="fullName" required />
            </div>
            <div class="form-group">
                <!-- Label liên kết với phần tử select có id="sex" -->
                <label for="sex">Giới tính:</label> 
                
                <!-- Dropdown chọn giới tính; "name" là key khi gửi form, "required" buộc phải chọn -->
                <select id="sex" name="sex" required>  
                    
                    <!-- Lựa chọn với giá trị "Male" và hiển thị "Nam" -->
                    <!-- - Thuộc tính "value" là "Male" (giá trị sẽ được gửi khi form được nộp). -->
                    <option value="Male">Nam</option>   
                    
                    <!-- Lựa chọn với giá trị "Female" và hiển thị "Nữ" -->                
                    <option value="Female">Nữ</option>
                    
                    <!-- Lựa chọn với giá trị "Other" và hiển thị "Khác" -->
                    <option value="Other">Khác</option>    
                </select>
            </div>

            <div class="form-group">
                <label for="birthDate">Ngày sinh:</label>
                <input type="date" id="birthDate" name="birthDate" required />
                <!--
                    Thẻ input với type="date" tạo ra giao diện chọn ngày (date picker).
                    Khi người dùng chọn ngày, giá trị được gửi theo định dạng ISO 8601, tức là "yyyy-MM-dd".
                    Điều này phù hợp với định dạng được dùng trong Java:
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Nhờ đó, khi dữ liệu được gửi lên server, chuỗi ngày sinh có định dạng 
                    chính xác để chuyển đổi thành đối tượng Date.
                -->
            </div>
            <div class="form-group">
                <label for="phoneNumber">Số điện thoại (tùy chọn):</label>
                <input type="text" id="phoneNumber" name="phoneNumber" />
            </div>
            <div class="form-group">
                <button type="submit">Đăng ký</button>
            </div>
        </form>
    </body>
</html>
<%@ include file="/common/footer.jsp" %>
<!-- Bao gồm file footer.jsp từ thư mục common để hiển thị thanh điều hướng chung -->