
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Hiring - HappiCleanse</title>
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
                <h1 class="display-3 text-white mb-3 animated slideInDown">Register Staff</h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Contact</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Login/Register Form Start -->
        <div class="container-xxl py-5">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-6 col-md-8 wow fadeInUp" data-wow-delay="0.1s">
                        <div class="bg-light p-5 rounded">
                            <!-- Tabs for Login and Register -->
                            <ul class="nav nav-pills mb-4 justify-content-center" id="pills-tab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <h4 class="nav-link active" id="pills-login-tab" data-bs-toggle="pill"
                                        data-bs-target="#pills-login" type="button" role="tab" aria-controls="pills-login"
                                        aria-selected="true">Register Staff HappiCleanse</h4>
                                </li>
                            </ul>

                            <!-- Tab Content for Login and Register -->
                            <div class="tab-content" id="pills-tabContent">
                                <!-- Login Form -->
                                <div class="tab-pane fade show active" id="pills-login" role="tabpanel"
                                     aria-labelledby="pills-login-tab">
                                    <form action="RegisterStaffServlet" method="post" enctype="multipart/form-data">
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="registerName"
                                                   placeholder="Your Name" name="firstName">
                                            <label for="registerName">First Name</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="registerName"
                                                   placeholder="Your Name" name="lastName">
                                            <label for="registerName">Last Name</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="email" class="form-control" id="registerEmail"
                                                   placeholder="name@example.com" name="email">
                                            <label for="registerEmail">Email address</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="registerEmail"
                                                   placeholder="username" name="phone">
                                            <label for="registerEmail">Phone</label>
                                        </div>
                                        <div class="input-group mb-3">
                                            <input type="file" class="form-control" name="CV" id="inputGroupFile02">
                                            <label class="input-group-text" for="inputGroupFile02">Upload your CV</label>
                                        </div>
                                        <div class="mb-3">
                                            <select class="form-select" name="gender" aria-label="Default select example">
                                                <option selected>Gender</option>
                                                <option value="Male">Male</option>
                                                <option value="Female">Female</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <select class="form-select" aria-label="Default select example">
                                                <option selected>Do you have a vehicle for use to and from customer homes?</option>
                                                <option value="1">Yes</option>
                                                <option value="2">No</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <select class="form-select" aria-label="Default select example">
                                                <option selected>Can you provide proof of Insurance on your vehicle?</option>
                                                <option value="1">Yes</option>
                                                <option value="2">No</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <select class="form-select" aria-label="Default select example">
                                                <option selected>Are you able to withstand regular physical contact with pet hair, mold, dust, mildew and cleaning solutions?</option>
                                                <option value="1">Yes</option>
                                                <option value="2">No</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <select class="form-select" aria-label="Default select example">
                                                <option selected>Are you able to lift and carry 20 lbs of equipment?</option>
                                                <option value="1">Yes</option>
                                                <option value="2">No</option>
                                            </select>
                                        </div>
                                        <button class="btn btn-primary w-100 py-3" type="submit">Register</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Login/Register Form End -->

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
