<!DOCTYPE html>
<%@page import="bean.ChuongBean"%>
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

textarea {
	width: 100%;
	height: 200px;
	padding: 10px;
	font-size: 16px;
	line-height: 1.5;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
	resize: none;
	margin-bottom: 10px;
}

.spadd {
	padding-top: 90px;
}

.form-design {
	display: flex;
	flex-direction: column;
}

.form-design-item input {
	width: 100%;
	margin-bottom: 10px;
	border-radius: 1rem;
	border: none;
	text-indent: 15px;
}

.login__form {
	padding-left: 15px;
}

.login__form:after {
	position: absolute;
	right: -14px;
	top: 0px;
	height: 100%;
	width: 3px;
	background: rgba(255, 255, 255, 0.2);
	content: "";
}

.login__form:before {
	position: absolute;
	right: 376px;
	height: 100%;
	width: 3px;
	background: rgba(255, 255, 255, 0.2);
	content: "";
}

.input-design {
	display: flex;
	width: 100%;
}

input[type="radio"] {
	width: 16px;
	height: 16px;
	margin-top: 8px;
	margin-left: 36px;
}

.input-design-1, .input-design-2 {
	font-size: 20px;
}

.input-design-2>input[type="radio"] {
	margin-left: 36px;
}

.form-design-item {
	display: flex;
}

.form-design-img {
	display: flex;
	margin-bottom: 20px;
	margin-top: 10px;
}

.img-form {
	padding-left: 65px;
}

.img-item {
	width: 200px;
	height: 142px;
	border: 2px solid #ccc;
	border-radius: 1rem;
}

.form-design-img span {
	font-size: 20px;
	color: white;
	width: 250px;
}

.form-design-item span {
	font-size: 20px;
	color: white;
	width: 130px;
	margin-bottom: 12px;
}

.form-design-list {
	display: flex;
	align-items: center;
	margin-bottom: 10px;
	margin-right: 60px;
}

.form-design-list h4 {
	font-size: 20px;
	color: white;
	width: 250px;
}

.input-design-check {
	display: flex;
}

