<%-- 
    Document   : footer
    Created on : 2 thg 3, 2025, 01:04:56
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
        <title>footer</title>
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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footerCss.css">
    </head>
    <body>
        <div class="wrapper">
            <!-- Footer chính của trang web -->
            <footer class="text-center text-lg-start">
                <!-- Section: Social media -->
                <!-- Phần này chứa liên kết đến các mạng xã hội -->
                <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
                    <!-- Left: Nội dung bên trái hiển thị lời mời kết nối với chúng ta trên mạng xã hội (chỉ hiện trên màn hình lớn) -->
                    <div class="me-5 d-none d-lg-block">
                        <span>Get connected with us on social networks:</span>
                    </div>
                    <!-- Right: Các icon mạng xã hội -->
                    <div class="social">
                        <!-- Mỗi liên kết dẫn tới trang mạng xã hội tương ứng -->
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-google"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-instagram"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-linkedin"></i>
                        </a>
                        <a href="" class="me-4 text-reset">
                            <i class="fab fa-github"></i>
                        </a>
                    </div>
                </section>
                <!-- End Section: Social media -->

                <!-- Section: Links -->
                <!-- Phần này chứa các liên kết hữu ích và thông tin công ty được chia theo cột -->
                <section class="mt-5">
                    <div class="container text-center text-md-start mt-5">
                        <div class="row mt-3">
                            <!-- Grid column 1: Thông tin công ty -->
                            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
                                <h6 class="text-uppercase fw-bold mb-4">
                                    <i class="fas fa-gem me-3"></i>Company name
                                </h6>
                                <p>
                                    Here you can use rows and columns to organize your footer content. Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                </p>
                            </div>
                            <!-- End Grid column 1 -->

                            <!-- Grid column 2: Sản phẩm -->
                            <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
                                <h6 class="text-uppercase fw-bold mb-4">Products</h6>
                                <!-- Liên kết đến các sản phẩm hoặc công nghệ -->
                                <p>
                                    <a href="#!" class="text-reset">Angular</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">React</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Vue</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Laravel</a>
                                </p>
                            </div>
                            <!-- End Grid column 2 -->

                            <!-- Grid column 3: Liên kết hữu ích -->
                            <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
                                <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
                                <!-- Các liên kết hỗ trợ người dùng như giá cả, cài đặt, đơn hàng, trợ giúp -->
                                <p>
                                    <a href="#!" class="text-reset">Pricing</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Settings</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Orders</a>
                                </p>
                                <p>
                                    <a href="#!" class="text-reset">Help</a>
                                </p>
                            </div>
                            <!-- End Grid column 3 -->

                            <!-- Grid column 4: Thông tin liên hệ -->
                            <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
                                <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                                <!-- Địa chỉ -->
                                <p><i class="fas fa-home me-3"></i> New York, NY 10012, US</p>
                                <!-- Email -->
                                <p>
                                    <i class="fas fa-envelope me-3"></i>
                                    info@example.com
                                </p>
                                <!-- Số điện thoại -->
                                <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
                                <!-- Fax -->
                                <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
                            </div>
                            <!-- End Grid column 4 -->
                        </div>
                    </div>
                </section>
                <!-- End Section: Links -->

                <!-- Copyright -->
                <!-- Phần cuối footer hiển thị thông tin bản quyền -->
                <div class="text-center p-4 footer-copyright">
                    © 2021 Copyright:
                    <a class="fw-bold" href="https://mdbootstrap.com/">MDBootstrap.com</a>
                </div>
            </footer>
            <!-- End Footer -->
        </div>

        <script>
            // Initialization for ES Users
            import { Input, initMDB } from "mdb-ui-kit";

            initMDB({Input});
        </script>
    </body>
</html>
