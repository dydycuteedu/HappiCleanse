<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>ADMIN EDIT SERVICE</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta content="Premium Multipurpose Admin & Dashboard Template" name="description" />
        <meta content="Themesdesign" name="author" />
        <!-- App favicon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/Admin\assets/images/favicon.ico">

        <!-- DataTables -->
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-buttons-bs4/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/Admin\assets/libs/datatables.net-select-bs4/css//select.bootstrap4.min.css" rel="stylesheet" type="text/css" />

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
                                            <h4 >Chỉnh Sửa Dịch Vụ</h4>
                                        </div>
                                        <form action="${pageContext.request.contextPath}/ServiceServlet" method="post" style="display: inline;">
                                            <div class="row mb-3">

                                                <input type="hidden" name="id" value="${service.idService}">

                                                <label for="rolename" class="col-sm-2 col-form-label">Tên Dịch Vụ</label>
                                                <div class="col-sm-10">
                                                    <input class="form-control" type="text" name="nameService" id="userid" value="${service.nameService}" >
                                                </div>
                                                <label for="rolename" class="col-sm-2 col-form-label">Mô tả dịch vụ</label>
                                                <div class="col-sm-10">
                                                    <input class="form-control" type="text" name="description" id="description" value="${service.description}" >
                                                </div>

                                                <div class="mb-0">
                                                    <div>
                                                        <input type="submit" class="btn btn-primary waves-effect waves-light me-1" name="action" value="Save"/>
                                                        <a href="${pageContext.request.contextPath}/ServiceServlet?action=management" class="btn btn-secondary waves-effect">
                                                            Quay trở lại
                                                        </a>
                                                    </div>
                                                </div>
                                        </form>
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

        <!-- bs custom file input plugin -->
        <script src="${pageContext.request.contextPath}/Admin\assets/libs/bs-custom-file-input/bs-custom-file-input.min.js"></script>

        <script src="${pageContext.request.contextPath}/Admin\assets/js/pages/form-element.init.js"></script>

        <script src="${pageContext.request.contextPath}/Admin\assets/js/app.js"></script>

    </body>
</html>