.btn-save {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.btn-save-img {
	display: flex;
	justify-content: center;
}

.btn-save input {
	width: 120px;
	height: 45px;
	margin: 10px;
	border-radius: 2rem;
}

.login__form-h3 {
	text-align: center;
}

.form-item-chapter {
	color: white;
	align-items: center;
	display: flex;
	margin-right: 50px;
	font-size: 20px;
}

.form-design-item-chapter {
	display: flex;
	margin-bottom: 10px;
}

.site-btn {
	border-radius: 2rem;
	margin: 10px;
	width: 120px;
	margin-top: 228px;
}

.login__form form button {
	border-radius: 2rem;
}

.nice-select .list {
	overflow: auto;
}

.list {
	width: 100%;
	overflow-y: scroll;
	max-height: 200px;
}

.nice-select {
	width: 250px;
	display: flex;
	justify-content: center;
}

.nice-select .option {
	text-align: center;
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

tr {
	display: flex;
	justify-content: space-between;
	border-bottom: 1px solid #ccc;
	align-items: center;
}

.login__form form button {
	margin: 6px;
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
	<!-- Login Section Begin -->
	<section class="login spadd">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					<div class="login__form" style='padding: 0'>
						<h3 style='text-align: center'>Edit Truyện</h3>
						<form action="Admin_SaveTruyenController" method="post"
							class="form-design">
							<%
							TruyenBean Truyen = (TruyenBean) request.getAttribute("ctTruyen");
							%>

							<div class="form-design-list">
								<h4>Thể loại:</h4>
								<select name="MaTheLoai">
									<%
									ArrayList<TheLoaiBean> ds = (ArrayList<TheLoaiBean>) request.getAttribute("dsTheLoai");
									for (TheLoaiBean tlb : ds) {
									%>
									<%
									if (tlb.getMaTheLoai().equals(Truyen.getMaTheLoai())) {
									%>
									<option value="<%=tlb.getMaTheLoai()%>" selected><%=tlb.getTenTheLoai()%></option>
									<%
									} else {
									%>
									<option value="<%=tlb.getMaTheLoai()%>"><%=tlb.getTenTheLoai()%></option>
									<%
									}
									}
									%>
								</select>
							</div>
							<div class="form-design-item">
								<span>Truyện:</span> <input name="TenTruyen" type="text"
									value="<%=Truyen.getTenTruyen()%>" placeholder="Tên truyện..."
									required>
							</div>
							<div class="form-design-item">
								<span>Tác giả:</span> <input name="TacGia" type="text"
									value="<%=Truyen.getTacGia()%>" placeholder="Tác giả..."
									required>
							</div>
							<div class="">
								<span style="font-size: 20px; color: white;">Giới thiệu:</span>
								<textarea name="GioiThieu"> <%=Truyen.getGioiThieu()%> </textarea>
							</div>
							<div class="btn-save">
								<input type="reset" class="site-btn">
								<button style="border-radius: 2rem; margin: 10px; width: 120px;"
									type="submit" class="site-btn" name="MaTruyen"
									value="<%=Truyen.getMaTruyen()%>">Lưu</button>
							</div>
						</form>

					</div>
				</div>
				<div class="col-lg-4">
					<div class="login__form">
						<h3 class="login__form-h3">Edit Chương</h3>
						<form action="Admin_SaveChuongController" method="post"
							class="form-design" enctype="multipart/form-data">
							<div class="form-design-item-chapter">
								<h4 class="form-item-chapter">Quantity:</h4>
								<select name="selected-mc">
									<%
									ArrayList<ChuongBean> dsChuong = (ArrayList<ChuongBean>) request.getAttribute("dsChuong");
									for (ChuongBean cb : dsChuong) {
									%>
									<option value="<%=cb.getMaChuong()%>" selected><%=cb.getTenChuong()%></option>
									<%
									}
									%>
								</select>
								<div style="width: 200px;"></div>
							</div>
							<input type="hidden" name="MaTruyen"
								value="<%=Truyen.getMaTruyen()%>">
							<div class="form-design-item">
								<span>Name:</span> <input name="TenChuong" type="text" value=""
									placeholder="Tên chương...">
							</div>
							<div class="form-design-item">
								<span>Pictures:</span> <input name="Anh" type="file"
									style="color: white;" multiple>
							</div>
							<div class="input-design-check">
								<div class="input-design input-design-1">
									<span style="color: white;">Update:</span> <input
										name="HoanThanh" type="radio" value="Update"
										<%if (Truyen.isHoanThanh() == false) {%> checked <%}%>>
								</div>
								<div class="input-design input-design-2">
									<span style="color: white;">Done:</span> <input
										name="HoanThanh" type="radio" value="Done"
										<%if (Truyen.isHoanThanh() == true) {%> checked <%}%>>
								</div>
							</div>
							<div class="btn-save">
								<%
								long SoChuong = (Long) request.getAttribute("SoChuong");
								%>
								<button type="button" class="site-btn" data-toggle="modal"
									data-target="#myModal">
									Xóa(<%=SoChuong%>)
								</button>
								<button type="submit" class="site-btn" name="thaoTac"
									value="Them">Lưu</button>
							</div>
						</form>
						<!-- The Modal -->
						<div class="modal" id="myModal">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="Admin_DeleteChuongController" method="post">
										<!-- Modal Header -->
										<div class="modal-header">
											<h4 class="modal-title">Xóa Chương</h4>
											<button type="button" class="close" data-dismiss="modal">&times;</button>
										</div>

										<!-- Modal body -->
										<div class="modal-body">
											<table>
												<tr>
													<td>Danh sách chương</td>
													<td></td>
												</tr>
												<%
												for (ChuongBean cb : dsChuong) {
												%>
												<tr>
													<td><input type="hidden" value="<%=cb.getMaTruyen()%>"
														name="MaTruyen"> <input type="hidden"
														value="<%=cb.getTenChuong()%>" name="TenChuong"> <%=cb.getTenChuong()%>
													</td>
													<td>
														<button type="submit" value="<%=cb.getMaChuong()%>"
															name="MaChuong" class="btn btn-primary">Xóa</button>
													</td>
												</tr>
												<%
												}
												%>
											</table>
										</div>

										<!-- Modal footer -->
										<div class="modal-footer">
											<button type="button" class="btn btn-danger"
												data-dismiss="modal">Close</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="login__form">
						<h3 class="login__form-h3">Edit Ảnh</h3>
						<form action="Admin_SaveAnhController" method="post"
							class="form-design" enctype="multipart/form-data">
							<input type="hidden" name="MaTruyen"
								value="<%=Truyen.getMaTruyen()%>">
							<div class="img-form">
								<img class="img-item" alt="" src="<%=Truyen.getAnhNen()%>">
							</div>
							<div class="form-design-img">
								<span>Ảnh bìa:</span> <input name="AnhNen" type="file"
									style="color: white;">
							</div>
							<div class="img-form">
								<img class="img-item" alt="" src="<%=Truyen.getAnhTruyen()%>">
							</div>
							<div class="form-design-img">
								<span>Ảnh truyện:</span> <input name="AnhTruyen" type="file"
									style="color: white;">
							</div>
							<div class="btn-save-img">
								<button style="border-radius: 2rem; margin: 10px; width: 120px;"
									type="submit" class="site-btn">Lưu</button>
							</div>
						</form>
					</div>
				</div>
			</div>
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
						<a href="HienThiTruyenController"><img
							src="img/logoAdmin.png" style="width: 140px" alt=""></a>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="footer__nav">
						<ul>
							<li><a href="Admin_DangNhapController">Quản lý thể loại</a></li>
							<li><a href="Admin_QLTruyenController">Quản lý truyện</a></li>
							<li><a href="Admin_QTVienController">Quản trị viên </a></li>
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