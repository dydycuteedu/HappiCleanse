
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Service List</title>
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
                <h1 class="display-3 text-white mb-3 animated slideInDown">Service </h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Service</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Service Start -->
        <div class="container-fluid py-5 px-4 px-lg-0">
            <div class="row g-0">
                <div class="col-lg-3 d-none d-lg-flex">
                    <div class="d-flex align-items-center justify-content-center bg-primary w-100 h-100">
                        <h1 class="display-3 text-white m-0" style="transform: rotate(-90deg);">15 Years Experience</h1>
                    </div>
                </div>
                <div class="col-md-12 col-lg-9">
                    <div class="ms-lg-5 ps-lg-5">
                        <div class="text-center text-lg-start wow fadeInUp" data-wow-delay="0.1s">
                            <h6 class="text-secondary text-uppercase">Our Services</h6>
                            <h1 class="mb-5">Explore Our Services</h1>
                        </div>
                        <div class="owl-carousel service-carousel position-relative wow fadeInUp" data-wow-delay="0.1s">
                            <c:forEach items="${serviceList}" var="service" >
                                <div class="bg-light p-4" style="height: 450px;">
                                    <div class="d-flex align-items-center justify-content-center border border-5 border-white mb-4" style="width: 75px; height: 75px;">
                                        <i class="fa fa-water fa-2x text-primary"></i>
                                    </div>
                                    <h4 class="mb-3">${service.nameService}</h4>
                                    <p>${service.description}</p>
                                    <p class="text-primary fw-medium"><i class="fa fa-check text-success me-2"></i>Quality Service</p>
                                    <p class="text-primary fw-medium"><i class="fa fa-check text-success me-2"></i>Customer Satisfaction</p>
                                    <p class="text-primary fw-medium"><i class="fa fa-check text-success me-2"></i>Support 24/7</p>
                                    <a href="DetailService?idService=${service.idService}" class="btn bg-white text-primary w-100 mt-2">Read More<i class="fa fa-arrow-right text-secondary ms-2"></i></a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Service End -->


        <!-- Booking Start -->
        <div class="container-fluid my-5 px-0">
            <div class="video wow fadeInUp" data-wow-delay="0.1s">
                <button type="button" class="btn-play" data-bs-toggle="modal" data-src="https://www.youtube.com/embed/DWRcNpR6Kdc" data-bs-target="#videoModal">
                    <span></span>
                </button>

                <div class="modal fade" id="videoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content rounded-0">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Youtube Video</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <!-- 16:9 aspect ratio -->
                                <div class="ratio ratio-16x9">
                                    <iframe class="embed-responsive-item" src="" id="video" allowfullscreen allowscriptaccess="always"
                                            allow="autoplay"></iframe>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <h1 class="text-white mb-4">Emergency Plumbing Service</h1>
                <h3 class="text-white mb-0">24 Hours 7 Days a Week</h3>
            </div>
            <div class="container position-relative wow fadeInUp" data-wow-delay="0.1s" style="margin-top: -6rem;">
                <div class="row justify-content-center">
                    <div class="col-lg-8">
                        <div class="bg-light text-center p-5">
                            <h1 class="mb-4">Book For A Service</h1>
                            <!--create order-->
                            <form action="CreateOrderServlet" method="POST">
                                <div class="row g-3">
                                    <div class="col-12 col-sm-6">
                                        <input type="text" class="form-control border-0" placeholder="Your Name" style="height: 55px;">
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <input type="email" class="form-control border-0" placeholder="Your Email" style="height: 55px;">
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <select class="form-select border-0" style="height: 55px;">
                                            <option selected>Select A Service</option>
                                            <c:forEach items="${serviceList}" var="service" >
                                                <<option value="${service.idService}">${service.nameService}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-12 col-sm-6">
                                        <div class="date" id="date1" data-target-input="nearest">
                                            <input type="text"
                                                   class="form-control border-0 datetimepicker-input"
                                                   placeholder="Service Date" data-target="#date1" data-toggle="datetimepicker" style="height: 55px;">
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <textarea class="form-control border-0" placeholder="Special Request"></textarea>
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
        <!-- Booking End -->


        <!-- Testimonial Start -->
        <div class="container-xxl py-5 wow fadeInUp" data-wow-delay="0.1s">
                <div class="container">
                    <div class="text-center">

                        <h1 class="mb-5">Khách hàng nói gì về chúng tôi?</h1>
                    </div>

                    <div class="owl-carousel testimonial-carousel position-relative wow fadeInUp" data-wow-delay="0.1s">
                        <c:forEach var="feedback" items="${feedbackList}">
                            <div class="testimonial-item text-center">
                                <div class="testimonial-text bg-light text-center p-4 mb-4">
                                    <p class="mb-0" style="white-space: nowrap;
                                       overflow: hidden;
                                       text-overflow: ellipsis;">${feedback.contentFeedback}</p>
                                </div>
                                <img class="bg-light rounded-circle p-2 mx-auto mb-2" src="${feedback.user.getAvatar()}" style="width: 80px; height: 80px;">
                                <div class="mb-2">
                                    <c:forEach var="i" begin="1" end="${feedback.ratings}">
                                        <small class="fa fa-star text-secondary"></small>
                                    </c:forEach>
                                </div>
                                <h5 class="mb-1">${feedback.user.getFullname()}</h5>
                                <p class="m-0">${feedback.editedTime}</p>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </div>
        <!-- Testimonial End -->

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
