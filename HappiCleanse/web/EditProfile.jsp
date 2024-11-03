
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
        <script>
            function showProfile() {
                document.getElementById("profile-section").style.display = "block";
                document.getElementById("history-section").style.display = "none";
            }

            function showHistory() {
                document.getElementById("profile-section").style.display = "none";
                document.getElementById("history-section").style.display = "block";
            }

            document.getElementById('profileImage').addEventListener('click', function () {
                // Trigger the hidden file input when the image is clicked
                document.getElementById('fileInput').click();
            });

            document.getElementById('fileInput').addEventListener('change', function (event) {
                // Check if a file is selected
                if (event.target.files && event.target.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        // Update the image preview with the new image
                        document.getElementById('profileImage').src = e.target.result;
                    };

                    // Read the selected image as a data URL
                    reader.readAsDataURL(event.target.files[0]);
                }
            });
        </script>
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
                    <!-- Profile Section with Buttons -->
                    <div class="col-lg-4 mb-5">
                        <div class="bg-light p-5 text-center h-100 d-flex flex-column align-items-center justify-content-center">
                            <form action="SaveAvatarServlet" method="post" enctype="multipart/form-data">

                                <div class="mb-4 text-center">
                                    <!-- Clickable profile image -->
                                    <img id="profileImage" src="${sessionScope.acc.avatar}" alt="Profile" class="avatar">
                                    <div class="input-group">
                                        <input type="file" class="form-control" name="avatar" id="inputGroupFile04" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                                        <button class="btn btn-outline-secondary" type="submit" id="inputGroupFileAddon04">Save Avatar</button>
                                    </div>
                                </div>
                            </form>
                            <!-- Buttons -->
                            <div class="w-100">
                                <button style="margin-top: 30px" class="btn btn-primary w-100 mb-3 py-2" type="button" onclick="showProfile()">Edit Profile</button>
                                <button class="btn btn-primary w-100 py-2" type="button" onclick="showHistory()">History</button>
                            </div>
                        </div>
                    </div>

                    <!-- Edit Profile Form Section -->
                    <div id="profile-section" class="col-lg-6" style="display: block; height: 500px;">
                        <div class="bg-light p-5 h-100 d-flex align-items-center">
                            <form class="w-100" action="editProfile" method="POST">
                                <div class="mb-4">
                                    <h3 class="text-center">My Profile</h3>
                                </div>

                                <div class="form-group mb-3">
                                    <label for="name" class="form-label">Full Name</label>
                                    <input type="text" name="fullname" class="form-control" id="name" placeholder="Full Name" value="${sessionScope.acc.fullname}">
                                </div>

                                <div class="form-group mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <input type="email" name="email" class="form-control" id="email" placeholder="Email" value="${sessionScope.acc.email}">
                                </div>

                                <div class="form-group mb-3">
                                    <label for="phone" class="form-label">Phone Number</label>
                                    <input type="text" name="phoneNumber" class="form-control" id="phone" placeholder="Phone Number" value="${sessionScope.acc.phonenumber}">
                                </div>

                                <div class="form-group mb-4">
                                    <label for="address" class="form-label">Address</label>
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
                                <div class="text-center">
                                    <button class="btn btn-primary w-50 py-2" type="submit">Confirm Update</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- Order History Section -->
                    <div id="history-section" class="col-lg-6" style="display: none;  height: 500px;">
                        <div class="bg-light p-5">
                            <h3 class="text-center mb-4">Order History</h3>
                            <div class="table-responsive">
                                <table class="table table-bordered text-center">
                                    <thead class="bg-light">
                                        <tr>
                                            <th>Order Number</th>
                                            <th>Date</th>
                                            <th>Status</th>
                                            <th>Order Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${orderList}" var="order">
                                            <tr>
                                                <td>${order.idOrder}</td>
                                                <td>${order.dateCreate}</td>
                                                <c:if test="${order.statusOrder == 'Completed'}">
                                                    <td><span class="badge bg-success">Completed</span></td>
                                                </c:if>
                                                <c:if test="${order.statusOrder == 'Pending'}">
                                                    <td><span class="badge bg-warning">Pending</span></td>
                                                </c:if>
                                                <c:if test="${order.statusOrder == 'Cancelled'}">
                                                    <td><span class="badge bg-danger">Cancelled</span></td>
                                                </c:if>
                                                <td>${order.dateCreate}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- Edit Profile Section End -->


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
