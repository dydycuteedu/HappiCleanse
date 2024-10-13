
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Login/Register - HappiCleanse</title>
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
                <h1 class="display-3 text-white mb-3 animated slideInDown">Payment </h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Payment</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Payment Selection Page Start -->
        <div class="container-fluid py-5">
            <div class="container">
                <!-- Page Header -->
                <div class="row mb-5">
                    <div class="col-md-12 text-center">
                        <h1 class="mb-4">Choose Your Payment Method</h1>
                        <p class="text-center">You are about to pay for the service: <strong>${service.nameService}</strong></p>
                        <p class="text-center">Amount to be paid: <strong>$${totalMoney}</strong></p> <!-- Replace with the actual amount -->
                    </div>
                </div>

                <!-- Payment Method Selection Form -->
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <div class="bg-light text-center p-5">
                            <h2 class="mb-4">Select Payment Option</h2>
                            <form action="PaymentServlet" method="post">
                                <!-- Radio Button for Payment Options -->
                                <div class="form-check mb-3">
                                    <input class="form-check-input" type="radio" name="paymentMethod" id="payByCash" value="cash" required>
                                    <label class="form-check-label" for="payByCash">
                                        Pay by Cash
                                    </label>
                                </div>
                                <div class="form-check mb-4">
                                    <input class="form-check-input" type="radio" name="paymentMethod" id="payByVNPay" value="vnpay" required>
                                    <label class="form-check-label" for="payByVNPay">
                                        Pay by VNPay
                                    </label>
                                </div>

                                <!-- Service Summary -->
                                <div class="row g-3 mb-4">
                                    <div class="col-12">
                                        <h4 class="text-start">Service Summary</h4>
                                        <p><strong>Service:</strong> ${service.nameService}</p>
                                        <p><strong>Description:</strong> ${service.description}</p>
                                        <p><strong>Amount:</strong> $100.00</p> <!-- Replace with actual amount -->
                                    </div>
                                </div>

                                <!-- Submit Button -->
                                <button class="btn btn-primary w-100 py-3" type="submit">Proceed to Payment</button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!-- Payment Selection Page End -->


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

