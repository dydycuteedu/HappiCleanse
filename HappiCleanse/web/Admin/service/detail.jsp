<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>SERVICE DETAIL</title>
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
                                        <div class="card-title">
                                            <h4 >Thông Tin Dịch vụ</h4>
                                        </div>
                                        <div class="profile-details">
                                            <ul>
                                                <li><strong>Mã Dịch vụ:</strong> ${service.idService}</li>
                                                <li><strong>Tên Dịch vụ:</strong> ${service.nameService}</li>
                                                <li><strong>Mô Tả:</strong> ${service.description}</li>
                                                <li><strong>Loại Dịch vụ:</strong> ${service.serviceCategory.nameServiceCategory}</li>
                                                <li><strong>Hình Ảnh:</strong>
                                                    <img class="rounded-circle header-profile-user" src="${service.img1}" alt="alt"/>
                                                    <img class="rounded-circle header-profile-user" src="${service.img2}" alt="alt"/>
                                                    <img class="rounded-circle header-profile-user" src="${service.img3}" alt="alt"/>
                                                </li>

                                            </ul>
                                        </div>
                                        <div class="mb-0">
                                            <div>
                                                <a href="${pageContext.request.contextPath}/ServiceServlet?action=management" class="btn btn-secondary waves-effect">
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
