<%-- 
    Document   : updateUser
    Created on : 4 thg 3, 2025, 18:35:03
    Author     : nhatduy261179
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Chỉnh sửa người dùng</h2>
    
    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/updateUser" method="post">
        <!-- Sử dụng input hidden để gửi userId -->
        <input type="hidden" name="userId" value="${updateUser.userId}" />
        <p>
            <label>Tên đăng nhập:</label>
            <input type="text" name="username" value="${updateUser.username}" required />
        </p>
        <p>
            <label>Email:</label>
            <input type="email" name="email" value="${updateUser.email}" required />
        </p>
        <p>
            <label>Mật khẩu:</label>
            <input type="password" name="password" value="${updateUser.password}" required />
        </p>
        <p>
            <label>Họ tên:</label>
            <input type="text" name="fullName" value="${updateUser.fullName}" required />
        </p>
        <p>
            <label>Số điện thoại:</label>
            <input type="text" name="phoneNumber" value="${updateUser.phoneNumber}" />
        </p>
        <p>
            <label>Vai trò:</label>
            <select name="roleId">
                <option value="1" ${updateUser.role.roleId == 1 ? 'selected' : ''}>Admin</option>
                <option value="2" ${updateUser.role.roleId == 2 ? 'selected' : ''}>Manager</option>
                <option value="3" ${updateUser.role.roleId == 3 ? 'selected' : ''}>User</option>
                <!-- Thêm các option khác nếu cần -->
            </select>
        </p>
        <p>
            <label>Avatar:</label>
            <input type="text" name="avatar" value="${updateUser.avatar}" />
        </p>
        <p>
            <label>Score:</label>
            <input type="number" name="score" value="${updateUser.score}" />
        </p>
        <p>
            <label>Giới tính:</label>
            <select name="sex">
                <option value="Nam" ${updateUser.sex == 'Nam' ? 'selected' : ''}>Nam</option>
                <option value="Nữ" ${updateUser.sex == 'Nữ' ? 'selected' : ''}>Nữ</option>
            </select>
        </p>
        <p>
            <label>Ngày sinh:</label>
            <input type="date" name="birthDate" value="${updateUser.birthDate}" />
        </p>
        <p>
            <label>Tình trạng:</label>
            <select name="locked">
                <option value="false" ${!updateUser.locked ? 'selected' : ''}>Hoạt động</option>
                <option value="true" ${updateUser.locked ? 'selected' : ''}>Khóa</option>
            </select>
        </p>
        <p>
            <input type="submit" value="Cập nhật" />
        </p>
    </form>
    </body>
</html>
