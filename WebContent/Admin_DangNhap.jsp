<!DOCTYPE html>
<%@page import="bean.TheLoaiBean"%>
<%@page import="bean.TruyenBean"%>
<%@page import="java.util.ArrayList"%>
<html lang="zxx">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Anime Template">
    <meta name="keywords" content="Anime, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Manga | Admin</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
    rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/plyr.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    
</head>

<style type="text/css">
.img{
    width: 80%;
    height: 300px;    
    border: 5px solid #000;
}
.header {
    background: #070720;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 2;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.5);
}
.header__navbar-item {
	margin: 0 8px;
	position: relative;
}

.header__navbar-user {
	display: flex;
	justify-items: center;
	z-index: 2;
}

.header__navbar-user-img {
	width: 22px;
	height: 22px;
	border-radius: 50%;
	border: 1px solid rgba(0, 0, 0, 0.2);
}

.header__navbar-user-name {
	position: relative;
	margin-left: 4px;
	margin-top: 4px;
	font-size: 1rem;
	font-weight: 600;
	color: white;
}

.header__navbar-user:hover .header__navbar-user-menu {
	display: block;
}

.header__navbar-user-menu {
	position: absolute;
	list-style: none;
	padding-left: 0;
	top: calc(100% + 8px);
	left: -18px;
	background-color: white;
	border-radius: 4px;
	width: 164px;
	z-index: 1;
	box-shadow: 0 1px 3px #d2cece;
	display: none;
	animation: fadeIn ease-in 0.4s;
}

.header__navbar-user-menu a {
	text-decoration: none;
	color: var(--text-color);
	font-size: 0.9rem;
	display: block;
	padding: 6px 16px;
	text-align: left;
}

.header__navbar-user-menu a:first-child {
	border-top-left-radius: 4px;
	border-top-right-radius: 4px;
}

.header__navbar-user-menu a:last-child {
	border-bottom-left-radius: 4px;
	border-bottom-right-radius: 4px;
}

.header__navbar-user-menu::before {
	content: "";
	border-width: 7px 14px;
	border-style: solid;
	border-color: transparent transparent white transparent;
	position: absolute;
	right: 117px;
	top: -12px;
}

.header__navbar-user-menu::after {
	content: "";
	display: block;
	position: absolute;
	top: -8px;
	right: 0;
	width: 87%;
	height: 10px;
}

.header__navbar-user-item--separate {
	border-top: 1px solid rgba(0, 0, 0, 0.05);
}

.header__navbar-user-menu a:hover {
	background-color: #f3f3f3;
}

@keyframes fadeIn {
	from { 
		opacity:0;	
	}
	to {
		opacity: 1;
	}
}
.edit-edit img {
	width: 30px;
	border-radius: 2rem;
	margin-right: 2px;
	background-color: white;
}
.search-container {
	display: flex;
	align-items: center;
	width: 100%;
	max-width: 400px;
	background-color: #fff;
	border-radius: 1rem;
	overflow: hidden;
	margin-right: 70px;
}

.search-container input[type=text] {
	flex-grow: 1;
}

.search-container button[type=submit] {
	background-color: #fff;
	color: #afadad;
	border: none;
	cursor: pointer;
}

.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}
.edit-edit {
	text-align: right;
	display: flex;
	justify-content: end;
	align-items: center;
	width: 100%;
}
.edit-edit input {
	border: none;
	text-indent: 15px;
}
.login__form:after {
    position: unset;
}
.login__form {
	padding-left: 0;
}
</style>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Header Section Begin -->
    <header class="header">
        <div class="container">
            <div class="row">
                <div class="col-lg-2">
                    <div class="header__logo">
                        <a href="#">
                            <img src="img/logoAdmin.png" style="width: 140px" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="header__nav">
                        <nav class="header__menu mobile-menu">
                            <ul>
                                <li><a href="Admin_QLTheLoaiController">Quản lý thể loại</a></li>
			                    <li><a href="Admin_QLTruyenController">Quản lý truyện</a></li>
			                    <li><a href="Admin_QTVienController">Quản trị viên</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <div class="col-lg-4" style="display: flex; padding: 0">
					<div class="edit-edit">
						<%
						if (session.getAttribute("admin") != null) {
						%>
						<ul>
							<li class="header__navbar-item header__navbar-user"><img
								alt="" src=""
								onerror="this.onerror=null; this.src='Avatar/user.png';">
								<span class="header__navbar-user-name"><%=session.getAttribute("admin")%></span>
								<ul class="header__navbar-user-menu">
									<li
										class="header__navbar-user-item header__navbar-user-item--separate">
										<a href="Admin_LogOutController">Đăng xuất</a>
									</li>
								</ul></li>
						</ul>
						<%
						} else {
						%>
						<a href="Admin_DangNhapController"><span class="icon_profile"
							style="color: #fff;"></span></a>
						<%
						}
						%>
					</div>
				</div>
            </div>
            <div id="mobile-menu-wrap"></div>
        </div>
    </header>
    <!-- Header End -->

      <!-- Normal Breadcrumb Begin -->
    <section class="normal-breadcrumb set-bg" data-setbg="img/normal-breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="normal__breadcrumb__text">
                        <h2>ADMIN Login</h2>
                        <p>Welcome to the official Manga blog.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Normal Breadcrumb End -->

    <!-- Login Section Begin -->
    <section class="login" style="display: flex;justify-content: center;padding-top: 30px;">
                    <div class="login__form" >
                        <h3 style="justify-content: center;display: flex;">Đăng nhập</h3>
                        <form action="Admin_DangNhapController" method="post">
                            <div class="input__item">
                                <input name="TaiKhoan" type="text" placeholder="Tên đăng nhập" required>
                                <span class="icon_profile"></span>
                            </div>
                            <div class="input__item">
                                <input name="MatKhau" type="password" placeholder="Mật khẩu" required>
                                <span class="icon_lock"></span>
                            </div>
                            <div style="justify-content: center;display: flex;">
                            <button type="submit" class="site-btn">Đăng nhập</button>
                            </div>
                            <%if(request.getParameter("kt")!=null)
							  		out.print("<br><br><b style='color: white'>Đăng nhập sai</b>");%>
                        </form>
                    </div>
    </section>
    <!-- Login Section End -->
<!-- Footer Section Begin -->
<footer class="footer">
    <div class="page-up">
        <a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="footer__logo">
                    <a href="HienThiTruyenController"><img src="img/logomanga2.png" style="width: 140px" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="footer__nav">
                    <ul>
                        <li><a href="Admin_QLTheLoaiController">Quản lý thể loại</a></li>
                        <li><a href="Admin_QLTruyenController">Quản lý truyện</a></li>
                        <li><a href="Admin_QTVienController">Quản trị viên</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-3">
                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                 Năm <script>document.write(new Date().getFullYear());</script>| by <a href="https://www.facebook.com/Zangbin" target="_blank">Trường Giang</a>
                  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>

              </div>
          </div>
      </div>
  </footer>
  <!-- Footer Section End -->

  <!-- Search model Begin -->
  <div class="search-model">
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="search-close-switch"><i class="icon_close"></i></div>
        <form class="search-model-form">
            <input type="text" id="search-input" placeholder="Search here.....">
        </form>
    </div>
</div>
<!-- Search model end -->

<!-- Js Plugins -->
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/player.js"></script>
<script src="js/jquery.nice-select.min.js"></script>
<script src="js/mixitup.min.js"></script>
<script src="js/jquery.slicknav.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/main.js"></script>


</body>

</html>