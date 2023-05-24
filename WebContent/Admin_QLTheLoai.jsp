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
<link
	href="https://fonts.googleapis.com/css2?family=Oswald:wght@300;400;500;600;700&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Mulish:wght@300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
<link rel="stylesheet"
	href="css/fontawesome-free-6.2.1-web/css/all.min.css" type="text/css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/plyr.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

</head>

<style type="text/css">
.img {
	width: 80%;
	height: 300px;
	border: 5px solid #000;
}

.padding {
	padding: 0 32px;
}

.table {
	width: 80%;
	margin-right: auto;
	margin-left: auto;
	max-width: 100%;
	margin-bottom: 20px;
	color: white;
}

.edit {
	display: flex;
	justify-content: space-between;
}

.edit input {
	border-radius: 1rem;
	border: none;
	text-indent: 15px;
}

.edit-edit {
	text-align: right;
	display: flex;
	justify-content: center;
	align-items: center;
}
.edit-edit input {
	border: none;
	text-indent: 15px;
}
.re-edit {
	position: relative;
	border-radius: 1rem;
	border: none;
	background-color: #ffff98;
	padding: 0 15px;
	margin-left: 20px;
	color: #433e3e;
	font-weight: 700;
}

.edit-block {
	width: 6px;
	height: 100%;
}

.re-edit:hover {
	opacity: 0.8;
	cursor: pointer;
}

.btn-add {
	border-radius: 1rem;
	border: none;
	background-color: #c1aafc;
	padding: 0 20px;
	font-weight: 700;
}

.re-edit:hover, .btn-add:hover {
	opacity: 0.8;
	color: black;
}

.add-comic {
	justify-content: flex-end;
	display: flex;
	margin-right: 140px;
	padding: 10px;
	padding-top: 80px;
}

.add-edit-id {
	border: none;
	text-indent: 15px;
}

.add-edit-name {
	border: none;
	text-indent: 15px;
	border-left: 2px solid #f7d8d8;
}

.add-edit-btn {
	border: none;
	border-radius: 1rem;
	background-color: #ffff98;
	padding: 2px 15px;
}

.add-edit-btn:hover {
	opacity: 0.8;
	color: black;
	background-color: #c2c6c9;
}

.modal-body {
	display: flex;
	flex-direction: column;
	padding: 20px;
}

.modal-body span {
	margin-bottom: 10px;
	font-size: 14px;
	font-weight: bold;
	color: #333;
}

.modal-body input {
	padding: 10px;
	border-radius: 5px;
	border: 1px solid #ccc;
	margin-bottom: 20px;
	font-size: 14px;
}

.btn.focus, .btn:focus {
	outline: 0;
	box-shadow: none;
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
.form-table {
	min-height: 100%;
	padding-bottom: 20px;
}
.edit-delete:hover {
	opacity: 0.8;
	color: #ccc;
}

.edit-delete {
	border: none;
	color: white;
	background-color: #0b0c2a;
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
						<a href="#"> <img src="img/logoAdmin.png" style="width: 140px"
							alt="">
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
					<form action="Admin_QLTheLoaiController" method="post" style="display: flex;">
							<div class="search-container">
								<input type="text" name="TenTheLoai" placeholder="Tìm kiếm..." name="search">
								<button type="submit">
									<i class="fa fa-search"></i>
								</button>
							</div>
						</form>
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
	<div class="add-comic">
		<button type="button" class="btn add-edit-btn" data-toggle="modal"
			data-target="#myModal">
			<i class="fa-sharp fa-solid fa-plus"></i>
		</button>
		<!-- The Modal -->
		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<form action="Admin_EditLoaiController" method="post">
						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Thêm Thể Loại</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>

						<!-- Modal body -->
						<div class="modal-body">
							<span>Mã thể loại</span> <input class="add-edit-id" name="maloai"
								type="text" value="" placeholder="Mã thể loại..."> <span>Tên
								thể loại</span> <input class="add-edit-name" name="tenloai" type="text"
								value="" placeholder="Tên thể loại...">
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary">Add</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
	<div class="form-table">
	<table class="table padding">
		<%
		ArrayList<TheLoaiBean> ds = (ArrayList<TheLoaiBean>) request.getAttribute("dsTheLoai");
		%>
		<tr>
			<td><b style="color: yellow;">MÃ</b></td>
			<td><b style="color: yellow;">THỂ LOẠI</b></td>
			<td></td>
		</tr>
		<%
		for (TheLoaiBean item : ds) {
		%>
		<tr>
			<td><%=item.getMaTheLoai()%></td>
			<td><%=item.getTenTheLoai()%></td>
			<td>
				<div style="display: flex; justify-content: space-around;">
					<div>
						<form action="Admin_EditLoaiController" method="post">
							<div class="edit">
								<div>
									<input name="nhap" type="text" value="" placeholder="Sửa tên..." required>
									<button class="re-edit" type="submit" name="butsua"  value="<%=item.getMaTheLoai()%>">
										Thay đổi
									</button>
								</div>
								<div class="edit-block"></div>
							</div>
						</form>
					</div>
					<div>
						<form action="Admin_EditLoaiController" method="post">
							<button class="edit-delete" type="submit" name="butxoa" value="<%=item.getMaTheLoai()%>">
								<i class="fa-solid fa-trash-can"></i>
							</button>
						</form>
					</div>
				</div>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	</div>

	<!-- Footer Section Begin -->
	<footer class="footer">
		<div class="page-up">
			<a href="#" id="scrollToTopButton"><span class="arrow_carrot-up"></span></a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="footer__logo">
						<a href="HienThiTruyenController"><img src="img/logoAdmin.png"
							style="width: 140px" alt=""></a>
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
					<p>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Năm
						<script>
							document.write(new Date().getFullYear());
						</script>
						| by <a href="https://www.facebook.com/Zangbin" target="_blank">Trường
							Giang</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>

				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Search model Begin -->
	<div class="search-model">
		<div class="h-100 d-flex align-items-center justify-content-center">
			<div class="search-close-switch">
				<i class="icon_close"></i>
			</div>
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