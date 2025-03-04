<%-- 
    Document   : createUser
    Created on : 4 thg 3, 2025, 20:51:01
    Author     : nhatduy261179
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Tạo Người Dùng Mới</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            .form-group {
                margin-bottom: 15px;
            }
            label {
                display: inline-block;
                width: 120px;
            }
            input, select {
                width: 200px;
            }
            .error {
                color: red;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <h1>Tạo Người Dùng Mới</h1>

        <!-- Hiển thị thông báo lỗi nếu có -->
        <c:if test="${not empty errorMessages}">
            <div class="error">${errorMessages}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/createUser" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" name="username" id="username" required/>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" id="email" required/>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" name="password" id="password" required/>
            </div>
            <div class="form-group">
                <label for="fullName">Họ và tên:</label>
                <input type="text" name="fullName" id="fullName" required/>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Số điện thoại:</label>
                <input type="text" name="phoneNumber" id="phoneNumber" required/>
            </div>
            <div class="form-group">
                <label for="roleId">Vai trò:</label>
                <select name="roleId" id="roleId">
                    <option value="1">Admin</option>
                    <option value="2">Manager</option>
                    <option value="3">User</option>
                </select>
            </div>
            <div class="form-group">
                <label for="locked">Khóa tài khoản:</label>
                <select name="locked" id="locked">
                    <option value="false">False</option>
                    <option value="true">True</option>
                </select>
            </div>
            <div class="form-group">
                <label for="Avatar">Avatar:</label>
                <input type="text" name="Avatar" id="Avatar" placeholder="default.gif nếu để trống"/>
            </div>
            <div class="form-group">
                <label for="sex">Giới tính:</label>
                <select name="sex" id="sex">
                    <option value="Male">Nam</option>
                    <option value="Female">Nữ</option>
                </select>
            </div>
            <div class="form-group">
                <label for="birthDate">Ngày sinh:</label>
                <input type="date" name="birthDate" id="birthDate" required/>
            </div>
            <div class="form-group">
                <label for="score">Điểm số:</label>
                <input type="number" name="score" id="score" required/>
            </div>
            <div class="form-group">
                <button type="submit">Tạo Người Dùng</button>
            </div>
        </form>
    </body>
</html>

