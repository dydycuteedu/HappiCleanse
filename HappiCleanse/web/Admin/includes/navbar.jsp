<!-- ========== Left Sidebar Start ========== -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="vertical-menu">

    <div data-simplebar class="h-100">

        <!-- User details -->
        <div class="user-profile text-center mt-3">
            <div class="">
                <img src="${sessionScope.acc.avatar}" alt="" class="avatar-md rounded-circle">
            </div>
            <div class="mt-3">
                <h4 class="font-size-16 mb-1">${sessionScope.acc.username}</h4>
                <span class="text-muted"><i class="ri-record-circle-line align-middle font-size-14 text-success"></i>Online</span>
            </div>
        </div>

        <!--- Sidemenu -->
        <div id="sidebar-menu">
            <!-- Left Menu Start -->
            <ul class="metismenu list-unstyled" id="side-menu">
                <li class="menu-title">Menu</li>

                <li>
                    <a href="${pageContext.request.contextPath}/AdminServlet" class="waves-effect">
                        <i class="ri-dashboard-line"></i><span class="badge rounded-pill bg-success float-end">3</span>
                        <span>Dashboard</span>
                    </a>
                </li>

                <li>
                    <a href="${pageContext.request.contextPath}/views/admin/home/calendar.jsp" class=" waves-effect">
                        <i class="ri-calendar-2-line"></i>
                        <span>Calendar</span>
                    </a>
                </li>

                <li>
                    <a href="javascript: void(0);" class="has-arrow waves-effect">
                        <i class="ri-mail-send-line"></i>
                        <span>Support</span>
                    </a>
                    <ul class="sub-menu" aria-expanded="false">
                        <li><a href="email-inbox.html">FeedBack</a></li>
                        <li><a href="email-read.html">Report</a></li>
                    </ul>
                </li>


                <li class="menu-title">Pages</li>

                <li>
                    <a href="javascript: void(0);" class="has-arrow waves-effect">
                        <i class="ri-account-circle-line"></i>
                        <span>Danh mục</span>
                    </a>
                    <ul class="sub-menu" aria-expanded="false">
                        <li><a href="${pageContext.request.contextPath}/PolicyCategoryServlet?actor=admin&action=management">Danh Mục Chính Sách</a></li>
                        <li><a href="${pageContext.request.contextPath}/DishCategoryServlet?actor=admin&action=management">Danh Mục Món Ăn</a></li>
                        <li><a href="${pageContext.request.contextPath}/RoleServlet?actor=admin&action=management">Danh Mục Vai Trò</a></li>
                        <li><a href="${pageContext.request.contextPath}/NutrionServlet?actor=admin&action=management">Danh Mục Nguyên Liệu</a></li>
                    </ul>
                </li>

                <li>
                    <a href="javascript: void(0);" class="has-arrow waves-effect">
                        <i class="ri-profile-line"></i>
                        <span>Quản lý</span>
                    </a>
                    <ul class="sub-menu" aria-expanded="false">
                        <li><a href="${pageContext.request.contextPath}/UsersServlet?actor=admin&action=management">Quản Lý Người Dùng</a></li>
                        <li><a href="${pageContext.request.contextPath}/PolicyServlet?actor=admin&action=management">Quản Lý Chính Sách</a></li>
                        <li><a href="${pageContext.request.contextPath}/OrderServlet?actor=admin&action=management">Quản Lý Đơn Hàng</a></li>
                        <li><a href="${pageContext.request.contextPath}/DishServlet?actor=admin&action=management">Quản Lý Món Ăn</a></li>
                        <li><a href="${pageContext.request.contextPath}/CostServlet?actor=admin&action=management">Quản Lý Chi Phí Dịch Vụ</a></li>
                        <li><a href="${pageContext.request.contextPath}/DishServlet?actor=admin&action=management">Quản Lý Sự Kiện</a></li>
                        <li><a href="${pageContext.request.contextPath}/DishServlet?actor=admin&action=management">Quản Lý Mã Giảm Giá</a></li>
                        <li><a href="${pageContext.request.contextPath}/DishServlet?actor=admin&action=management">Quản Lý Thông Báo</a></li>
                        <li><a href="${pageContext.request.contextPath}/DishServlet?actor=admin&action=management">Quản Lý Chi Phí Giao Hàng</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- Sidebar -->
    </div>
</div>
<!-- Left Sidebar End -->
