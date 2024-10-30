<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>REGISTER STAFF</title>
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
            #datatable th, #datatable td {
                white-space: nowrap; /* Ngăn không cho nội dung xuống dòng */
                overflow: hidden; /* Ẩn phần nội dung bị tràn ra ngoài */
                text-overflow: ellipsis; /* Thêm dấu ba chấm cho nội dung quá dài */
                max-width: 150px; /* Đặt chiều rộng tối đa cho ô, có thể điều chỉnh theo ý muốn */
                padding: 5px; /* Tạo khoảng cách giữa nội dung và viền ô */
                box-sizing: border-box; /* Đảm bảo padding không làm tăng kích thước ô */
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

            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->
            <div class="main-content">

                <div class="page-content">
                    <div class="container-fluid">

                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="card-title">
                                            <h4 >Đăng kí Staff</h4>
                                        </div>


                                        <table id="datatable" class="table table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                            <thead>
                                                <tr>

                                                    <th>Họ và Tên</th>

                                                    <th>Email</th>

                                                    <th>Giới tính</th>
                                                    <th>Số điện thoại</th>
                                                    <th>Hồ sơ xin việc</th>
                                                    <th>Hành Động</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="user" items="${list}">
                                                    <tr>
                                                        <td>${user.fullname}</td>
                                                        <td>${user.email}</td>
                                                        <td>${user.gender}</td>
                                                        <td>${user.phonenumber}</td>
                                                        <td><img style="height: 100px;" src="${user.cvUrl}"  alt="alt"/></td>
                                                            <td>
                                                                <div class="btn-group" role="group">

                                                                    <form action="${pageContext.request.contextPath}/RegisterServlet" method="POST" style="display: inline;">
                                                                    <input type="hidden" name="id" value="${user.idUser}">
                                                                    <input type="hidden" name="action" value="approve">

                                                                    <button type="submit" class="btn btn-sm btn-primary" style="margin-right: 5px;">
                                                                        <i class="ri-check-fill"></i>
                                                                    </button>
                                                                </form>

                                                                <form action="${pageContext.request.contextPath}/RegisterServlet" method="GET" style="display: inline;">
                                                                    <input type="hidden" name="id" value="${user.idUser}">
                                                                    <input type="hidden" name="action" value="deny">
                                                                  
                                                                    <button type="submit" class="btn btn-sm btn-danger">
                                                                        <i class="ri-indeterminate-circle-fill"></i>
                                                                    </button>
                                                                </form>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                            </div> <!-- end col -->
                        </div> <!-- end row -->
                    </div> <!-- container-fluid -->
                </div>
                <!-- End Page-content -->
                <!-- ========== Footer Start ========== -->
                <jsp:include page="../includes/footer.jsp" />
                <!-- ========== Footer End ========== -->


            </div>
            <!-- end main content-->

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
</html>