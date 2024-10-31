<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>ORDER DETAIL</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="Premium Multipurpose Admin & Dashboard Template" name="description" />
        <meta content="Themesdesign" name="author" />
        <!-- App favicon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/Admin\assets/images/favicon.ico">

        <!-- DataTables -->
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-select-bs4/css//select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

        <!-- Sweet Alert-->
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/sweetalert2/sweetalert2.min.css" rel="stylesheet" type="text/css" />
        <!-- Responsive datatable examples -->
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />     

        <!-- Bootstrap Css -->
        <link href="${pageContext.request.contextPath}/Admin\assets/css/bootstrap.min.css" id="bootstrap-style" rel="stylesheet" type="text/css" />
        <!-- Icons Css -->
        <link href="${pageContext.request.contextPath}/Admin\assets/css/icons.min.css" rel="stylesheet" type="text/css" />
        <!-- App Css-->
        <link href="${pageContext.request.contextPath}/Admin\assets/css/app.min.css" id="app-style" rel="stylesheet" type="text/css" />
        <style>
            body{
                background:#eee;
            }
            .card {
                box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
            }
            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid rgba(0,0,0,.125);
                border-radius: 1rem;
            }
            .text-reset {
                --bs-text-opacity: 1;
                color: inherit!important;
            }
            a {
                color: #5465ff;
                text-decoration: none;
            }
        </style>
    </head>

    <body data-topbar="dark">

        <!-- <body data-layout="horizontal" data-topbar="dark"> -->

        <!-- Begin page -->
        <div id="layout-wrapper">
            <!-- ========== Header Start ========== -->
            <jsp:include page="../includes/header.jsp" />
            <!-- ========== Header End ========== -->
            <!-- ========== Left Sidebar Start ========== -->
            <jsp:include page="../includes/navbar.jsp" /> 
            <!-- Left Sidebar End -->

            <div class="main-content">

                <div class="page-content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">

                                        <div class="container">
                                            <!-- Title -->
                                            <div class="d-flex justify-content-between align-items-center py-3">
                                                <h2 class="h5 mb-0"><a href="#" class="text-muted"></a> Mã Đơn hàng #${o.idOrder}</h2>
                                            </div>

                                            <!-- Main content -->
                                            <div class="row">
                                                <div class="col-lg-8">
                                                    <!-- Details -->
                                                    <div class="card mb-4">
                                                        <div class="card-body">
                                                            <div class="mb-3 d-flex justify-content-between">
                                                                <div>
                                                                    <span class="me-3">Thời gian hoàn thành</span>
                                                                    <span class="me-3">#${o.idOrder}</span>

                                                                </div>

                                                            </div>
                                                            <table class="table table-borderless">
                                                                <tfoot>
                                                                    <tr>
                                                                        <td colspan="2">Tên dịch vụ</td>
                                                                        <td class="text-end">120.000VND</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2">Phí dịch vụ</td>
                                                                        <td class="text-end">120.000VND * coeficient</td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td colspan="2">Tổng thời gian hoàn thành dịch vụ</td>
                                                                        <td class="text-end">timeEnd - timeStart</td>
                                                                    </tr>

                                                                    <tr class="fw-bold">
                                                                        <td colspan="2">Tổng tiền</td>
                                                                        <td class="text-end">Phí dịch vụ * số giờ hoàn thành</td>
                                                                    </tr>
                                                                </tfoot>
                                                            </table>
                                                        </div>
                                                    </div>
                                                    <!-- Payment -->
                                                    <div class="card mb-4">
                                                        <div class="card-body">
                                                            <div class="row">
                                                                <div class="col-lg-6">
                                                                    <h3 class="h6">Phương thức thanh toán</h3>
                                                                    <p>Tiền mặt<br>
                                                                        Total: $169,98 
                                                                        <span class="badge bg-success rounded-pill">PAID</span>
                                                                    </p>
                                                                    <p>VNPAY<br>
                                                                        Total: $169,98 
                                                                        <span class="badge bg-success rounded-pill">PAID</span>
                                                                    </p>
                                                                </div>
                                                                <div class="col-lg-6">
                                                                    <h3 class="h6">Thông tin khách hàng</h3>
                                                                    <address>
                                                                        <strong>${o.user.fullname}</strong>
                                                                        <br>
                                                                        ${o.user.address}
                                                                        <br>
                                                                        ${o.user.phonenumber}

                                                                    </address>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-4">
                                                    <!-- Customer Notes -->
                                                    <div class="card mb-4">
                                                        <div class="card-body">
                                                            <h3 class="h6">Ghi chú của khách hàng</h3>
                                                            <p>${o.notes}</p>
                                                        </div>
                                                    </div>
                                                    <div class="card mb-4">
                                                        <div class="card-body">
                                                            <h3 class="h6">Trạng thái đơn hàng</h3>
                                                            <c:if test="${o.statusOrder == 'Completed'}">
                                                                <span class="badge bg-success">Completed</span>
                                                            </c:if>
                                                            <c:if test="${o.statusOrder == 'Pending'}">
                                                                <span class="badge bg-warning">Pending</span>
                                                            </c:if>
                                                            <c:if test="${o.statusOrder == 'In Progress'}">
                                                                <span class="badge bg-warning">In Progress</span>
                                                            </c:if>
                                                            <c:if test="${o.statusOrder == 'Cancelled'}">
                                                                <span class="badge bg-danger">Cancelled</span>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                    <div class="card mb-4">
                                                        <!-- Staff information -->
                                                        <div class="card-body">
                                                            <h3 class="h6">Thông tin nhân viên</h3>
                                                            <strong>${o.staff.fullname}</strong>

                                                        </div>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-0">
                                            <div>
                                                <a href="${pageContext.request.contextPath}/AdminServlet" class="btn btn-secondary waves-effect">
                                                    Quay trở lại
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div> <!-- end col -->
                        </div>
                        <!-- end row -->
                    </div> <!-- container-fluid -->
                </div>
                <!-- End Page-content -->

                <!-- ========== Footer Start ========== -->
                <jsp:include page="../includes/footer.jsp" />
                <!-- ========== Footer End ========== -->

            </div>
            <!-- END layout-wrapper -->

            <!-- ========== Rightbar Start ========== -->
            <jsp:include page="../includes/rightbar.jsp" />
            <!-- ========== Rightbar End ========== -->

            <!-- JAVASCRIPT -->
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/metismenu/metisMenu.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/simplebar/simplebar.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/node-waves/waves.min.js"></script>

            <!-- Required datatable js -->
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net/js/jquery.dataTables.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
            <!-- Buttons examples -->
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/jszip/jszip.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/pdfmake/build/pdfmake.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/pdfmake/build/vfs_fonts.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons/js/buttons.html5.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons/js/buttons.print.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons/js/buttons.colVis.min.js"></script>

            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-select/js/dataTables.select.min.js"></script>

            <!-- Responsive examples -->
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>

            <!-- Datatable init js -->
            <script src="${pageContext.request.contextPath}/Admin\assets/js/pages/datatables.init.js"></script>
            <!-- Sweet Alerts js -->
            <script src="${pageContext.request.contextPath}/Admin\assets/libs/sweetalert2/sweetalert2.min.js"></script>

            <!-- Sweet alert init js-->
            <script src="${pageContext.request.contextPath}/Admin\assets/js/pages/sweet-alerts.init.js"></script>

            <script src="${pageContext.request.contextPath}/Admin\assets/js/app.js"></script>

    </body>
