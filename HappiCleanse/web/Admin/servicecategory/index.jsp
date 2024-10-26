<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Danh sách danh mục Dich vụ</title>
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
                                            <h4 >Quản Lí Danh Mục Dịch Vu</h4>
                                            <a href="${pageContext.request.contextPath}/ServiceCategoryServlet?&action=create" id="editable-sample_new" class="btn btn-primary">
                                                Tạo mới <i class="fa fa-plus"></i>
                                            </a>
                                        </div>


                                        <table id="datatable" class="table table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                            <thead>
                                                <tr>
                                                    <th>Mã Loại Dịch Vụ</th>
                                                    <th>Tên Loại Dịch Vụ</th>
                                                    <th>Màu Loại Dịch Vụ</th>
                                                    <th>Hành Động</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="servicecategory" items="${list}">
                                                <tr>
                                                    <td>${servicecategory.idServiceCategory}</td>
                                                    <td>${servicecategory.nameServiceCategory}</td>
                                                    <td>${servicecategory.colorServiceCategory}</td>
                                                    <td>
                                                        <div class="btn-group" role="group">

                                                            <form action="${pageContext.request.contextPath}/ServiceCategoryServlet" method="GET" style="display: inline;">
                                                                <input type="hidden" name="id" value="${servicecategory.idServiceCategory}">
                                                                <input type="hidden" name="action" value="view">

                                                                <button type="submit" class="btn btn-sm btn-primary" style="margin-right: 5px;">
                                                                    <i class="ri-profile-fill"></i>
                                                                </button>
                                                            </form>

                                                            <form action="${pageContext.request.contextPath}/ServiceCategoryServlet" method="GET" style="display: inline;">
                                                                <input type="hidden" name="id" value="${servicecategory.idServiceCategory}">
                                                                <input type="hidden" name="action" value="edit">

                                                                <button type="submit" class="btn btn-sm btn-warning" style="margin-right: 5px;">
                                                                    <i class="ri-pencil-fill"></i>
                                                                </button>
                                                            </form>

                                                            <form action="${pageContext.request.contextPath}/ServiceCategoryServlet" method="GET" style="display: inline;">
                                                                <input type="hidden" name="id" value="${servicecategory.idServiceCategory}">
                                                                <input type="hidden" name="action" value="delete">

                                                                <button type="submit" class="btn btn-sm btn-danger">
                                                                    <i class="ri-delete-bin-fill"></i>
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

        <script src="${pageContext.request.contextPath}/Admin\assets/js/app.js"></script>

    </body>
</html>