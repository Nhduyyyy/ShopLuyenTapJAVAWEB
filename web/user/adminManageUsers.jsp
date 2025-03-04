<%-- 
    Document   : adminManageUsers
    Created on : 4 thg 3, 2025, 13:45:07
    Author     : nhatduy261179
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Đặt content type và mã hóa trang là UTF-8 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Import thư viện JSTL với prefix "c" để sử dụng các thẻ JSTL trong trang -->

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/common/navAdmin.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin manage users</title>

        <!-- Bootstrap CSS: Cung cấp các style cơ bản và responsive cho website -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

        <!-- Bootstrap Bundle JS: Bao gồm các script của Bootstrap và Popper, hỗ trợ tương tác và các thành phần động -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

        <!-- Font Awesome: Thư viện icon phong phú, giúp thêm các biểu tượng vector dễ dàng vào giao diện web -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" 
              integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" 
              crossorigin="anonymous" 
              referrerpolicy="no-referrer" />
    </head>
    <body>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Ảnh</th>
                    <th>Tên người dùng</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Họ và tên</th>
                    <th>Số điện thoại</th>
                    <th>Birth Date</th>
                    <th>Ngày tạo</th>
                    <th>Ngày cập nhật</th>
                    <th>Đã khóa</th>                   
                    <th>ID Vai trò</th>
                    <th>Tên vai trò</th>
                </tr>
            </thead>
            <tbody class="table-group-divider">
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.userId}</td>
                        <td>
                            <img src="${pageContext.request.contextPath}/${user.avatar}" alt="User Image" width="50" height="50"/>
                        </td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.fullName}</td>
                        <td>${user.phoneNumber}</td>
                        <td>
                            <fmt:formatDate value="${user.birthDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>
                            <fmt:formatDate value="${user.createdAt}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                        </td>
                        <td>
                            <fmt:formatDate value="${user.updatedAt}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${user.locked}">khóa</c:when>
                                <c:otherwise>hoat động</c:otherwise>
                            </c:choose>
                        </td>                       
                        <td>${user.role.roleId}</td>
                        <td>${user.role.roleName}</td>                     
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>







