<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
* CoreUI - Free Bootstrap Admin Template
* @version v4.2.2
* @link https://coreui.io
* Copyright (c) 2022 creativeLabs ?ukasz Holeczek
* Licensed under MIT (https://coreui.io/license)
-->
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
        </script>
    </head>
    <body onload="checkUser()">
        <div class="bg-light min-vh-100 d-flex flex-row align-items-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6">
                        <div class="card mb-4 mx-4">
                            <div class="card-body p-4">
                                <h1>Register</h1>
                                <p class="text-medium-emphasis">Create your account</p>
                                <form id="register-form" action="Register" method="Post">
                                    <div class="input-group mb-3"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-text-square"></use>
                                            </svg></span>
                                        <input id="full-name" class="form-control" type="text" name="fullName" placeholder="Full Name" required>
                                    </div>
                                    <div class="input-group mb-3"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-envelope-open"></use>
                                            </svg></span>
                                        <input id="email" class="form-control" type="email" name="email" placeholder="Email" required>
                                    </div>
                                    <div class="input-group mb-3"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-pin"></use>
                                            </svg></span>
                                        <input id="address" class="form-control" type="text" name="address" placeholder="Address" required>
                                    </div>
                                    <div class="input-group mb-3"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-phone"></use>
                                            </svg></span>
                                        <input id="phone" class="form-control" type="text" name="phone" placeholder="Phone" pattern="^[0-9]{10}$" required>
                                    </div>
                                    <div class="input-group mb-4"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-user"></use>
                                            </svg></span>
                                        <input id="user-name" class="form-control" type="text" name="userName" placeholder="User Name" required>
                                    </div>
                                    <div class="input-group mb-3"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-lock-locked"></use>
                                            </svg></span>
                                        <input id="pass" class="form-control" type="password" name="password" placeholder="Password" required>
                                    </div>
                                    <div class="input-group mb-4"><span class="input-group-text">
                                            <svg class="icon">
                                            <use xlink:href="vendors/@coreui/icons/svg/free.svg#cil-lock-locked"></use>
                                            </svg></span>
                                        <input id="pass_repeat" class="form-control" type="password" placeholder="Repeat password">
                                    </div>
                                    <input class="btn btn-block btn-success" type="button" onclick="check()" value="Create Account">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- CoreUI and necessary plugins-->
        <script src="vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
        <script src="vendors/simplebar/js/simplebar.min.js"></script>
        <script>
                                        function check() {
                                            var pass = document.getElementById("pass").value;
                                            var passRepeat = document.getElementById("pass_repeat").value;
                                            if (pass !== passRepeat) {
                                                alert("Password repeat not match!");
                                            }
                                            if (pass === passRepeat) {
                                                document.getElementById("register-form").submit();
                                            }
                                        }

                                        function checkUser() {
            <c:if test="${requestScope.status eq true}">
                                            alert("User name is exist! Try again!");
                                            fillInfor();
            </c:if>
                                        }

                                        function fillInfor() {
                                            document.getElementById("full-name").value = "${requestScope.user.fullName}";
                                            document.getElementById("email").value = "${requestScope.user.email}";
                                            document.getElementById("address").value = "${requestScope.user.address}";
                                            document.getElementById("phone").value = "${requestScope.user.phone}";
                                            document.getElementById("user-name").value = "${requestScope.user.userName}";
                                        }
        </script>
    </body>
</html>