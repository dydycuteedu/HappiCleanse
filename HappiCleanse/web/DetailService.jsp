<%-- 
    Document   : DetailService
    Created on : Oct 20, 2024, 4:44:55 PM
    Author     : CHUC DY
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Detail Service HappiCleanse</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&family=Roboto:wght@500;700&display=swap"
              rel="stylesheet">

        <!-- Icon Font Stylesheet -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/animate/animate.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
        <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
    </head>

    <body>
        <%@include file="Header.jsp" %>


        <!-- Page Header Start -->
        <div class="container-fluid page-header mb-5 py-5">
            <div class="container">
                <h1 class="display-3 text-white mb-3 animated slideInDown">Detail Service </h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Detail Service</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Service Detail Start -->
        <div class="container-fluid py-5 px-4 px-lg-0">
            <div class="container">
                <!-- Service Header -->
                <div class="row g-0 mb-5">
                    <div class="col-md-12">
                        <h1 class="text-center mb-4" style="font-size: 80px;">${service.nameService}</h1>
                    </div>
                </div>
                <div class="row g-3">
                    <!-- Image 1 -->
                    <div class="col-md-4">
                        <img src="${service.img1}" alt="Image 1" class="img-fluid mb-4">
                    </div>

                    <!-- Image 2 -->
                    <div class="col-md-4">
                        <img src="${service.img2}" alt="Image 2" class="img-fluid mb-4">
                    </div>

                    <!-- Image 3 -->
                    <div class="col-md-4">
                        <img src="${service.img3}" alt="Image 3" class="img-fluid mb-4">
                    </div>
                </div>
                <!-- Service Details Section -->
                <div class="row mb-5">
                    <div class="col-lg-12">
                        <h2 class="mb-4">Về dịch vụ của chúng tôi</h2>
                        <p>${service.description}</p>
                        <h2 class="mb-4">Giá dịch vụ: <fmt:formatNumber value="${service.price}" type="number" groupingUsed="true" /><strong><span class="text-xs/sp14 font-medium mr-px">₫</span></strong></h2>
                        <h3 class="mt-5">Tại Sao Chọn Chúng Tôi?</h3>
                        <ul>
                            <li>Kỹ thuật viên có chứng chỉ và tay nghề cao, được đào tạo chuyên sâu.</li>
                            <li>Dịch vụ nhanh chóng, đáng tin cậy và giá cả phải chăng.</li>
                            <li>Sử dụng thiết bị hiện đại để chẩn đoán và khắc phục sự cố.</li>
                            <li>Có dịch vụ khẩn cấp 24/7.</li>
                        </ul>

                    </div>
                </div>

                <!-- Booking Section -->
                <div class="container position-relative wow fadeInUp" data-wow-delay="0.1s">
                    <div class="row justify-content-center">
                        <div class="col-lg-8">
                            <div class="bg-light text-center p-5">
                                <h1 class="mb-4">Book This Service</h1>
                                <form action="CreateOrderServlet" method="POST">
                                    <div class="row g-3">

                                        <div class="col-12 col-sm-6">
                                            <select class="form-select border-0" style="height: 55px;" name="idService">
                                                <option value="${service.idService}">${service.nameService}</option>
                                            </select>
                                        </div>
                                        <div class="col-12 col-sm-6">
                                            <div class="date" id="date1" data-target-input="nearest">
                                                <input type="datetime-local" class="form-control border-0" style="height: 55px;"  min="" name="dateShift" id="datetime">
                                            </div>
                                        </div>

                                        <div class="col-12">
                                            <textarea class="form-control border-0" placeholder="Special Request" name="notes"></textarea>
                                        </div>
                                        <div class="col-12">
                                            <button class="btn btn-primary w-100 py-3" type="submit">Book Now</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- Service Detail End -->


        <%@include file="Footer.jsp" %>

        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square rounded-0 back-to-top"><i class="bi bi-arrow-up"></i></a>

        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
        <script src="lib/wow/wow.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/waypoints/waypoints.min.js"></script>
        <script src="lib/counterup/counterup.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>
        <script src="lib/tempusdominus/js/moment.min.js"></script>
        <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
        <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>

