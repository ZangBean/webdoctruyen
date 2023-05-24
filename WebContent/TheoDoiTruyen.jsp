<!DOCTYPE html>
<%@page import="bean.TheoDoiBean"%>
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
<link rel="stylesheet" href="css/fontawesome-free-6.2.1-web/css/all.min.css">
<link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
<link rel="stylesheet" href="css/plyr.css" type="text/css">
<link rel="stylesheet" href="css/nice-select.css" type="text/css">
<link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
<link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

</head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: white;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	border-radius: 6px;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

.product__item {
	transition: transform ease-in 0.1s;
	will-change: transform;
}

.product__item:hover {
	opacity: 0.9;
	transform: translateY(-4px);
}

.text-name {
	color: while;
	text-shadow: 1px 1px 0.7px black;
}

.fa {
	font-size: 20px;
	padding-right: 4px;
	padding-top: 1px;
}
.product__item__pic .delete {
    font-size: 13px;
    color: #ffffff;
    background: #3d3d3d;
    display: inline-block;
    padding: 2px 10px;
    border-radius: 1rem;
    position: absolute;
    right: 10px;
    top: 10px;
}
.product__item__pic .delete a {
	color: white;
}
.product__item__pic .delete a:hover {
	color: #e6ff00;
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
	<section class="product spad" style="padding-top: 100px; min-height: 600px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="trending__product">
						<div class="row">
							<div class="col-lg-8 col-md-8 col-sm-8">
								<div class="section-title" style="display: flex; align-items: center;margin-bottom: 20px;">
									<h4>Truyện Đang Theo Dõi</h4>
									<div style="color: wheat;font-size: 30px;margin: 0px 0px 5px 10px;">
										<i class="fa-solid fa-flag-checkered"></i>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<%
							request.setCharacterEncoding("utf-8");
							response.setCharacterEncoding("utf-8");
							ArrayList<TheoDoiBean> dsTheoDoi = (ArrayList<TheoDoiBean>) request.getAttribute("dsTheoDoi");
							int n = dsTheoDoi.size();
							for (int i = 0; i < n; i++) {
								TheoDoiBean s = dsTheoDoi.get(i);
							%>

							<div class="col-lg-3 col-md-4 col-sm-6">
								<div class="product__item">
									<div class="product__item__pic set-bg" data-setbg="">
										<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>">
											<img alt="" src="<%=s.getTruyen().getAnhTruyen()%>"
											style="width: 300px; height: 335px; border-radius: 10px"
											onerror="this.onerror=null; this.src='Avatar/default-image.jpg';">
										</a>
										<%
										if (s.getTruyen().isHoanThanh() == false) {
										%>
										<div class="ep"><%=s.getChuong()%> / ?</div>
										<%
										} else {
										%>
										<div class="ep"><%=s.getChuong()%> / <%=s.getChuong()%></div>
										<%
										}
										%>
										<div class="delete">
											<a href="TheoDoiDeleteController?MaTruyen=<%=s.getMaTruyen()%>">
												<i class="fa-regular fa-trash-can"></i>
											</a>
										</div>
										<div class="comment"><i class="fa fa-comments"></i><%=s.getBinhLuan()%></div>
										<div class="view"><i class="fa fa-eye"></i><%=s.getTruyen().getLuotXem()%></div>
									</div>
									<div class="product__item__text">
										<ul>
											<li><%=s.getTruyen().getMaTheLoai()%></li>
										</ul>
										<h5>
											<a href="ChiTietTruyenController?mt=<%=s.getMaTruyen()%>"><%=s.getTruyen().getTenTruyen()%></a>
										</h5>
									</div>
								</div>
							</div>
							<%
							}
							%>
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