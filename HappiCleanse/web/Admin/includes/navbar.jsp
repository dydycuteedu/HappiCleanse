<!-- ========== Left Sidebar Start ========== -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="vertical-menu">

    <div data-simplebar class="h-100">

        <!-- User details -->
        <div class="user-profile text-center mt-3">
            <div class="">
                <img src="${sessionScope.acc.avatar}" alt="Profile" class="rounded-circle profile-pic" style="width: 100px;
                     height: 100px;
                     margin-right: 10px;
                     object-fit: cover;">
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
                    <a href="${pageContext.request.contextPath}/CalenderServlet" class=" waves-effect">
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
                        <li><a href="${pageContext.request.contextPath}/ServiceCategoryServlet?action=management">Danh Mục Dịch Vụ</a></li>
                        <li><a href="${pageContext.request.contextPath}/RoleServlet?action=management">Danh Mục Vai Trò</a></li>
                    </ul>
                </li>

                <li>
                    <a href="javascript: void(0);" class="has-arrow waves-effect">
                        <i class="ri-profile-line"></i>
                        <span>Quản lý</span>
                    </a>
                    <ul class="sub-menu" aria-expanded="false">
                        <li><a href="${pageContext.request.contextPath}/CustomerServlet?action=management">Quản Lý Customer</a></li>
                        <li><a href="${pageContext.request.contextPath}/StaffServlet?action=management">Quản Lý Staff</a></li>
                        <li><a href="${pageContext.request.contextPath}/OrderServlet?actor=admin&action=management">Quản Lý Đơn Hàng</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <!-- Sidebar -->
    </div>
</div>
<!-- Left Sidebar End -->
