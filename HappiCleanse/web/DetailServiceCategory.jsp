<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <title>Detail ServiceCategory HappiCleanse</title>
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
            .split-content .main {
                align-items: stretch;
            }

            .flex {
                display: flex;
                flex-wrap: wrap;
                align-items: center;
                justify-content: space-between;
            }
            .main {
                margin-left: auto;
                margin-right: auto;
                width: 100%;
                max-width: 66.667rem;
            }
            .spaced > .half {
                max-width: calc(50% -(var(--general-spacing) / 2));
            }
            .split-content article {
                _align-self: center;
            }
            .half {
                width: 50%;
            }
            .flex > * {
                flex: 0 1 auto;
            }
            .half {
                width: 50%;
            }
            .content {
                position: relative;
                font-size: 0.889rem;
            }
            .split-content .content + .content {
                margin-top: 1.778rem;
            }
            .content p {
                margin: 1.778rem 0;
            }
            .line-btn {
                outline: none;
                cursor: pointer;
                position: relative;
                line-height: 1;
                display: inline-block;
                z-index: 1;
                font-weight: 400;
                text-align: center;
                font-size: 1rem;
                font-style: italic;
                font-family: var(--primary-font);
                letter-spacing: 0.05em;
                color: var(--primary);
                transition: color 0.3s ease;
                padding: 0.625em 0;
                background-color: transparent;
            }
            a {
                color: var(--primary);
                transition: color .4s ease 0s;
                text-decoration: none;
            }
            .service-images + .side-nav {
                max-width: 25em;
                margin-top: 2.5em;
            }
            .side-nav {
                background-color: #17224d;
                padding: 2em;
            }
            .side-nav h4:after {
                content: '';
                display: block;
                height: 3px;
                width: 2.5em;
                margin: 1.5rem 0 1rem;
                background-color: #ffffff;
            }
            .side-nav ul {
                font-size: 0.944rem;
                font-family: var(--primary-font);
                line-height: 1.333;
            }

            ul, ol {
                list-style: none;
                margin: 0;
                padding: 0;
            }
            .side-nav li {
                margin-top: 0.5rem;
            }
            .side-nav li a:hover, .side-nav li a:focus, .side-nav li.selected > a {
                color: #ffffff;
            }

            .side-nav li a {
                display: block;
                color: #ffffff;
                padding: 0.444rem 0;
                position: relative;
            }
            a {
                /* color: var(--primary); */
                transition: color .4s ease 0s;
                text-decoration: none;
            }
        </style>
    </head>

    <body>
        <%@include file="Header.jsp" %>

        <!-- Page Header Start -->
        <div class="container-fluid page-header mb-5 py-5">
            <div class="container">
                <h1 class="display-3 text-white mb-3 animated slideInDown">Detail Service Category</h1>
                <nav aria-label="breadcrumb animated slideInDown">
                    <ol class="breadcrumb text-uppercase">
                        <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                        <li class="breadcrumb-item"><a class="text-white" href="#">Pages</a></li>
                        <li class="breadcrumb-item text-white active" aria-current="page">Detail Service Category</li>
                    </ol>
                </nav>
            </div>
        </div>
        <!-- Page Header End -->

        <section id="SplitContent" class="split-content" universal_="true">

            <div class="main flex spaced" bis_skin_checked="1">
                <article class="half" id="ContentZone">
                    <div id="MainContent" class="content" data-content="true" tabindex="0" bis_skin_checked="1">
                        <h1>${servicecategory.nameServiceCategory}</h1>
                    </div>
                    <div id="MainContent2" class="content" bis_skin_checked="1">
                        <h2>
                            ${servicecategory.subDescription}
                        </h2>
                        <p>
                            ${servicecategory.description}
                        </p>
                    </div>

                </article>
                <div class="half" id="FigureZone" bis_skin_checked="1" >
                    <div id="SideServiceImageV2" class="service-images new no-scroll" role="presentation" bis_skin_checked="1">


                        <div class="container" bis_skin_checked="1">
                            <picture data-role="picture" class="">
                                <img alt="side services image "
                                     src="${servicecategory.imgURL}" style="object-fit: cover; width: 100%;">
                            </picture>
                        </div>
                    </div>
                    <nav class="side-nav ui-repeater" id="SideNav" role="menu" universal_="true">
                        <header>
                            <a href="/cleaning-services/">
                                <h4 style="color: white">${servicecategory.nameServiceCategory}</h4>
                            </a>
                        </header>
                        <ul class="el-tab-box" role="tablist" aria-label="Navigation menu for Cleaning Services">
                            <c:forEach var="service" items="${service}">
                                <li class="level-1 active selected " aria-labelledby="Navigation menu for Cleaning Services"
                                    role="menuitem">
                                    <a href="DetailService?idService=${service.idService}" target="">${service.nameService}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </nav>
                </div>
            </div>
        </section>

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

