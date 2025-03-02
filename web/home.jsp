<%-- 
    Document   : home
    Created on : 2 thg 3, 2025, 01:03:43
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
        <title>home</title>
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
        <style>
            .home {
                height: 100vh;
            }
        </style>
    </head>
    <body>
        <div class="home"></div>
    </body>
</html>

<%@ include file="/common/footer.jsp" %>
<!-- Bao gồm file footer.jsp từ thư mục common để hiển thị thanh điều hướng chung -->
