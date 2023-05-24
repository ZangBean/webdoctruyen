<!DOCTYPE html>
<%@page import="bean.KhachHangBean"%>
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
<style>
.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}

.trending__product {
	display: flex;
	justify-content: center;
}

.form-infor {
	display: flex;
	flex-direction: row;
	align-items: center;
	background-color: #f5f5f5;
	padding: 30px;
	border-radius: 10px;
	margin-top: 30px;
}

.form-img {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-bottom: 10px;
}

.form-img img {
	border-radius: 50%;
	border: 2px solid #ddd;
}

.form-img input[type="file"] {
	margin-top: 10px;
	border: none;
	outline: none;
	background-color: #ddd;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
}

.form-infor-personal {
	display: flex;
	flex-direction: column;
	align-items: flex-start;
}

.form-infor-personal span {
	font-weight: bold;
	margin-bottom: 5px;
}

.form-infor-personal input[type="text"], .form-infor-personal input[type="password"]
	{
	margin-bottom: 10px;
	padding: 10px;
	border: none;
	border-radius: 5px;
	outline: none;
	width: 100%;
}

.form-infor-personal button[type="submit"] {
	padding: 10px 20px;
	background-color: #333;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: all 0.3s ease-in-out;
}

.form-infor-personal button[type="submit"]:hover {
	background-color: #555;
}

.form-btn-save {
	display: flex;
	justify-content: center;
	width: 100%;
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

	<section class="product spad" style="padding-top: 60px">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="trending__product">
						<div class="form-infor">
							<form action="TaiKhoanUpdateController"
								enctype="multipart/form-data" method="post">
								<%
								KhachHangBean khbean = (KhachHangBean) request.getAttribute("KhachHang");
								%>
								<div class="form-img">
									<input type="hidden" name="HoTen" value="<%=khbean.getHoTen()%>" readonly> 
									<img alt="" src="<%=khbean.getAvatar()%>" onerror="this.onerror=null; this.src='Avatar/user.png';" style="width: 100px"> 
									<input type="file" name="Avatar">
								</div>
								<div class="form-infor-personal">
									<span>Thông tin tài khoản</span> <span>Emai</span> <input
										type="text" name="Email" value="<%=khbean.getEmail()%>"
										readonly> <span>Tên đăng nhập</span> <input
										type="text" name="HoTen" value="<%=khbean.getHoTen()%>"
										readonly> <span>Mật khẩu (Đổi mật khẩu)</span> <input type="password"
										name="MatKhau" value="<%=khbean.getMatKhau()%>">
									<div class="form-btn-save">
										<button type="submit">Lưu</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
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