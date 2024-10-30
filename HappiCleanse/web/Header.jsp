
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <!-- Spinner Start -->
    <div id="spinner"
         class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
        <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
    <!-- Spinner End -->


    <!-- Topbar Start -->
    <div class="container-fluid bg-light d-none d-lg-block">
        <div class="row align-items-center top-bar">
            <div class="col-lg-3 col-md-12 text-center text-lg-start">
                <a href="" class="navbar-brand m-0 p-0">
                    <h1 class="text-primary m-0">Happi Cleanse</h1>
                </a>
            </div>
            <div class="col-lg-9 col-md-12 text-end">
                <div class="h-100 d-inline-flex align-items-center me-4">
                    <i class="fa fa-map-marker-alt text-primary me-2"></i>
                    <p class="m-0">Da Nang</p>
                </div>
                <div class="h-100 d-inline-flex align-items-center me-4">
                    <i class="far fa-envelope-open text-primary me-2"></i>
                    <p class="m-0">happicleanse@gmail.com.com</p>
                </div>

            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid nav-bar bg-light">
        <nav class="navbar navbar-expand-lg navbar-light bg-white p-3 py-lg-0 px-lg-4">
            <a href="" class="navbar-brand d-flex align-items-center m-0 p-0 d-lg-none">
                <h1 class="text-primary m-0">HappiCleanse</h1>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                <span class="fa fa-bars"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <div class="navbar-nav me-auto">
                    <a href="/HappiCleanse/home" class="nav-item nav-link active">Home</a>
                    <c:if test="${sessionScope.acc.role != 'Staff'}">
                        <a href="/HappiCleanse/Hiring.jsp" class="nav-item nav-link">Hiring</a>
                        <a href="ListServiceServlet" class="nav-item nav-link">Services</a>
                        <a href="BookingServlet" class="nav-item nav-link">Booking</a>
                        <a href="contact.html" class="nav-item nav-link">Contact</a>
                    </c:if>
                    <c:if test="${sessionScope.acc.role == 'Staff'}">
                        <a href="StaffWorkingServlet" class="nav-item nav-link">Order Booking List</a>
                    </c:if>
                </div>

                <c:if test="${sessionScope.acc == null}">
                    <a class="mt-4 mt-lg-0 me-lg-n4 py-3 px-4 bg-primary d-flex align-items-center"
                       style="border-radius: 5px" href="/HappiCleanse/login.jsp">
                        <div class="">
                            <p class="mb-1 text-white">Login</p>
                        </div>
                    </a>
                </c:if>
                <c:if test="${sessionScope.acc != null}">
                    <div class="container py-5">
                        <div class="d-flex justify-content-end">
                            <!-- Dropdown Component -->
                            <div class="dropdown">
                                <a href="#" class="d-flex align-items-center text-decoration-none dropdown-toggle" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                                    <!-- Profile Picture -->
                                    <img src="${sessionScope.acc.avatar}" alt="Profile" class="rounded-circle profile-pic" style="width: 50px;
                                         height: 50px;
                                         margin-right: 10px;
                                         object-fit: cover;">
                                    <!-- Name -->
                                    <span class="profile-name">${sessionScope.acc.fullname}</span>
                                </a>
                                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuLink">
                                    <c:if test="${sessionScope.acc.getRole() eq 'Admin'}">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/AdminServlet">Admin Management</a></li>
                                        </c:if>
                                    <li><a class="dropdown-item" href="editProfile">Profile</a></li>
                                    <li><a class="dropdown-item" href="#">Settings</a></li>
                                    <li><a class="dropdown-item" href="/HappiCleanse/Logout">Logout</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </nav>
    </div>
    <!-- Navbar End -->
