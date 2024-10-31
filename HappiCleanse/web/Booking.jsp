
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
        <style>
            .star-rating {
                font-size: 2em;
                direction: rtl; /* Display stars from right to left /
                unicode-bidi: bidi-override; / Support proper alignment */
                display: inline-block;
            }

            .star {
                cursor: pointer;
                color: lightgray;
                transition: color 0.3s;
            }

            .star:hover,
            .star:hover ~ .star {
                color: gold;
            }

            .selected {
                color: gold;
            }

        </style>
    </head>

    <body>
        <%@include file="Header.jsp" %>

        <!-- Page Header Start -->
        <div class="container-fluid page-header mb-5 py-5">
            <div class="container">
                <h1 class="display-3 text-white mb-3 animated slideInDown">Booking History</h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Booking History</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <!-- Service Start -->
        <div class="container-fluid py-5 px-4 px-lg-0">
            <div class="row g-0">
                <div class="col-md-12 col-lg-9">
                    <div class="ms-lg-5 ps-lg-5">
                        <div class="text-center text-lg-start wow fadeInUp" data-wow-delay="0.1s">
                            <h1 class="mb-5">Your Order History</h1>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-bordered text-center">
                                <thead class="bg-light">
                                    <tr>
                                        <th>Order Number</th>
                                        <th>Notes</th>
                                        <th>Trạng thái</th>
                                        <th>Thời gian bắt đầu</th>
                                        <th>Thời gian hoàn thành</th> 
                                        <th>Tên nhân viên làm việc</th>
                                        <th>Tổng tiền</th>
                                        <th>Hành động</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orderList}" var="order">
                                        <tr>
                                            <td>${order.idOrder}</td>
                                            <td>${order.notes}</td>
                                            <c:if test="${order.statusOrder == 'Completed'}">
                                                <td><span class="badge bg-success">Completed</span></td>
                                            </c:if>
                                            <c:if test="${order.statusOrder == 'Pending'}">
                                                <td><span class="badge bg-warning">Pending</span></td>
                                            </c:if>
                                            <c:if test="${order.statusOrder == 'In Progress'}">
                                                <td><span class="badge bg-warning">In Progress</span></td>
                                            </c:if>
                                            <c:if test="${order.statusOrder == 'Cancelled'}">
                                                <td><span class="badge bg-danger">Cancelled</span></td>
                                            </c:if>
                                            <td>${order.dateService}</td>
                                            <c:if test="${order.staff.fullname == null}">
                                                <td>Not yet</td>
                                            </c:if>
                                            <c:if test="${order.staff.fullname != null}">
                                                <td>${order.staff.fullname}</td>
                                            </c:if>
                                            <td>${order.shifts.price}00 vnd</td>
                                            <c:if test="${order.statusOrder == 'Pending'}">
                                                <td>
                                                    <form action="BookingServlet" method="post" style="display: inline;">
                                                        <input type="hidden" name="id" value="${order.idOrder}">
                                                        <button type="submit" class="btn btn-sm btn-danger" id="sa-params">
                                                            <i class="ri-delete-bin-fill">Cancel</i>
                                                        </button>
                                                    </form>
                                                </td>
                                            </c:if>
                                            <c:if test="${order.statusOrder == 'Completed'}">
                                                <td>
                                                    <button class="btn btn-light" data-bs-toggle="modal" data-bs-target="#createDishModal">
                                                        <i class="ri-delete-bin-fill">Feedback</i>
                                                    </button>
                                                </td>
                                            </c:if>
                                        </tr>
                                    <div class="modal fade" id="createDishModal" tabindex="20" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="createDishModalLabel">Feedback Service</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="FeedbackServlet" method="post">
                                                        <input hidden="true" type="text" class="form-control" name="orderid" value="${order.idOrder}" required>
                                                        <div class="star-rating">
                                                            <span class="star" data-value="5">&#9733;</span>
                                                            <span class="star" data-value="4">&#9733;</span>
                                                            <span class="star" data-value="3">&#9733;</span>
                                                            <span class="star" data-value="2">&#9733;</span>
                                                            <span class="star" data-value="1">&#9733;</span>
                                                        </div>

                                                        <input hidden="true" type="text" id="rating-value-${order.idOrder}" class="form-control" name="rating">
                                                        <div class="mb-3">
                                                            <label for="description" class="form-label">Feedback</label>
                                                            <textarea class="form-control" id="description" name="description" rows="3"></textarea>
                                                        </div>     
                                                        <button name="action" type="create" value="create" class="btn btn-primary">Send Feedback</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <script>
                                        document.querySelectorAll('.modal').forEach((modal) => {
                                            const stars = modal.querySelectorAll('.star'); // Chỉ lấy các 'star' trong modal này
                                            const ratingInput = modal.querySelector('input[name="rating"]'); // Lấy rating input trong modal này

                                            let selectedRating = 0;

                                            stars.forEach(star => {
                                                star.addEventListener('click', () => {
                                                    selectedRating = star.getAttribute('data-value');
                                                    ratingInput.value = selectedRating;
                                                    updateStars(stars, selectedRating);
                                                });

                                                star.addEventListener('mouseover', () => {
                                                    highlightStars(stars, star.getAttribute('data-value'));
                                                });

                                                star.addEventListener('mouseout', () => {
                                                    updateStars(stars, selectedRating);
                                                });
                                            });

                                            function highlightStars(stars, rating) {
                                                stars.forEach(star => {
                                                    star.classList.toggle('selected', star.getAttribute('data-value') <= rating);
                                                });
                                            }

                                            function updateStars(stars, rating) {
                                                stars.forEach(star => {
                                                    star.classList.toggle('selected', star.getAttribute('data-value') <= rating);
                                                });
                                            }
                                        });

                                    </script>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Service End -->

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

