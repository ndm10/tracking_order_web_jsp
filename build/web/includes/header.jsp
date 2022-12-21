<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
* CoreUI - Free Bootstrap Admin Template
* @version v4.2.2
* @link https://coreui.io
* Copyright (c) 2022 creativeLabs ?ukasz Holeczek
* Licensed under MIT (https://coreui.io/license)
-->
<!-- Breadcrumb-->
<html lang="en">
    <head>
        <base href="./">
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
        <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
        <meta name="author" content="?ukasz Holeczek">
        <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
        <title>CoreUI Free Bootstrap Admin Template</title>
        <link rel="apple-touch-icon" sizes="57x57" href="assets/favicon/apple-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="60x60" href="assets/favicon/apple-icon-60x60.png">
        <link rel="apple-touch-icon" sizes="72x72" href="assets/favicon/apple-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="assets/favicon/apple-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="assets/favicon/apple-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="assets/favicon/apple-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="assets/favicon/apple-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="assets/favicon/apple-icon-152x152.png">
        <link rel="apple-touch-icon" sizes="180x180" href="assets/favicon/apple-icon-180x180.png">
        <link rel="icon" type="image/png" sizes="192x192" href="assets/favicon/android-icon-192x192.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/favicon/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="96x96" href="assets/favicon/favicon-96x96.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/favicon/favicon-16x16.png">
        <link rel="manifest" href="assets/favicon/manifest.json">
        <meta name="msapplication-TileColor" content="#ffffff">
        <meta name="msapplication-TileImage" content="assets/favicon/ms-icon-144x144.png">
        <meta name="theme-color" content="#ffffff">
        <!-- Vendors styles-->
        <link rel="stylesheet" href="vendors/simplebar/css/simplebar.css">
        <link rel="stylesheet" href="css/vendors/simplebar.css">
        <!-- Main styles for this application-->
        <link href="css/style.css" rel="stylesheet">
        <!-- We use those styles to show code examples, you should remove them in your application.-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/prismjs@1.23.0/themes/prism.css">
        <link href="css/examples.css" rel="stylesheet">
        <!-- Global site tag (gtag.js) - Google Analytics-->
        <script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-118965717-3"></script>
        <script>
            window.dataLayer = window.dataLayer || [];

            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());
            // Shared ID
            gtag('config', 'UA-118965717-3');
            // Bootstrap ID
            gtag('config', 'UA-118965717-5');

            function displayMess() {
                var x = document.getElementById("snackbar");
                x.className = "show";
                setTimeout(function () {
                    x.className = x.className.replace("show", "");
                }, 3000);
            }
        </script>
        <style>
            #snackbar {
                visibility: hidden;
                min-width: 250px;
                margin-left: -125px;
                background-color: #333;
                color: #fff;
                text-align: center;
                border-radius: 10px;
                padding: 16px;
                position: fixed;
                z-index: 1;
                left: 50%;
                top: 30px;
                font-size: 17px;
            }

            #snackbar.show {
                visibility: visible;
                border-radius: 10px;
                -webkit-animation: fadein 1s, fadeout 1s 2.5s;
                animation: fadein 1s, fadeout 1s 2.5s;
            }

            @-webkit-keyframes fadein {
                from {
                    top: 0;
                    opacity: 0;
                }
                to {
                    top: 30px;
                    opacity: 1;
                }
            }

            @keyframes fadein {
                from {
                    top: 0;
                    opacity: 0;
                }
                to {
                    top: 30px;
                    opacity: 1;
                }
            }

            @-webkit-keyframes fadeout {
                from {
                    top: 30px;
                    opacity: 1;
                }
                to {
                    top: 0;
                    opacity: 0;
                }
            }

            @keyframes fadeout {
                from {
                    top: 30px;
                    opacity: 1;
                }
                to {
                    top: 0;
                    opacity: 0;
                }
            }
        </style>
        <link href="vendors/@coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
    </head>
    <body>
        <div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
            <div class="sidebar-brand d-none d-md-flex">
                Order Tracking
            </div>
            <ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
                <li class="nav-item"><a class="nav-link" href="Homepage">
                        <svg class="nav-icon">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-speedometer"></use>
                        </svg> Dashboard</a></li>
                <li class="nav-title">Admin</li>
                <li class="nav-item"><a class="nav-link" href="Order">
                        <svg class="nav-icon">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-notes"></use>
                        </svg> Orders</a></li>
                <li class="nav-item"><a class="nav-link" href="typography.html">
                        <svg class="nav-icon">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-layers"></use>
                        </svg> Group</a></li>
                <li class="nav-title">Staff</li>
                <li class="nav-item"><a class="nav-link" href="Order">
                        <svg class="nav-icon">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-notes"></use>
                        </svg> Orders</a></li>

            </ul>
            <button class="sidebar-toggler" type="button" data-coreui-toggle="unfoldable"></button>
        </div>
        <div class="wrapper d-flex flex-column min-vh-100 bg-light">
            <header class="header header-sticky mb-4">
                <div class="container-fluid">
                    <button class="header-toggler px-md-0 me-md-3" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()">
                        <svg class="icon icon-lg">
                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-menu"></use>
                        </svg>
                    </button><a class="header-brand d-md-none" href="#">
                        <svg width="118" height="46" alt="CoreUI Logo">
                        <use xlink:href="assets/brand/coreui.svg#full"></use>
                        </svg></a>
                        <c:if test="${sessionScope.account eq null}">
                        <ul class="header-nav d-none d-md-flex">
                            <li class="nav-item"><a class="nav-link" href="Login">Login</a></li>
                            <li class="nav-item"><a class="nav-link" href="Register">Register</a></li>
                        </ul>
                    </c:if>
                    <c:if test="${sessionScope.account ne null}">
                        <ul class="header-nav ms-3">
                            <li class="nav-item dropdown"><a class="nav-link py-0" data-coreui-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="avatar avatar-md"><img class="avatar-img" src="assets/img/avatars/clone.jpg" alt="user@email.com"></div>
                                </a>
                                <div class="dropdown-menu dropdown-menu-end pt-0">
                                    <div class="dropdown-header bg-light py-2">
                                        <div class="fw-semibold">Account</div>
                                    </div>
                                    <a class="dropdown-item" href="#">
                                        <svg class="icon me-2">
                                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
                                        </svg> Profile</a><a class="dropdown-item" href="#">
                                        <svg class="icon me-2">
                                        <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-settings"></use>
                                        </svg> Settings</a><a class="dropdown-item" href="#">
                                        <div class="dropdown-divider"></div><a class="dropdown-item" href="Logout">
                                            <svg class="icon me-2">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-account-logout"></use>
                                            </svg> Logout</a>
                                </div>
                            </li>
                        </ul>
                    </c:if>
                </div>
                <div class="header-divider"></div>
                <div class="container-fluid">
                    <div id="snackbar">${sessionScope.message}</div>
                    <c:if test="${sessionScope.message ne null}">
                        <script>
                            displayMess();
                        </script>
                    </c:if>
                    <c:set var="message" scope="session" value="${null}"></c:set>
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb my-0 ms-2">
                            <li class="breadcrumb-item">
                                <!-- if breadcrumb is single--><span>Home</span>
                            </li>
                            <li class="breadcrumb-item active"><span>Dashboard</span></li>
                        </ol>
                    </nav>
                </div>
            </header>