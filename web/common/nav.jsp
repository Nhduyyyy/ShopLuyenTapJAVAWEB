<%-- 
    Document   : nav
    Created on : 2 thg 3, 2025, 01:04:18
    Author     : nhatduy261179
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Đặt content type và mã hóa trang là UTF-8 -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Import thư viện JSTL với prefix "c" để sử dụng các thẻ JSTL trong trang -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>nav</title>
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

        <!-- Link CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navCss.css">
    </head>
    <body>
        <!-- Top Bar (tuỳ chọn) -->
        <!-- Phần top bar hiển thị các liên kết phụ nhỏ ở phía trên cùng của trang, thường dùng cho các liên kết như "Kênh Người Bán", "Tải Ứng Dụng", "Kết Nối" và các icon mạng xã hội -->
        <div class="custom-topbar py-1" id="topbar">
            <div class="container d-flex justify-content-end">
                <!-- Các liên kết điều hướng nhỏ -->
                <a href="#">Kênh Người Bán</a>
                <a href="#">Tải Ứng Dụng</a>
                <a href="#">Kết Nối</a>
                <!-- Liên kết đến các trang mạng xã hội: Facebook, Instagram -->
                <a href="#"><i class="fab fa-facebook"></i></a>
                <a href="#"><i class="fab fa-instagram"></i></a>
            </div>
        </div>

        <!-- Navbar chính -->
        <!-- Phần navbar chính chứa logo, thanh tìm kiếm và menu điều hướng chính -->
        <nav class="navbar navbar-expand-lg custom-navbar" id="navbar">
            <div class="container">
                <!-- Logo & brand -->
                <!-- Hiển thị logo của trang và tên thương hiệu (ở đây là ShopeeClone) -->
                <a class="navbar-brand" href="#">
                    <i class="fas fa-store"></i> ShopeeClone
                </a>

                <!-- Nút toggle khi thu nhỏ màn hình -->
                <!-- Nút này xuất hiện khi màn hình nhỏ, cho phép người dùng mở/đóng menu -->
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" 
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <!-- Nội dung navbar (collapse) -->
                <!-- Phần này chứa các thành phần bên trong navbar sẽ bị ẩn hoặc hiện khi người dùng click vào nút toggle -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <!-- Search bar ở giữa -->
                    <!-- Thanh tìm kiếm cho phép người dùng nhập từ khóa để tìm sản phẩm, thương hiệu và tên shop -->
                    <form class="d-flex custom-search-bar my-2 my-lg-0">
                        <input class="custom-search-input" type="search" placeholder="Tìm sản phẩm, thương hiệu và tên shop" aria-label="Search">
                        <button class="custom-search-button" type="submit">
                            <i class="fas fa-search"></i>
                        </button>
                    </form>

                    <!-- Menu bên phải -->
                    <!-- Danh sách menu điều hướng bên phải thanh navbar -->
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <!-- Liên kết thông báo -->
                        <li class="nav-item">
                            <a class="nav-link" href="#">Thông Báo</a>
                        </li>
                        <!-- Liên kết trợ giúp -->
                        <li class="nav-item">
                            <a class="nav-link" href="#">Trợ Giúp</a>
                        </li>

                        <!-- Dropdown User: Hiển thị khi hover -->
                        <!-- Sử dụng tag JSTL (JavaServer Pages Standard Tag Library) để kiểm tra người dùng đã đăng nhập hay chưa -->
                        
                        <%-- <c:choose> --%>
                        
                            <!-- Nếu sessionScope.user rỗng (người dùng chưa đăng nhập) -->
                            
                            <%-- <c:when test="${empty sessionScope.user}"> --%>
                            
                                <li class="nav-item dropdown">
                                    <!-- Biểu tượng người dùng, khi click sẽ hiện dropdown -->
                                    <a class="nav-link dropdown-toggle custom-icon-link" href="#" id="userDropdown" role="button" 
                                       data-bs-toggle="dropdown" aria-expanded="false">
                                        <i class="fas fa-user"></i>
                                    </a>
                                    <!-- Menu dropdown với các lựa chọn đăng nhập và đăng ký -->
                                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                        <li><a class="dropdown-item" href="">Đăng Nhập</a></li>
                                        <li><a class="dropdown-item" href="">Đăng Ký</a></li>
                                    </ul>
                                </li>
                                
                            <%-- </c:when> --%>
                            
                            <!-- Nếu sessionScope.user không rỗng (người dùng đã đăng nhập) -->
                            
                            <%-- <c:otherwise> --%>
                                <!--<li class="nav-item dropdown">-->
                                    
                                <!-- Hiển thị biểu tượng người dùng với dropdown chứa các chức năng dành cho người dùng đã đăng nhập -->
                                    
                                    <!--<a class="nav-link dropdown-toggle custom-icon-link" href="#" id="userDropdown" role="button"--> 
                                       <!--data-bs-toggle="dropdown" aria-expanded="false">-->
                                        <!--<i class="fas fa-user"></i>-->
                                    <!--</a>-->
                                    <!-- Menu dropdown với các lựa chọn: tài khoản của tôi, đơn mua, đăng xuất -->
                                    <!--<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">-->
                                        <!--<li><a class="dropdown-item" href="">Tài khoản của tôi</a></li>-->
                                        <!--<li><a class="dropdown-item" href="">Đơn mua</a></li>-->
                                        <!--<li><a class="dropdown-item" href="">Đăng Xuất</a></li>-->
                                    <!--</ul>-->
                                <!--</li>-->
                            <%--</c:otherwise>--%>
                        <%--</c:choose>--%>

                        <!-- Liên kết giỏ hàng -->
                        <!-- Hiển thị biểu tượng giỏ hàng cho phép người dùng truy cập vào trang giỏ hàng -->
                        <li class="nav-item nav">
                            <a class="nav-link custom-icon-link" href="#">
                                <i class="fas fa-shopping-cart"></i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <script>
            // Hiệu ứng thay đổi khi scroll
            const navbar = document.getElementById('navbar');
            const topbar = document.getElementById('topbar');

            window.addEventListener('scroll', function () {
                if (window.scrollY > 50) {
                    navbar.classList.add('scrolled');
                    topbar.classList.add('scrolled');
                } else {
                    navbar.classList.remove('scrolled');
                    topbar.classList.remove('scrolled');
                }
            });
        </script>
    </body>
</html>
