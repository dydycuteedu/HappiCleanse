

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>HappiCleanse- We can help your house</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta content="" name="keywords">
        <meta content="" name="description">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Web Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">

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


        <!-- Carousel Start -->
        <div class="container-fluid p-0 mb-5">
            <div class="owl-carousel header-carousel position-relative">
                <div class="owl-carousel-item position-relative">
                    <img class="img-fluid" src="img/carousel-1.jpg" alt="">
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(0, 0, 0, .4);">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                    <h5 class="text-white text-uppercase mb-3 animated slideInDown">House cleaning Services</h5>
                                    <h1 class="display-3 text-white animated slideInDown mb-4">House cleaning advanced Services</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Chúng tôi sẽ giúp ngôi nhà bạn đẹp hơn, tiết kiệm thời gian làm việc nhà cho bạn!!</p>
                                    <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="owl-carousel-item position-relative">
                    <img class="img-fluid" src="img/carousel-2.jpg" alt="">
                    <div class="position-absolute top-0 start-0 w-100 h-100 d-flex align-items-center" style="background: rgba(0, 0, 0, .4);">
                        <div class="container">
                            <div class="row justify-content-start">
                                <div class="col-10 col-lg-8">
                                    <h5 class="text-white text-uppercase mb-3 animated slideInDown">Babysister Services</h5>
                                    <h1 class="display-3 text-white animated slideInDown mb-4">Babysister Services</h1>
                                    <p class="fs-5 fw-medium text-white mb-4 pb-2">Việc trông trẻ quá tốn thời gian để làm? Chúng tôi có đội ngũ trông trẻ giúp bạn có thêm thời gian làm việc.</p>
                                    <a href="" class="btn btn-primary py-md-3 px-md-5 me-3 animated slideInLeft">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Carousel End -->


        <!-- Service Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="row g-4">
                    <c:forEach var="servicecategoryList" items="${servicecategoryList}">
                        <div class="col-lg-4 col-md-6 service-item-top wow fadeInUp" data-wow-delay="0.1s">
                            <div class="overflow-hidden">
                                <img class="img-fluid w-100 h-100" src="${servicecategoryList.img}" alt="">
                            </div>
                            <div class="d-flex align-items-center justify-content-between bg-light p-4">
                                <h5 class="text-truncate me-3 mb-0">${servicecategoryList.nameServiceCategory}</h5>
                                <a class="btn btn-square btn-outline-primary border-2 border-white flex-shrink-0" href=""><i class="fa fa-arrow-right"></i></a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- Service End -->


        <!-- About Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="row g-5">
                    <div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="text-secondary text-uppercase">About Us</h6>
                        <h1 class="mb-4">Chúng tôi được thành lập vaod năm 2024</h1>
                        <p class="mb-4">Đáp ứng nhu cầu cho các mái ấm nơi có các hộ gia đình, người phụ nữ nội trợ bận bịu với công việc văn phòng không có thời gian chăm lo cho ngôi nhà. Vì thế chúng tôi ra đời để phục vụ các bạn!!!</p>
                        <p class="fw-medium text-primary"><i class="fa fa-check text-success me-3"></i>Residential & commercial plumbing</p>
                        <p class="fw-medium text-primary"><i class="fa fa-check text-success me-3"></i>Quality services at affordable prices</p>
                        <p class="fw-medium text-primary"><i class="fa fa-check text-success me-3"></i>Immediate 24/ 7 emergency services</p>
                        <div class="bg-primary d-flex align-items-center p-4 mt-5">
                            <div class="d-flex flex-shrink-0 align-items-center justify-content-center bg-white" style="width: 60px; height: 60px;">
                                <i class="fa fa-phone-alt fa-2x text-primary"></i>
                            </div>
                            <div class="ms-3">
                                <p class="fs-5 fw-medium mb-2 text-white">Emergency 24/7</p>
                                <h3 class="m-0 text-secondary">+012 345 6789</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 pt-4" style="min-height: 500px;">
                        <div class="position-relative h-100 wow fadeInUp" data-wow-delay="0.5s">
                            <img class="position-absolute img-fluid w-100 h-100" src="img/about-1.jpg" style="object-fit: cover; padding: 0 0 50px 100px;" alt="">
                            <img class="position-absolute start-0 bottom-0 img-fluid bg-white pt-2 pe-2 w-50 h-50" src="img/about-2.jpg" style="object-fit: cover;" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- About End -->


        <!-- Fact Start -->
        <div class="container-fluid fact bg-dark my-5 py-5">
            <div class="container">
                <div class="row g-4">
                    <div class="col-md-6 col-lg-3 text-center wow fadeIn" data-wow-delay="0.1s">
                        <i class="fa fa-check fa-2x text-white mb-3"></i>
                        <h2 class="text-white mb-2" data-toggle="counter-up">1234</h2>
                        <p class="text-white mb-0">Years Experience</p>
                    </div>
                    <div class="col-md-6 col-lg-3 text-center wow fadeIn" data-wow-delay="0.3s">
                        <i class="fa fa-users-cog fa-2x text-white mb-3"></i>
                        <h2 class="text-white mb-2" data-toggle="counter-up">1234</h2>
                        <p class="text-white mb-0">Expert Technicians</p>
                    </div>
                    <div class="col-md-6 col-lg-3 text-center wow fadeIn" data-wow-delay="0.5s">
                        <i class="fa fa-users fa-2x text-white mb-3"></i>
                        <h2 class="text-white mb-2" data-toggle="counter-up">1234</h2>
                        <p class="text-white mb-0">Satisfied Clients</p>
                    </div>
                    <div class="col-md-6 col-lg-3 text-center wow fadeIn" data-wow-delay="0.7s">
                        <i class="fa fa-wrench fa-2x text-white mb-3"></i>
                        <h2 class="text-white mb-2" data-toggle="counter-up">1234</h2>
                        <p class="text-white mb-0">Compleate Projects</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Fact End -->


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

                <h1 class="text-white mb-4">HouseHould Service</h1>
                <h3 class="text-white mb-0">12 Hours 7 Days a Week</h3>
            </div>




            <!-- Team Start -->
            <div class="container-xxl py-5">
                <div class="container">
                    <div class="text-center wow fadeInUp" data-wow-delay="0.1s">
                        <h6 class="text-secondary text-uppercase">Our Technicians</h6>
                        <h1 class="mb-5">Our Expert Technicians</h1>
                    </div>
                    <div class="row g-4">
                        <c:forEach var="staffList" items="${staffList}">
                            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
                                <div class="team-item">
                                    <div class="position-relative overflow-hidden">
                                        <img class="img-fluid" src="${staffList.avatar}" alt="">
                                    </div>
                                    <div class="team-text">
                                        <div class="bg-light">
                                            <h5 class="fw-bold mb-0">${staffList.fullname}</h5>
                                            <small>${staffList.gender}</small>
                                        </div>
                                        <div class="bg-primary">
                                            <a class="btn btn-square mx-1" href=""><i class="fab fa-facebook-f"></i></a>
                                            <a class="btn btn-square mx-1" href=""><i class="fab fa-twitter"></i></a>
                                            <a class="btn btn-square mx-1" href=""><i class="fab fa-instagram"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <!-- Team End -->


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
                                    <p class="mb-0">${feedback.contentFeedback}</p>
                                </div>
                                <img class="bg-light rounded-circle p-2 mx-auto mb-2" src="img/testimonial-1.jpg" style="width: 80px; height: 80px;">
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
