
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
                        <p class="text-center">You are about to pay for the service: <strong>${order.service.nameService}</strong></p>
                        <p class="text-center">Amount to be paid: <strong>${order.totalMoney}00 vnđ</strong></p> <!-- Replace with the actual amount -->
                    </div>
                </div>

                <!-- Payment Method Selection Form -->
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <div class="bg-light text-center p-5">
                            <form action="PaymentServlet " method="post">
                                <h2 class="mb-4">Select Payment Option</h2>

                                <!-- Service Summary -->
                                <div class="row g-3 mb-4">
                                    <div class="col-12">
                                        <h4 class="text-start">Service Summary</h4>
                                        <p><strong>Service:</strong> ${order.service.nameService}</p>
                                        <p><strong>Description:</strong> ${order.service.description}</p>
                                        <p><strong>Amount:</strong>${order.totalMoney}</p> <!-- Replace with actual amount -->
                                    </div>
                                </div>
                                    <button class="btn btn-primary w-100 py-3" style="border-radius: 5px; font-size: 14px; margin-bottom: 20px" type="submit">
                                    Proceed to Payment by Cash
                                </button>
                            </form>
                            <button class="btn btn-primary w-100 py-3" style="border-radius: 5px; font-size: 14px;" data-bs-toggle="modal" data-bs-target="#depositModal">
                                Proceed to Payment VNPay
                            </button>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="depositModal" tabindex="-1" aria-labelledby="depositModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered"> <!-- Thêm modal-dialog-centered -->
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="depositModalLabel">Thanh toan</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form action="VNPayServlet" id="frmCreateOrder" method="post">     
                                    <input type="hidden" name="id" value="${order.idOrder}">
                                    <input type="hidden" name="action" value="deposit">

                                    <div class="form-group mb-4">
                                        <input class="form-control" data-val="true" data-val-number="The field Amount must be a number." data-val-required="The Amount field is required." 
                                               id="amount" max="100000000" min="10000" name="amount" type="hidden" step="10000" value="${order.totalMoney}"/>
                                    </div>

                                    <h4 class="mb-3">Chọn phương thức thanh toán</h4>
                                    <div class="form-group mb-4">
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="vnpayQR" name="bankCode" value="" >
                                            <label class="form-check-label" for="vnpayQR">Cổng thanh toán VNPAYQR</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="vnpayQRApp" name="bankCode" value="VNPAYQR">
                                            <label class="form-check-label" for="vnpayQRApp">Thanh toán bằng ứng dụng hỗ trợ VNPAYQR</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="vnbank" name="bankCode" value="VNBANK" checked>
                                            <label class="form-check-label" for="vnbank">Thanh toán qua thẻ ATM/Tài khoản nội địa</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="intlCard" name="bankCode" value="INTCARD">
                                            <label class="form-check-label" for="intlCard">Thanh toán qua thẻ quốc tế</label>
                                        </div>
                                    </div>

                                    <div class="form-group mb-4">
                                        <h5>Chọn ngôn ngữ giao diện thanh toán:</h5>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="languageVietnamese" name="language" value="vn" checked>
                                            <label class="form-check-label" for="languageVietnamese">Tiếng Việt</label>
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="languageEnglish" name="language" value="en">
                                            <label class="form-check-label" for="languageEnglish">Tiếng Anh</label>
                                        </div>
                                    </div>

                                    <button type="submit" class="btn btn-primary w-100">Thanh toán</button>
                                </form>

                            </div>

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

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
            <c:if test="${isSuccess == true}">
                $("#successModal").modal("show");
            </c:if>
            <c:if test="${isSuccess == false}">
                $("#successModal").modal("show");
            </c:if>
            });
        </script>
        <script type="text/javascript">
            $("#frmCreateOrder").submit(function () {
                var postData = $("#frmCreateOrder").serialize();
                var submitUrl = $("#frmCreateOrder").attr("action");
                $.ajax({
                    type: "POST",
                    url: submitUrl,
                    data: postData,
                    dataType: 'JSON',
                    success: function (x) {
                        if (x.code === '00') {
                            if (window.vnpay) {
                                vnpay.open({width: 768, height: 600, url: x.data});
                            } else {
                                location.href = x.data;
                            }
                            return false;
                        } else {
                            alert(x.Message);
                        }
                    }
                });
                return false;
            });
        </script>       
    </body>

</html>

