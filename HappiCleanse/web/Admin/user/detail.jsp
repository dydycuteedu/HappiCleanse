<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>Data Tables | Upcube - Admin & Dashboard Template</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="Premium Multipurpose Admin & Dashboard Template" name="description" />
        <meta content="Themesdesign" name="author" />
        <!-- App favicon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/views/admin\assets/images/favicon.ico">

        <!-- DataTables -->
        <link href="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-select-bs4/css//select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

        <!-- Sweet Alert-->
        <link href="${pageContext.request.contextPath}/views/admin\assets/libs/sweetalert2/sweetalert2.min.css" rel="stylesheet" type="text/css" />
        <!-- Responsive datatable examples -->
        <link href="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-responsive-bs4/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />     

        <!-- Bootstrap Css -->
        <link href="${pageContext.request.contextPath}/views/admin\assets/css/bootstrap.min.css" id="bootstrap-style" rel="stylesheet" type="text/css" />
        <!-- Icons Css -->
        <link href="${pageContext.request.contextPath}/views/admin\assets/css/icons.min.css" rel="stylesheet" type="text/css" />
        <!-- App Css-->
        <link href="${pageContext.request.contextPath}/views/admin\assets/css/app.min.css" id="app-style" rel="stylesheet" type="text/css" />
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
                                            <h4 >Thông Tin Người Dùng</h4>
                                        </div>
                                        <div class="profile-details">
                                            <ul>
                                                <li><strong>First Name:</strong> ${userdetail.firstName}</li>
                                                <li><strong>Last Name:</strong> ${userdetail.lastName}</li>
                                                <li><strong>Telephone</strong> ${userdetail.tel}</li>
                                                <li><strong>Gender:</strong> ${userdetail.gender}</li>
                                                <li><strong>Date of Birth:</strong> ${userdetail.dob}</li>
                                                <li><strong>Avatar</strong> <img src="${pageContext.request.contextPath}/views/admin\assets/images/users/${userdetail.avatar}" alt="" class="avatar-md rounded-circle"></li>
                                                <li><strong>Username:</strong> ${user.username}</li>
                                                <li><strong>Email:</strong> ${user.email}</li>
                                                <li><strong>Spicy Status:</strong> ${userfeel.isSpicy}</li>
                                                <li><strong>Sour Status:</strong> ${userfeel.isSour}</li>
                                                <li><strong>Salty Status:</strong> ${userfeel.isSalty}</li>
                                                <li><strong>Sweet Status:</strong> ${userfeel.isSweet}</li>
                                                <li><strong>Bitter Status:</strong> ${userfeel.isBitter}</li>
                                                <li><strong>Hot Status:</strong> ${userfeel.isHot}</li>
                                                <li><strong>Cold Status:</strong> ${userfeel.isCold}</li>
                                                <li><strong>Allergy:</strong> ${userallergy.name}</li>
                                                <li><strong>Height:</strong> ${userhealth.height} cm</li>
                                                <li><strong>Weight:</strong> ${userhealth.weight} kg</li>
                                                <li><strong>Blood Pressure:</strong> ${userhealth.isBloodPressure}</li>
                                            </ul>
                                        </div>
                                        <div class="mb-0">
                                            <div>
                                                <a href="${pageContext.request.contextPath}/UsersServlet?actor=admin&action=management" class="btn btn-secondary waves-effect">
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
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/jquery/jquery.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/bootstrap/js/bootstrap.bundle.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/metismenu/metisMenu.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/simplebar/simplebar.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/node-waves/waves.min.js"></script>

            <!-- Required datatable js -->
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net/js/jquery.dataTables.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-bs4/js/dataTables.bootstrap4.min.js"></script>
            <!-- Buttons examples -->
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-buttons-bs4/js/buttons.bootstrap4.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/jszip/jszip.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/pdfmake/build/pdfmake.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/pdfmake/build/vfs_fonts.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-buttons/js/buttons.html5.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-buttons/js/buttons.print.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-buttons/js/buttons.colVis.min.js"></script>

            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-select/js/dataTables.select.min.js"></script>

            <!-- Responsive examples -->
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>

            <!-- Datatable init js -->
            <script src="${pageContext.request.contextPath}/views/admin\assets/js/pages/datatables.init.js"></script>
            <!-- Sweet Alerts js -->
            <script src="${pageContext.request.contextPath}/views/admin\assets/libs/sweetalert2/sweetalert2.min.js"></script>

            <!-- Sweet alert init js-->
            <script src="${pageContext.request.contextPath}/views/admin\assets/js/pages/sweet-alerts.init.js"></script>

            <script src="${pageContext.request.contextPath}/views/admin\assets/js/app.js"></script>

    </body>
