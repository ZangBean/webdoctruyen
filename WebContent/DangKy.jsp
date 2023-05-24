<!DOCTYPE html>
<html lang="zxx">
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<head>
<meta charset="UTF-8">
<meta name="description" content="Anime Template">
<meta name="keywords" content="Anime, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Manga | Đọc truyện</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
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
.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}

.img {
	width: 80%;
	height: 300px;
	border: 5px solid #000;
}

</style>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- Header End -->

	<!-- Normal Breadcrumb Begin -->
	<section class="normal-breadcrumb set-bg"
		data-setbg="img/normal-breadcrumb.jpg">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<div class="normal__breadcrumb__text">
						<h2>Register</h2>
						<p>Welcome to the official Manga blog.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Normal Breadcrumb End -->

	<!-- Login Section Begin -->
	<section class="login" style="padding-top: 20px">

		<div class="login__form" style='padding: 0'>
			<h3 style='text-align: center'>Đăng ký</h3>
			<form action="DangKyController" method="post"
				style='display: flex; flex-direction: column; align-items: center'>
				<div class="input__item">
					<input name="Email" type="email" placeholder="Email" required>
					<span class="icon_mail"></span>
				</div>
				<div class="input__item">
					<input name="HoTen" type="text" placeholder="Tên đăng nhập"
						required> <span class="icon_profile"></span>
				</div>
				<div class="input__item">
					<input name="MatKhau" type="password" placeholder="Mật khẩu"
						required> <span class="icon_lock"></span>
				</div>
				<button type="submit" class="site-btn">Đăng ký</button>
				<%
				if (request.getParameter("kt") != null)
					out.print("<br><br><b style='color: white'>Tên đăng nhập đã tồn tại, vui lòng đổi tên đăng nhập khác !</b>");
				%>
			</form>
			<div style="display: flex;justify-content: center;">
			 <h5 style="color: white;margin-top: 20px;">Bạn đã có tài khoản? <a href="KTDNController">Đăng nhập!</a></h5>
			</div>
		</div>
	</section>
	<!-- Login Section End -->
	
	<!-- Footer Section Begin -->
	<jsp:include page="Footer.jsp"></jsp:include>
	<!-- Footer Section End -->

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