<%@page import="bean.TheLoaiBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.KhachHangBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.header {
	background: #070720;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	z-index: 10;
	box-shadow: 0 2px 8px rgba(0, 0, 0, 0.5);
}
.edit {
	text-align: right;
	display: flex;
	justify-content: center;
	align-items: center;
}

.edit img {
	width: 30px;
	border-radius: 2rem;
	margin-right: 2px;
	background-color: white;
}

.edit input {
	border: none;
	text-indent: 15px;
}
.list-category {
	height: 300px;
	overflow-y: scroll;
	border-radius: 4px;
}

.list-category li {
	padding: 5px;
	border-bottom: 1px solid #ccc;
	border-top: 1px solid #fff;
	background-color: #f8f8f8;
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
</style>
<!-- Header Section Begin -->
<header class="header">
	<div class="container">
		<div class="row">
			<div class="col-lg-2">
				<div class="header__logo">
					<a href="HienThiTruyenController"> <img
						src="img/logomanga2.png" style="width: 140px" alt="">
					</a>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="header__nav">
					<nav class="header__menu mobile-menu">
						<ul>
							<li><a href="HienThiTruyenController">Trang chủ</a></li>
							<li><a href="#">Thể loại <span class="arrow_carrot-down"></span></a>
								<ul class="dropdown list-category">
									<%
									ArrayList<TheLoaiBean> ls = (ArrayList<TheLoaiBean>) request.getAttribute("dsTheLoai");
									for (TheLoaiBean tlb : ls) {
									%>
									<li><a
										href="HienThiTruyenController?index=<%=1%>&MaTheLoai=<%=tlb.getMaTheLoai()%>"><%=tlb.getTenTheLoai()%></a></li>
									<%
									}
									%>
								</ul>
							<li><a href="LichSuController">Lịch sử</a></li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="col-lg-4" style="display: flex; padding: 0">
				<div class="edit">
					<form action="HienThiTruyenController" method="post"
						style="display: flex;">
						<div class="search-container">
							<input type="text" name="TenTruyen" placeholder="Tìm kiếm..."
								name="search">
							<button type="submit">
								<i class="fa fa-search"></i>
							</button>
						</div>
					</form>
					<%
					if (session.getAttribute("un") != null) {
					%>
					<ul>
						<li class="header__navbar-item header__navbar-user">
							<%
							KhachHangBean khbean = (KhachHangBean) request.getAttribute("KhachHang");
							%> <img alt="" src="<%=khbean.getAvatar()%>"
							onerror="this.onerror=null; this.src='Avatar/user.png';"> <span
							class="header__navbar-user-name"><%=khbean.getHoTen()%></span>
							<ul class="header__navbar-user-menu">
								<li class="header__navbar-user-item"><a
									href="TaiKhoanController">Tài khoản của tôi</a></li>
								<li class="header__navbar-user-item"><a
									href="LichSuController">Lịch sử đọc truyện</a></li>
								<li class="header__navbar-user-item"><a
									href="TheoDoiController">Danh sách theo dõi</a></li>
								<li
									class="header__navbar-user-item header__navbar-user-item--separate">
									<a href="ThoatController">Đăng xuất</a>
								</li>
							</ul>
						</li>
					</ul>
					<%
					} else {
					%>
					<a href="KTDNController"><span class="icon_profile"
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