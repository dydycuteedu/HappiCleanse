
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Edit Profile</title>
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
        <!-- Add your JavaScript here -->
        <style>
            .avatar {
                width: 300px;              /* Adjust size as needed */
                height: 300px;
                border-radius: 50%;        /* Makes the image circular */
                border: 3px solid #fff;    /* White border */
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Adds a shadow effect */
                object-fit: cover;         /* Ensures image covers the entire circle */
                display: block;
                margin-bottom: 30px;         /* Centers the avatar */
            }
            .card {
                box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
                background-color:  #edf1fc;
            }
            .card .card-header {
                font-weight: 500;
            }
            .card-header:first-child {
                border-radius: 0.35rem 0.35rem 0 0;
            }
            .card-header {
                padding: 1rem 1.35rem;
                margin-bottom: 0;
                background-color: rgba(33, 40, 50, 0.03);
                border-bottom: 1px solid rgba(33, 40, 50, 0.125);
            }
            .form-control, .dataTable-input {
                display: block;
                width: 100%;
                padding: 0.875rem 1.125rem;
                font-size: 0.875rem;
                font-weight: 400;
                line-height: 1;
                color: #69707a;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #c5ccd6;
                appearance: none;
                border-radius: 0.35rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

           
        </style>
    </head>

    <body>
        <%@include file="Header.jsp" %>


        <!-- Page Header Start -->
        <div class="container-fluid page-header mb-5 py-5">
            <div class="container">
                <h1 class="display-3 text-white mb-3 animated slideInDown">Profile</h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Profile</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Edit Profile Section Start -->
      
        <div class="container-xxl py-5">
            <div class="container">

                <div class="row justify-content-center">
                    <div class="col-lg-4 mb-5">
                        <div class="bg-light p-5 text-center h-100 d-flex flex-column align-items-center justify-content-center">
                            <form action="SaveAvatarServlet" method="post" enctype="multipart/form-data">

                                <div class="mb-4 text-center">
                                    <!-- Clickable profile image -->
                                    <img id="profileImage" src="${pageContext.request.contextPath}/${sessionScope.acc.avatar}" alt="Profile" class="avatar">
                                    <div class="input-group">
                                        <input type="file" class="form-control" name="avatar" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                                        <button class="btn btn-outline-secondary" type="submit" id="inputGroupFileAddon04">Save Avatar</button>
                                    </div>
                                </div>
                            </form>

                        </div>
                    </div>
                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header">Account Details</div>
                            <div class="card-body">
                                <form action="editProfile" method="POST">

                                    <!-- Form Row-->
                                    <div class="row gx-3 mb-3">

                                        <!-- Form Group (full name)-->
                                        <div class="col-md-6">
                                            <label class="form-label" for="name">Full name</label>
                                            <input type="text" name="fullname" class="form-control" id="name" placeholder="Full Name" value="${sessionScope.acc.fullname}">
                                        </div>
                                    </div>

                                    <!-- Form Group (email address)-->
                                    <div class="mb-3">
                                        <label class="form-label" for="email">Email address</label>
                                        <input type="email" name="email" class="form-control" id="email" placeholder="Email" value="${sessionScope.acc.email}">
                                    </div>
                                    <!-- Form Row-->

                                    <!-- Form Group (phone number)-->
                                    <div class="md-3">
                                        <label class="form-label" for="phone">Phone number</label>
                                        <input type="text" name="phoneNumber" class="form-control" id="phone" placeholder="Phone Number" value="${sessionScope.acc.phonenumber}">
                                    </div>
                                    <!-- Form Group (addresss)-->
                                    <div class="md-3">
                                        <label class="form-label" for="address">Address</label>
                                        <input type="text" name="address" class="form-control" id="address" placeholder="Address" value="${sessionScope.acc.address}">
                                    </div>

                                    <div class="form-group mb-4">
                                        <label for="gender" class="form-label me-2">Gender:</label>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="male" value="Male"
                                                   ${sessionScope.acc.gender == 'Male' ? 'checked' : ''}>
                                            <label class="form-check-label" for="male">Male</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="female" value="Female"
                                                   ${sessionScope.acc.gender == 'Female' ? 'checked' : ''}>
                                            <label class="form-check-label" for="female">Female</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="gender" id="other" value="Other"
                                                   ${sessionScope.acc.gender == 'Other' ? 'checked' : ''}>
                                            <label class="form-check-label" for="other">Other</label>
                                        </div>
                                    </div>
                                    <!-- Save changes button-->
                                    <button class="btn btn-primary" type="submit">Save changes</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
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
